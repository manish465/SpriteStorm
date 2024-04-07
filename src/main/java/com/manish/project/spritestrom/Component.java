package com.manish.project.spritestrom;

import java.util.UUID;

public abstract class Component {
    protected GameObject gameObject;
    protected final UUID componentID;

    public Component() {
        this.componentID = UUID.randomUUID();
    }

    public UUID getComponentID() {
        return componentID;
    }

    public abstract void start();
    public abstract void update();
}
