#!/bin/bash
# Bhojpuri Monodix Creator Script
# This script generates Apertium monodix format from Bhojpuri data

echo "Creating Bhojpuri monodix dictionary..."

INPUT_DIR="input/bhojpuri/morphological-paradigms-and-lexicon"
OUTPUT_FILE="output/bhojpuri-monodix.dix"
PARADIGM_DIR="$INPUT_DIR/paradigms"
LEXICON_FILE="$INPUT_DIR/lexicon/dict.final.txt"
FEATURE_FILE="B_M_M_Word-generation-ver-1.9.0.formatted.txt"
TAM_FILE="TAM-Mapping.md"

# Check if input directory exists
if [ ! -d "$INPUT_DIR" ]; then
    echo "Error: Input directory not found: $INPUT_DIR"
    exit 1
fi

# Run the Apertium creator
java -cp "bin:lib/sanscript-java_2.12-0.4.jar" bhaashik.morph.ApertiumCreatorMain \
    "$PARADIGM_DIR" \
    "$LEXICON_FILE" \
    "." \
    "$OUTPUT_FILE" \
    Bhojpuri

if [ $? -eq 0 ]; then
    echo "Successfully created $OUTPUT_FILE"
    echo ""
    echo "To compile with Apertium tools, run:"
    echo "  lt-comp lr $OUTPUT_FILE bhojpuri.bin"
else
    echo "Error creating monodix file"
    exit 1
fi
