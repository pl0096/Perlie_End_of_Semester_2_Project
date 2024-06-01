package main;

import entity.NPC_Dog;
import monster.MON_EvilDog;
import object.*;

public class AssetSetter {

    GamePanel gp;
    public int npc_nxtIdx = 1;


    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_Chest(gp);
        gp.obj[0].worldX = gp.tileSize * 49;
        gp.obj[0].worldY = gp.tileSize * 3;

        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].worldX = gp.tileSize * 41;
        gp.obj[1].worldY = gp.tileSize * 19;

        gp.obj[2] = new OBJ_Door(gp);
        gp.obj[2].worldX = gp.tileSize * 4;
        gp.obj[2].worldY = gp.tileSize * 8;

        gp.obj[3] = new OBJ_Key(gp);
        gp.obj[3].worldX = gp.tileSize * 12;
        gp.obj[3].worldY = gp.tileSize * 31;

        gp.obj[4] = new OBJ_Boots(gp);
        gp.obj[4].worldX = gp.tileSize * 12;
        gp.obj[4].worldY = gp.tileSize * 27;

        gp.obj[5] = new OBJ_Heart(gp);
        gp.obj[5].worldX = gp.tileSize * 32;
        gp.obj[5].worldY = gp.tileSize * 27;

        gp.obj[6] = new OBJ_Heart(gp);
        gp.obj[6].worldX = gp.tileSize * 29;
        gp.obj[6].worldY = gp.tileSize * 3;

        gp.obj[7] = new OBJ_Key(gp);
        gp.obj[7].worldX = gp.tileSize * 31;
        gp.obj[7].worldY = gp.tileSize * 3;

    }
    public void setNPC() {

        gp.npc[0] = new NPC_Dog(gp);
        gp.npc[0].worldX = gp.tileSize;
        gp.npc[0].worldY = gp.tileSize * 45;

    }
    public void setMonster() {
        gp.monster[0] = new MON_EvilDog(gp);
        gp.monster[0].worldX = gp.tileSize;
        gp.monster[0].worldY = gp.tileSize * 44;

        gp.monster[1] = new MON_EvilDog(gp);
        gp.monster[1].worldX = gp.tileSize * 9;
        gp.monster[1].worldY = gp.tileSize * 45;

        gp.monster[2] = new MON_EvilDog(gp);
        gp.monster[2].worldX = gp.tileSize * 11;
        gp.monster[2].worldY = gp.tileSize * 38;

        gp.monster[3] = new MON_EvilDog(gp);
        gp.monster[3].worldX = gp.tileSize * 41;
        gp.monster[3].worldY = gp.tileSize * 18;

        gp.monster[4] = new MON_EvilDog(gp);
        gp.monster[4].worldX = gp.tileSize * 13;
        gp.monster[4].worldY = gp.tileSize * 43;

        gp.monster[5] = new MON_EvilDog(gp);
        gp.monster[5].worldX = gp.tileSize * 24;
        gp.monster[5].worldY = gp.tileSize * 44;

        gp.monster[6] = new MON_EvilDog(gp);
        gp.monster[6].worldX = gp.tileSize * 29;
        gp.monster[6].worldY = gp.tileSize * 43;

        gp.monster[7] = new MON_EvilDog(gp);
        gp.monster[7].worldX = gp.tileSize * 45;
        gp.monster[7].worldY = gp.tileSize * 41;

        gp.monster[8] = new MON_EvilDog(gp);
        gp.monster[8].worldX = gp.tileSize * 46;
        gp.monster[8].worldY = gp.tileSize * 29;

        gp.monster[9] = new MON_EvilDog(gp);
        gp.monster[9].worldX = gp.tileSize * 36;
        gp.monster[9].worldY = gp.tileSize * 30;

        gp.monster[10] = new MON_EvilDog(gp);
        gp.monster[10].worldX = gp.tileSize * 32;
        gp.monster[10].worldY = gp.tileSize * 28;

        gp.monster[11] = new MON_EvilDog(gp);
        gp.monster[11].worldX = gp.tileSize * 21;
        gp.monster[11].worldY = gp.tileSize * 38;

        gp.monster[12] = new MON_EvilDog(gp);
        gp.monster[12].worldX = gp.tileSize * 15;
        gp.monster[12].worldY = gp.tileSize * 13;

        gp.monster[13] = new MON_EvilDog(gp);
        gp.monster[13].worldX = gp.tileSize * 12;
        gp.monster[13].worldY = gp.tileSize * 6;

        gp.monster[14] = new MON_EvilDog(gp);
        gp.monster[14].worldX = gp.tileSize * 9;
        gp.monster[14].worldY = gp.tileSize * 6;

        gp.monster[15] = new MON_EvilDog(gp);
        gp.monster[15].worldX = gp.tileSize * 28;
        gp.monster[15].worldY = gp.tileSize;

        gp.monster[16] = new MON_EvilDog(gp);
        gp.monster[16].worldX = gp.tileSize * 31;
        gp.monster[16].worldY = gp.tileSize;

        gp.monster[17] = new MON_EvilDog(gp);
        gp.monster[17].worldX = gp.tileSize * 25;
        gp.monster[17].worldY = gp.tileSize * 27;

        gp.monster[18] = new MON_EvilDog(gp);
        gp.monster[18].worldX = gp.tileSize * 47;
        gp.monster[18].worldY = gp.tileSize * 25;

        gp.monster[19] = new MON_EvilDog(gp);
        gp.monster[19].worldX = gp.tileSize * 6;
        gp.monster[19].worldY = gp.tileSize * 26;

        gp.monster[20] = new MON_EvilDog(gp);
        gp.monster[20].worldX = gp.tileSize * 5;
        gp.monster[20].worldY = gp.tileSize * 26;

    }
}
