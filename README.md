# Bhaashik Morphological Analysis API

A comprehensive Java API for morphological analysis and generation, with support for multiple Indic languages and output formats including Apertium monodix (for FST-based analysis/generation).

## Overview

This API provides a complete framework for:
- **Morphological Analysis**: Analyzing word forms to extract lemma + morphological features
- **Morphological Generation**: Generating inflected forms from lemma + features
- **Data Conversion**: Converting linguistic data from various formats
- **FST Integration**: Exporting to Apertium monodix format for compilation to FSTs

## Dependencies

- **Java 8+** - Required for compilation and execution
- **Sanscript Java** - For WX notation and Indic script transliteration
  - Repository: https://github.com/indic-transliteration/sanscript.java
  - Included in `lib/sanscript-classes/` directory
- **JUnit 4.13.2** - For running unit tests (included in `lib/`)
- **Hamcrest 1.3** - For test assertions (included in `lib/`)

## Building the Project

```bash
# Clone the Sanscript library (already done if lib/sanscript-source exists)
git clone https://github.com/indic-transliteration/sanscript.java lib/sanscript-source

# Compile Sanscript
javac -d lib/sanscript-classes lib/sanscript-source/src/main/java/com/wellebee/sanskrit/Sanscript.java

# Compile the main project
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java

# Compile tests (optional)
javac -d bin -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" test/bhaashik/morph/*.java

# Run tests (optional)
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" org.junit.runner.JUnitCore bhaashik.morph.MonolingualDictionaryTest bhaashik.morph.MorphologicalUnitTest bhaashik.morph.StemExtractionTest bhaashik.morph.TAMMapperTest bhaashik.morph.WXConverterTest
```

**Note:** On Windows, use semicolons (`;`) instead of colons (`:`) in classpaths.

## Architecture

### Core Components

#### 1. Data Model (`bhaashik.morph.model`)
- **`MorphologicalUnit`** - Represents single-word or multi-word morphological units
- **`MorphologicalAnalysis`** - Single analysis with lemma, features, probability, frequency
- **`MonolingualDictionary`** - Maps word forms to analyses (supports ambiguity)
- **`ParadigmCategory`** - Represents paradigm categories (e.g., Noun_m, Verb_Past)
- **`SpecificParadigm`** - Specific paradigm for a lemma with word forms
- **`FeatureStructure`** - Morphological features (category, gender, number, person, case, vibhakti, TAM)
- **`LexiconEntry`** - Lexicon mapping from lemma to paradigm category

#### 2. I/O Layer (`bhaashik.morph.io`)

**Readers** (Input):
- **`ParadigmReader`** - Interface for reading paradigm data
  - `DotPFormatParadigmReader` - Reads .p format files
- **`FeatureStructureReader`** - Interface for reading feature structures
  - `MarkdownFeatureStructureReader` - Reads markdown format (ApertiumDataCreator-part-*.md)
- **`LexiconReader`** - Interface for reading lexicon data
  - `CSVLexiconReader` - Reads CSV format lexicon files

**Writers** (Output):
- **`DictionaryWriter`** - Interface for writing morphological dictionaries
  - `ApertiumMonodixWriter` - Exports to Apertium monodix XML format

#### 3. Algorithms (`bhaashik.morph.algorithm`)
- **`StemExtractionStrategy`** - Interface for stem/affix extraction
  - `LongestCommonPrefixStrategy` - LCP algorithm (for suffixing languages)
  - `LongestCommonSubsequenceStrategy` - LCS algorithm (for complex morphology)

#### 4. Utilities (`bhaashik.morph.util`, `bhaashik.morph.encoding`)
- **`TAMMapper`** - Cross-language TAM (Tense-Aspect-Mood) mapping
- **`WXConverter`** - WX notation ↔ Devanagari/Indic scripts encoding conversion (powered by Sanscript library)

## Input Data Format

### 1. Paradigm Files (.p)
Format:
```
ParadigmCategoryName
lemma1
wordform1_1
wordform1_2
...
lemma2
wordform2_1
wordform2_2
...
```

Example (Noun_m.p):
```
Noun_m
घर
घर
घरों
लड़का
लड़का
लड़कों
```

