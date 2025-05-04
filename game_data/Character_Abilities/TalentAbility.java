package game_data.Character_Abilities;

import game_data.Utility_Classes.Enums.AbilityTypes;
import game_data.Utility_Classes.Enums.ElementTypes;
import game_data.Utility_Classes.Enums.TargetBehaviors;
import game_data.Utility_Classes.HitComponent;

import java.util.List;

public class TalentAbility extends CharacterAbilities {
    public TalentAbility(int id, String name, ElementTypes element, TargetBehaviors targetBehaviors, List<HitComponent> hitComponents, int maxUnitsAffected) {
        super(id, AbilityTypes.TALENT, name, element, targetBehaviors, hitComponents, maxUnitsAffected);
    }
}
