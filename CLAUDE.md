# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java-based morphological analysis API that converts linguistic data from a legacy format to **Apertium monodix** format for three Indic languages: **Bhojpuri**, **Maithili**, and **Magahi**. The generated monodix files can be compiled into Finite State Transducers (FSTs) for morphological analysis and generation.

### Purpose
- Convert legacy morphological paradigm data (.p files) and feature structures (markdown format) to Apertium monodix XML
- Support morphological analysis (word → lemma + features) and generation (lemma + features → word)
- Enable FST-based morphological tools for under-resourced Indic languages

## Build and Compilation

### Prerequisites
- Java 8+ (JDK required for compilation)
- Sanscript library for transliteration (included in `lib/sanscript-classes/` and `lib/sanscript-java_2.12-0.4.jar`)

### JDK Options for WSL2

Two JDK options are available when working in WSL2:

1. **WSL2 Ubuntu JDK** (recommended for development):
   ```bash
   # Currently using JDK 24.0.2 at /home/bhaashik/exec/jdk-24.0.2/bin/java
   javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java
   ```

2. **Windows JDK** (accessible from WSL2):
   ```bash
   # Windows JDK-25 available at /mnt/c/Program Files/Java/jdk-25/
   /mnt/c/Program\ Files/Java/jdk-25/bin/javac.exe -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java
   ```

### Build Commands

```bash
# Compile the entire project (from project root)
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java

# Or compile with JAR library (used by generation scripts)
javac -d bin -cp "lib/sanscript-java_2.12-0.4.jar" src/bhaashik/morph/**/*.java

# On Windows CMD, use semicolons in classpath
javac -d bin -cp "lib/sanscript-classes;lib/sanscript-java_2.12-0.4.jar" src/bhaashik/morph/**/*.java
```

**Important Notes:**
- The generation scripts (`create-*-monodix.sh`) use `lib/sanscript-java_2.12-0.4.jar` in the classpath
- Both `lib/sanscript-classes/` (compiled from source) and `lib/sanscript-java_2.12-0.4.jar` are available and interchangeable

### Generate Monodix Files

```bash
# Generate all three language dictionaries (WX notation only)
bash create-all-monodix.sh

# Or generate individually (WX notation)
bash create-bhojpuri-monodix.sh
bash create-maithili-monodix.sh
bash create-magahi-monodix.sh

# Generate BOTH WX and Devanagari versions (recommended for Apertium)
bash create-bhojpuri-monodix-both.sh

# On Windows
create-all-monodix.bat
create-bhojpuri-monodix.bat
```

### Script Conversion (WX ↔ Devanagari)

Following Apertium best practices for Indic languages, this project generates **both WX and native script** versions of monodix files:

```bash
# Convert any WX monodix file to Devanagari (streaming mode for large files)
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.util.MonodixScriptConverterStreaming \
    input.dix output.dix Devanagari

# Non-streaming converter (for smaller files)
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.util.MonodixScriptConverter \
    input.dix output.dix Devanagari

# Supported scripts: Devanagari, Bengali, Gujarati, Gurmukhi, Kannada, Malayalam, Oriya, Tamil, Telugu
```

**Streaming vs Non-Streaming Converter:**
- `MonodixScriptConverterStreaming`: For large files (>100MB), processes line-by-line, constant memory usage (~16KB buffer), ~120,000 lines/sec
- `MonodixScriptConverter`: For smaller files (<100MB), loads entire file into memory

**Why both WX and native script versions?**
- **WX (ASCII)**: Easier for version control, editing, and collaboration
- **Native script**: Required for end-users and standard Apertium tools
- Generated files have identical FST functionality

### Run Tests

```bash
# Compile tests first
javac -d bin -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" test/bhaashik/morph/*.java

# Run all tests (Linux/Mac/WSL2)
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" \
    org.junit.runner.JUnitCore \
    bhaashik.morph.MonolingualDictionaryTest \
    bhaashik.morph.MorphologicalUnitTest \
    bhaashik.morph.StemExtractionTest \
    bhaashik.morph.TAMMapperTest \
    bhaashik.morph.WXConverterTest

# Run a single test class
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" \
    org.junit.runner.JUnitCore bhaashik.morph.WXConverterTest

# On Windows CMD (use semicolons)
java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/sanscript-classes" ^
    org.junit.runner.JUnitCore bhaashik.morph.MonolingualDictionaryTest
```

