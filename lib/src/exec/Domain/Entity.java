package exec.Domain;

import orm.Attributes.*;

import java.util.Date;

public abstract class Entity {

    @Key
    @AutoIncrement
    private int id;

    @DateTime
    private Date createdAt;

    @DateTime
    private Date updatedAt;
}
