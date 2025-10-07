@echo off
REM Create all monodix dictionaries (Bhojpuri, Maithili, Magahi)

echo ========================================
echo Creating all monodix dictionaries
echo ========================================
echo.

call create-bhojpuri-monodix.bat
if %errorlevel% neq 0 (
    echo Failed to create Bhojpuri monodix
    exit /b 1
)

echo.
call create-maithili-monodix.bat
if %errorlevel% neq 0 (
    echo Failed to create Maithili monodix
    exit /b 1
)

echo.
call create-magahi-monodix.bat
if %errorlevel% neq 0 (
    echo Failed to create Magahi monodix
    exit /b 1
)

echo.
echo ========================================
echo All monodix dictionaries created successfully!
echo ========================================
