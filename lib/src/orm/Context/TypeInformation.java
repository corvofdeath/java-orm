package orm.Context;

import java.lang.reflect.Field;

public class TypeInformation {

    private String name;
    private String type;
    private Field field;

    TypeInformation(String name, String type, Field field) {
        this.name = name;
        this.type = type;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Field getField() {
        return field;
    }
}
