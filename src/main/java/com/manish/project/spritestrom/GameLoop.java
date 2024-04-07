package com.manish.project.spritestrom;

import org.lwjgl.glfw.GLFW;

public class GameLoop implements Runnable{
    private final long TARGET_TIME;

    private final Engine engine;

    public GameLoop(Engine engine, int fps){
        this.engine = engine;
        this.TARGET_TIME = 1000000000 / fps;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;

        while (engine.isRunning()){
            long now = System.nanoTime();
            long elapsedTime = now - lastTime;

            lastTime = now;
            unprocessedTime += elapsedTime / (double) TARGET_TIME;

            while (unprocessedTime >= 1) {
                engine.update(TARGET_TIME / 1000000000.0); // Pass delta time to update function
                unprocessedTime--;
            }

            engine.render();

            // Swap buffers
            GLFW.glfwSwapBuffers(engine.getWindow());

            // Poll for events
            GLFW.glfwPollEvents();

            // Check if the window should close
            if (GLFW.glfwWindowShouldClose(engine.getWindow())) {
                engine.setRunning(false);
            }

        }
    }
}
