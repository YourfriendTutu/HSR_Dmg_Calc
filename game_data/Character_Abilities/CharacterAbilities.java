package game_data.Character_Abilities;

import game_data.Utility_Classes.Enums.AbilityTypes;
import game_data.Utility_Classes.HitComponent;
import game_data.Utility_Classes.Enums.TargetBehaviors;
import game_data.Utility_Classes.Enums.ElementTypes;

import java.util.List;

public abstract class CharacterAbilities {
    private int id;
    private AbilityTypes abilityType;
    private String name;
    private ElementTypes element;
    private TargetBehaviors targetBehavior;
    private List<HitComponent> hitComponents;
    private int maxUnitsAffected; //Max Units affected for allies is 8 to account for memosprites. For enemies, it's 5

    //Don't want a default constructor for this case

    //Full Constructor
    public CharacterAbilities(int id, AbilityTypes abilityType, String name, ElementTypes element, TargetBehaviors targetBehavior, List<HitComponent> hitComponents, int maxUnitsAffected) {
        this.id = id;
        this.abilityType = abilityType;
        this.name = name;
        this.element = element;
        this.targetBehavior = targetBehavior;
        this.hitComponents = hitComponents;
        this.maxUnitsAffected = maxUnitsAffected;
    }

    //accessor methods
    public int getId() {return id;}
    public String getAbilityType() {return abilityType.toString();}
    public String getName() {return name;}
    public ElementTypes getElementType() {return element;}
    public TargetBehaviors getTargetBehavior() {return targetBehavior;}
    public List<HitComponent> getHitComponents() {return hitComponents;}
    public int getMaxUnitsAffected() {return maxUnitsAffected;}

    public int getNumOfHitComponents() {return hitComponents.size();}

    //prints ability information by using formatting 
    public String toString() {
        return String.format("%s (ID: %d%nAbility Type: %s%nElement: %s%nDamage Behavior: %s%nDamage Splits: %s%nHits: %d)", name, id, getAbilityType(), element, getTargetBehavior(), getHitComponents(), maxUnitsAffected);
    }
}