**Test Statistics:** 5 test classes, 33 tests total (all passing)

## Architecture

### Three-Layer Architecture

1. **Data Model Layer** (`src/bhaashik/morph/model/`)
   - Core data structures: `MorphologicalUnit`, `MorphologicalAnalysis`, `MonolingualDictionary`
   - Paradigm representations: `ParadigmCategory`, `SpecificParadigm`, `FeatureStructure`
   - Lexicon: `LexiconEntry` (maps lemma → paradigm category)

2. **I/O Layer** (`src/bhaashik/morph/io/`)
   - **Readers**: Convert input formats → internal models
     - `DotPFormatParadigmReader`: Reads `.p` paradigm files
     - `MarkdownFeatureStructureReader`: Reads feature structures from `ApertiumDataCreator-part-*.md` files
     - `CSVLexiconReader`: Reads CSV lexicon files
   - **Writers**: Convert internal models → output formats
     - `ApertiumMonodixWriter`: Generates Apertium monodix XML

3. **Algorithm Layer** (`src/bhaashik/morph/algorithm/`)
   - Stem extraction strategies for separating stems from affixes
   - `LongestCommonPrefixStrategy`: For suffixing languages (default for Indic)
   - `LongestCommonSubsequenceStrategy`: For non-concatenative morphology

4. **Utilities Layer** (`src/bhaashik/morph/util/` and `src/bhaashik/morph/encoding/`)
   - `TAMMapper`: Cross-language TAM (Tense-Aspect-Mood) mapping
   - `MonodixScriptConverter`: Non-streaming script converter
   - `MonodixScriptConverterStreaming`: Streaming script converter for large files
   - `WXConverter`: WX notation ↔ Indic scripts encoding conversion (powered by Sanscript library)
   - `GraphemeUtils`: Grapheme-aware string operations for Indic scripts (uses Java BreakIterator for correct handling of combining characters)
   - `DixValidator`: Validates generated .dix files
   - `AffixExtractor`: Utility for extracting affixes from word forms

### Data Flow

```
Input Data (.p files + feature structures + lexicon)
    ↓
ParadigmReader / FeatureStructureReader / LexiconReader
    ↓
Internal Models (ParadigmCategory, FeatureStructure, LexiconEntry)
    ↓
ApertiumMonodixWriter (with StemExtractionStrategy + TAMMapper)
    ↓
Apertium Monodix XML (.dix)
    ↓
MonodixScriptConverter[Streaming] (optional: WX → Devanagari)
    ↓
Apertium lt-comp (external tool)
    ↓
FST Binaries (.bin files for analysis/generation)
```

### Key Processing Pipeline

The main entry point `ApertiumCreatorMain.java` orchestrates:
1. Read feature structures (determines expected word form counts per paradigm)
2. Read paradigm files (.p format) using feature structure counts
3. Read lexicon (CSV mapping lemma → paradigm category)
4. Load TAM mapper (optional, for cross-language TAM mapping)
5. Configure and invoke ApertiumMonodixWriter
6. Generate monodix XML file

## Input Data Format

### 1. Paradigm Files (`.p`)
Location: `input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/{language}/morphological-paradigms-and-lexicon/paradigms/`

Format:
```
ParadigmCategoryName
lemma1
wordform1_1
wordform1_2
...
```

### 2. Feature Structure Files
Location: Project root (`ApertiumDataCreator-part-*.md` files or `B_M_M_Word-generation-ver-1.9.0.formatted.txt`)

Format: Maps paradigm categories to morphological features
```markdown
[[ParadigmCategoryName]]
<fs af='XX,n,m,sg,3,d,0,0'> :: घर :: घर
<fs af='XX,n,m,pl,3,o,0,0'> :: घरों :: घरों
```

The 8-field feature structure (`af='...'`):
1. Lemma (or `XX` placeholder)
2. Category (n=noun, v=verb, pn=pronoun, adj=adjective, etc.)
3. Gender (m/f/any)
4. Number (sg/pl/any)
5. Person (1/2/3/any)
6. Case (d=direct, o=oblique, any)
7. Vibhakti (case marker: ko, se, meM, para, kA, 0)
8. TAM (Tense-Aspect-Mood marker)

### 3. Lexicon Files
Location: `input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/{language}/morphological-paradigms-and-lexicon/lexicon/dict.final.txt`

