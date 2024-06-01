package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    // DEBUG
    boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {



        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) { //if the user pressed the w key
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) { //if the user pressed the s key
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT) { //if the user pressed the a key
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) { //if the user pressed the d key
            rightPressed = true;
        }
        if (code == KeyEvent.VK_P) { //if the user pressed the d key

            if(gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            enterPressed = true;
            System.out.println("enter key pressed");
        }

        //DEBUG
        if(code == KeyEvent.VK_T) {
            if(checkDrawTime) {
                checkDrawTime = false;
            }
            else{
                checkDrawTime = true;
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) { //if the user pressed the w key
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) { //if the user pressed the s key
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) { //if the user pressed the a key
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) { //if the user pressed the d key
            rightPressed = false;
        }
        if(code == KeyEvent.VK_ENTER) {
            enterPressed = false;

        }
    }
}
