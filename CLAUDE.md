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

# On Windows, use semicolons in classpath
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java
```

**Note:** The user prefers using JDK from Windows 11 host instead of WSL2 Ubuntu JDK when possible.

### Generate Monodix Files

```bash
# Generate all three language dictionaries
bash create-all-monodix.sh

# Or generate individually
bash create-bhojpuri-monodix.sh
bash create-maithili-monodix.sh
bash create-magahi-monodix.sh

# On Windows
create-all-monodix.bat
create-bhojpuri-monodix.bat
```

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

## Known Issues and Required Fixes

### Issue 1: Incorrect Stem-Suffix Separation in Pardef Structure

**Problem**: The current implementation does NOT properly separate stems and suffixes in pardef definitions as required by Apertium monodix format.

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

### Issue 2: Variant Forms Not Handled (Dialectal Variations)

**Problem**: Paradigm files (`.p`) contain dialectal/regional variants separated by `/`, but the code treats them as single strings.

**Example from** `input/bhojpuri/morphological-paradigms-and-lexicon/paradigms/Adj_All_e.p`:
```
Adj_All_e
amIra
amIrai/amIre/amIrE          ← Three variants of the same inflected form
kariyA
kariyai/kariai/kariye        ← Three different variants
```

**Current behavior** (INCORRECT):
```xml
<pardef n="Adj_All_e">
  <e><p><l>ai/amIre/amIrE</l><r><s n="adj"/>...</r></p></e>  <!-- Treats as single string! -->
</pardef>
```

**Expected behavior** (CORRECT):
For lemma **amIra**, stem **amIr**, lemma_suffix **a**:
```xml
<pardef n="amIr/a__Adj_All_e">
  <e><p><l>ai</l><r>a<s n="adj"/><s n="emph"/>...</r></p></e>   <!-- Variant 1 -->
  <e><p><l>e</l><r>a<s n="adj"/><s n="emph"/>...</r></p></e>    <!-- Variant 2 -->
  <e><p><l>E</l><r>a<s n="adj"/><s n="emph"/>...</r></p></e>    <!-- Variant 3 -->
</pardef>
```

Or possibly separate pardefs for major variant groups.

**Root cause**:
- `DotPFormatParadigmReader.java` reads word forms but doesn't split on `/`
- `ApertiumMonodixWriter.java` doesn't detect or handle `/` variants

**Fix needed**:
1. Modify `DotPFormatParadigmReader` to:
   - Detect `/` separator in word forms
   - Split and store variants (either as separate WordForm objects or as a list within WordForm)
2. Modify `ApertiumMonodixWriter.writeParadigmDefinition()` to:
   - For each feature structure with variants, generate multiple `<e>` entries
   - Each variant gets its own suffix extraction and `<e>` entry in the pardef
   - Consider adding variant/dialect tags if needed to distinguish forms

### Recommended Implementation Strategy

**Phase 1**: Fix stem-suffix separation
1. Study `examples/apertium-hin.hin.dix.xml` to understand pardef naming convention
2. Implement per-lexicon-entry pardef generation (since each lemma may split differently)
3. Format pardef names as: `stem/lemma_suffix__original_category_name`
4. Update main section to write only stems in `<i>` tags

**Phase 2**: Handle variants
1. Modify paradigm reader to split on `/`
2. Generate multiple pardef entries for each variant
3. Test with Bhojpuri data containing variants

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

### Legacy Code
The `source-files-06-05-25/` directory contains older implementations - **do not modify**. Work only in `src/` directory.

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
lt-comp lr bhojpuri-monodix.dix bhojpuri.bin
echo "घरों" | lt-proc bhojpuri.bin
```
