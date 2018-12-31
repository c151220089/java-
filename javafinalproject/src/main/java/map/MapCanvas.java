package map;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class MapCanvas extends Canvas {
    private GameMap gameMap;
    private GraphicsContext gContext;
    private Image map;

    public MapCanvas(int width, int height) {
        super(width, height);
        map = new Image(getClass().getResourceAsStream("/picture/map.jpg"));
        gContext = getGraphicsContext2D();
        gameMap = new GameMap(map);
    }
    public GraphicsContext getgContext() {
        return gContext;
    }
    public GameMap getGameMap() {
        return gameMap;
    }
}
