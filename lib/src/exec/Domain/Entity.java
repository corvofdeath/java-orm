package exec.Domain;

import orm.Attributes.*;

import java.util.Date;

public abstract class Entity {

    @Key
    @AutoIncrement
    private int id;

    @DateTime
    @Required
    private Date createdAt;

    @DateTime
    @AllowNull
    private Date updatedAt;
}
