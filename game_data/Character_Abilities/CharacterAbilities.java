package game_data.Character_Abilities;

import game_data.Utility_Classes.Enums.AbilityTypes;
import game_data.Utility_Classes.HitComponent;
import game_data.Utility_Classes.Enums.TargetBehaviors;
import game_data.Utility_Classes.Enums.ElementTypes;

import java.util.List;

public abstract class CharacterAbilities {
    private int id; //character Id + 0 + (1 = Basic | 2 = Skill | 3 = Ultimate | 4 = Talent | 5 = Technique) Ex. 106101 = 1061 The Herta, 01 = Basic
    private AbilityTypes abilityType; // BASIC | SKILL | ULTIMATE | TALENT | TECHNIQUE
    private String name;
    private ElementTypes element; // refer to Utility_Classes.ElementTypes Enum File
    private TargetBehaviors targetBehavior; // refer to TargetBehaviors Utility_Classes.Enum File
    private List<HitComponent> hitComponents; // List of damage splits or multiple instances of damage. Refer to Utility_Classes.HitComponent
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
    public AbilityTypes getAbilityType() {return abilityType;}
    public String getName() {return name;}
    public ElementTypes getElementType() {return element;}
    public TargetBehaviors getTargetBehavior() {return targetBehavior;}
    public List<HitComponent> getHitComponents() {return hitComponents;} //Returns num of hitComponents
    public int getMaxUnitsAffected() {return maxUnitsAffected;}
    public int getNumOfHitsTot() {return hitComponents.stream().mapToInt(HitComponent::getNumOfHits).sum();}
    //returns total number of hits by streaming through HitComponent.getNumOfHits for each object and returns the sum

    //prints ability information by using formatting
    public String toString() {
        return String.format("%s ID: %d%nAbility Type: %s%nElement: %s%nDamage Behavior: %s%nDamage Splits: %s%nTotal Hits: %d%nUnits Affected: %d", name, id, abilityType.toString(), element, getTargetBehavior(), getHitComponents(), getNumOfHitsTot(), maxUnitsAffected);
    }
}
