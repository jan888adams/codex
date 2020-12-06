package codex.database;

import codex.utils.reader.PropertiesReader;

import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;


/**
 * rdms
 *
 * @author Jan Adams
 * @version 08.11.2020
 */

public class DatabaseEngine {

    private final String url;
    private final String password;
    private final String user;
    private Connection connection;
    private final String driver;

    public DatabaseEngine() throws ConnectException {

        Properties prop = new PropertiesReader().read("env.properties");
        driver = prop.getProperty("DRIVER");
        url = prop.getProperty("URL");
        user = prop.getProperty("USER");
        password = prop.getProperty("PASSWORD");

        connect();
    }

    public void connect() throws ConnectException {
        try {
            Class.forName(driver);
            connection = getConnection(url, user, password);
        } catch (SQLException e) {
            if (connection == null) {
                throw new ConnectException("Connection to the codex.database fails");
            }
        } catch (ClassNotFoundException e) {
            throw new ConnectException("Driver could not be loaded");
        }
    }


    public void closeConnection() throws ConnectException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ConnectException("Connection could not be closed");
        }
    }

    public void rollBack() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            try {
                throw new Exception("Rollback could not be executed ");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * @param sqlStatements -
     * @return false if SQL statement could not be execute
     */

    public boolean executeSQL(String[] sqlStatements) throws ConnectException, SQLDataException {

        Statement statement;

        try {
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            for (String sqlStatement : sqlStatements) {
                statement.execute(sqlStatement);
            }
            connection.commit();
        } catch (SQLException e) {
            rollBack();
            throw new SQLDataException("SQl statement could not be executed");
        }

        closeConnection();
        return true;
    }

    public ResultSet executeSQL(String sqlStatement) throws SQLDataException, ConnectException {

        ResultSet results;

        try {
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            results = statement.executeQuery(sqlStatement);
            connection.commit();

        } catch (SQLException e) {
            rollBack();
            throw new SQLDataException("SQl statement could not be executed");
        }


        return results;
    }


}

