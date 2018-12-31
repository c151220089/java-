package formation;


import creature.Creature;
import java.util.List;

public class HeYiFormation {
    public static void setFormation (List<? extends Creature> cre, boolean temp) {

        if (temp == true) {
            cre.get(0).setLocation(6, 6 + 2);
            cre.get(1).setLocation(6, 7 + 2);
            cre.get(2).setLocation(5, 5 + 2);
            cre.get(3).setLocation(5, 8 + 2);
            cre.get(5).setLocation(4, 9 + 2);
            cre.get(4).setLocation(4, 4 + 2);
            cre.get(6).setLocation(3, 3 + 2);
            cre.get(7).setLocation(3, 10 + 2);
        } else {
            cre.get(0).setLocation(13, 6 + 2);
            cre.get(1).setLocation(13, 7 + 2);
            cre.get(2).setLocation(14, 5 + 2);
            cre.get(3).setLocation(14, 8 + 2);
            cre.get(4).setLocation(15, 4 + 2);
            cre.get(5).setLocation(15, 9 + 2);
            cre.get(6).setLocation(16, 3 + 2);
            cre.get(7).setLocation(16, 10 + 2);


        }
    }
}
