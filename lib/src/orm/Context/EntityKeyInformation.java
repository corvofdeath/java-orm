package orm.Context;

public class EntityKeyInformation {
    private String name;
    private String instruction;

    public EntityKeyInformation(String name, String instruction) {
        this.name = name;
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getName() {
        return name;
    }
}
