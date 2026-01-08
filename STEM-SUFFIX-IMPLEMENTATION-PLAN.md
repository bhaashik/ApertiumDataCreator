# Stem/Suffix Separation Implementation Plan

## Current vs. Correct Approach

### Current Approach (WRONG)
```xml
<pardef n="Noun_m">
  <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/></r></p></e>
  <e><p><l>ों</l><r><s n="n"/><s n="m"/><s n="pl"/></r></p></e>
</pardef>

<e lm="घर"><i>घर</i><par n="Noun_m"/></e>
```

**Problems:**
- Generic pardefs per category (Noun_m, Noun_f, etc.)
- Full lemma in `<i>` tag
- Suffix-only in `<l>` tag
- Result: 110 pardefs for 571K entries = huge file (47MB)

### Correct Approach (Hindi Example)
```xml
<pardef n="वध/ू__n_f">
  <e><p><l>ू</l><r>ू<s n="n"/><s n="f"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l>ुएँ</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="nom"/></r></p></e>
  <e><p><l>ुओं</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>

<e lm="वधू"><i>वध</i><par n="वध/ू__n_f"/></e>
```

**Benefits:**
- Pardef name encodes stem/suffix split: `stem/lemma_suffix__category`
- Only stem in `<i>` tag
- Lemma suffix in both `<l>` and `<r>` tags
- Result: 229 pardefs for 32K entries = small file (2.9MB)

## Key Concepts

### 1. Stem vs. Lemma Suffix
For lemma "वधू" (vadhū):
- **Stem**: वध (vadh) - the unchanging root
- **Lemma suffix**: ू (ū) - the part that marks the lemma form
- **Inflected suffixes**: ुएँ, ुओं - different forms

### 2. Pardef Name Format
```
stem/lemma_suffix__paradigm_category
```
Examples:
- `वध/ू__n_f` - stem=वध, lemma_suffix=ू, category=n_f
- `/ई__n_f` - stem=empty, lemma_suffix=ई, category=n_f
- `घ/र__n_m` - stem=घ, lemma_suffix=र, category=n_m

### 3. Pardef Structure
```xml
<pardef n="stem/lemma_suffix__category">
  <!-- For each word form in paradigm -->
  <e>
    <p>
      <l>inflected_suffix</l>
      <r>lemma_suffix + tags</r>
    </p>
  </e>
</pardef>
```

**Critical:** The `<r>` tag always contains the lemma_suffix, not the inflected suffix!

### 4. Lexicon Entry Structure
```xml
<e lm="full_lemma">
  <i>stem_only</i>
  <par n="stem/lemma_suffix__category"/>
</e>
```

## Implementation Steps

### Phase 1: Data Structure Changes

#### 1.1 Create New Class: `PardefInfo`
```java
class PardefInfo {
    String stem;              // e.g., "वध"
    String lemmaSuffix;       // e.g., "ू"
    String categoryName;      // e.g., "Noun_f"
    ParadigmCategory paradigm;
    List<LexiconEntry> entries; // All entries using this pardef

    String getPardefName() {
        return stem + "/" + lemmaSuffix + "__" + categoryName;
    }
}
```

#### 1.2 Modify `LexiconEntry`
Add fields to store stem/suffix split:
```java
class LexiconEntry {
    // Existing
    String lemma;
    String paradigmCategoryName;

    // NEW
    String stem;              // Extracted stem
    String lemmaSuffix;       // lemma - stem
}
```

### Phase 2: Stem Extraction Algorithm

#### 2.1 Extract Stem from Lemma
For each lexicon entry:
1. Get the paradigm for this entry
2. Get all word forms from paradigm
3. Use `StemExtractionStrategy` (already exists!) to find common prefix
4. stem = common prefix
5. lemmaSuffix = lemma - stem

Example:
```
Lemma: घर (ghar)
Word forms: घर, घरों
Common prefix: घर
stem = घर, lemmaSuffix = "" (empty)

Lemma: वधू (vadhū)
Word forms: वधू, वधुएँ, वधुओं
Common prefix: वध
stem = वध, lemmaSuffix = ू
```

#### 2.2 Handle Edge Cases
- **Empty stem**: When lemma = lemmaSuffix (e.g., "/ई__n_f")
- **Empty suffix**: When lemma = stem (e.g., "घर/__n_m")
- **Variants**: Split each variant separately

### Phase 3: Pardef Generation

