package formation;

import creature.Creature;
import java.util.List;

public class HengEFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp) {
        if(temp==true) {
            cre.get(0).setLocation(6,3+2);
            cre.get(1).setLocation(6,5+2);
            cre.get(2).setLocation(6,7+2);
            cre.get(3).setLocation(6,9+2);
            cre.get(4).setLocation(5,4+2);
            cre.get(5).setLocation(5,6+2);
            cre.get(6).setLocation(5,8+2);
            cre.get(7).setLocation(5,10+2);
        }else {
            cre.get(0).setLocation(13,3+2);
            cre.get(1).setLocation(13,5+2);
            cre.get(2).setLocation(13,7+2);
            cre.get(3).setLocation(13,9+2);
            cre.get(4).setLocation(14,4+2);
            cre.get(5).setLocation(14,6+2);
            cre.get(6).setLocation(14,8+2);
            cre.get(7).setLocation(14,10+2);
        }

    }
}
