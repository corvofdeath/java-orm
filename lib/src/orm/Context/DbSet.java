package orm.Context;

import orm.Entity;
import orm.Querys.IQuery;
import orm.Querys.IQueryable;
import orm.Querys.Implementation.Statement;
import utils.Logger;
import utils.ReflectionExtensions;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

        ArrayList<T> result = executeQuery(query);

        if (result.size() > 0)
            return result.get(0);

        return null;
    }

    public ArrayList<T> getAll(IQueryable query) {
        Logger.writeLine("[Query] - Executando a query...");
        Logger.writeLine(query.getQuery());
        return executeQuery(query);
    }

    private void executeUpdateQuery(IQuery query) {

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

    private ArrayList<T> executeQuery(IQuery query) {

        Connection connection = DbContext.connectionFactory.getConnection();
        Logger.writeLine("[Database] Starting Query!");
        ArrayList<T> list = new ArrayList<>();

        try {

            java.sql.Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query.getQuery());
            TypeInformation[] informations = getTypesInformations();

            while(result.next()) {

                T entity = this.classType.getDeclaredConstructor().newInstance();

                for (TypeInformation type : informations) {

                    if (type.getType().equals("String")) {
                        type.getField().set(entity, result.getString(type.getName()));
                    } else if (type.getType().equals("int")) {
                        type.getField().set(entity, result.getInt(type.getName()));
                    } else if (type.getType().equals("LocalDate")) {
                        Date date = result.getDate(type.getName());
                        LocalDate localDate = LocalDate.parse(date.toString());
                        type.getField().set(entity, localDate);
                    } else if (type.getType().equals("UUID")) {
                        type.getField().set(entity, UUID.fromString(result.getString(type.getName())));
                    } else if (type.getType().equals("double")) {
                        type.getField().set(entity, result.getDouble(type.getName()));
                    }
                }

                list.add(entity);
            }

            Logger.writeLine("[Database] Finish Query!");

        } catch (SQLException e) {

            e.printStackTrace();
            Logger.writeLine("Error message: " + e.getMessage());
            Logger.writeLine("[Database] Execute Query ERROR!");

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            DbContext.connectionFactory.closeConnection(connection);
            return list;
        }
    }

    private TypeInformation[] getTypesInformations() {

        ArrayList<TypeInformation> information = new ArrayList<>();

        for (Field field : ReflectionExtensions.getAllFields(new ArrayList<Field>(), this.classType)) {

            try {
                field.setAccessible(true);
                information.add(new TypeInformation(field.getName(), field.getType().getSimpleName(), field));
            } catch (Exception e) {
                e.printStackTrace();
                Logger.writeLine("Create Statement ERRROR!");
            }
        }

        TypeInformation[] array = new TypeInformation[information.size()];
        return information.toArray(array);
    }
}
