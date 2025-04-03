public class Entity {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private float spd;

    public Entity(String name) {
        this(name, 0, 0, 0, 0);
    }
    public Entity(String name, int hp, int atk, int def, float spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

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
    public float getSPD() {
        return spd;
    }

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
    public void setSPD(float spd) {
        this.spd = spd;
    }

    public String toString() {
        return String.format("Name: %s\nHP: %d\nATK: %d\nDEF: %d\nSPD: %.2f", name, hp, atk, def, spd);
    }
}
