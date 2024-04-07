package com.manish.project.spritestrom;

import java.awt.event.KeyEvent;

import static org.lwjgl.opengl.GL11.*;

public class DefaultScene extends Scene{
    public DefaultScene() {
        super("Default Scene");
    }

    public void start(){
        super.start();
    }

    @Override
    public void render() {
        glClear(GL_COLOR_BUFFER_BIT);

        // Render game objects here

        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex2f(-0.5f, -0.5f);
        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex2f(0.5f, -0.5f);
        glColor3f(0.0f, 0.0f, 1.0f);
        glVertex2f(0.0f, 0.5f);
        glEnd();
    }

    @Override
    public void update() {
        if(MouseListener.mouseButtonDown(0)){
            System.out.println("Clicked");
        }

        if(KeyListener.isKeyPressed(KeyEvent.VK_SPACE)){
            System.out.println("Space tapped");
        }
    }
}
