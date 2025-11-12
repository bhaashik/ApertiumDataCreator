# Apertium Monolingual Dictionary (Monodix) Format Guide

This document provides a comprehensive guide to the Apertium monodix XML format, specifically for morphologically rich Indic languages like Bhojpuri, Maithili, Magahi, and Hindi.

## Table of Contents
1. [Overview](#overview)
2. [File Structure](#file-structure)
3. [Alphabet Section](#alphabet-section)
4. [Symbol Definitions (sdefs)](#symbol-definitions-sdefs)
5. [Paradigm Definitions (pardefs)](#paradigm-definitions-pardefs)
6. [Main Section (Lexicon)](#main-section-lexicon)
7. [Stem-Suffix Separation](#stem-suffix-separation)
8. [Handling Variants](#handling-variants)
9. [FST Compilation](#fst-compilation)
10. [Complete Examples](#complete-examples)

---

## Overview

An Apertium monodix file is an XML document that describes the morphology of a single language. It defines:
- The alphabet/character set for the language
- Morphological symbols (tags like noun, plural, feminine, etc.)
- Paradigms (inflection patterns)
- A lexicon of lemmas with their paradigm assignments

The same monodix file is used for both:
- **Morphological Analysis**: Surface form → Lemma + Tags
- **Morphological Generation**: Lemma + Tags → Surface form

## File Structure

```xml
<?xml version="1.0" encoding="UTF-8"?>
<dictionary>
  <alphabet>...</alphabet>
  <sdefs>...</sdefs>
  <pardefs>...</pardefs>
  <section id="main" type="standard">...</section>
</dictionary>
```

### Top-Level Elements

1. **`<alphabet>`** - Character set used in the language
2. **`<sdefs>`** - Symbol definitions (morphological tags)
3. **`<pardefs>`** - Paradigm definitions (inflection templates)
4. **`<section id="main">`** - Lexicon entries

---

## Alphabet Section

The alphabet section defines all characters used in word forms.

```xml
<alphabet>अआइईउऊएऐओऔकखगघचछजझटठडढतथदधनपफबभमयरलवशषसहािीुूेैोौंःँ्</alphabet>
```

### How It Works

- **Purpose**: Defines valid characters for the FST
- **Content**: Usually the full Unicode block for the script (e.g., Devanagari U+0900 to U+097F)
- **Additional Characters**: May include Latin characters, digits, punctuation found in the data

### Best Practices

1. Include the full Unicode block for the primary script
2. Add any extra characters found in the linguistic data
3. Order doesn't matter, but keeping Unicode order is conventional

---

## Symbol Definitions (sdefs)

Symbol definitions declare all morphological tags used in the dictionary.

```xml
<sdefs>
  <sdef n="n"       c="Noun"/>
  <sdef n="v"       c="Verb"/>
  <sdef n="adj"     c="Adjective"/>
  <sdef n="m"       c="Masculine"/>
  <sdef n="f"       c="Feminine"/>
  <sdef n="sg"      c="Singular"/>
  <sdef n="pl"      c="Plural"/>
  <sdef n="nom"     c="Nominative"/>
  <sdef n="obl"     c="Oblique"/>
  <sdef n="pres"    c="Present tense"/>
  <sdef n="past"    c="Past tense"/>
</sdefs>
```

### Attributes

- **`n`** (required): Symbol name - the actual tag used in analyses
- **`c`** (optional): Comment - human-readable description

### Common Morphological Categories for Indic Languages

**Part of Speech:**
- `n` - Noun
- `v` - Verb
- `adj` - Adjective
- `adv` - Adverb
- `pn` - Pronoun
- `psp` - Postposition
- `avy` - Indeclinable

**Gender:**
- `m` - Masculine
- `f` - Feminine
- `mf` - Masculine/Feminine
- `any` - Any gender

**Number:**
- `sg` - Singular
- `pl` - Plural

**Case:**
- `nom` - Nominative (direct)
- `obl` - Oblique
- `d` - Direct
- `o` - Oblique

**Person:**
- `1` - First person
- `2` - Second person
- `3` - Third person

**Tense/Aspect/Mood (TAM):**
- `pres` - Present
- `past` - Past
- `fut` - Future
- `perf` - Perfective
- `impf` - Imperfective
- `prog` - Progressive
- `hab` - Habitual

---

## Paradigm Definitions (pardefs)

Paradigms define inflection patterns. Each paradigm is a template showing how to generate all inflected forms from a stem.

### Basic Structure

```xml
<pardefs>
  <pardef n="paradigm_name">
    <e>
      <p>
        <l>surface_suffix</l>
        <r>lemma_suffix<s n="tag1"/><s n="tag2"/>...</r>
      </p>
    </e>
    <!-- more entries -->
  </pardef>
</pardefs>
```

### Key Elements

- **`<pardef n="...">`** - Paradigm definition with unique name
- **`<e>`** - Entry (one inflected form)
- **`<p>`** - Pair (left-right mapping)
- **`<l>`** - Left side (surface form suffix) - used in **ANALYSIS**
- **`<r>`** - Right side (lemma suffix + tags) - used in **GENERATION**
- **`<s n="..."/>`** - Symbol/tag reference

### Understanding `<l>` and `<r>`

The key to understanding Apertium monodix is the **left-right paradigm**:

- **`<l>` (left/surface)**: The suffix that appears in the actual word form (surface)
- **`<r>` (right/lemma)**: The lemma suffix + morphological tags (abstract)

**For Analysis (surface → lemma+tags):**
- FST reads from left (`<l>`)
- Outputs right (`<r>`)

**For Generation (lemma+tags → surface):**
- FST reads from right (`<r>`)
- Outputs left (`<l>`)

---

## Stem-Suffix Separation

### The Critical Format: `stem/lemma_suffix__category`

The paradigm name **must** encode how to split the lemma into stem and suffix:

```
Format: stem/lemma_suffix__category
```

**Examples:**

```xml
<!-- Lemma: वधू (vadhū) = वध (stem) + ू (lemma_suffix) -->
<pardef n="वध/ू__n_f">
  <e><p><l>ू</l><r>ू<s n="n"/><s n="f"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l>ुएँ</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="nom"/></r></p></e>
  <e><p><l>ुओं</l><r>ू<s n="n"/><s n="f"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>

<!-- Lemma: लड़का (ladkā) = लड़क (stem) + ा (lemma_suffix) -->
<pardef n="लड़क/ा__n_m">
  <e><p><l>ा</l><r>ा<s n="n"/><s n="m"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l>े</l><r>ा<s n="n"/><s n="m"/><s n="sg"/><s n="obl"/></r></p></e>
  <e><p><l>े</l><r>ा<s n="n"/><s n="m"/><s n="pl"/><s n="nom"/></r></p></e>
  <e><p><l>ों</l><r>ा<s n="n"/><s n="m"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>

<!-- Lemma: घर (ghar) - no suffix, just stem -->
<pardef n="घर__n_m">
  <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l></l><r><s n="n"/><s n="m"/><s n="sg"/><s n="obl"/></r></p></e>
  <e><p><l>ों</l><r><s n="n"/><s n="m"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>
```

### How Stem-Suffix Separation Works

#### Example 1: वधू (bride)

**Lemma**: वधू
**Stem**: वध
**Lemma Suffix**: ू
**Pardef Name**: `वध/ू__n_f`

**Pardef Entries:**

| Surface Form | `<l>` | `<r>` | Morphological Tags | How It Combines |
|-------------|-------|-------|-------------------|-----------------|
| वधू | ू | ू | n.f.sg.nom | वध + ू = वधू |
| वधुएँ | ुएँ | ू | n.f.pl.nom | वध + ुएँ = वधुएँ |
| वधुओं | ुओं | ू | n.f.pl.obl | वध + ुओं = वधुओं |

**In the main section:**

```xml
<e lm="वधू">
  <i>वध</i>                  <!-- ONLY the stem -->
  <par n="वध/ू__n_f"/>       <!-- Paradigm with stem/suffix split -->
</e>
```

#### Example 2: लड़का (boy)

**Lemma**: लड़का
**Stem**: लड़क
**Lemma Suffix**: ा
**Pardef Name**: `लड़क/ा__n_m`

**Pardef Entries:**

| Surface Form | `<l>` | `<r>` | Tags | How It Combines |
|-------------|-------|-------|------|-----------------|
| लड़का | ा | ा | n.m.sg.nom | लड़क + ा = लड़का |
| लड़के | े | ा | n.m.sg.obl | लड़क + े = लड़के |
| लड़के | े | ा | n.m.pl.nom | लड़क + े = लड़के |
| लड़कों | ों | ा | n.m.pl.obl | लड़क + ों = लड़कों |

**In the main section:**

```xml
<e lm="लड़का">
  <i>लड़क</i>                <!-- ONLY the stem -->
  <par n="लड़क/ा__n_m"/>     <!-- Paradigm with stem/suffix split -->
</e>
```

### Why This Matters

The FST needs to know:
1. **Where to split the lemma**: The pardef name shows lemma = stem + lemma_suffix
2. **What suffixes are possible**: The `<l>` entries show all surface suffixes
3. **What they mean**: The `<r>` entries show the morphological interpretation

**For Analysis:**
- See "लड़कों" → Find stem "लड़क" → Match `<l>ों</l>` → Output "लड़का" + `<r>ा<s n="n"/><s n="m"/><s n="pl"/><s n="obl"/></r>`

**For Generation:**
- See lemma "लड़का" + tags n.m.pl.obl → Split to stem "लड़क" → Find matching `<r>` → Output "लड़क" + `<l>ों</l>` = "लड़कों"

---

## Main Section (Lexicon)

The main section lists all lemmas with their paradigm assignments.

### Structure

```xml
<section id="main" type="standard">
  <e lm="lemma">
    <i>stem</i>
    <par n="stem/lemma_suffix__category"/>
  </e>
  <!-- more entries -->
</section>
```

### Key Elements

- **`<e lm="...">`** - Entry with lemma attribute
- **`<i>`** - Identity/stem (what gets concatenated with paradigm suffixes)
- **`<par n="..."/>`** - Paradigm reference

### CRITICAL: Only Stem in `<i>` Tag

**Wrong (OLD format):**

```xml
<e lm="लड़का">
  <i>लड़का</i>              <!-- Full lemma - WRONG! -->
  <par n="Noun_m"/>
</e>
```

**Correct (NEW format):**

```xml
<e lm="लड़का">
  <i>लड़क</i>               <!-- Only stem - CORRECT! -->
  <par n="लड़क/ा__n_m"/>
</e>
```

### Examples

```xml
<section id="main" type="standard">
  <!-- Lemma with suffix -->
  <e lm="वधू">
    <i>वध</i>
    <par n="वध/ू__n_f"/>
  </e>

  <!-- Lemma without suffix (stem = lemma) -->
  <e lm="घर">
    <i>घर</i>
    <par n="घर__n_m"/>
  </e>

  <!-- Verb lemma -->
  <e lm="खाना">
    <i>खा</i>
    <par n="खा/ना__v"/>
  </e>
</section>
```

---

## Handling Variants

Many low-resource languages like Bhojpuri have dialectal or regional variants for the same morphological form.

### Variant Format in Source Data

In `.p` paradigm files, variants are separated by `/`:

```
Adj_case_e
aneka
anekana/anekai          ← Two variants for the same slot
anekana/anekai          ← Two variants for the same slot
```

### Variant Representation in Monodix

Each variant gets its own `<e>` entry in the pardef:

```xml
<pardef n="aneka__Adj_case_e">
  <!-- First morphological slot, first variant -->
  <e><p><l>na</l><r><s n="adj"/><s n="pl"/><s n="d"/><s n="emph"/></r></p></e>

  <!-- First morphological slot, second variant -->
  <e><p><l>i</l><r><s n="adj"/><s n="pl"/><s n="d"/><s n="emph"/></r></p></e>

  <!-- Second morphological slot, first variant -->
  <e><p><l>na</l><r><s n="adj"/><s n="pl"/><s n="o"/><s n="emph"/></r></p></e>

  <!-- Second morphological slot, second variant -->
  <e><p><l>i</l><r><s n="adj"/><s n="pl"/><s n="o"/><s n="emph"/></r></p></e>
</pardef>
```

### Example with Multiple Variants

```
bIsa
bIsana/bisana/bIsoM/bisiyana/bisiana/bisOM/bisiyoM
```

This becomes 7 separate `<e>` entries in the pardef, all with the same morphological tags but different surface forms.

### Variant Tags (Optional)

You can optionally mark variants with tags:

```xml
<e><p><l>na</l><r><s n="adj"/><s n="pl"/><s n="d"/><s n="var1"/></r></p></e>
<e><p><l>i</l><r><s n="adj"/><s n="pl"/><s n="d"/><s n="var2"/></r></p></e>
```

---

## FST Compilation

Once the monodix file is created, it must be compiled to a Finite State Transducer (FST) using Apertium's `lt-comp` tool.

### Compilation Commands

```bash
# For analysis (left-to-right: surface → lemma+tags)
lt-comp lr language.dix language-analyzer.bin

# For generation (right-to-left: lemma+tags → surface)
lt-comp rl language.dix language-generator.bin
```

### Usage Examples

**Analysis:**

```bash
$ echo "लड़कों" | lt-proc bhojpuri-analyzer.bin
^लड़का<n><m><pl><o>$
```

**Generation:**

```bash
$ echo "^लड़का<n><m><pl><o>$" | lt-proc -g bhojpuri-generator.bin
लड़कों
```

### Validation

Test that your monodix file compiles without errors:

```bash
lt-comp lr bhojpuri-monodix.dix /dev/null
```

If compilation succeeds, your format is correct!

---

## Complete Examples

### Example 1: Simple Noun Paradigm

**Lemma**: रात (rāt, "night")
**Category**: Feminine noun
**Stem**: रात
**Lemma Suffix**: (empty)

```xml
<pardef n="रात__n_f">
  <e><p><l></l><r><s n="n"/><s n="f"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l></l><r><s n="n"/><s n="f"/><s n="sg"/><s n="obl"/></r></p></e>
  <e><p><l>ें</l><r><s n="n"/><s n="f"/><s n="pl"/><s n="nom"/></r></p></e>
  <e><p><l>ों</l><r><s n="n"/><s n="f"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>

<section id="main" type="standard">
  <e lm="रात">
    <i>रात</i>
    <par n="रात__n_f"/>
  </e>
</section>
```

**Generated forms:**
- रात (sg.nom/obl)
- रातें (pl.nom)
- रातों (pl.obl)

### Example 2: Noun with Suffix

**Lemma**: लड़की (ladkī, "girl")
**Category**: Feminine noun
**Stem**: लड़क
**Lemma Suffix**: ी

```xml
<pardef n="लड़क/ी__n_f">
  <e><p><l>ी</l><r>ी<s n="n"/><s n="f"/><s n="sg"/><s n="nom"/></r></p></e>
  <e><p><l>ी</l><r>ी<s n="n"/><s n="f"/><s n="sg"/><s n="obl"/></r></p></e>
  <e><p><l>ियाँ</l><r>ी<s n="n"/><s n="f"/><s n="pl"/><s n="nom"/></r></p></e>
  <e><p><l>ियों</l><r>ी<s n="n"/><s n="f"/><s n="pl"/><s n="obl"/></r></p></e>
</pardef>

<section id="main" type="standard">
  <e lm="लड़की">
    <i>लड़क</i>
    <par n="लड़क/ी__n_f"/>
  </e>
</section>
```

**Generated forms:**
- लड़की (sg.nom/obl)
- लड़कियाँ (pl.nom)
- लड़कियों (pl.obl)

### Example 3: With Variants (Bhojpuri)

**Lemma**: aneka (अनेक)
**Category**: Adjective with emphasis
**Variants**: -na/-i for both direct and oblique plural

```xml
<pardef n="aneka__Adj_case_e">
  <!-- Plural direct, variant 1 -->
  <e><p><l>na</l><r><s n="adj"/><s n="pl"/><s n="d"/><s n="emph"/></r></p></e>

  <!-- Plural direct, variant 2 -->
  <e><p><l>i</l><r><s n="adj"/><s n="pl"/><s n="d"/><s n="emph"/></r></p></e>

  <!-- Plural oblique, variant 1 -->
  <e><p><l>na</l><r><s n="adj"/><s n="pl"/><s n="o"/><s n="emph"/></r></p></e>

  <!-- Plural oblique, variant 2 -->
  <e><p><l>i</l><r><s n="adj"/><s n="pl"/><s n="o"/><s n="emph"/></r></p></e>
</pardef>

<section id="main" type="standard">
  <e lm="aneka">
    <i>aneka</i>
    <par n="aneka__Adj_case_e"/>
  </e>
</section>
```

**Generated forms:**
- anekana OR anekai (pl.d.emph)
- anekana OR anekai (pl.o.emph)

---

## Summary Checklist

When creating or validating a monodix file, ensure:

- [ ] **Alphabet** includes all characters used in word forms
- [ ] **All tags** used in pardefs are defined in `<sdefs>`
- [ ] **Pardef names** follow `stem/lemma_suffix__category` format
- [ ] **`<l>` entries** contain only surface suffixes (what appears in actual words)
- [ ] **`<r>` entries** contain lemma suffix + all morphological tags
- [ ] **Main section `<i>` tags** contain ONLY stems, not full lemmas
- [ ] **Pardef references** match the stem/suffix split exactly
- [ ] **Variants** are represented as separate `<e>` entries
- [ ] File **compiles successfully** with `lt-comp`

---

## References

- [Apertium Documentation](https://wiki.apertium.org/)
- [Apertium Monodix Format](https://wiki.apertium.org/wiki/Monodix)
- [lt-toolbox Documentation](https://wiki.apertium.org/wiki/Lttoolbox)
- Example: `examples/apertium-hin.hin.dix.xml` (Hindi monodix)
- This project's README.md

---

**Document Version**: 1.0
**Last Updated**: 2025-01-11
**Maintainer**: Bhaashik Morphological Analysis API
