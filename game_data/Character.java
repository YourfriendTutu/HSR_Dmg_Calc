package game_data;
import java.util.Arrays;

public class Character {
    private String path;
    private String element;
    private int rarity;
    private Entity base;

    //Current playable Paths as of HSR V3.2
    private static final String[] pathsList =
            {"Destruction", "Hunt", "Erudition", "Harmony", "Nihility", "Preservation", "Abundance", "Remembrance"};

    //Current playable Elements as of HSR V3.2
    private static final String[] elemsList =
            {"Physical", "Fire", "Ice", "Lightning", "Wind", "Quantum", "Imaginary"};

    //game_data.Character Constructor
    public Character(String path, String element, int rarity, Entity base) {
        this.path = path;
        this.element = element;
        this.rarity = rarity;
        this.base = base;
    }

    //Derek: Might be redundant since we're going to code the characters but we allow users to create their own characters then this method might have uses.
    //But it could also be useful to avoid logic errors since this creates compile-time errors.
    //Basically, logic err = program runs but not as intended vs compile-time = program doesn't run and we know something is def. wrong.

    //Check Method if Path is valid.
    public boolean validPath(String[] array, String path) {
        return Arrays.asList(pathsList).contains(path);
//        This just checks if dictionary contains path and returns true or false without needing iterations (for loop). After reading this delete the noted code.
//        boolean validPath = false;
//        for (int i = 0; i < 8; ++i) {
//            if (path.equals(array[i])) {
//                    validPath = true;
//                    break;
//            }
//        }
    }

    //Check Method if Element is valid.
    public boolean validElement(String[] array, String element) {
        return Arrays.asList(elemsList).contains(element);
    }

    //get Methods for Path, Elem, and Rarity
    public String getPath() {
        return path;
    }
    public String getElement() {
        return element;
    }
    public int getRarity() {
        return rarity;
    }

    //set Methods for Path, Elem, and Rarity
    public void setPath(String path) {
        this.path = path;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    //Derek: "Show example use case for this because I'm not sure what this is for(Purpose).
    //toString method for showing Path, Element, and Rarity.
    public String toString() {
        return String.format("Path: %s\nElement: %s\nRarity: %d*\n", path, element, rarity);
    }
}
