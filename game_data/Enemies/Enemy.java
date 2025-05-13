package game_data.Enemies;

import java.util.List;
import java.util.Arrays;

import game_data.Utility_Classes.ElementalResistance;
import game_data.Utility_Classes.Entity;
import game_data.Utility_Classes.Enums.StatTypes;

public class Enemy extends Entity {
    private List<String> weaknesses;

    //Current playable Elements as of HSR V3.2
    private static final List<String> elemsList = Arrays.asList("Physical", "Fire", "Ice", "Lightning", "Wind", "Quantum", "Imaginary");

    //game_data.Enemies.Enemy Constructor
    public Enemy(int id, String name, int hp, int atk, int def, int spd, List<String> weaknesses) {
        super(id, 'E', name, hp, atk, def, spd, 0.0F);
        this.weaknesses = weaknesses;
        if (!hasValidWeaknesses()) {
            throw new IllegalArgumentException("Invalid weaknesses provided");
        }
        ElementalResistance.setEnemyRes();
        setWeaknessRes();
    }

    //private Boolean method for check valid elemental weaknesses
    private boolean hasValidWeaknesses() {
        for (String str : weaknesses) {
            if (!elemsList.contains(str)) {return false;}
        }return true;
    }

    //private Setter for enemy weakness res
    private void setWeaknessRes() {
        for (String str : weaknesses) {
            ElementalResistance.setResistance(str, 0.0F);
        }
    }

    public String getWeakness() {
        return String.join(", ", weaknesses);
    }

    @Override
    public String printStats() {return String.format("Enemy Stats: \n"
    + "Name: %s\n"
    + "Weaknesses: %s\n"
    + "HP: %d\n"
    + "ATK: %d\n"
    + "DEF: %d\n"
    + "SPD: %d\n",
            getName(), getWeakness(), getStatValue(StatTypes.HP, Integer.class), getStatValue(StatTypes.ATK, Integer.class), getStatValue(StatTypes.DEF, Integer.class), getStatValue(StatTypes.SPD, Integer.class));}

    public String getElement() {return "None";}

}