#### 3.1 Group Entries by Pardef
```java
Map<String, PardefInfo> pardefs = new HashMap<>();

for (LexiconEntry entry : lexicon) {
    String pardefName = entry.stem + "/" + entry.lemmaSuffix + "__" + entry.paradigmCategory;

    if (!pardefs.containsKey(pardefName)) {
        PardefInfo info = new PardefInfo();
        info.stem = entry.stem;
        info.lemmaSuffix = entry.lemmaSuffix;
        info.categoryName = entry.paradigmCategory;
        info.paradigm = getParadigm(entry.paradigmCategory);
        pardefs.put(pardefName, info);
    }

    pardefs.get(pardefName).entries.add(entry);
}
```

#### 3.2 Write Pardef Definition
```java
void writePardef(PardefInfo info) {
    writer.write("<pardef n=\"" + info.getPardefName() + "\">\n");

    for (WordForm wf : info.paradigm.getWordForms()) {
        for (String variant : wf.getVariants()) {
            // Extract suffix from variant
            String inflectedSuffix = extractSuffix(variant, info.stem);

            writer.write("  <e>\n");
            writer.write("    <p>\n");
            writer.write("      <l>" + escapeXml(inflectedSuffix) + "</l>\n");
            writer.write("      <r>" + escapeXml(info.lemmaSuffix));
            writer.write(generateTags(wf.getFeatureStructure()));
            writer.write("</r>\n");
            writer.write("    </p>\n");
            writer.write("  </e>\n");
        }
    }

    writer.write("</pardef>\n");
}
```

### Phase 4: Lexicon Generation

```java
void writeLexiconEntry(LexiconEntry entry) {
    String pardefName = entry.stem + "/" + entry.lemmaSuffix + "__" + entry.paradigmCategory;

    writer.write("<e lm=\"" + escapeXml(entry.lemma) + "\">");
    writer.write("<i>" + escapeXml(entry.stem) + "</i>");
    writer.write("<par n=\"" + escapeXml(pardefName) + "\"/>");
    writer.write("</e>\n");
}
```

## Expected Impact

### File Size Reduction
**Current (Bhojpuri):**
- 111 pardefs
- 571,558 entries
- 47MB (WX)

**Expected (with stem/suffix):**
- ~10,000-50,000 unique stem/suffix combinations
- 571,558 entries (same)
- ~5-10MB (estimated 80-90% reduction)

### Why Smaller?
1. **Fewer duplicate pardefs**: Each unique stem/suffix gets one pardef
2. **Shorter entries**: Only stem in `<i>`, not full lemma
3. **Better compression**: More reuse of pardef references

## Code Changes Required

### Files to Modify

1. **`src/bhaashik/morph/model/LexiconEntry.java`**
   - Add `stem` and `lemmaSuffix` fields

2. **`src/bhaashik/morph/io/ApertiumMonodixWriter.java`**
   - Replace `writeParadigmDefinitions()` with new logic
   - Add `extractStemFromLemma()` method
   - Add `groupEntriesByPardef()` method
   - Modify `writeMainSection()` to use stem-only

3. **`src/bhaashik/morph/algorithm/StemExtractionStrategy.java`**
   - Already exists! Just need to use it differently
   - Currently used per-paradigm, need to use per-lexicon-entry

### New Files to Create

1. **`src/bhaashik/morph/model/PardefInfo.java`**
   - New class to represent unique pardefs

## Testing Strategy

### Phase 1: Single Paradigm Test
- Pick one paradigm (e.g., Noun_m)
- Pick 5-10 lexicon entries
- Generate pardef + lexicon manually
- Verify against Hindi example

### Phase 2: Full Generation
- Run on all three languages
- Compare file sizes
- Verify pardef count

### Phase 3: Compilation Test
- Try compiling with `lt-comp`
- Fix any XML/format errors
- Verify FST works

## Risk Areas

1. **Empty stems/suffixes**: Need special handling
2. **Variant forms**: Each variant may need separate pardef
3. **Special characters**: XML escaping in pardef names
4. **Performance**: Grouping 571K entries by pardef name
5. **Pardef name uniqueness**: Ensure no collisions

## Success Criteria

✓ File size: 5-10MB (vs. current 47MB)
✓ Pardef count: 10K-50K (vs. current 111)
✓ Compiles with lt-comp without errors
✓ Structure matches Hindi example
✓ All 571K entries have correct pardef references
