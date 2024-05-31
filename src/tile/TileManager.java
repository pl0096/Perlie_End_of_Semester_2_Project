package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[50]; // the number of tiles that will be created
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/tilemap.txt");
    }
    
    public void getTileImage(){

        //placeholder
        setup(0, "tile00", false);
        setup(1, "tile01", false);
        setup(2, "tile02", false);
        setup(3, "tile03", true);
        setup(4, "tile04", true);
        setup(5, "tile05", false);
        setup(6, "tile06", true);
        setup(7, "tile07", true);
        setup(8, "tile08", true);
        setup(9, "tile09", true);
        setup(10, "tile10", true);
        setup(11, "tile11", true);
        setup(12, "tile12", true);
        setup(13, "tile13", true);
        setup(14, "tile14", true);
        setup(15, "tile15", false);
        setup(16, "tile16", false);
        setup(17, "tile17", false);
        setup(18, "tile18", false);
        setup(19, "tile19", false);
        setup(20, "tile20", false);
        setup(21, "tile21", false);
        setup(22, "tile22", false);
        setup(23, "tile23", false);
        setup(24, "tile24", false);
        setup(25, "tile25", true);
        setup(26, "tile26", true);
        setup(27, "tile27", true);
        setup(28, "tile28", true);


    }

    public void setup(int index, String imageName, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int imageNum = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = imageNum;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch(Exception e){

        }
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {


                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }

    }
}
