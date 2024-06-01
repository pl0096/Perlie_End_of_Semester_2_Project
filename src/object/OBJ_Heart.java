package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp){
        super(gp);

        name = "Heart";

        image2 = setup("/object/object5", gp.tileSize, gp.tileSize);
        image3 = setup("/object/object6", gp.tileSize, gp.tileSize);
        image = setup("/object/object4", gp.tileSize, gp.tileSize);


    }
}