### 2. Feature Structure Files (Markdown)
Format:
```markdown
ParadigmCategoryName
<fs af='lemma,cat,gen,num,per,case,vibh,tam' attr='value'>
surface_form_in_target_language

<fs af='...'>
surface_form
```

Example:
```markdown
Noun_m
<fs af='XX,n,m,sg,,d,0,0'>
घर

<fs af='XX,n,m,pl,,o,0,0'>
घरों
```

### 3. Lexicon File (CSV)
Format: `"lemma","field2","specific_paradigm","paradigm_category","meaning","author"`

Example:
```csv
"घर","1","Gara","Noun_m","house","Author"
"लड़का","1","ladZikA","Noun_m","boy","Author"
```

### 4. TAM Mapping File (Optional)
Maps TAM markers from source languages to target language (e.g., Hindi).

Format:
```
SL	TL
ba	nA
yeke	nA
ilA	wA_hE
wa	rahA
```

## Usage

### Quick Start with Wrapper Scripts

The easiest way to generate monodix files is using the provided wrapper scripts:

**Windows:**
```bat
REM Build the project first
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java

REM Create all three dictionaries
create-all-monodix.bat

REM Or create individual dictionaries
create-bhojpuri-monodix.bat
create-maithili-monodix.bat
create-magahi-monodix.bat
```

**Linux/Mac:**
```bash
# Build the project first
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/**/*.java

# Create all three dictionaries
bash create-all-monodix.sh

# Or create individual dictionaries
bash create-bhojpuri-monodix.sh
bash create-maithili-monodix.sh
bash create-magahi-monodix.sh
```

### Command Line (Advanced)

```bash
# Using default paths (looks in input/ directory)
java -cp "bin:lib/sanscript-classes" bhaashik.morph.ApertiumCreatorMain

# With custom paths
java -cp "bin:lib/sanscript-classes" bhaashik.morph.ApertiumCreatorMain \
  --language <language> \
  --paradigm-dir <paradigm-dir> \
  --lexicon-file <lexicon-file> \
  --feature-file <feature-file> \
  --tam-file <tam-file> \
  --output <output.dix> \
  --script <script> \
  --vibhakti-mode <mode>
```

Example:
```bash
java -cp "bin:lib/sanscript-classes" bhaashik.morph.ApertiumCreatorMain \
  --language Bhojpuri \
  --paradigm-dir input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/paradigms \
  --lexicon-file input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/lexicon.txt \
  --feature-file input/B_M_M_Word-generation-ver-1.9.0.formatted.txt \
  --tam-file TAM-Mapping.md \
  --output bhojpuri-monodix.dix \
  --script Devanagari \
  --vibhakti-mode ATTACHED
```

### Programmatic API

```java
import bhaashik.morph.io.*;
import bhaashik.morph.algorithm.*;
import bhaashik.morph.util.TAMMapper;

// Step 1: Read feature structures
FeatureStructureReader fsReader = new MarkdownFeatureStructureReader();
ParadigmCategoryToFSSetMap fsMap = fsReader.readFeatureStructures(new File("."));

// Step 2: Read paradigms
ParadigmReader paradigmReader = new DotPFormatParadigmReader();
List<ParadigmCategory> categories = paradigmReader.readAllParadigms(
    new File("paradigms"),
    paradigmCatName -> fsMap.getWordFormCount(paradigmCatName)
);

// Step 3: Read lexicon
LexiconReader lexiconReader = new CSVLexiconReader();
List<LexiconEntry> lexicon = lexiconReader.readLexicon(new File("lexicon.txt"));

// Step 4: Configure and write output
ApertiumMonodixWriter writer = new ApertiumMonodixWriter();
writer.setStemExtractionStrategy(new LongestCommonPrefixStrategy());
writer.setScriptName("Devanagari");
writer.setVibhaktiHandling(ApertiumMonodixWriter.VibhaktiHandling.ATTACHED);

TAMMapper tamMapper = TAMMapper.createDefaultBMMToHindiMapper();
writer.setTAMMapper(tamMapper);

writer.writeDictionary(new File("output.dix"), categories, fsMap, lexicon);
```

## Configuration Options

### Stem Extraction Strategy
Choose the algorithm for separating stems from affixes:
- **`LongestCommonPrefixStrategy`** - Best for suffixing languages (default for Indic)
- **`LongestCommonSubsequenceStrategy`** - For non-concatenative morphology

