package formation;

import creature.Creature;
import java.util.List;

public class FangMenFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp){
        if(temp==true) {
            cre.get(0).setLocation(6,6+2);
            cre.get(1).setLocation(5,5+2);
            cre.get(2).setLocation(4,4+2);
            cre.get(3).setLocation(3,5+2);
            cre.get(4).setLocation(2,6+2);
            cre.get(5).setLocation(3,7+2);
            cre.get(6).setLocation(4,8+2);
            cre.get(7).setLocation(5,7+2);
        }else {
            cre.get(0).setLocation(13,6+2);
            cre.get(1).setLocation(14,5+2);
            cre.get(2).setLocation(15,4+2);
            cre.get(3).setLocation(16,5+2);
            cre.get(4).setLocation(17,6+2);
            cre.get(5).setLocation(16,7+2);
            cre.get(6).setLocation(15,8+2);
            cre.get(7).setLocation(14,7+2);
        }

    }
}
