# Session 2026-01-08: Stem/Suffix Implementation Results

## Summary

Implemented stem/suffix separation in Apertium monodix generation, but results show the approach needs revision.

## Implementation Completed

### Code Changes
1. ✅ Created `PardefInfo` model class (`src/bhaashik/morph/model/PardefInfo.java`)
2. ✅ Added `stem` and `lemmaSuffix` fields to `LexiconEntry.java`
3. ✅ Implemented `extractStemFromParadigm()` - finds common prefix of all paradigm word forms
4. ✅ Implemented `extractStemsAndGroupPardefs()` - groups lexicon entries by unique stem/suffix/category
5. ✅ Modified `writeDictionary()` to use new grouping approach
6. ✅ Updated `writeParadigmDefinitionsNew()` and `writeMainSectionNew()` for stem-only format

### Algorithm Used
For each lexicon entry:
1. Get paradigm category's stem (common prefix of paradigm's word forms)
2. Calculate stem length ratio from paradigm (stem_len / lemma_len)
3. Apply same ratio to lexicon entry to split into stem + suffix
4. Group entries by unique `stem/suffix__category` combination
5. Generate one pardef per unique combination

## Results - WORSE than before!

### File Statistics

**Before (OLD approach)**:
- File size: 47MB
- Pardefs: 111 (one per category)
- Format: Generic category names (e.g., `Noun_m`)
- Lexicon: Full lemma in `<i>` tag

**After (NEW approach)**:
- File size: 784MB (16.7x LARGER!)
- Pardefs: 441,730 (3,980x MORE!)
- Format: Stem/suffix names (e.g., `1000/vAz__Adj_m_vAlA`)
- Lexicon: Stem-only in `<i>` tag

**Expected (based on Hindi)**:
- File size: 5-10MB (2.9MB for Hindi)
- Pardefs: 10K-50K (229 for Hindi)
- Format: Stem/suffix names with clustering

### Sample Pardefs Generated
```xml
<pardef n="1000/vAz__Adj_m_vAlA">
<pardef n="100_gunA__Advrb">
<pardef n="1/00_gunA__Advrb_e1">
<pardef n="अ/A__Adj_f_e_vAlI">
```

## Problem Diagnosis

### Why 441K pardefs instead of expected 10K-50K?

The length-based splitting creates **artificially unique stem/suffix combinations** for almost every lexicon entry.

**Example**:
- Paradigm: Noun_m with lemma "घर" (ghar)
- Paradigm word forms: घर, घरों, घरन, घरस
- Extracted paradigm stem: "घर" (length = 3 characters)
- Paradigm lemma length: 3 characters
- **Ratio**: 3/3 = 1.0 (100% stem, 0% suffix)

When applied to different lexicon entries:
- "आदमी" (5 chars) → stem="आदमी" (5 chars * 1.0), suffix="" → pardef `आदमी/__Noun_m`
- "लड़का" (5 chars) → stem="लड़का" (5 chars * 1.0), suffix="" → pardef `लड़का/__Noun_m`
- "घोड़ा" (5 chars) → stem="घोड़ा" (5 chars * 1.0), suffix="" → pardef `घोड़ा/__Noun_m`

**Result**: Every word gets a unique pardef, no grouping benefit!

### Why is file size 16x larger?

Each of the 441K pardefs contains:
- Full paradigm definition (all word forms with variants)
- For Noun_m: 4 forms with multiple variants = ~40 lines per pardef
- 441K pardefs × 40 lines = ~17.6M lines of pardef definitions
- Plus 571K lexicon entries

**OLD approach**:
- 111 pardefs × 40 lines = ~4.4K lines
- 571K lexicon entries with full lemmas
- **Total**: ~2.3M lines, 47MB

**NEW approach**:
- 441K pardefs × 40 lines = ~17.6M lines
- 571K lexicon entries with stems only
- **Total**: ~30M lines, 784MB

## Root Cause Analysis

### The Core Issue

**My assumption**: Use paradigm's stem length ratio to split each lexicon entry.

**Why this fails**:
1. The paradigm's stem ratio is specific to that ONE prototypical example
2. Applying it blindly to all words creates arbitrary splits
3. Words don't naturally cluster because splits are artificial, not morphological

**Hindi's approach** (229 pardefs for 32K entries):
- Hand-curated or morphologically analyzed
- Real stem/suffix boundaries based on actual inflection patterns
- Words with same morphological pattern share pardefs
- Natural clustering reduces pardef count

**Our situation**:
- Paradigms are templates, not real morphological patterns
- We only have lemma → paradigm mapping, not actual inflections per word
- Length-based splitting doesn't respect morphological boundaries
- No natural clustering possible

## Options Going Forward

### Option 1: Revert to Per-Category Pardefs (RECOMMENDED)
Keep 111 pardefs (one per category) but improve the format:
- Pardef definitions use stem/suffix from paradigm template
- Lexicon entries write stem-only in `<i>` tags
- Pardef names stay as category names (not stem/suffix format)
- File size: Similar to 47MB, maybe smaller with stem-only entries

**Pros**:
- Simple, works with current data
- File size manageable
- Matches our data structure (paradigm templates + lemma mapping)

**Cons**:
- Doesn't follow Hindi's stem/suffix pardef naming convention
- Larger than ideal (47MB vs Hindi's 2.9MB)

### Option 2: Morphological Analysis Per Word
Implement real morphological analysis:
- For each lemma, generate its inflected forms using the paradigm
- Extract stem from actual inflections (not from length ratio)
- Group by real morphological patterns

**Pros**:
- Correct approach, follows Hindi model
- Better compression through natural clustering

**Cons**:
- Requires implementing inflection generation
- Complex, time-consuming
- May still have many unique patterns due to language complexity

### Option 3: Hybrid Approach
- Use per-category pardefs (111)
- Optimize pardef definitions to reduce redundancy
- Use stem-only lexicon entries
- Accept 47MB as reasonable for 571K entries

## Recommendation

**Go with Option 1** for now:
1. Revert pardef generation to per-category approach (111 pardefs)
2. Keep the stem extraction for lexicon entries (write stem-only in `<i>` tags)
3. Pardef names = category names (e.g., "Noun_m")
4. Pardef definitions still use stem/suffix extraction from paradigm

This gives us:
- ✅ Correct Apertium format with stem-only in `<i>` tags
- ✅ Manageable file size (~47MB or less)
- ✅ Works with current data structure
- ✅ No need for complex morphological analysis

The file will be larger than Hindi's 2.9MB because:
- Hindi: 32K entries, 229 carefully curated patterns
- Bhojpuri: 571K entries (18x more), less morphological clustering

A 47MB file for 571K entries is actually reasonable (82 bytes/entry).

## Next Steps

1. Modify `extractStemsAndGroupPardefs()` to group by category only, not stem/suffix
2. Keep stem extraction for individual entries
3. Update pardef name format to use category names
4. Regenerate and verify file size
5. Test with small dataset first
