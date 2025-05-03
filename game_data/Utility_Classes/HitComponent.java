package game_data.Utility_Classes;

//This is a helper class created in case certain damage splits scale off of different stats. Hypothetical Ex. Blade Follow-up 1st split
//scales off HP and 2nd split scales off ATK.

import game_data.Utility_Classes.Enums.StatTypes;
import game_data.Utility_Classes.Enums.TargetBehaviors;

public class HitComponent {
    private float splitRatio;
    private StatTypes statType;
    private TargetBehaviors targetBehavior;

    public HitComponent(StatTypes statType, float splitRatio, TargetBehaviors targetBehavior) {
        this.statType = statType;
        this.splitRatio = splitRatio;
        this.targetBehavior = TargetBehaviors.SINGLEATK;
    }

    public String getStatType() {return statType.toString();}
    public float getSplitRatio() {return splitRatio;}
    public TargetBehaviors getTargetBehavior() {return targetBehavior;}

    public String toString(){
        return String.format("Stat Type: %s, Target Behavior: %s, Split Ratio: %0.2f", getStatType(), targetBehavior.toString(), getSplitRatio());
    }
}
