public class Character {
    private String path;
    private String element;
    private int rarity;
    private Entity base;

    private static final String[] pathsList =
            {"Destruction", "Hunt", "Erudition", "Harmony", "Nihility", "Preservation", "Abundance", "Remembrance"};

    public Character(String path, String element, int rarity, Entity base) {
        this.path = path;
        this.element = element;
        this.rarity = rarity;
        this.base = base;
    }

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

    public String getPath() {
        return path;
    }
    public String getElement() {
        return element;
    }
    public int getRarity() {
        return rarity;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public String toString() {
        return String.format("Path: %s\nElement: %s\nRarity: %d*\n", path, element, rarity);
    }
}
