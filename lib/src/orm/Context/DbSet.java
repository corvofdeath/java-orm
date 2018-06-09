package orm.Context;

public class DbSet<T> {

    private final Class<T> classType;

    DbSet(Class<T> classType) {
        this.classType = classType;
    }
}
