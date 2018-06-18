package orm.Context;

public class EntityPropertyInformation {

    private String name;
    private String constraint;

    public EntityPropertyInformation(String name, String constraint) {
        this.name = name;
        this.constraint = constraint;
    }

    public String getConstraint() {
        return constraint;
    }

    public String getName() {
        return name;
    }
}