### Vibhakti Handling
Configure how case markers/postpositions are handled:
- **`ATTACHED`** - Vibhakti is part of the word (e.g., घरमें) - Bhojpuri/Magahi/Maithili
- **`SEPARATE`** - Vibhakti is a separate word (e.g., घर में) - Hindi
- **`AUTO`** - Auto-detect based on feature structure attributes

### Script/Alphabet and Encoding Conversion
Specify the Unicode script range for the alphabet section:
- `Devanagari` (default)
- `Bengali`, `Gurmukhi`, `Gujarati`, `Oriya`, `Tamil`, `Telugu`, `Kannada`, `Malayalam`

The WXConverter (powered by Sanscript) supports transliteration between:
- **Brahmic scripts**: Devanagari, Bengali, Gujarati, Gurmukhi, Kannada, Malayalam, Oriya, Tamil, Telugu
- **Roman schemes**: WX, IAST, ITRANS, Harvard-Kyoto (HK), SLP1, Velthuis

Example usage:
```java
WXConverter converter = new WXConverter();
String devanagari = converter.convert("namaskAra", "WX", "Devanagari");
// Output: नमस्कार

String wx = converter.convert("नमस्कार", "Devanagari", "WX");
// Output: namaskAra

String iast = converter.convert("namaskAra", "WX", "IAST");
// Output: namaskāra
```

## Output Format

The API generates Apertium monodix XML files (.dix) with:
- **`<alphabet>`** - Character set (Unicode block + additional characters from data)
- **`<sdefs>`** - Symbol definitions (morphological tags)
- **`<pardefs>`** - Paradigm definitions (inflection patterns)
- **`<section id="main">`** - Lexicon entries

### Compiling to FST

Use Apertium's `lt-comp` to compile the .dix file to FST:

```bash
# For analysis (left-to-right)
lt-comp lr bhojpuri-monodix.dix bhojpuri-analyzer.bin

# For generation (right-to-left)
lt-comp rl bhojpuri-monodix.dix bhojpuri-generator.bin
```

### Using the FST

```bash
# Analysis
echo "घरों" | lt-proc bhojpuri-analyzer.bin
# Output: ^घर<n><m><pl><o>$

# Generation
echo "^घर<n><m><pl><o>$" | lt-proc -g bhojpuri-generator.bin
# Output: घरों
```

## Extending the API

### Adding a New Input Format

Implement the appropriate reader interface:

```java
public class MyCustomParadigmReader implements ParadigmReader {
    @Override
    public ParadigmCategory readParadigmCategory(File file, int numForms) throws IOException {
        // Your parsing logic
    }

    @Override
    public List<ParadigmCategory> readAllParadigms(File directory, FormCountProvider formCountProvider) throws IOException {
        // Your parsing logic
    }

    @Override
    public String getFormatName() {
        return "My Custom Format";
    }
}
```

### Adding a New Output Format

Implement the DictionaryWriter interface:

```java
public class JSONDictionaryWriter implements DictionaryWriter {
    @Override
    public void writeDictionary(File outputFile, List<ParadigmCategory> categories,
                               ParadigmCategoryToFSSetMap fsMap, List<LexiconEntry> lexicon) throws IOException {
        // Your export logic
    }

    @Override
    public String getFormatName() {
        return "JSON";
    }

    @Override
    public String getFileExtension() {
        return "json";
    }
}
```

### Adding a New Stem Extraction Algorithm

Implement the StemExtractionStrategy interface:

```java
public class MyCustomStrategy implements StemExtractionStrategy {
    @Override
    public StemAffixResult extract(String lemma, String inflectedForm) {
        // Your algorithm
    }

    @Override
    public String getStrategyName() {
        return "My Custom Algorithm";
    }
}
```

## Testing

The project includes comprehensive unit tests covering:
- **MorphologicalUnitTest** - Single-word and multi-word units, equality
- **MonolingualDictionaryTest** - Dictionary operations, ambiguity handling
- **StemExtractionTest** - LCP and LCS algorithms, edge cases
- **TAMMapperTest** - TAM mapping, default mappings
- **WXConverterTest** - WX/Devanagari conversion, encoding support

