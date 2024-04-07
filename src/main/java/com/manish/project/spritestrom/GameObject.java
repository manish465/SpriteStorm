package com.manish.project.spritestrom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameObject {
    private final UUID gameObjectID;
    private final List<Component> components;

    public GameObject(){
        gameObjectID = UUID.randomUUID();
        components = new ArrayList<>();
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component c : components) {
            if (componentClass.isAssignableFrom(c.getClass())) {
                try {
                    return componentClass.cast(c);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    assert false : "Error: Casting component.";
                }
            }
        }

        return null;
    }

    public <T extends Component> void removeComponent(Class<T> componentClass) {
        for (int i=0; i < components.size(); i++) {
            Component c = components.get(i);
            if (componentClass.isAssignableFrom(c.getClass())) {
                components.remove(i);
                return;
            }
        }
    }

    public void addComponent(Component c) {
        this.components.add(c);
        c.gameObject = this;
    }

    public void update() {
        for (int i=0; i < components.size(); i++) {
            components.get(i).update();
        }
    }

    public void start() {
        for (int i=0; i < components.size(); i++) {
            components.get(i).start();
        }
    }

    public UUID getGameObjectID() {
        return gameObjectID;
    }
}
