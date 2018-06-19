package orm.Querys.Implementation;

import orm.Querys.IQueryable;
import utils.Logger;

public class Queryable extends Query implements IQueryable {

    public Queryable(String table) {
        this.statement.append("SELECT * FROM ").append(table).append(";");
    }

    @Override
    public IQueryable where(String where) {

        this.statement.deleteCharAt(this.statement.lastIndexOf(";"));
        this.statement.append(" WHERE ").append(where).append(";");

        Logger.writeLine("[Query] - Executando a query...");
        Logger.writeLine(this.getQuery());
        return this;
    }

    @Override
    public IQueryable and(String condition) {

        this.statement.deleteCharAt(this.statement.lastIndexOf(";"));
        this.statement.append(" AND ").append(condition).append(";");

        return this;
    }

    @Override
    public IQueryable or(String condition) {

        this.statement.deleteCharAt(this.statement.lastIndexOf(";"));
        this.statement.append(" OR ").append(condition).append(";");

        return this;
    }

    @Override
    public IQueryable orderBy(String orderby) {

        this.statement.deleteCharAt(this.statement.lastIndexOf(";"));
        this.statement.append(" ORDERBY ").append(orderby).append(";");

        return this;
    }


}
