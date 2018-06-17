package orm.Querys;

public interface IStatement extends IQuery {

    IQuery create(Object object);
    IQuery update(Object object);
    IQuery delete(Object object);
}
