package orm.SqlGenerator;

import orm.Context.EntityInformation;
import orm.Context.EntityPropertyInformation;

public class Generator {

    private StringBuilder statement;

    public Generator() {
        this.statement = new StringBuilder();
    }

    public void initSQLStatement(String database) {

        // Create dabase statement
        statement.append("CREATE DATABASE  IF NOT EXISTS `").append(database).append("`\n");
        statement.append("USE `").append(database).append("`;\n");
        statement.append("SET NAMES UTF8 ;\n");
    }

    public void insertTableStatement(Class table) {

        EntityInformation information = new EntityInformation(table);

        statement.append(" SET character_set_client = utf8mb4 ;\n");
        statement.append("CREATE TABLE IF NOT EXISTS `").append(information.getTableName()).append("` (\n");

        EntityPropertyInformation[] properties = information.getPropertiesInformations();
        for (EntityPropertyInformation property : properties) {
            statement.append("`").append(property.getName()).append("`").append(property.getConstraint()).append(",\n");
        }

        statement.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n\n");
    }


    public String getStatement() {
        return this.statement.toString();
    }
}
