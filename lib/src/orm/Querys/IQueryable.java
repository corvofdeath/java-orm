package orm.Querys;

public interface IQueryable extends IQuery {

    public IQueryable where(String where);
    public IQueryable and(String condition);
    public IQueryable or(String condition);
    public IQueryable orderBy(String orderby);
}
