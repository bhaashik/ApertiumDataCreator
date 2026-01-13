#!/usr/bin/env python3
"""
Convert input data (paradigms and lexicon) from WX to Devanagari.
Preserves original files and creates -deva versions.

Rules:
- .p files: DON'T convert first line (paradigm name), convert rest
- lexicon files: Only convert fields 1 and 3, keep field 4 (paradigm name) as-is
- Feature structure file: DON'T convert at all
"""

import os
import sys
from pathlib import Path
from wxconv import WXC

def convert_paradigm_file(input_file, output_file, encoding='utf-8'):
    """
    Convert a .p paradigm file from WX to Devanagari.
    First line (paradigm name) stays in WX, rest is converted.
    """
    converter = WXC(order='wx2utf', lang='hin')

    with open(input_file, 'r', encoding=encoding) as f_in:
        with open(output_file, 'w', encoding=encoding) as f_out:
            for line_num, line in enumerate(f_in, 1):
                if line_num == 1:
                    # First line is paradigm name - keep as-is (WX/ASCII)
                    f_out.write(line)
                else:
                    # Convert word forms to Devanagari
                    converted = converter.convert(line.rstrip('\n'))
                    f_out.write(converted + '\n')

    return line_num

def convert_lexicon_file(input_file, output_file, encoding='utf-8'):
    """
    Convert lexicon file from WX to Devanagari.
    CSV format: field1,field2,field3,field4,field5,field6
    Only convert fields 1 and 3, keep field 4 (paradigm name) as-is.
    Ignore fields 2, 5, 6.
    """
    converter = WXC(order='wx2utf', lang='hin')

    lines_converted = 0
    with open(input_file, 'r', encoding=encoding) as f_in:
        with open(output_file, 'w', encoding=encoding) as f_out:
            for line in f_in:
                line = line.rstrip('\n')

                # Split by comma, handling quoted fields
                fields = []
                current_field = []
                in_quotes = False

                for char in line:
                    if char == '"':
                        in_quotes = not in_quotes
                        current_field.append(char)
                    elif char == ',' and not in_quotes:
                        fields.append(''.join(current_field))
                        current_field = []
                    else:
                        current_field.append(char)

                if current_field:
                    fields.append(''.join(current_field))

                # Convert only fields 1 and 3 (indices 0 and 2)
                if len(fields) >= 4:
                    # Remove quotes for conversion, add back after
                    field1_raw = fields[0].strip('"')
                    field3_raw = fields[2].strip('"')

                    field1_converted = converter.convert(field1_raw)
                    field3_converted = converter.convert(field3_raw)

                    # Reconstruct with converted fields 1,3 and original field 4
                    # Format: field1,field2,field3,field4,field5,field6
                    # We only keep fields 1, 3, 4 (drop 2, 5, 6)
                    output_line = f'"{field1_converted}","","{field3_converted}",{fields[3]},"",""'
                    f_out.write(output_line + '\n')
                else:
                    # If line doesn't have expected format, write as-is
                    f_out.write(line + '\n')

                lines_converted += 1

    return lines_converted

def convert_paradigm_directory(paradigm_dir, output_dir):
    """Convert all .p files in paradigm directory."""
    paradigm_path = Path(paradigm_dir)
    output_path = Path(output_dir)

    # Create output directory
    output_path.mkdir(parents=True, exist_ok=True)

    # Find all .p files
    p_files = list(paradigm_path.glob('*.p'))
    print(f"\nFound {len(p_files)} paradigm files in {paradigm_dir}")

    total_lines = 0
    for p_file in sorted(p_files):
        output_file = output_path / p_file.name
        lines = convert_paradigm_file(p_file, output_file)
        total_lines += lines

    print(f"✓ Converted {len(p_files)} paradigm files ({total_lines:,} lines)")
    return len(p_files), total_lines

def main():
    if len(sys.argv) < 2:
        print("Usage: python3 convert-input-to-deva.py <language>")
        print("Example: python3 convert-input-to-deva.py bhojpuri")
        sys.exit(1)

    language = sys.argv[1].lower()

    # Paths
    base_dir = Path("input/Bhojpuri-Magahi-and-Maithili-Linguistic-Resources")
    lang_dir = base_dir / language

    if not lang_dir.exists():
        print(f"Error: Language directory not found: {lang_dir}")
        sys.exit(1)

    # Input paths
    paradigm_dir = lang_dir / "paradigms"
    lexicon_file = lang_dir / "lexicon.txt"

    # Output paths (parallel to input with -deva suffix)
    paradigm_output = lang_dir / "paradigms-deva"
    lexicon_output = lang_dir / "lexicon-deva.txt"

    print(f"=== Converting {language.title()} Input Data to Devanagari ===\n")
    print("Rules:")
    print("  - .p files: Keep paradigm name (line 1) in WX, convert word forms")
    print("  - Lexicon: Convert only fields 1 and 3, keep field 4 (paradigm name)")
    print()

    # Convert paradigms
    if paradigm_dir.exists():
        convert_paradigm_directory(paradigm_dir, paradigm_output)
    else:
        print(f"Warning: Paradigm directory not found: {paradigm_dir}")

    # Convert lexicon
    if lexicon_file.exists():
        print(f"\nConverting lexicon file...")
        lines = convert_lexicon_file(lexicon_file, lexicon_output)
        print(f"✓ Converted lexicon file ({lines:,} lines)")
    else:
        print(f"Warning: Lexicon file not found: {lexicon_file}")

    print(f"\n✅ Conversion complete for {language.title()}!")
    print(f"Output directories:")
    print(f"  Paradigms: {paradigm_output}")
    print(f"  Lexicon:   {lexicon_output}")

if __name__ == "__main__":
    main()
