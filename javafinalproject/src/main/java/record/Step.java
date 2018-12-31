package record;
import creature.*;
public class Step {
    private Creature cre;
    private int xBegin;
    private int yBegin;
    private int xEnd;
    private int yEnd;
    private int sort;
    private boolean die;
    public Step(Creature c){
        this.cre = c;
        setSort(Record.time++);
    }
    public Step(Creature c,int xb,int yb,int xe,int ye)
    {
        this.cre = c;
        setXBegin(xb);
        setYBegin(yb);
        setXEnd(xe);
        setYEnd(ye);
        setSort(Record.time++);
        setDie(false);
    }

    public Step(Creature c,int xe,int ye,boolean temp)
    {
        this.cre = c;
        setXEnd(xe);
        setYEnd(ye);
        setSort(Record.time++);
        setDie(temp);
    }

    @Override
    public String toString(){
        String str =" "+getSort()+" "+getCre().getName()+" "+((getDie()==false)?("move"+" "+getXbegin()+" "+getYbegin()+" "+getXend()+" "+getYend()):
                ("die"+" "+getXend()+" "+getYend()))+"\n";
        return str;
    }
    public int getXbegin(){return this.xBegin;}
    public int getYbegin(){return this.yBegin;}
    public int getXend(){return this.xEnd;}
    public int getYend(){return this.yEnd;}
    public void setXBegin(int x){this.xBegin = x;}
    public void setYBegin(int y){this.yBegin = y;}
    public void setXEnd(int x){this.xEnd = x;}
    public void setYEnd(int y){this.yEnd = y;}
    public int getSort(){return  this.sort;}
    public void setSort(int sort){this.sort = sort;}
    public void setDie(boolean temp){this.die = temp;}
    public boolean getDie(){return this.die;}
    public Creature getCre() {
        return cre;
    }
}
