package codex.utils.sql;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 15.11.2020
 */

public class SqlInjectionHandler {

    //TODO: umbenennen und allgemeiner machen

    public String replaceNotAllowedCharacters(String str) {
        String data = null;
        if (str != null && str.length() > 0) {
            str = str.replace("\\", "\\\\");
            str = str.replace("'", "\\'");
            str = str.replace("\0", "\\0");
            str = str.replace("\n", "\\n");
            str = str.replace("\r", "\\r");
            str = str.replace("\"", "\\\"");
            str = str.replace("\\x1a", "\\Z");
            data = str;
        }
        return data;
    }
}
