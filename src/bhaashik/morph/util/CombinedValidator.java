package bhaashik.morph.util;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CombinedValidator {

    public static boolean validateXmlStructure(File dixFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(dixFile);

            Element root = doc.getDocumentElement();
            if (!"dictionary".equals(root.getNodeName())) {
                System.err.println("❌ Root element is not <dictionary>");
                return false;
            }

            NodeList children = root.getChildNodes();
            boolean hasAlphabet = false, hasSdefs = false, hasMain = false;
            Set<String> pardefNames = new HashSet<>();

            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE) continue;

                Element el = (Element) node;
                switch (el.getTagName()) {
                    case "alphabet":
                        hasAlphabet = true;
                        break;
                    case "sdefs":
                        hasSdefs = true;
                        NodeList sdefs = el.getElementsByTagName("sdef");
                        for (int j = 0; j < sdefs.getLength(); j++) {
                            Element sdef = (Element) sdefs.item(j);
                            if (!sdef.hasAttribute("n")) {
                                System.err.println("❌ <sdef> missing 'n' attribute.");
                                return false;
                            }
                        }
                        break;
                    case "section":
                        if ("main".equals(el.getAttribute("id"))) {
                            hasMain = true;

                            NodeList sectionChildren = el.getChildNodes();
                            for (int j = 0; j < sectionChildren.getLength(); j++) {
                                Node sc = sectionChildren.item(j);
                                if (sc.getNodeType() != Node.ELEMENT_NODE) continue;

                                Element secElem = (Element) sc;
                                if ("pardef".equals(secElem.getTagName())) {
                                    String pname = secElem.getAttribute("n");
                                    if (pname == null || pname.isEmpty()) {
                                        System.err.println("❌ <pardef> missing 'n' attribute.");
                                        return false;
                                    }
                                    pardefNames.add(pname);
                                } else if ("e".equals(secElem.getTagName())) {
                                    NodeList parTags = secElem.getElementsByTagName("par");
                                    for (int k = 0; k < parTags.getLength(); k++) {
                                        Element par = (Element) parTags.item(k);
                                        String ref = par.getAttribute("n");
                                        if (!pardefNames.contains(ref)) {
                                            System.err.println("❌ Reference to undefined <pardef>: " + ref);
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
            }

            if (!hasAlphabet) System.err.println("❌ Missing <alphabet>");
            if (!hasSdefs) System.err.println("❌ Missing <sdefs>");
            if (!hasMain) System.err.println("❌ Missing <section id=\"main\">");

            return hasAlphabet && hasSdefs && hasMain;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validateWithLtComp(File dixFile) {
        try {
            ProcessBuilder pb = new ProcessBuilder("lt-comp", "lr", dixFile.getAbsolutePath(), "/dev/null");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.lines().collect(Collectors.joining("\n"));
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                System.err.println("❌ lt-comp validation failed:");
                System.err.println(output);
                return false;
            }

            return true;
        } catch (Exception e) {
            System.err.println("❌ Error running lt-comp: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java apertium.validation.CombinedValidator <path-to-dix-file>");
            System.exit(1);
        }

        File dixFile = new File(args[0]);
        boolean xmlValid = validateXmlStructure(dixFile);
        System.out.println(xmlValid ? "✅ XML structure is valid." : "❌ XML structure is invalid.");

        boolean ltCompValid = validateWithLtComp(dixFile);
        System.out.println(ltCompValid ? "✅ lt-comp compilation succeeded." : "❌ lt-comp compilation failed.");

        if (xmlValid && ltCompValid) {
            System.out.println("✅✅ .dix file is valid and compilable.");
        } else {
            System.out.println("❌❌ .dix file has issues. Please check the logs above.");
        }
    }
}
