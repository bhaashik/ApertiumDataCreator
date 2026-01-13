# Test Case: Noun_m Paradigm

## Input Data

### Paradigm File: Noun_m.p (Devanagari)
```
Noun_m
लड़िका
लड़िका
लड़िकन
लड़िका
लड़िकन
राजा
राजा
राजा
राजा
राजन
घर
घर
घर
घर
घरन
खर्च
खर्च
खर्च
खर्च
```

**Analysis:**
- 4 word forms per lemma
- Pattern: sg-direct, sg-direct, sg-oblique, pl-direct, pl-oblique
- Some lemmas: लड़िका, राजा, घर, खर्च

### Lexicon Entries
```
"","","आदमी","Noun_m","",""
"","","घर","Noun_m","",""
```

**Lemmas to test:**
1. **आदमी** (ādmī) - man
2. **घर** (ghar) - house

## Step-by-Step Generation

### Entry 1: आदमी (ādmī)

**Step 1: Get paradigm word forms**
From Noun_m paradigm, we need word forms for lemma "आदमी".
Looking at the pattern (4 forms):
- आदमी (sg, direct)
- आदमी (sg, direct) - duplicate
- आदमियन (sg, oblique) - suffix "यन"
- आदमी (pl, direct)
- आदमियन (pl, oblique)

**Step 2: Extract stem**
```
Lemma: आदमी
Word forms: आदमी, आदमियन
Common prefix (stem): आदमी
```
Wait - the stem should be shorter! Let me reconsider...

Actually, looking at the paradigm more carefully:
- लड़िका → लड़िकन (suffix changes: का → कन)
- राजा → राजन (suffix changes: आ → न)
- घर → घरन (suffix changes: "" → न)

So the pattern is:
- For lemmas ending in vowel: stem = lemma minus last character
- For lemmas ending in consonant: stem = full lemma

**Corrected extraction:**
```
Lemma: आदमी (ādmī)
Last char: ई
Stem: आदम (ādam)
Lemma suffix: ी (ī)

Word forms that would be generated:
- आदम + ी = आदमी (sg, direct)
- आदम + ियन = आदमियन (sg, oblique)
```

**Step 3: Generate pardef name**
```
stem/lemma_suffix__category
आदम/ी__Noun_m
```

**Step 4: Generate pardef**
```xml
<pardef n="आदम/ी__Noun_m">
  <!-- sg, direct: base form -->
  <e>
    <p>
      <l>ी</l>
      <r>ी<s n="n"/><s n="m"/><s n="sg"/><s n="d"/></r>
    </p>
  </e>

  <!-- sg, oblique: suffix changes -->
  <e>
    <p>
      <l>ियन</l>
      <r>ी<s n="n"/><s n="m"/><s n="sg"/><s n="o"/></r>
    </p>
  </e>

  <!-- pl, direct: same as sg -->
  <e>
    <p>
      <l>ी</l>
      <r>ी<s n="n"/><s n="m"/><s n="pl"/><s n="d"/></r>
    </p>
  </e>

  <!-- pl, oblique: suffix changes -->
  <e>
    <p>
      <l>ियन</l>
      <r>ी<s n="n"/><s n="m"/><s n="pl"/><s n="o"/></r>
    </p>
  </e>
</pardef>
```

**Step 5: Generate lexicon entry**
```xml
<e lm="आदमी">
  <i>आदम</i>
  <par n="आदम/ी__Noun_m"/>
</e>
```

### Entry 2: घर (ghar)

**Step 1: Word forms**
From paradigm:
- घर (sg, direct)
- घर (sg, direct)
- घर (sg, oblique)
- घर (pl, direct)
- घरन (pl, oblique)

**Step 2: Extract stem**
```
Lemma: घर
Last char: र (consonant)
Stem: घर (full word - no vowel ending to remove)
Lemma suffix: "" (empty)

Alternatively, looking at the oblique form:
घर → घरन (suffix: "" → न)
So stem could be: घर
But for consistency with lemma, we keep:
Stem: घर
Lemma suffix: "" (empty)
```

**Step 3: Generate pardef name**
```
stem/lemma_suffix__category
घर/__Noun_m
```

