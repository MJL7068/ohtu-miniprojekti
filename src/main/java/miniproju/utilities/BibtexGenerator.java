package miniproju.utilities;

import java.util.Map;

/**
 *
 * @author ilkka
 */
public class BibtexGenerator {

    private static final String[][] replacements;

    // Map character replacements
    static {
        replacements = new String[6][];
        replacements[0] = new String[] {"ä", "\\\"{a}"};
        replacements[1] = new String[] {"Ä", "\\\"{A}"};
        replacements[2] = new String[] {"ö", "\\\"{o}"};
        replacements[3] = new String[] {"Ö", "\\\"{O}"};
        replacements[4] = new String[] {"å", "\\aa"};
        replacements[5] = new String[] {"Å", "\\AA"};
    }

    private BibtexGenerator() {
    }

    public static String toBibtex(String entryType, String entryKey, Map<String, Object> fields) {
        StringBuilder sb = new StringBuilder("@" + entryType + "{");
        sb.append(entryKey).append(",\n");

        for (String fieldName : fields.keySet()) {
            sb.append(fieldName).append(" = {");

            String fieldValue = fields.get(fieldName).toString();
            fieldValue = preserveCapitals(fieldValue);
            fieldValue = replaceScandics(fieldValue);

            sb.append(fieldValue).append("}");
            sb.append(",\n");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");

        return sb.toString();
    }

    private static String preserveCapitals(String s) {
        return s.replaceAll("([A-Z])", "{$1}");
    }

    private static String replaceScandics(String s) {
        for (String[] rep : replacements) {
            s = s.replace(rep[0], rep[1]);
        }
        return s;
    }

}
