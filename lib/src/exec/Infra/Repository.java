package exec.Infra;

import exec.Interfaces.IRepository;
import orm.Context.DbContext;
import orm.Entity;
import orm.Querys.IQueryable;
import orm.Querys.Implementation.Queryable;

import java.util.ArrayList;

public class Repository implements IRepository {

    private final DbContext context;

    public Repository(DbContext context) {
        this.context = context;
    }

    private IQueryable getQuery(Class entityClass, String where, String... conditions) {

        IQueryable query = new Queryable(entityClass.getSimpleName());

        if (where != null && where.length() > 0) {
            query.where(where);
        }

        if (conditions != null && conditions.length > 0) {

            // TODO: make this a queryable method

            for (String condition : conditions) {

                // repositorio.get(Entity.class, "idade > '15', "&& asdasd", "|| asdjasd"")
                // AND
                if (condition.charAt(0) == '&' && condition.charAt(1) == '&') {
                    query.and(condition);
                } else if (condition.charAt(0) == '|' && condition.charAt(1) == '|') {
                    // OR
                    query.or(condition);
                }

                // TODO: Else for exception
            }

        }

        return query;
    }

    @Override
    public <T extends Entity> T create(Class<T> entityClass, T entity) {
        return (T) this.context.getDbset(entityClass).insert(entity);
    }

    @Override
    public <T extends Entity> T update(Class<T> entityClass, T entity) {
        return (T) this.context.getDbset(entityClass).update(entity);
    }

    @Override
    public <T extends Entity> void delete(Class<T> entityClass, T entity) {
        this.context.getDbset(entityClass).delete(entity);
    }

    @Override
    public <T extends Entity> T get(Class<T> entityClass, String where, String... conditions) {
        return (T) this.context.getDbset(entityClass).get(getQuery(entityClass, where, conditions));
    }

    @Override
    public <T extends Entity> ArrayList<T> getAll(Class<T> entityClass, String where, String... conditions) {
        return this.context.getDbset(entityClass).getAll(getQuery(entityClass, where, conditions));
    }
}
