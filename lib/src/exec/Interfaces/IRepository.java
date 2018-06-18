package exec.Interfaces;

import orm.Entity;

import java.util.ArrayList;

public interface IRepository {

    // CRUD
    <T extends Entity> T create(Class<T> entityClass, T entity);
    <T extends Entity> T update(Class<T> entityClass, T entity);
    <T extends Entity> void delete(Class<T> entityClass, T entity);

    // READ
    <T extends Entity> T get(Class<T> entityClass, String where, String... conditions);
    <T extends Entity> ArrayList<T> getAll(Class<T> entityClass, String where, String... conditions);
}
