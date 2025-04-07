package game_data;

public class Entity {
    //Id allows creating lists to be much easier. For ex. entities with id's between 100-1000 are characters. and 1000-10000 are enemies
    private int id;
    private int level;
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float critRate;

    //Entity Constructor
    public Entity() {this(0,0,"",0,0,0,0,0);}
    public Entity(int id, int level, String name, int hp, int atk, int def) {this(id, level, name, hp, atk, def, 0, 0);}
    public Entity(String name) {
        this(0, 0, name, 0, 0, 0, 0,0);
    }
    public Entity(int id, int level, String name, int hp, int atk, int def, int spd, float critRate) {
        if (id < 0) {throw new IllegalArgumentException("ID cannot be negative.");}
        this.id = id;
        // idea for automatic assignment
        if ((id > 0) && (id < 1000)) {this.level = 80;} //characters and lightcones
        else if (id < 10000) {this.level = 90;} //enemy
        else if (id < 11000) {this.level = 15;} //relics
        // insert validation for checking name exists list
        this.name = name;
        // maybe possible for automatic assignment of base stats depending on... character name or path
        // grabbing value of key from dict
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.critRate = critRate;
    }

    //get Methods
    public int getId() {return id;}
    public int getLevel() {return level;}
    public String getName() {return name;}
    public int getHP() {return hp;}
    public int getATK() {return atk;}
    public int getDEF() {return def;}
    public int getSPD() {return spd;}
    public float getCR() {return critRate;}

    //set Methods
    public void setId(int id) {this.id = id;}
    public void setLevel(int level) {this.level = level;}
    public void setName(String name) {this.name = name;}
    public void setHP(int hp) {this.hp = hp;}
    public void setATK(int atk) {this.atk = atk;}
    public void setDEF(int def) {this.def = def;}
    public void setSPD(int spd) {this.spd = spd;}
    public void setCR(float critRate) {this.critRate = critRate;}

    //toString for entity variables.
    public String toString() {
        return String.format("Name: %s\nHP: %d\nATK: %d\nDEF: %d\nSPD: %d", name, hp, atk, def, spd);
    }
}
