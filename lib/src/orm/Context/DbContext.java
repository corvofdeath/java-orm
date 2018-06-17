package orm.Context;

import orm.SqlGenerator.Generator;
import orm.SqlGenerator.WriteSql;
import utils.Logger;

import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;

public abstract class DbContext {

    private Connection connection;
    private String url = "jdbc:";
    private String user;
    private String password;
    private String database = "";
    private String options = "?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC";

    protected final HashMap<Class, DbSet> dbSets;

    public static ConnectionFactory connectionFactory;

    // Normal Constructor
    public DbContext(String connectionString, String user, String password) {
        this.url += connectionString;
        this.user = user;
        this.password = password;
        this.database = getDatabaseName(connectionString);

        this.dbSets = new HashMap<Class, DbSet>();

        // Init database
        init(Options.none);
    }

    // Options constructor
    public DbContext(String connectionString, String user, String password, Options option) {
        this.url += connectionString;
        this.user = user;
        this.password = password;
        this.database = getDatabaseName(connectionString);

        this.dbSets = new HashMap<Class, DbSet>();

        // Init database
        init(option);
    }

    protected void addDbSet(Class key, DbSet value){
        this.dbSets.put(key, value);
    }

    // overload to fill dbsets
    protected abstract void fillDbSets();

    private void init(Options options) {
        Logger.writeLine("[Database] Initialization Start...");

        // initialize dbsets based on entities
        fillDbSets();

        if (options.equals(Options.dump)) {

            Logger.writeLine("\n[Database]: Start dump...\n\n");

            // generate sq
            Generator sqlGenerator = new Generator();
            sqlGenerator.initSQLStatement(this.database);

            for (Class key : this.dbSets.keySet()) {
                sqlGenerator.insertTableStatement(key);
            }

            sqlGenerator.insertFinalStatement();

            // TODO: jogar num arquivo
            String sql = sqlGenerator.getStatement();
            Logger.writeLine(sql);
            WriteSql.createDumpFile(sql);
            Logger.writeLine("[Database]: Finish dump!");

        } else {

            // establish a connection with database
            Logger.writeLine("[Database] try connection to: " + this.getFullUrl());
            DbContext.connectionFactory = new ConnectionFactory(this.getFullUrl(), this.user, this.password);
            Connection connection = DbContext.connectionFactory.getConnection();
            Logger.writeLine("[Database] Connection Successful");
            DbContext.connectionFactory.closeConnection(connection);
        }

    }

    private String getFullUrl() {
        return this.url + this.database + this.options;
    }

    private String getDatabaseName(String connectionString) {

        String[] parts = connectionString.split("/");

        // remove database name from url
        this.updateUrl(parts);

        // return the last element of the array
        return parts[parts.length - 1];
    }

    private String updateUrl (String[] parts) {

        this.url = "jdbc:" + parts[0] + "/" + parts[1] + "/" + parts[2];

        return this.url;
    }
}
