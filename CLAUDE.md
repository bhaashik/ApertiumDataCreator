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
- Sanscript library for transliteration (included in `lib/sanscript-classes/`)

### Build Commands

```bash
# Compile the entire project (from project root)
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java

# Or compile with JAR library (used by actual scripts)
javac -d bin -cp "lib/sanscript-java_2.12-0.4.jar" src/bhaashik/morph/**/*.java

# On Windows, use semicolons in classpath
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java
```

**Important Notes:**
- The actual generation scripts use `lib/sanscript-java_2.12-0.4.jar` in the classpath
- Both `lib/sanscript-classes/` (compiled from source) and `lib/sanscript-java_2.12-0.4.jar` are available
- Use WSL2 Ubuntu JDK for development

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
# Convert any WX monodix file to Devanagari
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.util.MonodixScriptConverter \
    input.dix output.dix Devanagari

# Supported scripts: Devanagari, Bengali, Gujarati, Gurmukhi, Kannada, Malayalam, Oriya, Tamil, Telugu
```

**Why both versions?**
- **WX (ASCII)**: Easier for version control, editing, and collaboration
- **Native script**: Required for end-users and standard Apertium tools
- Generated files have identical FST functionality

### Run Tests

```bash
# Compile tests first
javac -d bin -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" test/bhaashik/morph/*.java

# Run all tests (Linux/Mac)
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" org.junit.runner.JUnitCore bhaashik.morph.MonolingualDictionaryTest bhaashik.morph.MorphologicalUnitTest bhaashik.morph.StemExtractionTest bhaashik.morph.TAMMapperTest bhaashik.morph.WXConverterTest

# On Windows (use semicolons)
java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/sanscript-classes" org.junit.runner.JUnitCore bhaashik.morph.MonolingualDictionaryTest
```

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

### Input Data
- Linguistic resources: `input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/`
  - `bhojpuri/morphological-paradigms-and-lexicon/`
  - `maithili/morphological-paradigms-and-lexicon/`
  - `magahi/morphological-paradigms-and-lexicon/`
- Feature structures: Root directory (`ApertiumDataCreator-part-*.md` or `B_M_M_Word-generation-ver-1.9.0.formatted.txt`)

### Output
- Generated files: `output/` directory (created automatically)
- Default output filenames: `{language}-monodix.dix`

### Dependencies
- `lib/sanscript-classes/`: Compiled Sanscript library
- `lib/sanscript-source/`: Sanscript source code
- `lib/*.jar`: JUnit, Jackson, and other dependencies

### Tests
- Location: `test/bhaashik/morph/`
- 5 test classes, 33 tests total (all passing)

## Recent Fixes and Known Issues

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

See `SESSION-2025-11-23-monodix-compilation-fixes.md` for detailed fix documentation.

### ⚠️ Known Issue: Stem-Suffix Separation in Pardef Structure

**Problem**: The current implementation does NOT fully follow Apertium's recommended stem/lemma_suffix naming convention for pardefs.

**Current behavior** (INCORRECT):
```xml
<pardef n="Noun_m">
  <e><p><l>ों</l><r><s n="n"/><s n="m"/><s n="pl"/></r></p></e>
</pardef>

<section id="main">
  <e lm="घर">
    <i>घर</i>
    <par n="Noun_m"/>
  </e>
</section>
```

**Expected behavior** (CORRECT - see `examples/apertium-hin.hin.dix.xml`):
```xml
<pardef n="वध/ू__n_f">
  <e><p><l>ू</l><r>ू<s n="n"/><s n="f"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l>ुएँ</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="nom"/></r></p></e>
  <e><p><l>ुओं</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>

<section id="main">
  <e lm="वधू">
    <i>वध</i>              <!-- STEM only -->
    <par n="वध/ू__n_f"/>   <!-- Pardef name: stem/lemma_suffix__category -->
  </e>
</section>
```

**Understanding the format**:
- **Lemma**: वधू (vadhū)
- **Stem**: वध (vadh)
- **Lemma suffix**: ू (ū)
- **Pardef name**: `वध/ू__n_f` means "lemma वधू = stem वध + lemma_suffix ू"

The pardef then shows all possible suffixes:
- `<l>ू</l>` → वध + ू = वधू (singular nominative)
- `<l>ुएँ</l>` → वध + ुएँ = वधुएँ (plural nominative)
- `<l>ुओं</l>` → वध + ुओं = वधुओं (plural oblique)

**Why this matters**:
- The FST needs to know: lemma = stem + lemma_suffix
- For **generation**: Remove lemma_suffix from lemma → get stem → add appropriate suffix from pardef
- For **analysis**: Identify stem → match with pardef → determine which lemma and morphological tags

**Root cause**:
- Line 248 in `ApertiumMonodixWriter.java`: Uses `category.getCategoryName()` instead of `stem/lemma_suffix__category` format
- Line 270-278: Extracts suffixes but doesn't encode the lemma split in the pardef name
- Line 370: Writes full lemma in `<i>` tag instead of just the stem

**Fix needed**:
1. Modify `writeParadigmDefinition()` to:
   - Extract stem from lemma (using stemExtractor)
   - Calculate lemma_suffix = lemma - stem
   - Generate pardef name as: `stem/lemma_suffix__category_name`
   - Write `<l>` entries with the varying suffixes (already done correctly)
   - Write `<r>` entries with the lemma_suffix + tags
2. Modify `writeMainSection()` to:
   - Extract stem from each lexicon entry's lemma
   - Write only the stem in `<i>` tag
   - Reference the correctly formatted pardef name (stem/lemma_suffix__category)
3. Handle pardef name generation per lexicon entry (since each lemma may have different stem/suffix split)

### ✅ HANDLED: Variant Forms (Dialectal Variations)

**Status**: The code now properly handles dialectal/regional variants separated by `/` in paradigm files.

**Implementation**: `DotPFormatParadigmReader` and `ApertiumMonodixWriter` split variant forms and generate separate `<e>` entries for each.

**Example**: For `amIrai/amIre/amIrE`, the system generates three separate pardef entries with different suffixes.

## Performance and File Statistics

### Bhojpuri Monodix Generation (Reference)
- **Generation Time**: ~75 minutes for full dictionary
- **Output File Size**: ~437 MB (WX notation)
- **Paradigm Definitions**: 217,227
- **Lexicon Entries**: 218,242 (from 571,558 source entries)
- **Legitimate Empty `<l>` Tags**: 103 (zero-suffix forms like adverbs, uninflecting adjectives)

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
