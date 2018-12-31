package creature;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import map.*;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
public abstract class Creature implements Runnable
{
    protected String name;
    protected int x;
    protected int y;
    public static int GoodOne = 8;
    public static int BadOne = 8;
    protected boolean alive = true;
    protected boolean side;
    protected int width;
    protected int height;
    protected Image image;
    protected int blood;
    protected int attack;
    protected boolean doubleattack;
    protected Direction dr;
    public Creature () {
        height = 40;
        width =40;
        doubleattack = true;
    }
    public Creature(String name,int x,int y,boolean side)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        setSide(side);
        width = 40;
        height = 40;
    }

    public void setImage(Image image){this.image = image;}
    public void setName(String name){this.name = name;}
    public void setAlive(boolean temp){this.alive = temp;}
    public boolean getisAlive(){return alive;}
    public void draw(GraphicsContext gContext) {
        if (image != null) {
            gContext.drawImage(image, x*width, y*height,width,height);
        }
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int x){this.x =  x;}
    public void setY(int y){this.y =  y;}
    public int getBlood(){return blood;}
    synchronized public void setLocation(int x,int y) {
        GameMap.setPoint(x, y);
        GameMap.removePoint(this.getX(), this.getY());
        this.setX(x);
        this.setY(y);
    }
    public void setBlood(int blood) {this.blood = blood; }
    public int getAttack(){return this.attack;}
    public void setDoubleAttack(boolean temp){this.doubleattack = temp;}
    synchronized public static void decGoodOne(){--GoodOne;}
    synchronized public static void decBadOne(){--BadOne;}
    synchronized public static int getGoodNum(){return GoodOne;}
    synchronized public static int getBadNum(){return BadOne;}
    public void move(int x,int y) throws Exception{}
    public void run(){}
    public String getName(){return this.name;}
    public void setSide(boolean side){this.side = side;}
    public void setDirection(Direction dir){this.dr = dir;}
    public Direction getDr(){return this.dr;}

}

