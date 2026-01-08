# Session Summary: Stem/Suffix Implementation
**Date:** 2026-01-07
**Tokens Used:** ~104K
**Status:** Planning and data preparation complete, ready for implementation

---

## Problem Identified

The generated monodix files are **10-20x larger** than they should be:

| Language | Current Size | Expected Size | Current Pardefs | Expected Pardefs |
|----------|--------------|---------------|-----------------|------------------|
| Bhojpuri | 47MB (WX)    | ~5-10MB       | 111             | ~10K-50K         |
| Maithili | 51MB (WX)    | ~5-10MB       | 110             | ~10K-50K         |
| Magahi   | 39MB (WX)    | ~5-10MB       | 110             | ~10K-50K         |

**Comparison with Hindi:**
- Hindi: 2.9MB, 229 pardefs, 32K entries
- Our approach: Missing stem/suffix separation

---

## Root Cause Analysis

### Current Approach (WRONG)
```xml
<pardef n="Noun_m">
  <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/></r></p></e>
  <e><p><l>ों</l><r><s n="n"/><s n="m"/><s n="pl"/></r></p></e>
</pardef>

<e lm="घर"><i>घर</i><par n="Noun_m"/></e>
<e lm="आदमी"><i>आदमी</i><par n="Noun_m"/></e>
```

**Problems:**
1. Generic pardefs per category (Noun_m applies to all masculine nouns)
2. Full lemma in `<i>` tag
3. Doesn't handle vowel-ending vs consonant-ending properly
4. Result: 571K full lemmas duplicated in file

### Correct Approach (Hindi Example)
```xml
<pardef n="वध/ू__n_f">
  <e><p><l>ू</l><r>ू<s n="n"/><s n="f"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l>ुएँ</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="nom"/></r></p></e>
</pardef>

<e lm="वधू"><i>वध</i><par n="वध/ू__n_f"/></e>
```

**Benefits:**
1. Pardef name encodes stem/suffix split: `stem/lemma_suffix__category`
2. Only stem in `<i>` tag (shorter)
3. Lemma suffix in both `<l>` and `<r>` tags
4. Each unique stem/suffix pattern gets one pardef
5. Result: Massive deduplication

---

## Key Understanding: Data Flow

### 1. Input Sources
```
Paradigm Files (.p) → Prototypical examples showing patterns
    ↓
Feature Structures (B_M_M file) → Maps features to word forms
    ↓
Lexicon (dict.final) → Maps lemmas to paradigm categories
```

### 2. Paradigm File Structure
Example: `Noun_m.p`
```
Noun_m              ← Category name
लड़िका              ← Prototypical lemma
लड़िका              ← Form 1: sg, direct (same as lemma)
लड़िकन              ← Form 2: sg, oblique (का → कन pattern)
लड़िका              ← Form 3: pl, direct
लड़िकन              ← Form 4: pl, oblique
```

**Key Insight:** This shows the PATTERN. For other lemmas (घर, आदमी), apply the same transformations.

### 3. Feature Structure Format
From `B_M_M_Word-generation-ver-1.9.0.formatted-structured-for-csv-for-dix-generation.md`:
```
\[\[Noun_m\]\]

\<fs af='XX,n,m,sg,3,d,0,0'\>
\> घर
\>\> घर

\<fs af='XX,n,m,pl,3,d,0,0'\>
\> घर
\>\> घर

\<fs af='XX,n,m,sg,3,o,0,0'\>
\> घर
\>\> घर

\<fs af='XX,n,m,pl,3,o,0,0'\>
\> घरन
\>\> घरों
```

**Fields in af:** lemma, category, gender, number, person, case, vibhakti, TAM

### 4. Current Code Flow
```
1. Read paradigms (.p files) → ParadigmCategory objects
2. Read feature structures → ParadigmCategoryToFSSetMap
3. Read lexicon → LexiconEntry objects
4. For each paradigm category:
   - Write ONE pardef with generic name (Noun_m)
5. For each lexicon entry:
   - Write full lemma in <i> tag
   - Reference generic pardef
```

---

## Work Completed

### ✅ 1. Input Data Conversion
**Script:** `convert-input-to-deva.py`

