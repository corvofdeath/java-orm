package orm.Context;

import utils.Logger;

import java.sql.*;

public class ConnectionFactory {

    private String url;
    private String user;
    private String password;

    public ConnectionFactory(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection()  {

        try {
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.writeLine("Error message: " + e.getMessage());
            Logger.writeLine("[Database] Initialization ERROR!");
        }

        return null;
    }

    public void closeConnection(Connection connection) {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.writeLine("Error message: " + e.getMessage());
            Logger.writeLine("[Database] Close ERROR!");
        }
    }
}
