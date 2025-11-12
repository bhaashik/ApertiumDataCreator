#!/bin/bash
# Bhojpuri Monodix Creator Script - Generates both WX and Devanagari versions
# This follows Apertium best practices for Indic languages

echo "======================================"
echo "Creating Bhojpuri monodix dictionaries"
echo "Generating both WX and Devanagari versions"
echo "======================================"
echo ""

INPUT_DIR="input/bhojpuri/morphological-paradigms-and-lexicon"
OUTPUT_DIR="output"
PARADIGM_DIR="$INPUT_DIR/paradigms"
LEXICON_FILE="$INPUT_DIR/lexicon/dict.final.txt"

# Output file names
WX_OUTPUT="$OUTPUT_DIR/bhojpuri-wx.dix"
DEVA_OUTPUT="$OUTPUT_DIR/bhojpuri-deva.dix"

# Check if input directory exists
if [ ! -d "$INPUT_DIR" ]; then
    echo "Error: Input directory not found: $INPUT_DIR"
    exit 1
fi

# Create output directory if it doesn't exist
mkdir -p "$OUTPUT_DIR"

echo "Step 1: Generating WX-based monodix file..."
echo "==========================================="
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.ApertiumCreatorMain \
    "$PARADIGM_DIR" \
    "$LEXICON_FILE" \
    "." \
    "$WX_OUTPUT" \
    Bhojpuri

if [ $? -ne 0 ]; then
    echo "Error: Failed to create WX-based monodix file"
    exit 1
fi

echo ""
echo "Step 2: Converting WX to Devanagari (Streaming Mode)..."
echo "========================================================="
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.util.MonodixScriptConverterStreaming \
    "$WX_OUTPUT" \
    "$DEVA_OUTPUT" \
    Devanagari

if [ $? -ne 0 ]; then
    echo "Error: Failed to convert to Devanagari"
    exit 1
fi

echo ""
echo "======================================"
echo "✅ Successfully created both versions!"
echo "======================================"
echo ""
echo "Output files:"
echo "  WX notation:  $WX_OUTPUT"
echo "  Devanagari:   $DEVA_OUTPUT"
echo ""
echo "File sizes:"
ls -lh "$WX_OUTPUT" "$DEVA_OUTPUT" | awk '{print "  " $9 ": " $5}'
echo ""
echo "To compile FSTs with Apertium tools:"
echo "  WX version:   lt-comp lr $WX_OUTPUT bhojpuri-wx.bin"
echo "  Deva version: lt-comp lr $DEVA_OUTPUT bhojpuri-deva.bin"
echo ""
