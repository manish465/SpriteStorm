package com.manish.project.spritestrom;

import org.lwjgl.glfw.GLFW;

public class GameEngine {
    private final long window;
    private boolean running;

    public GameEngine(){
        window = new GameWindow("Primary Window", 800, 600).getWindow();
        GameLoop gameLoop = new GameLoop(this, 120, 200);

        // no return
        gameLoop.run();
        stop();
    }

    public void stop(){
        GLFW.glfwTerminate();
    }

    public void render(){
        SceneManager.get().getCurrentScene().render();
    }

    public void update(){
        SceneManager.get().getCurrentScene().update();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public long getWindow() {
        return window;
    }
}
