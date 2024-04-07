package com.manish.project.spritestrom;

import org.lwjgl.glfw.GLFW;

public class KeyListener {
    private static KeyListener instance;
    private final boolean[] keyPressed;

    private KeyListener(){
        keyPressed = new boolean[350];
    }

    public static KeyListener get() {
        if (KeyListener.instance == null) {
            KeyListener.instance = new KeyListener();
        }

        return KeyListener.instance;
    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods){
        if(action == GLFW.GLFW_PRESS){
            get().keyPressed[key] = true;
        }else if (action == GLFW.GLFW_RELEASE){
            get().keyPressed[key] = false;
        }
    }

    public static boolean isKeyPressed(int keyCode){
        return get().keyPressed[keyCode];
    }

}
