package formation;

import creature.Creature;
import java.util.List;

public class ChangeSheFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp) {
        if(temp==true) {
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(4,i+5);
            }
        }else {
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(15,i+5);
            }
        }


    }
}
