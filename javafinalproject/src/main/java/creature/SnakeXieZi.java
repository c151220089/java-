package creature;


import javafx.scene.image.Image;

public class SnakeXieZi extends BadCreature implements  Runnable{
    public SnakeXieZi () {
        super();
        blood = 20;
        attack = 3;
    }
    public SnakeXieZi(String name,int x,int y,Boolean side)
    {

        super(name,x,y,side);
        image = new Image(getClass().getResourceAsStream("/source/Monster" + name + ".png"));
        blood = 20;
        attack = 3;
    }


}
