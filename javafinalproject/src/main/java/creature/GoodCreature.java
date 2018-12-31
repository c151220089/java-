package creature;

import javafx.scene.image.Image;
import map.GameMap;
import main.Main;
import record.*;

public abstract class GoodCreature extends Creature implements Runnable {
    public GoodCreature() {
        setSide(true);
        height = 40;
        width = 40;
        this.setDirection(Direction.Right);
    }

    public GoodCreature(String name, int x, int y, Boolean side) {
        super(name, x, y, side);
        image = new Image(getClass().getResourceAsStream("/picture/p" + name + ".png"));
        this.setDirection(Direction.Right);
    }

    public void run() {

        while (alive == true && (GoodOne * BadOne > 0 || !Main.getBoard().isBadOneAllDie())) {
            try {
                if (kill(this) == false) {
                    boolean tempmove = false;
                    int ram = (int) (Math.random() * 100);
                    for (Creature badone : Main.getBoard().getBadCreature())
                        if (badone.getisAlive() && Main.getBoard().xDistantce(this, badone) <= 1) {
                            if ((ram <= 50 && this.getY() > 3) || (ram > 50 && this.getY() == 14)) {
                                move(this.getX(), this.getY()-1);
                                tempmove = true;
                            } else if ((ram <= 50 && this.getY() == 3) || (ram > 50 && this.getY() < 14)) {
                                move(this.getX(), this.getY()+1);
                                tempmove = true;
                            }
                        }
                    if(tempmove == false) {
                        if ( getDr() == Direction.Right) {
                            if (GameMap.getGameMapPoint(this.getX() + 1, this.getY()) == 0) {
                                move(this.getX()+1, this.getY());
                                setDirection(Direction.Right);
                            }
                        } else {

                            if (GameMap.getGameMapPoint(this.getX() + 1, this.getY()) == 0) {
                                move(this.getX()+1, this.getY());
                                setDirection(Direction.Left);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                //System.out.println("位置已被同伴占领，停止移动");
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean kill(Creature c1) {
        for (Creature badone : Main.getBoard().getBadCreature())
            if (badone.alive == true && Main.getBoard().distance(c1, badone) <= 1) {
                int attack = (this.doubleattack==true)?(this.getAttack()*2):this.getAttack();
                this.setDoubleAttack(false);
                badone.setBlood(badone.getBlood()-attack);
                if(badone.getBlood()<=0) {
                    badone.setAlive(false);
                    System.out.println("妖怪数量减一,妖怪剩余数量："+(BadOne-1));
                    Creature.decBadOne();
                    GameMap.removePoint(badone.getX(), badone.getY());
                    badone.setImage(new Image(getClass().getResourceAsStream("/picture/die.png")));
                    Step st = new Step(badone,badone.getX(),badone.getY(),true);
                    Main.getRecord().getSt().add(st);
                    if(Creature.getBadNum() == 0 || Main.getBoard().isBadOneAllDie())
                    {
                        System.out.println("葫芦娃阵营胜利");
                        Main.getRecord().writeRocord();

                    }
                    try {
                        move(badone.getX(), badone.getY());

                    } catch (Exception e) {
                        System.out.println("");
                    } finally {
                        return true;
                    }
                }
                else
                    return true;
            }

        return false;
    }

    public void move(int x, int y) throws Exception {
        //if (kill(c1) == true)
        synchronized (this) {
            //if(this.c[c1.y][c1.x+1] != null)
            //System.out.println("已有人占据此位置，无法移动");
            //else {
            //System.out.println("可以移动");
            //this.c[c1.first_y][c1.first_y]=null;
            //this.c[c1.y][c1.x] = null;
            if (x >= 0 && x < 20 && y >= 0 && y < 15 && GameMap.getGameMapPoint(x, y) == 0) {
                //System.out.println(x+","+y+":"+ GameMap.getGameMapPoint(x, y));
                Step st = new Step(this,this.getX(),this.getY(),x,y);
                Main.getRecord().getSt().add(st);
                this.setLocation(x, y);
            } else
                throw new Exception();


        }
    }
}
