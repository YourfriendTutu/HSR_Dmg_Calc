package game_data;

public class Lightcone extends Character {
    private float critRateInc;
    private float skillDmgInc;
    private float ultDmgInc;
    // skill and ult dmg inc to be utilized in method for dmg calculation

    //Rebecca: very rough coding to try out, may be scrapped depending on your ideas
    //game_data.Lightcone Constructor
    public Lightcone(int id, int level, String name, int hp, int atk, int def, String path, int rarity,
                     float critRateInc, float skillDmgInc, float ultDmgInc) {
        super(id, level, name, hp, atk, def, path, rarity);
        this.critRateInc = critRateInc;
        this.skillDmgInc = skillDmgInc;
        this.ultDmgInc = ultDmgInc;
    }

    public float getCritRateInc() {return critRateInc;}

    //Method to add LC stats to Character stats
    public static void equipLC(Character c, Lightcone lc) {
        c.setHP(c.getHP() + lc.getHP());
        c.setATK(c.getATK() + lc.getATK());
        c.setDEF(c.getDEF() + lc.getDEF());
        c.setCR(c.getCR() + lc.getCritRateInc());
    }

    // Rebecca: purpose is for me to temporarily check if the LC info entered was correct
    // forgot to add path, could change lightcone to be character subclass
    public String toString() {return String.format("ID: %d\nName: %s\nPath: %s\nRarity: %d*\nLevel: %d\n" +
                    "HP: %d\nATK: %d\nDEF: %d",
            getId(), getName(), getPath(), getRarity(), getLevel(), getHP(), getATK(), getDEF());}
}
