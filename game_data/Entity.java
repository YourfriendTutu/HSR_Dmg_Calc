package game_data;

public class Entity {
    //Id allows creating lists to be much easier. For ex. entities with id's between 100-1000 are characters. and 1000-10000 are enemies
    //Two Variable ID system is structured and easy to read, doesnt need parsing, and DB efficient. Good habit for expansion compared to Int only IDs.
    private int id;
    private char category;
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float cr;
    private float cd;
    private float bonusDmg;
    private float elemRes;

    //Entity Constructor
    public Entity() {this(0, 'x', "",0,0,0,0,0.05F,0.5F,0.0F,0.2F);}
    public Entity(int id, char category, String name, int hp, int atk, int def, float cr, float cd) {
        this(id, category, name, hp, atk, def, 0, cr, cd, 0, 0);
    }
    public Entity(int id,char category, String name, int hp, int atk, int def, int spd, float elemRes) {
        this(id, category, name, hp, atk, def, spd, 0, 0, 0, elemRes);
    }
    public Entity(int id, char category, String name, int hp, int atk, int def, int spd, float cr, float cd, float bonusDmg) {
        this(id, category, name, hp, atk, def, spd, cr, cd, bonusDmg, 0);
    }
    public Entity(int id, char category, String name, int hp, int atk, int def, int spd, float cr, float cd, float bonusDmg, float elemRes) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.cr = cr;
        this.cd = cd;
        this.bonusDmg = bonusDmg;
        this.elemRes = elemRes;
    }

    //get Methods
    public int getId() {return id;}
    public char getCategory() {return category;}
    public String getName() {return name;}
    public int getHp() {return hp;}
    public int getAtk() {return atk;}
    public int getDef() {return def;}
    public int getSpd() {return spd;}
    public float getCr() {return cr;}
    public float getCd() {return cd;}
    public float getBonusDmg() {return bonusDmg;}
    public float getElemRes() {return elemRes;}

    //set Methods
    public void setId(int id) {this.id = id;}
    public void setCategory(char category) {this.category = category;}
    public void setName(String name) {this.name = name;}
    public void setHp(int hp) {this.hp = hp;}
    public void setAtk(int atk) {this.atk = atk;}
    public void setDef(int def) {this.def = def;}
    public void setSpd(int spd) {this.spd = spd;}
    public void setCr(float cr) {this.cr = cr;}
    public void setCd(float cd) {this.cd = cd;}
    public void setBonusDmg(float bonusDmg) {this.bonusDmg = bonusDmg;}
    public void setElemRes(float elemRes) {this.elemRes = elemRes;}

    //toString for entity variables.
    public String toString() {
        String EntityType = "";
        if (category == 'c') {EntityType = "Character";}
        else if (category == 'E') {EntityType = "Enemy";}
        else if (category == 'L') {EntityType = "Lightcone";}
        return String.format("Entity Type: %s\nName: %s\nHP: %d\nATK: %d\nDEF: %d\nSPD: %d\nCRIT Rate: %f\nCRIT Dmg: %f\n", EntityType, name, hp, atk, def, spd, cr, cd);
    }
}
