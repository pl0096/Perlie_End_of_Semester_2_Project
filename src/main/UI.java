package main;

import entity.Entity;
import object.OBJ_Heart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

//text message, icons etc.
public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {

        this.gp = gp;
        arial_40 = new Font("Courier New", Font.PLAIN, 40);
        arial_80B = new Font("Courier New", Font.BOLD, 80);

        //CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_80B);
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState) {
            drawPlayerLife();

        }
        if(gp.gameState == gp.pauseState) {
            drawPlayerLife();
        }
    }
    public void drawPlayerLife() {

        //DRAW MAX LIFE
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //DRAW BLANK HEART
        while(i < gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        //RESET
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;
        while(i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);


            }
            i++;
            x += gp.tileSize;
        }


    }

    public void drawPauseScreen() {

        String text = "PAUSED";
        int x = getXforCenterText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public int getXforCenterText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length / 2;
        return x;
    }



}
