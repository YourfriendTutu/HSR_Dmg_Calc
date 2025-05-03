package game_data.Enemies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnemyCreator {

    //Method to load enemies from JSON file
    public static List<game_data.Enemies.Enemy> loadEnemies(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<game_data.Enemies.Enemy>>() {}.getType();
            Gson gson = new Gson();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Main Code
    public static void main(String[] args) {
        //Enemies are id from 1000-10000 Exclusive, by release version then alphabetically.

        //V1.0
        //Antibaryon
        game_data.Enemies.Enemy antibaryon = new game_data.Enemies.Enemy(1001, "Antibaryon", 16429, 718, 1150, 109, 0.0F, Arrays.asList("Physical", "Quantum"));

        //V1.6
        //Skaracabaz
        game_data.Enemies.Enemy skaracabaz = new game_data.Enemies.Enemy(1500, "Skaracabaz", 812090, 773, 1199, 158, 0.0F, Arrays.asList("Physical", "Ice", "Imaginary"));

        //List of enemies to add to Json file
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(antibaryon);
        enemies.add(skaracabaz);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Java to Json language converter
        String enemyJson = gson.toJson(enemies);

        //File writer to character_data.json
        try (FileWriter writer = new FileWriter("game_data/Enemies/enemy_data.json")) {
            writer.write(enemyJson);
            System.out.println("Written updated enemy data to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
