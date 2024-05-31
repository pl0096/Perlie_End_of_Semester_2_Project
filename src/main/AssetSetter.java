package main;

import entity.NPC_Dog;
import monster.MON_EvilDog;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject() {




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


    }
}
