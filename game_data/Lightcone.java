package game_data;

public class Lightcone {
    private int L_hp;
    private int L_atk;
    private int L_def;
    private float L_cr;
    private float L_cd;
    private float skillDmgInc;
    private float ultDmgInc;
    // skill and ult dmg inc to be utilized in method for dmg calculation

    //Rebecca: very rough coding to try out, may be scrapped depending on your ideas
    //attempt at construction, has a relationship, with character
    //game_data.Lightcone Constructor
    public Lightcone(int id, String name, int hp, int atk, int def, String path, int rarity,
                     float critRateInc, float skillDmgInc, float ultDmgInc) {
        super(id, name, hp, atk, def, path, rarity);
        this.critRateInc = critRateInc;
        this.skillDmgInc = skillDmgInc;
        this.ultDmgInc = ultDmgInc;
    }

    public float getCritRateInc() {return critRateInc;}

    //Method to add LC stats to Character stats
    public static void equipLC(Character c, Lightcone lc) {
        c.setHp(c.getHp() + lc.getHp());
        c.setATK(c.getATK() + lc.getATK());
        c.setDEF(c.getDEF() + lc.getDEF());
        c.setCR(c.getCR() + lc.getCritRateInc());
    }

}
