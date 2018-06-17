package orm.Querys.Implementation;

import orm.Querys.IQuery;
import orm.Querys.IStatement;
import utils.Logger;
import utils.ReflectionExtensions;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class Statement extends Query implements IStatement {

    private String table;

    public Statement(String table) {
        this.table = table;
    }

    @Override
    public IQuery create(Object object) {

        this.statement.append("INSERT INTO ").append(table).append(" ");

        StringBuilder columns = new StringBuilder().append("(");
        StringBuilder values = new StringBuilder().append("(");

        for (ValueInformation information : getValues(object)) {

            if (information.getColumn().equals("id")) continue;

            columns.append("'").append(information.getColumn()).append("',");
            values.append("'").append(information.getValue()).append("',");
        }

        columns.deleteCharAt(columns.lastIndexOf(","));
        values.deleteCharAt(values.lastIndexOf(","));

        columns.append(")");
        values.append(")");

        this.statement.append(columns).append(" VALUES ").append(values).append(";");

        return this;
    }

    @Override
    public IQuery update(Object object) {

        this.statement.append("UPDATE ").append(table).append(" SET ");
        String id = "";

        for (ValueInformation information : getValues(object)) {

            if (information.getColumn().equals("id")) id = information.getValue();

            this.statement.append(information.getColumn()).append(" = ").append(information.getValue()).append(", ");
        }

        this.statement.deleteCharAt(this.statement.lastIndexOf(","));

        this.statement.append(" WHERE id = ").append(id).append(";");
        return this;
    }

    @Override
    public IQuery delete(Object object) {

        this.statement.append("DELETE FROM ").append(table).append(" WHERE id = ");

        for (ValueInformation information : getValues(object)) {

            if (information.getColumn().equals("id")) {
                this.statement.append(information.getValue()).append(";");
                break;
            }
        }

        return this;
    }

    private ValueInformation[] getValues(Object object) {

        ArrayList<ValueInformation> information = new ArrayList<>();

        for (Field field : ReflectionExtensions.getAllFields(new ArrayList<Field>(), object.getClass())) {

            try {
                field.setAccessible(true);
                information.add(new ValueInformation(field.getName(), field.get(object).toString()));

            } catch (Exception e) {
                e.printStackTrace();
                Logger.writeLine("Create Statement ERRROR!");
            }
        }

        ValueInformation[] array = new ValueInformation[information.size()];
        return information.toArray(array);
    }
}
