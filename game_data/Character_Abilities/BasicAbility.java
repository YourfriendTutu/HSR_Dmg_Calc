package game_data.Character_Abilities;

import game_data.Utility_Classes.Enums.AbilityTypes;
import game_data.Utility_Classes.Enums.TargetBehaviors;
import game_data.Utility_Classes.Enums.ElementTypes;
import game_data.Utility_Classes.HitComponent;

import java.util.List;

public class BasicAbility extends CharacterAbilities {
    public BasicAbility(int id, String name, ElementTypes element, TargetBehaviors targetBehavior, List<HitComponent> hitComponents, int unitsAffected) {
        super(id, AbilityTypes.BASIC, name, element, targetBehavior, hitComponents, unitsAffected);

    }
}
