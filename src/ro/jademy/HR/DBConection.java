package ro.jademy.HR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {

    public static Connection getConnection() throws SQLException {
        String URL = "jdbc:hsqldb:hsql://localhost/employees";
        String user = "SA";
        String password = "";
        Connection conn = DriverManager.getConnection(URL, user, password);
        return conn;

    }
}
