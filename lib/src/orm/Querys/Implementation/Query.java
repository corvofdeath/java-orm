package orm.Querys.Implementation;

import orm.Querys.IQuery;

public abstract class Query implements IQuery {

    protected StringBuilder statement;

    @Override
    public String getQuery() {
        return statement.toString();
    }
}
