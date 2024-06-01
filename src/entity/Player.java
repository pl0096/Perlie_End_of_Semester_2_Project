package entity;

import jdk.internal.icu.impl.StringPrepDataReader;
import jdk.jshell.execution.Util;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKeys = 0;
    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 4 * gp.scale;
        solidArea.y = 9* gp.scale ;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 6 * gp.scale;
        solidArea.height = 7 * gp.scale;


        attackArea.width = 36;
        attackArea.height = 36;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 2;
        worldY = 47 * gp.tileSize;
        speed = 4;
        direction = "down";

        //PLAYER STATUS
        maxLife = 6;
        life = maxLife;

    }
    public void getPlayerImage(){
        up1 = setup("/player/chicksprite_up1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/chicksprite_up2", gp.tileSize, gp.tileSize);
        down1 = setup("/player/chicksprite_down1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/chicksprite_down2", gp.tileSize, gp.tileSize);
        left1 = setup("/player/chicksprite_left1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/chicksprite_left2", gp.tileSize, gp.tileSize);
        right1 = setup("/player/chicksprite_right1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/chicksprite_right2", gp.tileSize, gp.tileSize);
    }

    public void getPlayerAttackImage() {
        attackUp1 = setup("/player/chickAttack02", gp.tileSize, gp.tileSize*2);
        attackUp2 = setup("/player/chickAttack03", gp.tileSize, gp.tileSize*2);
        attackDown1 = setup("/player/chickAttack00", gp.tileSize, gp.tileSize * 2);
        attackDown2 = setup("/player/chickAttack01", gp.tileSize, gp.tileSize * 2);
        attackLeft1 = setup("/player/chickAttack06", gp.tileSize * 2, gp.tileSize);
        attackLeft2 = setup("/player/chickAttack07", gp.tileSize * 2, gp.tileSize);
        attackRight1 = setup("/player/chickAttack04", gp.tileSize * 2, gp.tileSize);
        attackRight2 = setup("/player/chickAttack05", gp.tileSize * 2, gp.tileSize);

    }


    public void update() {

        if(attacking == true) {
            attacking();
        }

        else if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true) {
                direction = "up";
            }
            else if(keyH.downPressed == true) {
                direction = "down";
            }
            else if(keyH.leftPressed == true) {
                direction = "left";
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(!collisionOn){
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }

            }

            spriteCounter++;
            if(spriteCounter > 10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if(invincible == true) {
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }




    }




    public void attacking() {

        spriteCounter++;

        if(spriteCounter <= 5) {
            spriteNum = 1;
        }
        if(spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;

            // save the current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //Adjust player's worldX/Y for the attackArea
            switch(direction) {
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;


            }
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);

            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;



    }
        if(spriteCounter > 25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    public void pickUpObject(int i) {

        if(i != 999) {
            switch(gp.obj[i].name) {
                case ("Chest"):
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4);

                case ("Key"): {
                    gp.obj[i] = null;
                    hasKeys++;
                    gp.playSE(1);


                }
                case ("Door"): {
                    if(hasKeys > 0) {
                        gp.obj[i] = null;
                        hasKeys--;
                        gp.playSE(3);



                    }

                }
                case ("Boots"): {
                    speed += 1;
                    gp.obj[i] = null;
                    gp.playSE(2);

                }
            }

        }
    }
    public void interactNPC(int i) {
        if(gp.keyH.enterPressed) {
            attacking = true;
        }
    }
    public void contactMonster(int i) {

        if(i != 999) {

            if(invincible == false) {
                life -= 1;

                if(life == 0) {
                    gp.ui.gameLost = true;
                    gp.ui.gameFinished = true;
                }
                invincible = true;

            }

        }
    }

    public void damageMonster(int i){
        if(i != 999) {

            if(gp.monster[i].invincible == false) {

                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;

                if(gp.monster[i].life <= 0) {
                    gp.npc[gp.aSetter.npc_nxtIdx] = new NPC_Dog(gp);
                    gp.npc[gp.aSetter.npc_nxtIdx].worldX = gp.monster[i].worldX;
                    gp.npc[gp.aSetter.npc_nxtIdx].worldY = gp.monster[i].worldY;
                    gp.aSetter.npc_nxtIdx++;

                    gp.monster[i] = null;

                }
            }
        }

    }
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch(direction) {
            case "up":
                if(attacking == false) {
                    if(spriteNum == 1){
                        image = up1;
                    }
                    if(spriteNum == 2) {
                        image = up2;
                    }
                }
                if(attacking == true) {

                    tempScreenY = screenY - gp.tileSize;
                    if(spriteNum == 1){
                        image = attackUp1;
                    }
                    if(spriteNum == 2) {
                        image = attackUp2;
                    }
                }

                break;

            case "down":
                if(attacking == false) {
                    if(spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2) {
                        image = down2;
                    }
                }
                if(attacking == true) {
                    if(spriteNum == 1){
                        image = attackDown1;
                    }
                    if(spriteNum == 2) {
                        image = attackDown2;
                    }
                }

                break;

            case "left":
                if(attacking == false) {
                    if(spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2) {
                        image = left2;
                    }
                }
                if(attacking == true) {
                    tempScreenX = screenX - gp.tileSize;
                    if(spriteNum == 1){
                        image = attackLeft1;
                    }
                    if(spriteNum == 2) {
                        image = attackLeft2;
                    }
                }

                break;
            case "right":
                if(attacking == false) {
                    if(spriteNum == 1){
                        image = right1;
                    }
                    if(spriteNum == 2) {
                        image = right2;
                    }
                }
                if(attacking == true) {
                    if(spriteNum == 1){
                        image = attackRight1;
                    }
                    if(spriteNum == 2) {
                        image = attackRight2;
                    }
                }

                break;



        }
        //System.out.println("(" + worldX/ gp.tileSize + ", " + worldY/ gp.tileSize + ")");

        if(invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }

        g2.drawImage(image, tempScreenX, tempScreenY, null);


        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));


//        g2.setFont(new Font("Arial", Font.PLAIN, 26));
//        g2.setColor(Color.white);
//        g2.drawString("Invincible: " + invincibleCounter + invincible, 10, 400 );


    }
}
