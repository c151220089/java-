package creature;

import javafx.scene.image.Image;
public class LuoLuo extends BadCreature implements Runnable {
    public LuoLuo () {
        this.side = true;
        height = 40;
        width =40;
        blood = 6;
        attack = 2;
        dr = Direction.Left;
    }
    public LuoLuo(String name,int x,int y,Boolean side)
    {

        super(name,x,y,side);
        image = new Image(getClass().getResourceAsStream("/source/Monster" + name+ ".png"));
        blood = 6;
        attack = 2;
        dr = Direction.Left;
    }

}