Converted all input data from WX to Devanagari using Python `wxconv` library:
- ✅ Bhojpuri: 117 paradigms, 571,558 lexicon entries
- ✅ Maithili: 120 paradigms, 625,668 lexicon entries
- ✅ Magahi: 120 paradigms, 488,783 lexicon entries

**Conversion Rules:**
- `.p` files: Keep paradigm name (line 1) in WX, convert word forms
- Lexicon: Convert only fields 1 and 3, keep field 4 (paradigm name) in ASCII
- Feature structure file: NOT converted (not needed)

**Output Locations:**
```
input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/
  bhojpuri/paradigms-deva/
  bhojpuri/lexicon-deva.txt
  maithili/paradigms-deva/
  maithili/lexicon-deva.txt
  magahi/paradigms-deva/
  magahi/lexicon-deva.txt
```

### ✅ 2. Documentation Created

1. **STEM-SUFFIX-IMPLEMENTATION-PLAN.md**
   - Comprehensive implementation plan
   - Data structure changes needed
   - Algorithm details
   - Expected impact analysis

2. **test-case-noun-m.md**
   - Concrete test case with 2 entries (आदमी, घर)
   - Shows expected output for both:
     - Vowel-ending lemma (आदमी → आदम/ी)
     - Consonant-ending lemma (घर → घर/__)
   - Validation steps

3. **CLAUDE.md**
   - Already comprehensive project documentation
   - Updated with recent findings

### ✅ 3. Issue Analysis

**Avagraha Character Issue:** Confirmed that Java Sanscript converter uses 'Z' instead of 'ऽ'. Using Python `wxconv` solves this.

**File Size Issue:** Root cause identified - no stem/suffix separation leads to massive duplication.

---

## Implementation Plan

### Phase 1: Model Changes (NEW CLASSES)

#### 1. Create `PardefInfo.java`
```java
package bhaashik.morph.model;

public class PardefInfo {
    private String stem;              // e.g., "वध"
    private String lemmaSuffix;       // e.g., "ू"
    private String categoryName;      // e.g., "Noun_m"
    private ParadigmCategory paradigm;
    private List<LexiconEntry> entries;

    public String getPardefName() {
        return stem + "/" + lemmaSuffix + "__" + categoryName;
    }

    // Getters, setters, constructor...
}
```

#### 2. Modify `LexiconEntry.java`
Add fields:
```java
private String stem;              // Extracted stem
private String lemmaSuffix;       // lemma - stem
```

### Phase 2: Algorithm Implementation (CORE LOGIC)

#### 1. Stem Extraction Method
Location: `ApertiumMonodixWriter.java`
```java
private void extractStemAndSuffix(LexiconEntry entry, ParadigmCategory paradigm) {
    String lemma = entry.getLemma();
    List<WordForm> wordForms = paradigm.getWordForms();

    // Use existing StemExtractionStrategy!
    List<String> allForms = new ArrayList<>();
    allForms.add(lemma);
    for (WordForm wf : wordForms) {
        allForms.addAll(wf.getVariants());
    }

    StemAffixResult result = stemExtractor.extract(lemma, allForms);
    entry.setStem(result.getStem());
    entry.setLemmaSuffix(lemma.substring(result.getStem().length()));
}
```

#### 2. Pardef Grouping Method
```java
private Map<String, PardefInfo> groupEntriesByPardef(
    List<ParadigmCategory> categories,
    ParadigmCategoryToFSSetMap fsMap,
    List<LexiconEntry> lexicon) {

    Map<String, PardefInfo> pardefs = new HashMap<>();

    // First, extract stem/suffix for all entries
    for (LexiconEntry entry : lexicon) {
        ParadigmCategory paradigm = findParadigm(categories, entry.getParadigmCategoryName());
        extractStemAndSuffix(entry, paradigm);
    }

    // Then group by pardef name
    for (LexiconEntry entry : lexicon) {
        String pardefName = entry.getStem() + "/" + entry.getLemmaSuffix() +
                           "__" + entry.getParadigmCategoryName();

        if (!pardefs.containsKey(pardefName)) {
            PardefInfo info = new PardefInfo();
            info.setStem(entry.getStem());
            info.setLemmaSuffix(entry.getLemmaSuffix());
            info.setCategoryName(entry.getParadigmCategoryName());
            info.setParadigm(findParadigm(categories, entry.getParadigmCategoryName()));
            pardefs.put(pardefName, info);
        }

        pardefs.get(pardefName).getEntries().add(entry);
    }

    return pardefs;
}
```

