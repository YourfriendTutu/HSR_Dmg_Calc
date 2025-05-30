package game_data.Character_Abilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import game_data.Utility_Classes.HitComponent;
import game_data.Utility_Classes.Enums.StatTypes;
import game_data.Utility_Classes.Enums.TargetBehaviors;
import game_data.Utility_Classes.Enums.ElementTypes;

import java.io.FileWriter;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbilityCreator {
    public static List<game_data.Character_Abilities.CharacterAbilities> loadAbilities(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<game_data.Character_Abilities.CharacterAbilities>>() {}.getType();
            Gson gson = new Gson();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Main
    public static void main(String[] args) {

        //ID scheme: Use the character ID, add a 0, then use 1-5 to identify Ability Type using the following,
        //1 = Basic | 2 = Skill | 3 = Ultimate | 4 = Talent | 5 = Technique
        //The Herta Ex. Character Id = 1061, Basic = 01, Ability ID = 106101

        //Bounce Behavior: The 1st instance of a Bounce attack will always target the selected enemy and then target random enemies.
        //Blast Behavior: Blast Attacks deal damage to the main target and either deal the same amount or less to adjacent targets.
        //It may target adjacent or two more adjacent units. Ex. 1-1.5-1 or 1-1-2-1-1

        //V3.0
        //The Herta Abilities
        CharacterAbilities the_herta_basic = new BasicAbility(106101, "Did You Get It?", ElementTypes.ICE, TargetBehaviors.SINGLEATK,
            List.of(new HitComponent(StatTypes.ATK, 1.0f, TargetBehaviors.SINGLEATK)), 1);
        //V3.2
        //Anaxa Abilities
        //Anaxa Basic
        CharacterAbilities anaxa_basic = new BasicAbility(106601, "Pain, Brews Truth", ElementTypes.WIND, TargetBehaviors.SINGLEATK,
                List.of(new HitComponent(StatTypes.ATK, 1.0f, TargetBehaviors.SINGLEATK)), 1);
        //Anaxa Skill
        CharacterAbilities anaxa_skill = new SkillAbility(106602, "Fractal, Exiles Fallacy", ElementTypes.WIND, TargetBehaviors.BOUNCE,
            List.of(new HitComponent(StatTypes.ATK, 0.7F, TargetBehaviors.SINGLEATK),
                    new HitComponent(StatTypes.ATK, 0.7F, TargetBehaviors.BOUNCE, 4)), 5);

        //List of character abilities
        List<CharacterAbilities> characterAbilities = new ArrayList<>();
        characterAbilities.add(the_herta_basic);
        characterAbilities.add(anaxa_basic);
        characterAbilities.add(anaxa_skill);

        //Makes Json file readable and neat
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Java to Json language converter
        String characterAbilitiesJson = gson.toJson(characterAbilities);

        //File writer to character_data.json
        try(FileWriter writer = new FileWriter("game_data/Character_Abilities/character_abilities_data.json")){
            writer.write(characterAbilitiesJson);
            System.out.println("Written updated character abilities data to file.");
        } catch (IOException e) {e.printStackTrace();}
    }

}
