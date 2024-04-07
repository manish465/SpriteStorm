package com.manish.project.spritestrom;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {
    private static SceneManager sceneManager;
    private List<Scene> sceneList;
    private Scene currentScene;

    private SceneManager(){
        sceneList = new ArrayList<>();
        currentScene = new DefaultScene();

        sceneList.add(currentScene);
    }

    public static SceneManager get(){
        if(sceneManager == null){
            sceneManager = new SceneManager();
        }

        return sceneManager;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }
}
