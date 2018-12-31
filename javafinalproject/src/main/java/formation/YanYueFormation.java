package formation;

import creature.Creature;
import java.util.List;

public class YanYueFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp) {
        if(temp==true) {
            cre.get(0).setLocation(5,8+2);
            cre.get(1).setLocation(6,9+2);
            cre.get(2).setLocation(5,5+2);
            cre.get(3).setLocation(6,4+2);
            cre.get(4).setLocation(4,6+2);
            cre.get(5).setLocation(4,7+2);
            cre.get(6).setLocation(2,7+2);
            cre.get(7).setLocation(2,6+2);
        }else {
            cre.get(0).setLocation(14,8+2);
            cre.get(1).setLocation(13,9+2);
            cre.get(2).setLocation(14,5+2);
            cre.get(3).setLocation(13,4+2);
            cre.get(4).setLocation(15,6+2);
            cre.get(5).setLocation(15,7+2);
            cre.get(6).setLocation(17,7+2);
            cre.get(7).setLocation(17,6+2);
        }

    }
}
