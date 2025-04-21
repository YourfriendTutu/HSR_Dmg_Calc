package game_data.Abilities;

public class Ability {
    private int id;
    private char category;
    private String name;
    private String element;
    private float elemDmg;
    private int instances;

    public Ability(int id, char category, String name, String element, float elemDmg, int instances) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.element = element;
        this.elemDmg = elemDmg;
        this.instances = instances;
    }

    public int getId() {return id;}
    public char getCategory() {return category;}
    public String getName() {return name;}
    public String getElement() {return element;}
    public float getElemDmg() {return elemDmg;}
    public float getInstances() {return instances;}

    public void setId(int id) {this.id = id;}
    public void setCategory(char category) {this.category = category;}
    public void setName(String name) {this.name = name;}
    public void setElement(String element) {this.element = element;}
    public void setElemDmg(float elemDmg) {this.elemDmg = elemDmg;}
    public void setInstances(int instances) {this.instances = instances;}
}

public float baseDmg(Ability a, game_data.Characters.Character c) {
    if (a.getCategory() == 'Q') {
        return a.getElemDmg() * c.getAtk();
    }
    if (a.getCategory() == 'E') {
        return a.getElemDmg() * c.getAtk() * a.getInstances();
    }
}
