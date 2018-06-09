package orm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    private String create = "CREATE DATABASE  IF NOT EXISTS ";

    public void Create(Connection connection, String database) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(this.create + database);
            System.out.println("Database created successfully...");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro on create statment");
        }
    }
}
