package game_data.Character_Abilities;

import game_data.Utility_Classes.ScalingAttribute;

import java.util.List;

public abstract class CharacterAbilities {
    private int id;
    private String name;
    private String element;
    private List<ScalingAttribute> scalingAttributes;
    private int numOfHits;

    //Don't want a default constructor for this case

    //Constructor
    public Ability(int id, String name, String element, List<ScalingAttribute> scalingAttributes) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.scalingAttributes = scalingAttributes;
    }
}
