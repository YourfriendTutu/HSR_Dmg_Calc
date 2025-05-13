package game_data.Lightcones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LightconeCreator {

    //Method to load lightcones from JSON file
    public static List<game_data.Lightcones.Lightcone> loadLightcones(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<game_data.Lightcones.Lightcone>>() {}.getType();
            Gson gson = new Gson();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Main Code
    public static void main(String[] args) {
        //Lightcones are id from 10000-100000 Exclusive, by release version then alphabetically.

        //V3.0
        //Into the Unreachable Veil
        game_data.Lightcones.Lightcone unreachable_veil = new game_data.Lightcones.Lightcone(10061, "Into the Unreachable Veil", 952, 635, 463, 0.12F, 0.0F, "Erudition", 5, "resources//lightcone_images/Light_Cone_Into_the_Unreachable_Veil_Artwork.png");

        //V3.2
        //Life Should Be Cast to Flames
        game_data.Lightcones.Lightcone cast_to_flames = new game_data.Lightcones.Lightcone(10066, "Life Should Be Cast to Flames", 953, 582, 529, 0.0F, 0.0F, "Erudition", 5, "resources//lightcone_images/Light_Cone_Life_Should_Be_Cast_to_Flames_Artwork.png");

        //List of characters to add to Json file
        List<Lightcone> lightcones = new ArrayList<>();
        lightcones.add(unreachable_veil);
        lightcones.add(cast_to_flames);

        //Makes Json file readable and neat
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Java to Json language converter
        String lightconeJson = gson.toJson(lightcones);

        //File writer to character_data.json
        try(FileWriter writer = new FileWriter("game_data/Lightcones/lightcone_data.json")){
            writer.write(lightconeJson);
            System.out.println("Written updated lightcone data to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
