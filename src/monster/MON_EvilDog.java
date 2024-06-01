package monster;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class MON_EvilDog extends Entity {
    public MON_EvilDog(GamePanel gp) {
        super(gp);

        type = 2;
        name = "Evil Dog";
        speed = 2;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 6;
        solidArea.y = 12;
        solidArea.width = 36;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage(){
        up1 = setup("/monster/evildog2", gp.tileSize, gp.tileSize);
        up2 = setup("/monster/evildog3", gp.tileSize, gp.tileSize);
        down1 = setup("/monster/evildog0", gp.tileSize, gp.tileSize);
        down2 = setup("/monster/evildog1", gp.tileSize, gp.tileSize);
        left1 = setup("/monster/evildog4", gp.tileSize, gp.tileSize);
        left2 = setup("/monster/evildog5", gp.tileSize, gp.tileSize);
        right1 = setup("/monster/evildog6", gp.tileSize, gp.tileSize);
        right2 = setup("/monster/evildog7", gp.tileSize, gp.tileSize);
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
