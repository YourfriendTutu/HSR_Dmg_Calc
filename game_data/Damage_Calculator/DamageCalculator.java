package game_data.Damage_Calculator;

import game_data.Characters.Character;
import game_data.Enemies.Enemy;
import game_data.Character_Abilities.CharacterAbilities;
import game_data.Utility_Classes.HitComponent;
import game_data.Utility_Classes.EnemyFormation;

public class DamageCalculator {
    private Character character;
    private CharacterAbilities ability;
    private EnemyFormation enemyFormation;
    private int TargetIndex; //Represents main target of user. Indexed from 0-4 because max enemies is 5.
    private float DefMultiplier = 20f / 43f; //Since Character level 80 and Enemy level 95 is assumed, DEF Multiplier is fixed at this value.
    //Def Multiplier = Character Level + 20 / (Enemy Level + 20 + Character Level + 20)


    public DamageCalculator(Character character, CharacterAbilities ability, EnemyFormation enemyFormation, int TargetIndex) {
        this.character = character;
        this.ability = ability;
        this.enemyFormation = enemyFormation;
        this.TargetIndex = TargetIndex;
    }


    //Still needs Weakened Attacker Multiplier, Toughness Broken multiplier, Resistance, Vunerability, DMG mitigation, Broken Multiplier
    public int calculateBaseDamage() { //Base Damage Calc
        Enemy target = enemyFormation.getEnemyAtPosition(TargetIndex);
        float total = 0f;

        for (HitComponent hit : ability.getHitComponents()) {
            int baseStat = character.getStatValue(hit.getStatType(), Integer.class); //All Scaling stat values are currently integers (HP, ATK, DEF, SPD)
            float multiplier = hit.getSplitRatio();
            float baseDamage = (baseStat * multiplier);

            total += baseDamage;
        }
        return (int) total;
    }

    //Currently missing key multipliers & factors: Resistance, Dmg Taken, Toughness, DEF Reduction, DEF Ignore
    public int calculateDamage() { //General Damage Calculator
        int baseDamage = calculateBaseDamage();
        float total = 0f;
        float bonusDamage = character.getBonusDmg(); //Needs to be fixed to account for specific damage bonuses

        total = baseDamage * bonusDamage * DefMultiplier;
        return (int) total;
    }

    //Currently only accounts for all attack splits Critting, needs to implement Crit Multiplier
    //Crit Multiplier = 1 + Crit Dmg
    //otherwise = 1
    public int calculateBaseCriticalDamage() { //Crit Damage Calc
        //Crit Multiplier = BaseDamage * (1 + CRIT DMG%)
        float CriticalDamageDone = calculateDamage() * (1 + character.getCd());
        return (int) CriticalDamageDone;
    }

    public Enemy getMainTarget() {
        return enemyFormation.getEnemyAtPosition(TargetIndex);
    }

    public String toString() {
        return String.format("Base Damage: %d"
                + "General Damage: %d"
                + "Critical Damage: %d"
                , calculateBaseDamage(), calculateDamage(), calculateBaseCriticalDamage());
    }
}
