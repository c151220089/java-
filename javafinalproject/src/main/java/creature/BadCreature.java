package creature;


import javafx.scene.image.Image;
import map.GameMap;
import record.Step;
import main.Main;
import board.*;

public abstract class BadCreature extends Creature implements Runnable{

    public BadCreature () {
        setSide(false);
        height = 40;
        width =40;
        this.setDirection(Direction.Left);
    }
    public BadCreature(String name,int x,int y,Boolean side)
    {

        super(name,x,y,side);
        image = new Image(getClass().getResourceAsStream("/picture/p" + name + ".png"));
        this.setDirection(Direction.Left);

    }

    public void run()
    {

        //System.out.println("time:"+time);
        while(alive == true && (GoodOne * BadOne > 0 || !Main.getBoard().isGoodOneAllDie()))
        {
            try {
                if (kill(this) == false) {
                    boolean tempmove = false;
                    int ram = (int) (Math.random() * 100);
                    for (Creature goodone : Main.getBoard().getGoodCreature()) {
                        if (goodone.getisAlive() && Main.getBoard().xDistantce(this, goodone) <= 1) {
                            if ((ram <= 50 && this.getY() > 3) || (ram > 50 && this.getY() >= 12)) {
                                move(this.getX(), this.getY()-1);
                            } else if ((ram <= 50 && this.getY() <= 3) || (ram > 50 && this.getY() < 12)) {
                                move(this.getX(), this.getY()+1);
                            } else if (this.getY() < 12) {
                                move(this.getX(), this.getY()+1);
                            } else {
                                move(this.getX(), this.getY()-1);
                            }
                            tempmove = true;
                        }
                    }
                    if (tempmove == false) {
                        if (getDr() == Direction.Left) {
                            if (GameMap.getGameMapPoint(this.getX() - 1, this.getY()) == 0) {
                                move(this.getX()-1, this.getY());
                                setDirection(Direction.Left);
                            }
                        } else {
                            if (GameMap.getGameMapPoint(this.getX() + 1, this.getY()) == 0) {
                                move(this.getX()+1, this.getY());
                                setDirection(Direction.Right);
                            }
                        }

                    }
                }
            }
            catch (Exception e)
            {
                //System.out.println("");
            }

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean kill(Creature c1)
    {
        for(Creature goodone: Main.getBoard().getGoodCreature()) {
            if (goodone.alive == true && Main.getBoard().distance(c1, goodone) <= 1) {
                int attack = (this.doubleattack==true)?(this.getAttack()*2):this.getAttack();
                this.setDoubleAttack(false);
                goodone.setBlood(goodone.getBlood()-attack);
                if(goodone.getBlood()<=0) {
                    goodone.setAlive(false);
                    System.out.println("葫芦娃数量减一,葫芦娃剩余数量："+(GoodOne-1));
                    Creature.decGoodOne();
                    GameMap.removePoint(goodone.getX(), goodone.getY());
                    goodone.setImage(new Image(getClass().getResourceAsStream("/picture/die.png")));
                    Step st = new Step(goodone,goodone.getX(),goodone.getY(),true);
                    Main.getRecord().getSt().add(st);
                    if(Creature.getGoodNum() == 0|| Main.getBoard().isGoodOneAllDie())
                    {
                        System.out.println("妖怪阵营胜利");
                        Main.getRecord().writeRocord();
                    }
                    try {
                        move(goodone.getX(), goodone.getY());

                    } catch (Exception e) {
                        System.out.println("");
                    } finally {
                        return true;
                    }
                }
                else
                    return true;
            }
        }
        return false;
    }

    public void move(int x,int y) throws Exception
    {
        //if (kill(c1) == true)
        synchronized (this) {
            //if(this.c[c1.y][c1.x+1] != null)
            //System.out.println("已有人占据此位置，无法移动");
            //else {
            //System.out.println("可以移动");
            if((x >= 0 && x < 20) && (y>=0 && y <15) && GameMap.getGameMapPoint(x,y) == 0) {
                Step st = new Step(this,this.getX(),this.getY(),x,y);
                Main.getRecord().getSt().add(st);
                this.setLocation(x,y);
            }
            else
                throw new Exception();


        }
    }
}
