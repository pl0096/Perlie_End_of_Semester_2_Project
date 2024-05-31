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
        up1 = setup("/monster/evildog2");
        up2 = setup("/monster/evildog3");
        down1 = setup("/monster/evildog0");
        down2 = setup("/monster/evildog1");
        left1 = setup("/monster/evildog4");
        left2 = setup("/monster/evildog5");
        right1 = setup("/monster/evildog6");
        right2 = setup("/monster/evildog7");
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
