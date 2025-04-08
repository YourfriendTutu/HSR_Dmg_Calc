package game_data;

public class Lightcone extends Entity {
    private String path;
    private int rarity;


    //game_data.Lightcone Constructor
    public Lightcone(String name, int hp, int atk, int def, float cr, float cd, String path, int rarity) {
        super(name, hp, atk, def, cr, cd);
        this.path = path;
        this.rarity = rarity;
    }

    //Method to add LC stats to Character stats
    public static void equipLC(Character c, Lightcone lc) {
        c.setHp(c.getHp() + lc.getHp());
        c.setAtk(c.getAtk() + lc.getAtk());
        c.setDef(c.getDef() + lc.getDef());
        c.setCr(c.getCr() + lc.getCr());
        c.setCr(c.getCd() + lc.getCd());
    }

}
