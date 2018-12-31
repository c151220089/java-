package main;
import board.*;
import creature.Creature;
import formation.Formation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.util.*;
import formation.*;
import javafx.scene.layout.Pane;
import record.Record;
public class Main extends Application {

    private static Board b;
    private static Record r;
    private static boolean runapply = false;

    void setRunApply(boolean temp) {
        runapply = temp;
    }
    public static Board getBoard() {
        return b;
    }
    public static Record getRecord() {
        return r;
    }
    static public Optional<String> setChoice(boolean temp) {
        List<String> choices = new ArrayList<>();
        choices.add("长蛇阵");
        choices.add("鹤翼阵");
        choices.add("雁行阵");
        choices.add("锋矢阵");
        choices.add("方门阵");
        choices.add("雁月阵");
        choices.add("衡轭阵");
        choices.add("鱼鳞阵");
        String name = (temp == true) ? "葫芦娃" : "妖怪";
        ChoiceDialog<String> dialog = new ChoiceDialog<>("长蛇阵", choices);
        dialog.setTitle("请选择" + name + "葫芦娃阵营的布阵");
        dialog.setHeaderText(name + "阵营总共8种阵型可供选择");
        dialog.setContentText("请选择:");
        Optional<String> result = dialog.showAndWait();
        return result;
    }

    static public void comfirmChoice(Optional<String> result, boolean temp) {
        ArrayList<Creature> ctemp = (temp == true) ? (b.getGoodCreature()) : (b.getBadCreature());
        String choice = result.toString();
        if (choice.equals("Optional[长蛇阵]")){  new Formation().setFormation(ctemp, Type.ChangShe,temp);
        } else if (choice.equals("Optional[鹤翼阵]")){   new Formation().setFormation(ctemp, Type.HeYi,temp);
        } else if (choice.equals("Optional[雁行阵]")){   new Formation().setFormation(ctemp, Type.YanXing,temp);
        } else if (choice.equals("Optional[锋矢阵]")){   new Formation().setFormation(ctemp, Type.FengShi,temp);
        } else if (choice.equals("Optional[方门阵]")){   new Formation().setFormation(ctemp, Type.FangMen,temp);
        } else if (choice.equals("Optional[雁月阵]")){   new Formation().setFormation(ctemp, Type.YanYue,temp);
        } else if (choice.equals("Optional[衡轭阵]")){   new Formation().setFormation(ctemp, Type.HengE,temp);
        } else if (choice.equals("Optional[鱼鳞阵]")){   new Formation().setFormation(ctemp,Type.YuLin, temp);
        }

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        b = new Board();
        r = new Record();
        Optional<String> resultTrue = setChoice(true);
        Optional<String> resultFalse = setChoice(false);
        comfirmChoice(resultTrue,true);
        comfirmChoice(resultFalse,false);

        root.getChildren().add(b.getMapCanvas());
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("葫芦娃大战妖精");
        primaryStage.setScene(scene);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.SPACE) && !runapply ) {
                    setRunApply(true);
                    b.initCreatureThread();
                }
            }
        });
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
                launch(args);
    }
}
