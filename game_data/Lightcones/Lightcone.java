package game_data.Lightcones;

import game_data.Characters.Character;
import game_data.Entity;

public class Lightcone extends Entity {
    private String path;
    private int rarity;


    //game_data.Lightcones.Lightcone Constructor
    public Lightcone(int id, String name, int hp, int atk, int def, float cr, float cd, String path, int rarity) {
        super(id, 'L', name, hp, atk, def, cr, cd);
        this.path = path;
        this.rarity = rarity;
    }

    //Method to add LC stats to Character stats
    public static void equipLC(game_data.Characters.Character c, Lightcone lc) {
        //If LC is already equipped, unequips current LC
        if (c.getEquippedLightcone() != null) {
            unequipLC(c);
        }

        c.setHp(c.getHp() + lc.getHp());
        c.setAtk(c.getAtk() + lc.getAtk());
        c.setDef(c.getDef() + lc.getDef());
        c.setCr(c.getCr() + lc.getCr());
        c.setCr(c.getCd() + lc.getCd());
        //equips LC
        c.setEquippedLightcone(lc);
    }

    //Method to remove LC stats from Character Stats
    public static void unequipLC(Character c) {
        //Retrieves equipped LC. If no equipped LC, returns.
        Lightcone lc = c.getEquippedLightcone();
        if (lc == null) return;

        //Subtracts all character stats by LC stats.
        c.setHp(c.getHp() - lc.getHp());
        c.setAtk(c.getAtk() - lc.getAtk());
        c.setDef(c.getDef() - lc.getDef());
        c.setCr(c.getCr() - lc.getCr());
        c.setCr(c.getCd() - lc.getCd());

        //unequips LC
        c.setEquippedLightcone(null);
    }

}