**Step 4: Generate pardef**
```xml
<pardef n="घर/__Noun_m">
  <!-- sg, direct: base form -->
  <e>
    <p>
      <l></l>
      <r><s n="n"/><s n="m"/><s n="sg"/><s n="d"/></r>
    </p>
  </e>

  <!-- sg, oblique: no change -->
  <e>
    <p>
      <l></l>
      <r><s n="n"/><s n="m"/><s n="sg"/><s n="o"/></r>
    </p>
  </e>

  <!-- pl, direct: no change -->
  <e>
    <p>
      <l></l>
      <r><s n="n"/><s n="m"/><s n="pl"/><s n="d"/></r>
    </p>
  </e>

  <!-- pl, oblique: adds न -->
  <e>
    <p>
      <l>न</l>
      <r><s n="n"/><s n="m"/><s n="pl"/><s n="o"/></r>
    </p>
  </e>
</pardef>
```

**Step 5: Generate lexicon entry**
```xml
<e lm="घर">
  <i>घर</i>
  <par n="घर/__Noun_m"/>
</e>
```

## Expected vs. Current Output

### Current Output (WRONG)
```xml
<pardefs>
  <pardef n="Noun_m">
    <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/><s n="d"/></r></p></e>
    <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/><s n="o"/></r></p></e>
    <e><p><l></l><r><s n="n"/><s n="m"/><s n="pl"/><s n="d"/></r></p></e>
    <e><p><l>न</l><r><s n="n"/><s n="m"/><s n="pl"/><s n="o"/></r></p></e>
  </pardef>
</pardefs>

<section id="main">
  <e lm="आदमी"><i>आदमी</i><par n="Noun_m"/></e>
  <e lm="घर"><i>घर</i><par n="Noun_m"/></e>
</section>
```

**Problems:**
- One pardef for all Noun_m entries
- Doesn't handle vowel-ending vs consonant-ending properly
- "आदमी" would generate wrong forms (आदमीन instead of आदमियन)

### Expected Output (CORRECT)
```xml
<pardefs>
  <pardef n="आदम/ी__Noun_m">
    <e><p><l>ी</l><r>ी<s n="n"/><s n="m"/><s n="sg"/><s n="d"/></r></p></e>
    <e><p><l>ियन</l><r>ी<s n="n"/><s n="m"/><s n="sg"/><s n="o"/></r></p></e>
    <e><p><l>ी</l><r>ी<s n="n"/><s n="m"/><s n="pl"/><s n="d"/></r></p></e>
    <e><p><l>ियन</l><r>ी<s n="n"/><s n="म"/><s n="pl"/><s n="o"/></r></p></e>
  </pardef>

  <pardef n="घर/__Noun_m">
    <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/><s n="d"/></r></p></e>
    <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/><s n="o"/></r></p></e>
    <e><p><l></l><r><s n="n"/><s n="m"/><s n="pl"/><s n="d"/></r></p></e>
    <e><p><l>न</l><r><s n="n"/><s n="m"/><s n="pl"/><s n="o"/></r></p></e>
  </pardef>
</pardefs>

<section id="main">
  <e lm="आदमी"><i>आदम</i><par n="आदम/ी__Noun_m"/></e>
  <e lm="घर"><i>घर</i><par n="घर/__Noun_m"/></e>
</section>
```

**Benefits:**
- Each stem/suffix pattern gets its own pardef
- "आदमी" correctly generates: आदम+ियन = आदमियन
- "घर" correctly generates: घर+न = घरन
- Pardef name encodes the stem split

## Validation

### Test 1: Generate "आदमी" + oblique
```
Stem: आदम
Pardef: आदम/ी__Noun_m
Oblique suffix from pardef: ियन
Result: आदम + ियन = आदमियन ✓
```

### Test 2: Generate "घर" + oblique
```
Stem: घर
Pardef: घर/__Noun_m
Oblique suffix from pardef: न
Result: घर + न = घरन ✓
```

## Implementation Notes

1. **Stem extraction must use actual paradigm word forms**, not just lemma
2. **Empty lemma suffix** (घर/__Noun_m) is valid
3. **Pardef names must be XML-escaped** (forward slash is okay)
4. **Each unique stem/suffix split** gets one pardef
5. **Multiple lexicon entries can share** the same pardef if they have the same stem/suffix pattern

## Next Steps

1. Implement `extractStemAndSuffix()` method
2. Implement `groupEntriesByPardef()` method
3. Test on these 2 entries
4. Expand to full Noun_m paradigm
5. Expand to all paradigms