### Phase 3: Output Generation (MODIFY EXISTING)

#### 1. Modify `writeParadigmDefinitions()`
```java
private void writeParadigmDefinitions(
    Writer writer,
    Map<String, PardefInfo> pardefs,
    ParadigmCategoryToFSSetMap fsMap) throws IOException {

    writer.write("  <pardefs>\n");

    for (PardefInfo info : pardefs.values()) {
        writePardefDefinition(writer, info, fsMap);
    }

    writer.write("  </pardefs>\n");
}

private void writePardefDefinition(
    Writer writer,
    PardefInfo info,
    ParadigmCategoryToFSSetMap fsMap) throws IOException {

    writer.write("    <pardef n=\"" + escapeXml(info.getPardefName()) + "\">\n");

    ParCatFeatureStructures fsEntries = fsMap.getFeatureStructures(info.getCategoryName());
    List<WordForm> wordForms = info.getParadigm().getWordForms();

    for (int i = 0; i < wordForms.size(); i++) {
        WordForm wf = wordForms.get(i);
        FeatureStructureEntry fsEntry = fsEntries.getEntries().get(i);

        for (String variant : wf.getVariants()) {
            // Extract inflected suffix
            String inflectedSuffix = variant.substring(info.getStem().length());

            writer.write("      <e>\n");
            writer.write("        <p>\n");
            writer.write("          <l>" + escapeXml(inflectedSuffix) + "</l>\n");
            writer.write("          <r>" + escapeXml(info.getLemmaSuffix()));
            writer.write(generateTagsFromFeatureStructure(fsEntry.getFeatureStructure()));
            writer.write("</r>\n");
            writer.write("        </p>\n");
            writer.write("      </e>\n");
        }
    }

    writer.write("    </pardef>\n");
}
```

#### 2. Modify `writeMainSection()`
```java
private void writeMainSection(
    Writer writer,
    List<LexiconEntry> lexicon) throws IOException {

    writer.write("  <section id=\"main\" type=\"standard\">\n");

    for (LexiconEntry entry : lexicon) {
        String pardefName = entry.getStem() + "/" + entry.getLemmaSuffix() +
                           "__" + entry.getParadigmCategoryName();

        writer.write("    <e lm=\"" + escapeXml(entry.getLemma()) + "\">");
        writer.write("<i>" + escapeXml(entry.getStem()) + "</i>");
        writer.write("<par n=\"" + escapeXml(pardefName) + "\"/>");
        writer.write("</e>\n");
    }

    writer.write("  </section>\n");
}
```

#### 3. Update Main Generation Logic
In `writeDictionary()`:
```java
// OLD:
writeParadigmDefinitions(writer, categories, fsMap);
writeMainSection(writer, lexicon);

// NEW:
Map<String, PardefInfo> pardefs = groupEntriesByPardef(categories, fsMap, lexicon);
writeParadigmDefinitions(writer, pardefs, fsMap);
writeMainSection(writer, lexicon);
```

---

## Testing Strategy

### Test 1: Small Dataset (5-10 entries)
```bash
# Create test lexicon with just 10 Noun_m entries
head -10 input/bhojpuri/lexicon-deva.txt > test-lexicon.txt

# Generate monodix
java -cp "bin:lib/*" bhaashik.morph.ApertiumCreatorMain \
  input/bhojpuri/paradigms-deva \
  test-lexicon.txt \
  . \
  test-output.dix \
  Bhojpuri

# Verify:
# 1. Check pardef count (should be ~5-10, not 1)
# 2. Check pardef names have stem/suffix format
# 3. Check <i> tags contain only stems
# 4. Manually verify against Hindi example
```

### Test 2: Full Bhojpuri
```bash
# Generate full Bhojpuri monodix
bash create-bhojpuri-monodix.sh

# Verify:
# 1. File size ~5-10MB (vs. current 47MB)
# 2. Pardef count ~10K-50K (vs. current 111)
# 3. Compiles with lt-comp
# 4. Sample verification of specific entries
```

### Test 3: All Languages
```bash
# Generate all three
bash create-all-monodix.sh

# Compare sizes
ls -lh output/*-wx.dix
```

