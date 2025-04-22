package game_data.Utility_Classes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ElementalResistance {
    private String element;
    private float resistance;
    private static final ConcurrentHashMap<String, Float> elemResistances = new ConcurrentHashMap<>();

    //Current playable Elements as of HSR V3.2
    private static final List<String> elemsList = Arrays.asList("Physical", "Fire", "Ice", "Lightning", "Wind", "Quantum", "Imaginary");

    static {
        elemResistances.put("Physical", 0.0f);
        elemResistances.put("Fire", 0.0f);
        elemResistances.put("Ice", 0.0f);
        elemResistances.put("Lightning", 0.0f);
        elemResistances.put("Wind", 0.0f);
        elemResistances.put("Quantum", 0.0f);
        elemResistances.put("Imaginary", 0.0f);
    }
    //Getter for elemental resistance by element name
    public static float getResistance(String element) {
        return elemResistances.getOrDefault(element, 0.0f);
    }
    //Setter for elemental resistance
    public static void setResistance(String element, float resistance) {
        elemResistances.put(element, resistance);
    }

    //Setter for all resistances
    public static void setAllResistances(Float resistance) {
        for (String element : elemsList) {
            elemResistances.put(element, resistance);
        }
    }

    //Setter for default enemy res
    public static void setEnemyRes() {
        setAllResistances(0.2F);
    }

    //ToString

}
