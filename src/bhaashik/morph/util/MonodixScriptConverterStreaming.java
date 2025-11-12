package bhaashik.morph.util;

import bhaashik.morph.encoding.WXConverter;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Streaming version of MonodixScriptConverter for handling large files.
 * Processes files line-by-line without loading entire content into memory.
 */
public class MonodixScriptConverterStreaming {

    private final WXConverter converter;

    public MonodixScriptConverterStreaming() {
        this.converter = new WXConverter();
    }

    /**
     * Convert a monodix file from WX to the specified target script using streaming.
     */
    public void convertFile(File inputFile, File outputFile, String targetScript) throws IOException {
        System.out.println("\n=== Converting Monodix to " + targetScript + " (Streaming Mode) ===");
        System.out.println("Input:  " + inputFile.getAbsolutePath());
        System.out.println("Output: " + outputFile.getAbsolutePath());

        long linesProcessed = 0;
        long startTime = System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"), 8192 * 16)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line and write immediately
                String convertedLine = convertLine(line, targetScript);
                writer.write(convertedLine);
                writer.write("\n");

                linesProcessed++;
                if (linesProcessed % 100000 == 0) {
                    long currentTime = System.currentTimeMillis();
                    double seconds = (currentTime - startTime) / 1000.0;
                    double linesPerSec = linesProcessed / seconds;
                    System.out.printf("  Processed %,d lines (%.0f lines/sec)...%n",
                        linesProcessed, linesPerSec);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1000.0;

        System.out.println("✓ Conversion complete!");
        System.out.printf("  Lines processed: %,d%n", linesProcessed);
        System.out.printf("  Time taken: %.2f seconds%n", seconds);
        System.out.printf("  Input file size:  %,d bytes (%.2f MB)%n",
            inputFile.length(), inputFile.length() / 1024.0 / 1024.0);
        System.out.printf("  Output file size: %,d bytes (%.2f MB)%n",
            outputFile.length(), outputFile.length() / 1024.0 / 1024.0);
    }

    /**
     * Convert a single line from WX to target script.
     */
    private String convertLine(String line, String targetScript) {
        // Skip empty lines and XML declarations
        if (line.trim().isEmpty() || line.trim().startsWith("<?xml")) {
            return line;
        }

        // Update script comment
        if (line.contains("<!-- Script: WX -->")) {
            return line.replace("<!-- Script: WX -->",
                "<!-- Script: " + targetScript + " (converted from WX) -->");
        }

        // Convert attributes and tag content
        line = convertAttributeInLine(line, "lm", targetScript);
        line = convertAttributeInLine(line, "n", targetScript);  // For pardef names
        line = convertTagInLine(line, "i", targetScript);
        line = convertTagInLine(line, "l", targetScript);
        line = convertRTagInLine(line, targetScript);

        return line;
    }

    /**
     * Convert attribute value in a line.
     */
    private String convertAttributeInLine(String line, String attrName, String targetScript) {
        Pattern pattern = Pattern.compile(attrName + "=\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(line);

        if (!matcher.find()) {
            return line;
        }

        StringBuffer result = new StringBuffer();
        matcher.reset();

        while (matcher.find()) {
            String attrValue = matcher.group(1);

            // For pardef names (n attribute), handle stem/suffix__category format
            if (attrName.equals("n") && attrValue.contains("__")) {
                attrValue = convertPardefName(attrValue, targetScript);
            } else {
                attrValue = converter.convert(attrValue, "WX", targetScript);
            }

            attrValue = attrValue.replace("\"", "&quot;");
            matcher.appendReplacement(result,
                attrName + "=\"" + Matcher.quoteReplacement(attrValue) + "\"");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Convert text inside a tag in a line.
     */
    private String convertTagInLine(String line, String tagName, String targetScript) {
        Pattern pattern = Pattern.compile("<" + tagName + ">([^<]*)</" + tagName + ">");
        Matcher matcher = pattern.matcher(line);

        if (!matcher.find()) {
            return line;
        }

        StringBuffer result = new StringBuffer();
        matcher.reset();

        while (matcher.find()) {
            String content = matcher.group(1);
            String converted = converter.convert(content, "WX", targetScript);
            matcher.appendReplacement(result,
                "<" + tagName + ">" + Matcher.quoteReplacement(converted) + "</" + tagName + ">");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Convert <r> tag content while preserving <s n="..."/> symbol tags.
     */
    private String convertRTagInLine(String line, String targetScript) {
        Pattern pattern = Pattern.compile("<r>(.*?)</r>");
        Matcher matcher = pattern.matcher(line);

        if (!matcher.find()) {
            return line;
        }

        StringBuffer result = new StringBuffer();
        matcher.reset();

        while (matcher.find()) {
            String rContent = matcher.group(1);
            String converted = convertRContent(rContent, targetScript);
            matcher.appendReplacement(result,
                "<r>" + Matcher.quoteReplacement(converted) + "</r>");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Convert text in <r> content while preserving <s> tags.
     */
    private String convertRContent(String rContent, String targetScript) {
        Pattern symbolPattern = Pattern.compile("<s n=\"[^\"]*\"/>");
        Matcher symbolMatcher = symbolPattern.matcher(rContent);

        StringBuilder result = new StringBuilder();
        int lastEnd = 0;

        while (symbolMatcher.find()) {
            String textBefore = rContent.substring(lastEnd, symbolMatcher.start());
            if (!textBefore.isEmpty()) {
                result.append(converter.convert(textBefore, "WX", targetScript));
            }
            result.append(symbolMatcher.group());
            lastEnd = symbolMatcher.end();
        }

        if (lastEnd < rContent.length()) {
            String textAfter = rContent.substring(lastEnd);
            if (!textAfter.isEmpty()) {
                result.append(converter.convert(textAfter, "WX", targetScript));
            }
        }

        return result.toString();
    }

    /**
     * Convert pardef name: stem/suffix__category
     */
    private String convertPardefName(String pardefName, String targetScript) {
        int categoryPos = pardefName.lastIndexOf("__");
        if (categoryPos == -1) {
            return converter.convert(pardefName, "WX", targetScript);
        }

        String lemmaPort = pardefName.substring(0, categoryPos);
        String category = pardefName.substring(categoryPos);

        String convertedLemma = converter.convert(lemmaPort, "WX", targetScript);
        return convertedLemma + category;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: MonodixScriptConverterStreaming <input-file> <output-file> <target-script>");
            System.err.println("Example: MonodixScriptConverterStreaming bhojpuri-wx.dix bhojpuri-deva.dix Devanagari");
            System.err.println();
            System.err.println("Supported scripts: Devanagari, Bengali, Gujarati, Gurmukhi,");
            System.err.println("                   Kannada, Malayalam, Oriya, Tamil, Telugu");
            System.exit(1);
        }

        String inputPath = args[0];
        String outputPath = args[1];
        String targetScript = args[2];

        try {
            MonodixScriptConverterStreaming converter = new MonodixScriptConverterStreaming();
            converter.convertFile(new File(inputPath), new File(outputPath), targetScript);

            System.out.println("\n✅ Successfully converted monodix file to " + targetScript + "!");
        } catch (Exception e) {
            System.err.println("Error converting file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
