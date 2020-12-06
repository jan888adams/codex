package codex.utils.sql;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 10.11.2020
 */

public class SqlStatement {

    public final static String INSERT_INTO = "INSERT INTO ";
    public final static String VALUES = " VALUES";
    public final static String SELECT = "SELECT ";
    public final static String ALL = "* ";
    public final static String FROM = "FROM ";
    public final static String WHERE = " WHERE ";
    public final static String UPDATE = " UPDATE ";
    public final static String SET = " SET ";
    public final static String DELETE = "DELETE ";

    private final String table;

    public SqlStatement(String table) {
        this.table = table;
    }

    public String insertInto(String... values) {

        StringBuilder statement = new StringBuilder(INSERT_INTO + table +
                VALUES + "(");

        for (int i = 0; i < values.length - 1; i++) {
            statement.append("'").append(values[i]).append("'").append(",");
        }
        return statement + "'" + values[values.length - 1] + "'" + ")";
    }

    public String deleteFrom(String keyColumn, String key) {
        return DELETE + FROM + table + WHERE + keyColumn + "'" + key + "'";
    }

    public String selectAll(String keyColumn, String key) {
         return SELECT + ALL + FROM + table +
                WHERE + keyColumn + " = " + "'" + key + "'";
    }

   // TODO: Map-File erstellen, um Tabellennamen mit Java-Been Klassen zu mappen.
}
