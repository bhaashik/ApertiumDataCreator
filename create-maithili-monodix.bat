@echo off
REM Maithili Monodix Creator Script
REM This script generates Apertium monodix format from Maithili data

echo Creating Maithili monodix dictionary...

set INPUT_DIR=input\Bhojpuri-Magahi-and-Maithili-Linguistic-Resources\maithili
set OUTPUT_FILE=maithili-monodix.dix
set PARADIGM_DIR=%INPUT_DIR%\paradigms
set LEXICON_FILE=%INPUT_DIR%\lexicon.txt
set FEATURE_FILE=input\B_M_M_Word-generation-ver-1.9.0.formatted.txt
set TAM_FILE=TAM-Mapping.md

REM Check if input directory exists
if not exist "%INPUT_DIR%" (
    echo Error: Input directory not found: %INPUT_DIR%
    exit /b 1
)

REM Run the Apertium creator
java -cp "bin;lib/sanscript-classes" bhaashik.morph.ApertiumCreatorMain ^
    --language Maithili ^
    --paradigm-dir "%PARADIGM_DIR%" ^
    --lexicon-file "%LEXICON_FILE%" ^
    --feature-file "%FEATURE_FILE%" ^
    --tam-file "%TAM_FILE%" ^
    --output "%OUTPUT_FILE%" ^
    --script Devanagari ^
    --vibhakti-mode ATTACHED

if %errorlevel% equ 0 (
    echo Successfully created %OUTPUT_FILE%
    echo.
    echo To compile with Apertium tools, run:
    echo   lt-comp lr %OUTPUT_FILE% maithili.bin
) else (
    echo Error creating monodix file
    exit /b 1
)
