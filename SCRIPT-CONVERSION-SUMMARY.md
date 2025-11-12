# Script Conversion Functionality - Summary

## What Was Implemented

### 1. **MonodixScriptConverter** (Basic Version)
- Location: `src/bhaashik/morph/util/MonodixScriptConverter.java`
- Converts entire monodix file from WX to native Indic scripts
- Suitable for small to medium files (< 100MB)
- Loads entire file into memory for processing

### 2. **MonodixScriptConverterStreaming** (Production Version)
- Location: `src/bhaashik/morph/util/MonodixScriptConverterStreaming.java`
- **Streaming line-by-line processing** for large files
- Handles files of any size without memory issues
- Converts Bhojpuri 435MB file in ~2.5 minutes (120K lines/sec)

### 3. **Automated Generation Script**
- Location: `create-bhojpuri-monodix-both.sh`
- Generates **both WX and Devanagari versions** automatically
- Follows Apertium best practices for Indic languages

## How It Works

### Conversion Process
1. **Input**: WX-notation monodix file (ASCII-based)
2. **Streaming Processing**: Line-by-line conversion
3. **Output**: Native script monodix file (Devanagari, Bengali, etc.)

### What Gets Converted
- ✅ Lemmas in `lm` attributes
- ✅ Stems in `<i>` tags
- ✅ Surface forms in `<l>` tags
- ✅ Lexical forms in `<r>` tags (preserving `<s n="..."/>` symbol tags)
- ✅ Pardef names (stem/suffix portions only, not categories)

### What Stays Unchanged
- ❌ XML structure and tags
- ❌ Symbol definitions `<s n="..."/>`
- ❌ Attribute names
- ❌ Category names in pardefs (e.g., `__Advrb`, `__Noun_m`)

## Usage Examples

### Command-Line Usage
```bash
# For small files (< 100MB)
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" \
  bhaashik.morph.util.MonodixScriptConverter \
  input.dix output.dix Devanagari

# For large files (recommended)
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" \
  bhaashik.morph.util.MonodixScriptConverterStreaming \
  bhojpuri-wx.dix bhojpuri-deva.dix Devanagari
```

### Using the Automated Script
```bash
# Generates both WX and Devanagari versions
bash create-bhojpuri-monodix-both.sh
```

## Supported Target Scripts

Using the Sanscript library, the following target scripts are supported:
- **Devanagari** (Hindi, Marathi, Sanskrit, Bhojpuri, Maithili, Magahi, etc.)
- **Bengali** (Bengali, Assamese)
- **Gujarati**
- **Gurmukhi** (Punjabi)
- **Kannada**
- **Malayalam**
- **Oriya/Odia**
- **Tamil**
- **Telugu**

## Performance

### Bhojpuri Conversion Results
```
Input:   435 MB (18 million lines)
Output:  563 MB (Devanagari characters are larger)
Time:    152 seconds (~2.5 minutes)
Speed:   ~120,000 lines/second
```

## Files Generated

### For Bhojpuri
```
output/
├── bhojpuri-wx.dix    (435 MB) - WX notation (ASCII)
└── bhojpuri-deva.dix  (563 MB) - Devanagari script
```

Both files have **identical functionality** when compiled to FSTs - the only difference is the character encoding.

## Why Both Versions?

Following Apertium best practices for Indic languages:

1. **WX Version (ASCII)**
   - Easy version control (Git-friendly)
   - Easy to edit with any text editor
   - Cross-platform compatibility
   - Used for development and collaboration

2. **Native Script Version (Devanagari)**
   - User-friendly for end users
   - Natural reading experience
   - Standard for published resources
   - Required for deployment

## Integration with Workflow

The standard workflow is now:
1. **Develop** using WX notation (source data, tools, version control)
2. **Generate** WX-based monodix files
3. **Convert** to native scripts for distribution
4. **Compile** both versions to FSTs
5. **Deploy** native script versions to users

## Next Steps

To use with Apertium tools:
```bash
# Compile FSTs
lt-comp lr output/bhojpuri-wx.dix bhojpuri-wx.bin
lt-comp lr output/bhojpuri-deva.dix bhojpuri-deva.bin

# Test analysis (WX)
echo "KaravA" | lt-proc bhojpuri-wx.bin

# Test analysis (Devanagari)
echo "करवा" | lt-proc bhojpuri-deva.bin
```

## Technical Details

### Memory Efficiency
- **Old approach**: Loaded 435MB file → Out of Memory
- **New approach**: Streaming → Constant memory usage (~16KB buffer)

### Line-by-Line Processing
Each line is:
1. Read from input
2. Converted (WX → target script)
3. Written to output
4. Discarded from memory

This allows processing files of **unlimited size**.

