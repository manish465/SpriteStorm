package com.manish.project.spritestrom;

import org.lwjgl.glfw.GLFW;

public class GameLoop {
    private final double timePerFrame;
    private final double timePerUpdate;

    private final Engine engine;

    public GameLoop(Engine engine, int fps, int ups){
        this.engine = engine;

        timePerFrame = 1000000000.0 / fps;
        timePerUpdate = 1000000000.0 / ups;
    }

    public void run() {
        engine.setRunning(true);

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;


        while (engine.isRunning()){
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                engine.update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                engine.render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }

            // Swap buffers
            GLFW.glfwSwapBuffers(engine.getWindow());

            // Poll for events
            GLFW.glfwPollEvents();

            // Check if the window should close
            if (GLFW.glfwWindowShouldClose(engine.getWindow())) {
                engine.setRunning(false);
                engine.stop();
            }
        }
    }
}
