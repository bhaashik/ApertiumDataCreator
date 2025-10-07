#!/bin/bash
# Create all monodix dictionaries (Bhojpuri, Maithili, Magahi)

echo "========================================"
echo "Creating all monodix dictionaries"
echo "========================================"
echo ""

bash create-bhojpuri-monodix.sh
if [ $? -ne 0 ]; then
    echo "Failed to create Bhojpuri monodix"
    exit 1
fi

echo ""
bash create-maithili-monodix.sh
if [ $? -ne 0 ]; then
    echo "Failed to create Maithili monodix"
    exit 1
fi

echo ""
bash create-magahi-monodix.sh
if [ $? -ne 0 ]; then
    echo "Failed to create Magahi monodix"
    exit 1
fi

echo ""
echo "========================================"
echo "All monodix dictionaries created successfully!"
echo "========================================"
