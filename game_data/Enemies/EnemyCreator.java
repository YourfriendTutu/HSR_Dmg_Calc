package game_data.Enemies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EnemyCreator {

   // The Method to Load enemies from JSON file
    public static List<game_data.Enemies.Enemy> loadEnemies(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Enemy>>() {}.getType();
            Gson gson = new Gson();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
   
 public static void main(String[] args) {
    List<Enemy> enemies = new ArrayList<>();
     //need to add the actual enemies 
 }
   
