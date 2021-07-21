package cu.com.yleon.technicaltest.manager;

import org.springframework.core.env.Environment;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private static DatabaseManager instance = null;
    private final Environment env;

    public DatabaseManager(Environment env) {
        this.env = env;
    }

    public static synchronized DatabaseManager getInstance(Environment env) {
        if (instance == null) {
            instance = new DatabaseManager(env);
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection;
        try {
            Class.forName(env.getProperty("bd.driver"));
            String userName = env.getProperty("bd.username");
            String password = env.getProperty("bd.password");
            connection = DriverManager.getConnection(env.getProperty("bd.url"), userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Connection DB error.", e);
        }
        return connection;
    }

    public Statement getStatment(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Get Statment Connection error.", e);
        }
    }

    public void createLogTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = getStatment(connection);
            statement.executeUpdate("create table IF NOT EXISTS Log_Values(message varchar(255), type int)");
        } catch (SQLException e) {
            throw new RuntimeException("Create log table BD error.", e);
        }
    }

    public void insertMessageBD(String message, String messageType) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = getStatment(connection);
            statement.execute("INSERT INTO Log_Values(message, type) VALUES('" + message + "', " + messageType + ")");
        } catch (SQLException e) {
            throw new RuntimeException("Insert message BD error.", e);
        }
    }
}
