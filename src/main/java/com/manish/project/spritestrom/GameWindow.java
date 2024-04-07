package com.manish.project.spritestrom;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class GameWindow {
    private final long window;

    public GameWindow(String name, int width, int height){
        if(!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Create a window
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        window = GLFW.glfwCreateWindow(width, height, name, 0,0);
        if(window == 0){
            throw new RuntimeException("Failed to create the GLFW window");
        }

        GLFW.glfwSetCursorPosCallback(window, MouseListener::mousePosCallback);
        GLFW.glfwSetMouseButtonCallback(window, MouseListener::mouseButtonCallback);
        GLFW.glfwSetScrollCallback(window, MouseListener::mouseScrollCallback);
        GLFW.glfwSetKeyCallback(window, KeyListener::keyCallback);

        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Set the clear color
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public long getWindow() {
        return window;
    }
}
