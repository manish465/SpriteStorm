package com.manish.project.spritestrom;

import org.lwjgl.glfw.GLFW;

public class Engine {
    public GameLoop gameLoop;

    private final long window;
    private boolean running;

    public Engine(){
        window = new GameWindow("Primary Window", 800, 600).getWindow();
        gameLoop = new GameLoop(this, 120);

        running = true;

        gameLoop.run();
        stop();
    }

    public void stop(){
        GLFW.glfwTerminate();
    }

    public void render(){

    }

    public void update(double deltaTime){
        
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
