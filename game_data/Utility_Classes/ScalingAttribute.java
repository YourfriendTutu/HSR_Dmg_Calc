package game_data.Utility_Classes;

public class ScalingAttribute {
    private String Attribute; //Character stats like HP, Atk, Def, etc.
    private float multiplier; //Skill multiplier

    public ScalingAttribute(String attribute, float multiplier) {
        this.Attribute = attribute;
        this.multiplier = multiplier;
    }

    public String getAttribute() {return Attribute;}
    public float getMultiplier() {return multiplier;}
}
