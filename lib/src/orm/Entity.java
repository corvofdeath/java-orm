package orm;

import orm.Attributes.*;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Entity {

    @Key
    private UUID id;

    @DateTime
    @Required
    private LocalDate createdAt;

    @DateTime
    @AllowNull
    private LocalDate updatedAt;

    public String getId() {
        return id.toString();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
