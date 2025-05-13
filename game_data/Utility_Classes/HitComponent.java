package game_data.Utility_Classes;

//This is a helper class created in case certain damage splits scale off of different stats. Hypothetical Ex. Blade Follow-up 1st split
//scales off HP and 2nd split scales off ATK.

import game_data.Utility_Classes.Enums.StatTypes;
import game_data.Utility_Classes.Enums.TargetBehaviors;

import java.io.Serializable;

public class HitComponent implements Serializable {
    private float splitRatio;
    private StatTypes statType;
    private TargetBehaviors targetBehavior;
    private int numOfHits;

    //Single-Hit Constructor
    public HitComponent(StatTypes statType, float splitRatio, TargetBehaviors targetBehavior) {
        this.statType = statType;
        this.splitRatio = splitRatio;
        this.targetBehavior = TargetBehaviors.SINGLEATK;
        this.numOfHits = 1;
    }

    //Multi-Hit Constructor
    public HitComponent(StatTypes statType, float splitRatio, TargetBehaviors targetBehavior, int numOfHits) {
        this.statType = statType;
        this.splitRatio = splitRatio;
        this.targetBehavior = targetBehavior;
        this.numOfHits = numOfHits;
    }

    //Getters
    public StatTypes getStatType() {return statType;}
    public float getSplitRatio() {return splitRatio;}
    public TargetBehaviors getTargetBehavior() {return targetBehavior;}
    public int getNumOfHits() {return numOfHits;}

    public String toString(){
        return String.format("Stat Type: %s, Target Behavior: %s, Split Ratio: %0.2f, Total Hits: %d", statType.toString(), targetBehavior.toString(), getSplitRatio(), getNumOfHits());
    }
}
