package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Dog extends Entity{

    public NPC_Dog(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;

        solidArea.x = 6;
        solidArea.y = 12;
        solidArea.width = 36;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage(){
        up1 = setup("/npc/npc2");
        up2 = setup("/npc/npc3");
        down1 = setup("/npc/npc0");
        down2 = setup("/npc/npc1");
        left1 = setup("/npc/npc4");
        left2 = setup("/npc/npc5");
        right1 = setup("/npc/npc6");
        right2 = setup("/npc/npc7");
    }

    public void setAction() {

        actionLockCounter++;

        if(actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if(i <= 25) {
                direction = "up";
            }
            if(i > 25 && i <= 50) {
                direction = "down";
            }
            if(i > 50 && i <= 75) {
                direction = "left";
            }
            if(i > 75) {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }


}
