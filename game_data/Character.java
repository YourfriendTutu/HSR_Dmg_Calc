package game_data;

public class Character {
    private String path;
    private String element;
    private int rarity;
    private Entity base;

    //Current Paths as of HSR V3.2
    private static final String[] pathsList =
            {"Destruction", "Hunt", "Erudition", "Harmony", "Nihility", "Preservation", "Abundance", "Remembrance"};

    //game_data.Character Constructor
    public Character(String path, String element, int rarity, Entity base) {
        this.path = path;
        this.element = element;
        this.rarity = rarity;
        this.base = base;
    }

    //Derek: Might be redundant since we're going to code the characters but we allow users to create their own characters then this method might have uses.
    //Method Checks if Path is valid.
    public boolean validPath(String[] array, String path) {
        boolean validPath = false;
        for (int i = 0; i < 8; ++i) {
            if (path == array[i]) {
                    validPath = true;
                    break;
            }
        }
        return validPath;
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
