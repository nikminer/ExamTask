package com.company.models.base;

import java.time.LocalDateTime;

public abstract class BaseIdentification {
    final protected int id;
    final protected LocalDateTime creationDateTime;

    public BaseIdentification(int id) {
        this.id = id;
        this.creationDateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
}
