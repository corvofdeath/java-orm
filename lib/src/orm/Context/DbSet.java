package orm.Context;

import orm.Entity;
import orm.Querys.IQueryable;
import orm.Querys.Implementation.*;
import orm.Querys.Implementation.Statement;
import utils.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.UUID;

public class DbSet<T extends Entity> {

    private final Class<T> classType;

    public DbSet(Class<T> classType) {
        this.classType = classType;
    }

    public T insert(T entity) {

        entity.setId(UUID.randomUUID());
        entity.setCreatedAt(LocalDate.now());
        entity.setUpdatedAt(LocalDate.now());

        Statement query = new Statement(classType.getSimpleName());
        query.create(entity);

        executeUpdateQuery(query);

        return entity;
    }

    public T update(T entity) {

        entity.setUpdatedAt(LocalDate.now());

        Statement query = new Statement(classType.getSimpleName());
        query.update(entity);
        executeUpdateQuery(query);

        return  entity;
    }

    public void delete(T entity) {

        Statement query = new Statement(classType.getSimpleName());
        query.delete(entity);

        executeUpdateQuery(query);
    }

    public T get(IQueryable query) {
        return null;
    }

    public T[] getAll(IQueryable query) {
        return null;
    }

    private void executeUpdateQuery(Query query) {

        Connection connection = DbContext.connectionFactory.getConnection();
        Logger.writeLine("[Database] Starting Query!");
        try {
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(query.getQuery());
            Logger.writeLine("[Database] Finish Query!");
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.writeLine("Error message: " + e.getMessage());
            Logger.writeLine("[Database] Execute Query ERROR!");
        } finally {
            DbContext.connectionFactory.closeConnection(connection);
        }
    }
}
