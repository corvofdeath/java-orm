package orm.Context;

import orm.Querys.IQueryable;
import orm.Querys.Implementation.*;
import orm.Querys.Implementation.Statement;
import utils.Logger;

import java.sql.*;

public class DbSet<T> {

    private final Class<T> classType;

    public DbSet(Class<T> classType) {
        this.classType = classType;
    }

    public T insert(T entity) {

        Statement query = new Statement(classType.getSimpleName());
        query.create(entity);

        executeUpdateQuery(query);

        return entity;
    }

    public T update(T entity) {
        return  entity;
    }

    public void delete(T entity) {

    }

    public T get(IQueryable query) {
        return null;
    }

    public T[] getAll(IQueryable query) {
        return null;
    }

    private void executeUpdateQuery(Query query) {

        Connection connection = DbContext.connectionFactory.getConnection();

        try {
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(query.getQuery());
            Logger.writeLine("[Database] Finish Query!");
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.writeLine("Error message: " + e.getMessage());
            Logger.writeLine("[Database] Close ERROR!");
        } finally {
            DbContext.connectionFactory.closeConnection(connection);
        }
    }
}
