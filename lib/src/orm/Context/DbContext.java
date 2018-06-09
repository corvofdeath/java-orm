package orm.Context;

import utils.Logger;

import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;

public class DbContext {

    private Connection connection;
    private String url = "jdbc:";
    private String user;
    private String password;
    private String database = "";
    private String options = "?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";

    protected final HashMap<Class, DbSet> dbSets;

    DbContext(String connectionString, String user, String password) {
        this.url += connectionString;
        this.user = user;
        this.password = password;
        this.database = getDatabaseName(connectionString);

        this.dbSets = new HashMap<Class, DbSet>();

        // Init database
        init();
    }

    private void init() {
        Logger.writeLine("[Database] Initialization Start...");

        try {

            // establish a connection with database
            Logger.writeLine("[Database] try connection to: " + this.getUrl());
            Connection connection = DriverManager.getConnection(this.getUrl(), this.user, this.password);
            Logger.writeLine("[Database] Connection Successful");


        } catch(SQLException e) {
            e.printStackTrace();
            Logger.writeLine("Error message: " + e.getMessage());
            Logger.writeLine("[Database] Initialization ERROR!");
        }
    }

    private String getFullUrl() {
        return this.url + this.database + this.options;
    }

    private String getUrl() {
        return  this.url + this.options;
    }

    private String getDatabaseName(String connectionString) {

        String[] parts = connectionString.split("/");

        // remove database name from url
        this.updateUrl(parts);

        // return the last element of the array
        return parts[parts.length - 1];
    }

    private String updateUrl (String[] parts) {

        this.url = parts[0] + "//" + parts[1] + "/" + parts[2];

        return this.url;
    }
}
