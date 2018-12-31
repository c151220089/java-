package map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class GameMap {
    private volatile static int[][] mapIndex = new int[15][20];
    private final int mapImageWidth = 800;
    private final int mapImageHeight = 600;
    private Image img;
    public GameMap(Image map) {
        this.img = map;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 20; j++)
                mapIndex[i][j] = 0;
    }
    synchronized public static int getGameMapPoint(int x, int y) {  return mapIndex[y][x];}
    synchronized public static void removePoint(int x, int y) {  mapIndex[y][x] = 0;  }
    synchronized public static void setPoint(int x, int y) {
        mapIndex[y][x] = 1;
    }
    public void drawMap(GraphicsContext gc) {
        gc.drawImage(img, 0, 0, mapImageWidth, mapImageHeight, 0, 0, 800, 600);
    }
}