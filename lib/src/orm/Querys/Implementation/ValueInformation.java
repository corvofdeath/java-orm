package orm.Querys.Implementation;

public class ValueInformation {

    private String column;
    private String value;

    public ValueInformation(String column, String value) {
        this.column = column;
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public String getValue() {
        return value;
    }
}
