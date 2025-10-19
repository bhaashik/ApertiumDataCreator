import re

input_file = "bhojpuri-monodix_updated_with pardefs and sdefs.dix"
output_file = "bhojpuri-monodix-split.dix"

with open(input_file, "r", encoding="utf-8") as f:
    text = f.read()

# Step 1: Remove redundant <e><p> ... </p></e> wrappers around entries with multiple lemmas
# This regex finds <e><p> blocks where <l> contains at least one '/' and removes the outer tags
text = re.sub(
    r"<e>\s*<p>\s*((?:<l>[^<>/]+(?:/[^<>/]+)+</l>\s*<r>.*?</r>\s*)+)</p>\s*</e>",
    r"\1",
    text,
    flags=re.DOTALL
)

# Step 2: Expand entries with multiple lemmas in <l>...</l>
def expand_l(match):
    l_content = match.group(1)
    r_content = match.group(2)
    parts = l_content.split('/')
    expanded = ""
    for p in parts:
        expanded += f"<e><p><l>{p}</l><r>{r_content}</r></p></e>\n"
    return expanded

pattern = r"<l>([^<>/]+(?:/[^<>/]+)+)</l>\s*<r>(.*?)</r>"
new_text = re.sub(pattern, expand_l, text, flags=re.DOTALL)

with open(output_file, "w", encoding="utf-8") as f:
    f.write(new_text)

print(f"✅ Done! Saved as {output_file}")