CSV Format: `"lemma","field2","specific_paradigm","paradigm_category","meaning","author"`

### 4. TAM Mapping File (Optional)
Location: `TAM-Mapping.md` (root directory)

Maps TAM markers from source languages (Bhojpuri/Magahi/Maithili) to Hindi.

## Key Concepts

### Stem Extraction
The system uses algorithms to separate stems from affixes:
- **Longest Common Prefix (LCP)**: Default for Indic languages (suffixing)
- Extracts common prefix as stem, remainder as suffix
- Used to create Apertium `<pardef>` paradigm definitions

### Vibhakti Handling
Three modes for case marker/postposition handling:
- `ATTACHED`: Vibhakti is part of word (e.g., घरमें) - used for Bhojpuri/Magahi/Maithili
- `SEPARATE`: Vibhakti is separate word (e.g., घर में) - used for Hindi
- `AUTO`: Auto-detect from feature structure

### TAM Mapping
Cross-language mapping for Tense-Aspect-Mood markers:
- Maps Bhojpuri/Magahi/Maithili TAM markers to Hindi equivalents
- Example: Bhojpuri "ba" → Hindi "nA"
- Used for generation in target script/language

### WX Notation and Transliteration
The `WXConverter` (powered by Sanscript library) handles:
- Conversion between WX notation and Indic scripts (Devanagari, Bengali, etc.)
- Conversion to Roman schemes (IAST, ITRANS, Harvard-Kyoto, SLP1)
- Location: `src/bhaashik/morph/encoding/WXConverter.java`

**Important Note on String Operations with Indic Scripts**:
- Java's `String.length()` counts UTF-16 code units, NOT grapheme clusters (user-perceived characters)
- Indic vowel marks (maatraas), nuktas, and halants are combining characters that attach to base characters
- Example: "किताबुल" = 7 graphemes (क + ि + त + ा + ब + ु + ल) but fewer UTF-16 code units because ि, ा, ु are combining marks
- For correct length/substring operations with Devanagari, count **all graphemes individually**
- Current implementation uses WX notation (ASCII-based, one-to-one mapping) to avoid these issues
- `GraphemeUtils.java` provides grapheme-aware operations using Java's `BreakIterator` for future Devanagari processing
- When working directly with Devanagari text, use `GraphemeUtils` instead of standard String methods

## Output Format

The generated Apertium monodix (.dix) files contain:
- `<alphabet>`: Unicode character set for the language
- `<sdefs>`: Symbol definitions (morphological tags like `<n>`, `<pl>`, `<o>`)
- `<pardefs>`: Paradigm definitions (inflection patterns)
- `<section id="main">`: Lexicon entries linking lemmas to paradigms

### Compiling to FST

External Apertium tools (not part of this project):
```bash
# Analysis (surface → lemma+tags)
lt-comp lr bhojpuri-monodix.dix bhojpuri-analyzer.bin

# Generation (lemma+tags → surface)
lt-comp rl bhojpuri-monodix.dix bhojpuri-generator.bin
```

## Important File Locations

### Source Code
- Main entry: `src/bhaashik/morph/ApertiumCreatorMain.java`
- Core writer: `src/bhaashik/morph/io/ApertiumMonodixWriter.java`
- Readers: `src/bhaashik/morph/io/*Reader.java`
- Models: `src/bhaashik/morph/model/*.java`
- Utilities: `src/bhaashik/morph/util/*.java`
- Encoding: `src/bhaashik/morph/encoding/*.java`

### Input Data
- Linguistic resources: `input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/`
  - `bhojpuri/morphological-paradigms-and-lexicon/`
  - `maithili/morphological-paradigms-and-lexicon/`
  - `magahi/morphological-paradigms-and-lexicon/`
- Feature structures: Root directory (`ApertiumDataCreator-part-*.md` or `B_M_M_Word-generation-ver-1.9.0.formatted.txt`)

### Output
- Generated files: `output/` directory (created automatically)
- Default output filenames: `{language}-monodix.dix`, `{language}-wx.dix`, `{language}-deva.dix`

### Dependencies
- `lib/sanscript-classes/`: Compiled Sanscript library (from source)
- `lib/sanscript-java_2.12-0.4.jar`: Sanscript JAR (used by scripts)
- `lib/sanscript-source/`: Sanscript source code
- `lib/*.jar`: JUnit, Jackson, and other dependencies

