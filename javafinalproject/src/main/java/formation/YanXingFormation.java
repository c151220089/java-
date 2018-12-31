package formation;

import creature.Creature;

import java.util.List;

public class YanXingFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp) {
        if(temp==true) {
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(8-i,3+i+2);
            }
        }else {
            for(int i=0;i<cre.size();i++) {
                cre.get(i).setLocation(11+i,3+i+2);
            }
        }

    }
}
