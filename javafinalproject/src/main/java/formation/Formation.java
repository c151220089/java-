package formation;

import java.util.*;
import creature.Creature;

public class Formation {

    public void setFormation (List<? extends Creature> cre,Type tp,boolean temp){
        if(tp == Type.ChangShe)
            ChangeSheFormation.setFormation(cre,temp);
        else if(tp == Type.FangMen)
            FangMenFormation.setFormation(cre,temp);
        if(tp == Type.FengShi)
            FengShiFormation.setFormation(cre,temp);
        if(tp == Type.HengE)
            HengEFormation.setFormation(cre,temp);
        if(tp == Type.HeYi)
            HeYiFormation.setFormation(cre,temp);
        if(tp == Type.YanXing)
            YanXingFormation.setFormation(cre,temp);
        if(tp == Type.YanYue)
            YanYueFormation.setFormation(cre,temp);
        if(tp == Type.YuLin)
            YuLinFormation.setFormation(cre,temp);
    }

}
