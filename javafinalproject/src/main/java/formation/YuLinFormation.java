package formation;

import java.util.*;
import creature.*;
public class YuLinFormation {
    public static void setFormation (List<? extends Creature> cre,boolean temp) {
        if(temp==true) {
            cre.get(0).setLocation(4,7+2);
            cre.get(1).setLocation(5,7+2);
            cre.get(2).setLocation(4,8+2);
            cre.get(3).setLocation(4,6+2);
            cre.get(4).setLocation(6,6+2);
            cre.get(5).setLocation(5,5+2);
            cre.get(6).setLocation(4,4+2);
            cre.get(7).setLocation(3,7+2);
        }else {
            cre.get(0).setLocation(14,7+2);
            cre.get(1).setLocation(13,7+2);
            cre.get(2).setLocation(14,8+2);
            cre.get(3).setLocation(14,6+2);
            cre.get(4).setLocation(12,6+2);
            cre.get(5).setLocation(13,5+2);
            cre.get(6).setLocation(14,4+2);
            cre.get(7).setLocation(15,7+2);
        }

    }
}
