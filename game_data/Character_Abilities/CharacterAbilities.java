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
    public CharacterAbilities(int id, String name, String element, List<ScalingAttribute> scalingAttributes) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.scalingAttributes = scalingAttributes;
    }

    //accessor methods
    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getElement() { 
        return element; 
    }
    public List<ScalingAttribute> getScalingAttributes() { 
        return scalingAttributes; 
    }
    public int getNumOfHits() { 
        return numOfHits; 
    }

    //prints ability information by using formatting 
    public String toString() {
        return String.format("%s (ID: %d, Element: %s, Hits: %d, Scaling: %s)", name, id, element, numOfHits, scalingAttributes.toString());
    }
}
