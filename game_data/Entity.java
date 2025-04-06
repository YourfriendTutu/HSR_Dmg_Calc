package game_data;

public class Entity {
    //Id allows creating lists to be much easier. For ex. entities with id's between 100-1000 are characters. and 1000-10000 are enemies
    private int id;
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spd;

    //Entity Constructor
    public Entity(String name) {
        this(0, name, 0, 0, 0, 0);
    }
    public Entity(int id, String name, int hp, int atk, int def, int spd) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    //get Methods
    public int getId() {return id;}
    public String getName() {
        return name;
    }
    public int getHP() {
        return hp;
    }
    public int getATK() {
        return atk;
    }
    public int getDEF() {
        return def;
    }
    public int getSPD() {
        return spd;
    }

    //set Methods
    public void setId(int id) {this.id = id;}
    public void setName(String name) {
        this.name = name;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }
    public void setATK(int atk) {
        this.atk = atk;
    }
    public void setDEF(int def) {
        this.def = def;
    }
    public void setSPD(int spd) {
        this.spd = spd;
    }

    //toString for entity variables.
    public String toString() {
        return String.format("Name: %s\nHP: %d\nATK: %d\nDEF: %d\nSPD: %df", name, hp, atk, def, spd);
    }
}
