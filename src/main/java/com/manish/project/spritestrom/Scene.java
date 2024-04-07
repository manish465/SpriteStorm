package com.manish.project.spritestrom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Scene {
    private final UUID sceneID;
    private final String name;
    protected List<GameObject> gameObjects;

    public Scene(String name) {
        sceneID = UUID.randomUUID();
        this.name = name;
        gameObjects = new ArrayList<>();
    }

    public void start() {
        for (GameObject go : gameObjects) {
            go.start();
        }
    }

    public void addGameObjectToScene(GameObject go) {
        gameObjects.add(go);
    }

    public String getName() {
        return name;
    }

    public UUID getSceneID() {
        return sceneID;
    }

    public abstract void render();
    public abstract void update();
}
