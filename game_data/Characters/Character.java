package game_data.Characters;
import game_data.Utility_Classes.Entity;
import game_data.Lightcones.Lightcone;
import game_data.Utility_Classes.Enums.StatTypes;

import java.util.Arrays;

public class Character extends Entity {
    private String path;
    private String element;
    private int rarity;

    //Current playable Paths as of HSR V3.2
    private static final String[] pathsList =
            {"Destruction", "Hunt", "Erudition", "Harmony", "Nihility", "Preservation", "Abundance", "Remembrance"};

    //Current playable Elements as of HSR V3.2
    private static final String[] elemsList = {"Physical", "Fire", "Ice", "Lightning", "Wind", "Quantum", "Imaginary"};


    //game_data.Character Constructor
    public Character(int id, String name, int hp, int atk, int def, int spd, String path, String element, int rarity) {
        //Made it so cr,cd, bonus & elem are defaulted cause these stats are increased by traces which are conditional.
        super(id, 'C', name, hp, atk, def, spd, 0.05F, 0.5F, 0.0F, 0.0F);
        if (!validPath(pathsList, path)) {throw new IllegalArgumentException("Invalid path.");}
        this.path = path;
        if (!validElement(elemsList, element)) {throw new IllegalArgumentException("Invalid element.");}
        this.element = element;
        if (!(rarity >= 3 && rarity <= 5)) {throw new IllegalArgumentException("Invalid rarity.");}
        this.rarity = rarity;
    }

    //Derek: Might be redundant since we're going to code the characters but we allow users to create their own characters then this method might have uses.
    //But it could also be useful to avoid logic errors since this creates compile-time errors.
    //Basically, logic err = program runs but not as intended vs compile-time = program doesn't run and we know something is def. wrong.

    //Rebecca: Was more thinking to use it as validation in constructor and set, following textbook examples.
    //see additions with throw exceptions

    //Check Method if Path is valid.
    public boolean validPath(String[] array, String path) { return Arrays.asList(pathsList).contains(path); }

    //Check Method if Element is valid.
    public boolean validElement(String[] array, String element) {
        return Arrays.asList(elemsList).contains(element);
    }

    //get Methods for Path, Elem, and Rarity
    public String getPath() {return path;}
    public String getElement() {return element;}
    public int getRarity() {return rarity;}

    //set Methods for Path, Elem, and Rarity
    public void setPath(String path) {
        if (!validPath(pathsList, path)) {throw new IllegalArgumentException("Invalid path.");}
        this.path = path;
    }
    public void setElement(String element) {
        if (!validElement(elemsList, element)) {throw new IllegalArgumentException("Invalid element.");}
        this.element = element;
    }
    public void setRarity(int rarity) {
        if (!(rarity >= 3 && rarity <= 5)) {throw new IllegalArgumentException("Invalid rarity.");}
        this.rarity = rarity;
    }

    //printStars method for displaying rarity in GUI
    public String printStars() {
        int numStars = getRarity();
        return switch (numStars) {
            case 4 -> "****";
            case 5 -> "*****";
            default -> "Error: Invalid rarity.";
        };
    }

    //printStats String method to get into the habit of using enum operations to reduce boilerplate
    //This is mainly just for practice, don't know if this will be used.
    @Override
    public String printStats(){
        return String.format("Character Stats:\n"
        + "Name: %s\n"
        + "Path: %s\n"
        + "Element: %s\n"
        + "HP: %d\n"
        + "ATK: %d\n"
        + "DEF: %d\n"
        + "SPD: %d\n"
        + "CRIT Rate: %f\n"
        + "CRIT Dmg: %f\n"
        , getName(), getPath(), getElement(), getStatValue(StatTypes.HP, Integer.class), getStatValue(StatTypes.ATK, Integer.class),
                getStatValue(StatTypes.DEF, Integer.class), getStatValue(StatTypes.SPD, Integer.class), getStatValue(StatTypes.CRIT_RATE, Float.class),
                getStatValue(StatTypes.CRIT_DMG, Float.class));
    }
    //Derek: Show example use case for this because I'm not sure what this is for(Purpose).
    //Rebecca: Removed in favor of using Entity toString()

    //Equipped Lightcone variable
    private Lightcone equippedLightcone;

    //Get Lightcone Method
    public Lightcone getEquippedLightcone() { return equippedLightcone; }

    //Set Lightcone Method
    public void setEquippedLightcone(Lightcone equippedLightcone) {
        this.equippedLightcone = this.equippedLightcone;
    }



}
