#!/bin/bash
# Bhojpuri Monodix Creator Script
# This script generates Apertium monodix format from Bhojpuri data

echo "Creating Bhojpuri monodix dictionary..."

INPUT_DIR="input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources/bhojpuri"
OUTPUT_FILE="bhojpuri-monodix.dix"
PARADIGM_DIR="$INPUT_DIR/paradigms"
LEXICON_FILE="$INPUT_DIR/lexicon.txt"
FEATURE_FILE="input/B_M_M_Word-generation-ver-1.9.0.formatted.txt"
TAM_FILE="TAM-Mapping.md"

# Check if input directory exists
if [ ! -d "$INPUT_DIR" ]; then
    echo "Error: Input directory not found: $INPUT_DIR"
    exit 1
fi

# Run the Apertium creator
java -cp "bin:lib/sanscript-classes" bhaashik.morph.ApertiumCreatorMain \
    --language Bhojpuri \
    --paradigm-dir "$PARADIGM_DIR" \
    --lexicon-file "$LEXICON_FILE" \
    --feature-file "$FEATURE_FILE" \
    --tam-file "$TAM_FILE" \
    --output "$OUTPUT_FILE" \
    --script Devanagari \
    --vibhakti-mode ATTACHED

if [ $? -eq 0 ]; then
    echo "Successfully created $OUTPUT_FILE"
    echo ""
    echo "To compile with Apertium tools, run:"
    echo "  lt-comp lr $OUTPUT_FILE bhojpuri.bin"
else
    echo "Error creating monodix file"
    exit 1
fi
