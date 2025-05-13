package game_data.Utility_Classes.Enums;

public enum ElementTypes {
    PHYSICAL("Physical"),
    FIRE("Fire"),
    ICE("Ice"),
    LIGHTNING("Lightning"),
    WIND("Wind"),
    QUANTUM("Quantum"),
    IMAGINARY("Imaginary");

    private final String displayName;

    ElementTypes(String displayName) {this.displayName = displayName;}

    @Override
    public String toString() {return displayName;}
}
