package formation;

import creature.Creature;
import java.util.List;

public class FengShiFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp) {
        if(temp==true) {
            cre.get(0).setLocation(6,6+2);
            cre.get(1).setLocation(4,6+2);
            cre.get(2).setLocation(2,6+2);
            cre.get(3).setLocation(0,6+2);
            cre.get(4).setLocation(5,5+2);
            cre.get(5).setLocation(4,4+2);
            cre.get(6).setLocation(5,7+2);
            cre.get(7).setLocation(4,8+2);
        }else {
            cre.get(0).setLocation(13,6+2);
            cre.get(1).setLocation(15,6+2);
            cre.get(2).setLocation(17,6+2);
            cre.get(3).setLocation(18,6+2);
            cre.get(4).setLocation(14,5+2);
            cre.get(5).setLocation(15,4+2);
            cre.get(6).setLocation(14,7+2);
            cre.get(7).setLocation(15,8+2);
        }

    }
}
