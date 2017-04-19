/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ilkka
 */
public class BibtexGenerator {

    private static final Map<String, String> scandis;

    // Map character replacements
    static {
        Map<String, String> m = new HashMap<>();
        m.put("ä", "\\\"{a}");
        m.put("Ä", "\\\"{A}");
        m.put("ö", "\\\"{o}");
        m.put("Ö", "\\\"{O}");
        m.put("å", "\\aa");
        m.put("Å", "\\AA");
        scandis = Collections.unmodifiableMap(m);
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
            fieldValue = replaceScandis(fieldValue);

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

    private static String replaceScandis(String s) {
        for (String scandi : scandis.keySet()) {
            s = s.replace(scandi, scandis.get(scandi));

        }
        return s;
    }

}