### Tests
- Location: `test/bhaashik/morph/`
- 5 test classes, 33 tests total (all passing)

## Recent Fixes and Implementation History

### ✅ FIXED (Jan 2026): Stem-Suffix Separation in Pardef Structure

**Major Implementation**: Correct per-category pardef structure following official Apertium standards.

**Previous Problem**: Implementation did not follow Apertium's stem/lemma_suffix naming convention, resulting in:
- 217,227 pardefs (one per word instead of per category)
- 437 MB file size
- Generic pardef names like `Noun_m` instead of `stem/suffix__category`

**Current Implementation** (CORRECT - based on `examples/apertium-bho.bho.dix`):
```xml
<!-- PARDEF: One per paradigm category, named with example stem/suffix -->
<pardef n="ध/ी__n_f">
  <e><p><l>ी</l><r>ी<s n="n"/><s n="f"/><s n="sg"/></r></p></e>
  <e><p><l>ियाँ</l><r>ी<s n="n"/><s n="f"/><s n="pl"/></r></p></e>
</pardef>

<!-- LEXICON: Multiple words share same pardef -->
<e lm="कहनी"><i>कहन</i><par n="ध/ी__n_f"/></e>  <!-- lemma=कहनी, stem=कहन -->
<e lm="बच्चा"><i>बच्च</i><par n="ध/ा__n_m"/></e>  <!-- lemma=बच्चा, stem=बच्च -->
```

**Key Understanding**:
- The "ध/ी" in pardef name is a **LABEL** showing the morphological pattern, NOT the actual stem of every word
- Each paradigm category gets ONE pardef (e.g., all feminine nouns ending in ी share the same `ध/ी__n_f` pardef)
- Individual word stems are written in the `<i>` tag of lexicon entries
- Pardef contains the inflection rules that apply to all words in that category

**Implementation Methods** (in `ApertiumMonodixWriter.java`):
- `writeParadigmDefinitionsWithStemSuffix()` - generates per-category pardefs with stem/suffix labels
- `writeMainSectionWithStems()` - extracts individual stems for each lexicon entry
- `extractStemForLexiconEntry()` - calculates stem by removing paradigm's suffix from lemma

**Results Achieved**:
- **Bhojpuri**: 34 MB, 111 pardefs, 487,311 entries
- **Maithili**: 10 MB, 84 pardefs, 142,883 entries
- **Magahi**: 15 MB, 85 pardefs, 219,411 entries
- File size reduction: 437 MB → 34 MB (13x smaller for Bhojpuri)
- Pardef count: 217,227 → 111 (1,956x reduction)
- Format: ✅ Matches official Apertium Bhojpuri/Hindi standards

See `SESSION-2026-01-08-SUCCESS.md` for detailed implementation documentation.

### ✅ FIXED (Nov 2025): Empty `<l>` Tags and Missing Symbol Definitions

Two critical compilation issues were identified and fixed in November 2025:

**Issue 1: Empty `<l>` Tags** - RESOLVED
- **Problem**: 28,129 empty `<l></l>` tags prevented FST compilation
- **Cause**: Suffix extraction used paradigm lemma instead of lexicon entry stem
- **Fix**: Modified `ApertiumMonodixWriter.java` lines 391-417 to extract suffixes relative to the actual stem
- **Result**: Empty tags reduced to 103 legitimate zero-suffix forms (99.6% reduction)

**Issue 2: Missing Symbol Definitions** - RESOLVED
- **Problem**: 8 symbols (emph, emph1, mood, mood1, hon, neg, rdp, dexis) used but not defined in `<sdefs>`
- **Cause**: Code only collected feature VALUES, not KEYS from additional attributes
- **Fix**: Modified `collectSymbolsFromFeatureStructure()` (lines 354-366) to add both keys and values
- **Result**: All symbols now properly defined before use

### ✅ HANDLED: Variant Forms (Dialectal Variations)

**Status**: The code now properly handles dialectal/regional variants separated by `/` in paradigm files.

**Implementation**: `DotPFormatParadigmReader` and `ApertiumMonodixWriter` split variant forms and generate separate `<e>` entries for each.

**Example**: For `amIrai/amIre/amIrE`, the system generates three separate pardef entries with different suffixes.

## Performance and File Statistics

### Current Generation Statistics (Jan 2026)

