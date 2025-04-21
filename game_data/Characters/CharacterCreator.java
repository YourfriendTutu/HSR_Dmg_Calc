package game_data.Characters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterCreator {

    //Method to load characters from JSON file
    public static List<game_data.Characters.Character> loadCharacters(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<game_data.Characters.Character>>() {}.getType();
            Gson gson = new Gson();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Main Code
    public static void main(String[] args) {
        //Characters are id from 1000-10000 Exclusive, by release version then alphabetically.

        //V1.0
        //Arlan
        game_data.Characters.Character arlan = new game_data.Characters.Character(1001, "Arlan", 1199, 599, 330, 102, "Destruction", "Lightning", 4);

        //Asta
        game_data.Characters.Character asta = new game_data.Characters.Character(1002, "Asta", 1023, 511, 463, 106, "Harmony", "Fire", 4);

        //Bailu
        game_data.Characters.Character bailu = new game_data.Characters.Character(1003, "Bailu", 1319, 562, 485, 98, "Abundance", "Lightning", 5);

        //V3.0
        //The Herta
        game_data.Characters.Character the_herta = new game_data.Characters.Character(1061, "The Herta", 1164, 679, 485, 99, "Erudition", "Ice", 5);

        //V3.2
        //Anaxa
        game_data.Characters.Character anaxa = new game_data.Characters.Character(1066,"Anaxa", 1164, 679, 485, 99, "Erudition", "Wind", 5);

        //Meme Entities(Friends)
        //Clark (He's my friend, just ignore this cause its funny)
        game_data.Characters.Character clark = new game_data.Characters.Character(9999, "Clark", 1538, 543, 443, 107, "Destruction", "Lightning", 5);

        //Hao (Local Whale)
        game_data.Characters.Character hao = new game_data.Characters.Character(9998, "Hao", 812, 416, 793, 120, "Nihility", "Lightning", 5);

        //Jason (Bailu@home or you could just lose 50/50's to Bailu. On second thought, maybe winning Bailu is better than this dude)
        //Bro gets one tapped by a Destruction Trotter imagine.
        //Bonus Trace w/dodge mechanic scaling off spd?
        game_data.Characters.Character jason = new game_data.Characters.Character(9997, "Jason", 1, 1, 1, 10000, "Abundance", "Imaginary", 5);

        //List of characters to add to Json file
        List<Character> characters = new ArrayList<>();
        characters.add(arlan);
        characters.add(asta);
        characters.add(bailu);
        characters.add(the_herta);
        characters.add(anaxa);

        //Meme Characters
        characters.add(clark);
        characters.add(hao);
        characters.add(jason);

        //Makes Json file readable and neat
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Java to Json language converter
        String characterJson = gson.toJson(characters);

        //File writer to character_data.json
        try(FileWriter writer = new FileWriter("game_data/Characters/character_data.json")){
            writer.write(characterJson);
            System.out.println("Written updated character data to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
