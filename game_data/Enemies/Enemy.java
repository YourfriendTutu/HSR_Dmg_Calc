package game_data.Enemies;

import java.util.List;
import java.util.Arrays;

import game_data.ElementalResistance;
import game_data.Entity;

public class Enemy extends Entity {
    private List<String> weaknesses;

    //Current playable Elements as of HSR V3.2
    private static final List<String> elemsList = Arrays.asList("Physical", "Fire", "Ice", "Lightning", "Wind", "Quantum", "Imaginary");

    //game_data.Enemies.Enemy Constructor
    public Enemy(int id, String name, int hp, int atk, int def, int spd, float elemRes, List<String> weaknesses) {
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

}
