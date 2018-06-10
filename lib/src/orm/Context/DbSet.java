package orm.Context;

public class DbSet<T> {

    private final Class<T> classType;

    public DbSet(Class<T> classType) {
        this.classType = classType;
    }
}
