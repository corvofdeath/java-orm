package orm.SqlGenerator;

import orm.Context.EntityInformation;
import orm.Context.EntityKeyInformation;
import orm.Context.EntityPropertyInformation;

public class Generator {

    private StringBuilder statement;

    public Generator() {
        this.statement = new StringBuilder();
    }

    public void initSQLStatement(String database) {

        // Create dabase statement
        statement.append("CREATE DATABASE  IF NOT EXISTS `").append(database).append("` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;\n");
        //statement.append("USE `").append(database).append("`;\n");

        statement.append("-- JAVA-SA-ORM --\n");
        statement.append("-- ------------------------------------------------------\n\n");
        statement.append("/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\n");
        statement.append("/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\n");
        statement.append("/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\n");
        statement.append("SET NAMES UTF8 ;\n");
        statement.append("/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;\n");
        statement.append("/*!40103 SET TIME_ZONE='+00:00' */;\n");
        statement.append("/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\n");
        statement.append("/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\n");
        statement.append("/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;\n");
        statement.append("/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;\n");

        statement.append("\n");
        statement.append("\n");
    }

    public void insertTableStatement(Class table) {

        EntityInformation information = new EntityInformation(table);

        statement.append("--\n");
        statement.append("-- Table structure for table `").append(information.getTableName()).append("`\n");
        statement.append("--\n");

        statement.append("\n");

        statement.append("/*!40101 SET @saved_cs_client     = @@character_set_client */;\n");
        statement.append(" SET character_set_client = utf8mb4 ;\n");
        statement.append("CREATE TABLE IF NOT EXISTS `").append(information.getTableName()).append("` (\n");

        EntityPropertyInformation[] properties = information.getPropertiesInformations();
        for (EntityPropertyInformation property : properties) {
            statement.append("`").append(property.getName()).append("`").append(property.getConstraint()).append(",\n");
        }

        EntityKeyInformation[] keys = information.getKeysInformations();
        for (EntityKeyInformation key : keys) {
            statement.append(key.getInstruction());
        }

        statement.deleteCharAt(statement.lastIndexOf(","));
        statement.append("\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
        statement.append("/*!40101 SET character_set_client = @saved_cs_client */;\n");
        statement.append("\n");
    }

    public void insertFinalStatement() {
        statement.append("/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;\n");
        statement.append("/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;\n");
        statement.append("/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;\n");
        statement.append("/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;\n");
        statement.append("/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;\n");
        statement.append("/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;\n");
        statement.append("/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;\n");
        statement.append("/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;\n");
    }


    public String getStatement() {
        return this.statement.toString();
    }
}
