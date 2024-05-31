package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp){
        super(gp);

        name = "Heart";

        image2 = setup("/object/object5");
        image3 = setup("/object/object6");
        image = setup("/object/object4");


    }
}
