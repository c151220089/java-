package creature;

import javafx.scene.image.Image;

public class GranPa extends GoodCreature implements Runnable{
    public GranPa () {
        this.side = true;
        height = 40;
        width =40;
        blood = 2;
        attack = 1;
    }
    public GranPa(String name,int x,int y,Boolean side)
    {
        super(name,x,y,side);
        image = new Image(getClass().getResourceAsStream("/source/c"+name+".png"));
        blood = 2;
        attack = 1;
    }




}