**Running tests:**
```bash
# Windows
java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/sanscript-classes" org.junit.runner.JUnitCore bhaashik.morph.MonolingualDictionaryTest bhaashik.morph.MorphologicalUnitTest bhaashik.morph.StemExtractionTest bhaashik.morph.TAMMapperTest bhaashik.morph.WXConverterTest

# Linux/Mac
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/sanscript-classes" org.junit.runner.JUnitCore bhaashik.morph.MonolingualDictionaryTest bhaashik.morph.MorphologicalUnitTest bhaashik.morph.StemExtractionTest bhaashik.morph.TAMMapperTest bhaashik.morph.WXConverterTest
```

**Test results:** 33 tests pass ✅

## Supported Languages

Currently tested with:
- **Bhojpuri** (भोजपुरी)
- **Maithili** (मैथिली)
- **Magahi** (मगही)

The API is designed to work with any language given appropriate paradigm and feature structure data.

## Project Structure

```
ApertiumDataCreator/
├── src/
│   └── bhaashik/
│       └── morph/
│           ├── ApertiumCreatorMain.java      # Main entry point
│           ├── model/                         # Data models
│           │   ├── MorphologicalUnit.java
│           │   ├── MorphologicalAnalysis.java
│           │   ├── MonolingualDictionary.java
│           │   ├── ParadigmCategory.java
│           │   ├── SpecificParadigm.java
│           │   ├── WordForm.java
│           │   ├── FeatureStructure.java
│           │   └── LexiconEntry.java
│           ├── io/                            # I/O layer
│           │   ├── ParadigmReader.java
│           │   ├── DotPFormatParadigmReader.java
│           │   ├── FeatureStructureReader.java
│           │   ├── MarkdownFeatureStructureReader.java
│           │   ├── LexiconReader.java
│           │   ├── CSVLexiconReader.java
│           │   ├── DictionaryWriter.java
│           │   └── ApertiumMonodixWriter.java
│           ├── algorithm/                     # Algorithms
│           │   ├── StemExtractionStrategy.java
│           │   ├── LongestCommonPrefixStrategy.java
│           │   └── LongestCommonSubsequenceStrategy.java
│           ├── encoding/                      # Encoding converters
│           │   └── WXConverter.java
│           ├── util/                          # Utilities
│           │   └── TAMMapper.java
│           └── api/                           # API interfaces
│               ├── MorphologicalAnalyzer.java
│               ├── MorphologicalGenerator.java
│               ├── EncodingConverter.java
│               ├── DataLoader.java
│               └── MorphologyExporter.java
├── input/                                     # Input data
│   └── Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/
├── output/                                    # Generated files
├── ApertiumDataCreator-part-*.md             # Feature structure data (13 parts)
├── TAM-Mapping.md                            # TAM mapping file
└── README.md                                 # This file
```

## Technical Details

### Feature Structure Format

The 8-field feature structure (af='...') contains:
1. **Lemma** - Base form (or placeholder like 'XX')
2. **Category** - POS tag (n=noun, v=verb, pn=pronoun, adj=adjective, etc.)
3. **Gender** - m/f/any
4. **Number** - sg/pl/any
5. **Person** - 1/2/3/any
6. **Case** - d (direct), o (oblique), any
7. **Vibhakti** - Case marker/postposition (ko, se, meM, para, kA, 0)
8. **TAM** - Tense-Aspect-Mood marker (gA, wa, yala, hE, etc.)

Additional attributes (emph, emph1, agr_gen, etc.) are also supported.

### Apertium Monodix Format

The generated .dix file follows Apertium's monodix format:
- **`<l>` (left side)**: Surface form suffix - used for ANALYSIS
- **`<r>` (right side)**: Morphological tags - used for GENERATION

Example paradigm entry:
```xml
<pardef n="Noun_m">
  <e>
    <p>
      <l>ों</l>  <!-- Surface suffix -->
      <r><s n="n"/><s n="m"/><s n="pl"/><s n="o"/></r>  <!-- Tags -->
    </p>
  </e>
</pardef>
```

## License

[Add your license information here]

## Contributors

[Add contributor information here]

## References

- Apertium: https://www.apertium.org/
- Sanscript Java Library: https://github.com/indic-transliteration/sanscript.java
- Universal Dependencies: https://universaldependencies.org/
- UniMorph: https://unimorph.github.io/
- Computational Paninian Grammar (CPG)
- WX Notation: https://en.wikipedia.org/wiki/WX_notation
