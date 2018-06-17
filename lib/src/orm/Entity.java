package orm;

import orm.Attributes.*;

import java.util.Date;
import java.util.UUID;

public abstract class Entity {

    @Key
    private UUID id;

    @DateTime
    @Required
    private Date createdAt;

    @DateTime
    @AllowNull
    private Date updatedAt;

    public String getId() {
        return id.toString();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