All three languages successfully generated with correct Apertium format:

| Language | File Size | Pardefs | Lexicon Entries | Bytes/Entry | Lines |
|----------|-----------|---------|-----------------|-------------|-------|
| **Bhojpuri** | 34 MB | 111 | 487,311 | 73 | 519,485 |
| **Maithili** | 10 MB | 84 | 142,883 | 74 | 173,564 |
| **Magahi** | 15 MB | 85 | 219,411 | 72 | 243,884 |
| **Total** | 59 MB | 280 | 849,605 | - | 936,933 |

**Efficiency Comparison**:
- Our Bhojpuri: 73 bytes/entry
- Official Hindi (apertium-hin): 95 bytes/entry
- Official Bhojpuri example (apertium-bho): 520 bytes/entry (includes documentation)

**Historical Improvement** (Bhojpuri):
- Old implementation: 437 MB, 217,227 pardefs (one per word)
- Current implementation: 34 MB, 111 pardefs (one per category)
- Reduction: 13x smaller file, 1,956x fewer pardefs

### Script Conversion Performance
- **MonodixScriptConverterStreaming**: Production converter for large files
- **Processing Speed**: ~120,000 lines/second
- **Example**: 435MB file (18 million lines) converted in 152 seconds
- **Memory Usage**: Constant (~16KB buffer) - suitable for very large files

## Development Notes

### Adding Support for New Languages
1. Add paradigm files (.p) to `input/{language}/morphological-paradigms-and-lexicon/paradigms/`
2. Add lexicon to `input/{language}/morphological-paradigms-and-lexicon/lexicon/`
3. Ensure feature structures include paradigm categories for the new language
4. Create wrapper script (e.g., `create-{language}-monodix.sh`)

### Extending the System
- New input format: Implement `ParadigmReader`, `FeatureStructureReader`, or `LexiconReader` interface
- New output format: Implement `DictionaryWriter` interface
- New stem algorithm: Implement `StemExtractionStrategy` interface

## Common Tasks

### Regenerate monodix after data changes
```bash
# Recompile if Java code changed
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java

# Regenerate specific language
bash create-bhojpuri-monodix.sh
```

### Convert existing WX monodix to Devanagari
```bash
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.util.MonodixScriptConverterStreaming \
    output/bhojpuri-wx.dix \
    output/bhojpuri-deva.dix \
    Devanagari
```

### Debug parsing issues
Check the console output from `ApertiumCreatorMain` which shows:
- Number of paradigm categories loaded
- Number of feature structures read
- Number of lexicon entries processed
- Any parsing errors with line numbers

### Verify FST compilation
After generating .dix files, test with Apertium tools (if installed):
```bash
# Compile for analysis (left-to-right)
lt-comp lr output/bhojpuri-monodix.dix bhojpuri.bin

# Test analyzer
echo "घरों" | lt-proc bhojpuri.bin

# Verify all symbols are defined (debugging)
grep -o '<sdef n="[^"]*"' output/bhojpuri-monodix.dix | sed 's/<sdef n="//' | sed 's/"//' | sort -u > /tmp/defined_sdefs.txt
grep -o '<s n="[^"]*"' output/bhojpuri-monodix.dix | sed 's/<s n="//' | sed 's/"//' | sort -u > /tmp/used_sdefs.txt
comm -23 /tmp/used_sdefs.txt /tmp/defined_sdefs.txt  # Should be empty
```

## References and Documentation

### Apertium Official Documentation
- **Monodix Basics**: https://wiki.apertium.org/wiki/Monodix_basics
- **Monodix Format**: https://wiki.apertium.org/wiki/Monodix
- See `Apertium-References.txt` for complete reference list

### Example Files in Repository
- `examples/apertium-bho.bho.dix` - Official Bhojpuri monodix (reference implementation)
- `examples/apertium-hin.hin.dix.xml` - Hindi monodix example
- These examples demonstrate correct pardef structure and stem/suffix separation

### Session Documentation
Recent development work is documented in session files:
- `SESSION-2026-01-08-SUCCESS.md` - Successful stem/suffix implementation (Jan 2026)
- `SESSION-2026-01-08-stem-suffix-results.md` - Detailed results and analysis
- `STEM-SUFFIX-IMPLEMENTATION-PLAN.md` - Original implementation plan
- These files contain valuable implementation details and lessons learned
