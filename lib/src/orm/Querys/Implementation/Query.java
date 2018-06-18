package orm.Querys.Implementation;

import orm.Querys.IQuery;

public abstract class Query implements IQuery {

    protected StringBuilder statement = new StringBuilder();

    @Override
    public String getQuery() {
        return statement.toString();
    }
}
