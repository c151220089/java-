package board;
import creature.*;
import map.*;
import javafx.application.Platform;
import javafx.scene.image.Image;
import java.util.*;
public class Board {
    private Creature []g = new Creature[8];
    private Creature []b = new Creature[8];
    private MapCanvas mapCanvas;
    private boolean isRunning	= true;
    private ArrayList<Creature> good = new ArrayList<>();
    private ArrayList<Creature>	bad	= new ArrayList<>();
    public Board() {
        mapCanvas = new MapCanvas( 8000, 600 );
        String []name1 = {"老大","老二","老三","老四","老五","老六","老七","爷爷"};
        for ( int i = 0; i < g.length; i++ ) {
            if(i < g.length -1)
                g[i] = new HuLuWa();
            else
                g[i] = new GranPa();
            g[i].setName(name1[i]);
            Image image = new Image( getClass().getResourceAsStream( "/picture/" + g[i].getName() + ".png" ) );
            g[i].setImage( image );
        }
        for ( Creature calabash : g ) {
            good.add( calabash );
        }
        String []name2 = {"啰啰1","啰啰2","啰啰3","啰啰4","啰啰5","啰啰6","蝎子精","蛇精"};
        for ( int i = 0; i < b.length; i++ ) {
            if(i < b.length -2)
                b[i] = new LuoLuo();
            else
                b[i] = new SnakeXieZi();
            b[i].setName(name2[i]);
            Image image = new Image( getClass().getResourceAsStream( "/picture/" + b[i].getName()+ ".png" ) );
            b[i].setImage( image );
        }
        for ( Creature calabash : b ) {
            bad.add( calabash );
        }

        thread.start();
    }
    public ArrayList<Creature> getGoodCreature(){return good;}
    public ArrayList<Creature> getBadCreature(){return bad;}
    public MapCanvas getMapCanvas() {
        return mapCanvas;
    }
    public int distance(Creature t1,Creature t2)
    {
        return Math.abs(t1.getX()-t2.getX())+Math.abs(t1.getY()-t2.getY());
    }
    public int xDistantce(Creature t1,Creature t2)
    {
        return Math.abs(t1.getX()-t2.getX());
    }

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isRunning) {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        drawMap();
                        drawPlayer();
                    }
                });
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public void drawMap() {
        mapCanvas.getGameMap().drawMap(mapCanvas.getgContext());
    }
    public void drawPlayer() {
        for ( Creature player : g ) {
            if ( player.getisAlive() == false )
                player.draw( mapCanvas.getgContext() );
        }
        for ( Creature enemy : b ) {
            if ( enemy.getisAlive() == false )
                enemy.draw( mapCanvas.getgContext() );
        }
        for ( Creature player : g ) {
            if ( player.getisAlive() == true )
                player.draw( mapCanvas.getgContext() );
        }
        for ( Creature enemy : b) {
            if ( enemy.getisAlive() == true )
                enemy.draw( mapCanvas.getgContext() );
        }
    }
    public void initCreatureThread() {
        for ( Creature bsp : b) {
            Thread thread1 = new Thread( bsp );
            thread1.start();
        }
        for ( Creature bsp : g ) {
            Thread thread1 = new Thread( bsp );
            thread1.start();
        }
    }
    public boolean isBadOneAllDie(){
        for(Creature cre: b)
            if(cre.getisAlive() == true)
                return false;
        return true;
    }
    public boolean isGoodOneAllDie(){
        for(Creature cre: g)
            if(cre.getisAlive() == true)
                return false;
        return true;
    }
}

