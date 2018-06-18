package exec;

import orm.CreateDatabase;

import java.sql.*;

public class Main {

    public static void main (String[] args) throws Exception {
        try {

            String serverName = "localhost:3306";
            String mydatabase = "softsoft";
            String url = "jdbc:mysql://" + serverName + "/" + "?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";

            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);

            CreateDatabase create = new CreateDatabase();
            create.Create(connection, "teste2");
        } catch (Exception e) {
            throw e;
        }

    }
}
