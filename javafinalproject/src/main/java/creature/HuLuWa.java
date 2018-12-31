package creature;

import javafx.scene.image.Image;

public class HuLuWa extends GoodCreature implements Runnable{
    public HuLuWa () {
        this.side = true;
        height = 40;
        width =40;
        blood = 8;
        attack = 3;
    }
    public HuLuWa(String name,int x,int y,Boolean side)
    {
        super(name,x,y,side);
        image = new Image(getClass().getResourceAsStream("/source/c"+name+".png"));
        blood = 8;
        attack = 3;
    }









}