---

## Expected Results

### File Size Reduction
```
Bhojpuri: 47MB → ~5-10MB (80-90% reduction)
Maithili: 51MB → ~5-10MB (80-90% reduction)
Magahi:   39MB → ~5-10MB (80-90% reduction)
```

### Pardef Count Increase
```
Current:  ~111 per language
Expected: ~10,000-50,000 per language (100-500x increase)
```

**Why this is GOOD:**
- More pardefs = better deduplication
- Each unique stem/suffix pattern gets its own pardef
- Lexicon entries just reference these shared pardefs
- Overall file size dramatically reduced

---

## Critical Edge Cases to Handle

1. **Empty stem**: Lemma like "ई" where stem = "", suffix = "ई"
   - Pardef name: `/ई__Noun_f`

2. **Empty suffix**: Lemma like "घर" where stem = "घर", suffix = ""
   - Pardef name: `घर/__Noun_m`

3. **Variant forms**: Lemmas with `/` separator
   - Example: "kuvAz/kuAz" in WX
   - Each variant may need separate processing

4. **Special characters in pardef names**:
   - Forward slash `/` is okay in XML attributes
   - Devanagari characters are okay
   - Must XML-escape: `<`, `>`, `&`, `"`, `'`

5. **Performance**: 571K entries need stem extraction
   - Use efficient data structures (HashMap)
   - Consider progress logging for large datasets

---

## Files Modified/Created

### New Files
- `src/bhaashik/morph/model/PardefInfo.java` (NEW)
- `convert-input-to-deva.py` (CREATED)
- `STEM-SUFFIX-IMPLEMENTATION-PLAN.md` (CREATED)
- `test-case-noun-m.md` (CREATED)
- `SESSION-2026-01-07-stem-suffix-implementation.md` (THIS FILE)

### Modified Files
- `src/bhaashik/morph/model/LexiconEntry.java` (add fields)
- `src/bhaashik/morph/io/ApertiumMonodixWriter.java` (major refactor)

### Existing Files (unchanged, but used)
- `src/bhaashik/morph/algorithm/StemExtractionStrategy.java` (already exists!)
- `src/bhaashik/morph/algorithm/LongestCommonPrefixStrategy.java`

---

## Next Session TODO

1. **Create PardefInfo.java** class
2. **Modify LexiconEntry.java** to add stem/suffix fields
3. **Implement stem extraction** in ApertiumMonodixWriter
4. **Implement pardef grouping** logic
5. **Modify writeParadigmDefinitions()** method
6. **Modify writeMainSection()** method
7. **Test on small dataset** (10 entries)
8. **Test on full Bhojpuri** dataset
9. **Generate all three languages**
10. **Verify file sizes and compilation**

---

## Important Notes for Resumption

1. **Devanagari input data is ready** - use the `-deva` directories and files
2. **Don't convert paradigm names** - they stay in ASCII
3. **Use existing StemExtractionStrategy** - it's already implemented!
4. **Reference Hindi example** at `examples/apertium-hin.hin.dix.xml`
5. **Test incrementally** - don't jump to full generation
6. **The key insight**: Pardef name encodes the stem/suffix split

---

## Commands for Next Session

```bash
# Verify Devanagari input is ready
ls -la input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/paradigms-deva/
ls -la input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/lexicon-deva.txt

# After implementation, test with small dataset
head -10 input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/lexicon-deva.txt > test-lexicon.txt

# Compile
javac -d bin -cp "lib/sanscript-classes" src/bhaashik/morph/model/*.java src/bhaashik/morph/io/*.java

# Run test
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.ApertiumCreatorMain \
  input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri/paradigms-deva \
  test-lexicon.txt \
  . \
  test-output.dix \
  Bhojpuri

# Verify output
grep -c '<pardef n=' test-output.dix
head -100 test-output.dix
```

---

## Success Criteria

✅ File size: 5-10MB (down from 47MB)
✅ Pardef count: 10K-50K (up from 111)
✅ Pardef names use `stem/suffix__category` format
✅ Lexicon entries use `<i>stem</i>` not `<i>full_lemma</i>`
✅ Compiles with `lt-comp` without errors
✅ Structure matches Hindi example in `examples/`
✅ All three languages generated successfully

---

End of Session Summary
