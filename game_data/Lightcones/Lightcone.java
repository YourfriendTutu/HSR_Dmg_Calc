package game_data.Lightcones;

import game_data.Characters.Character;
import game_data.Utility_Classes.Entity;
import game_data.Utility_Classes.Enums.StatTypes;

public class Lightcone extends Entity {
    private String path;
    private int rarity;


    //game_data.Lightcones.Lightcone Constructor
    public Lightcone(int id, String name, int hp, int atk, int def, float cr, float cd, String path, int rarity) {
        super(id, 'L', name, hp, atk, def, cr, cd);
        this.path = path;
        this.rarity = rarity;
    }

    //get Methods
    public String getPath() {return this.path;}
    public int getRarity() {return this.rarity;}

    //set Methods
    public void setPath(String path) {this.path = path;}
    public void setRarity(int rarity) {this.rarity = rarity;}

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

    @Override
    public String printStats(){
        return String.format("Lightcone Stats:\n"
                        + "Name: %s\n"
                        + "Path: %s\n"
                        + "HP: %d\n"
                        + "ATK: %d\n"
                        + "DEF: %d\n"
                        + "SPD: %d\n"
                        + "CRIT Rate: %f\n"
                        + "CRIT Dmg: %f\n"
                , getName(), getPath(), getStatValue(StatTypes.HP, Integer.class), getStatValue(StatTypes.ATK, Integer.class),
                getStatValue(StatTypes.DEF, Integer.class), getStatValue(StatTypes.SPD, Integer.class), getStatValue(StatTypes.CRIT_RATE, Float.class),
                getStatValue(StatTypes.CRIT_DMG, Float.class));
    }
}
