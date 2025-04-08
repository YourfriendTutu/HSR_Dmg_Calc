import game_data.Character;
import game_data.Entity;
import game_data.Lightcone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Character therta = new game_data.Character(101,"The Herta",1164,679,485,99,
                0.05F,0.5F,0.0F,0.2F,"Erudition", "Ice", 5);
        Lightcone thertaSig = new Lightcone(1, 80, "Into the Unreachable Veil", 952, 635, 463,
                "Erudition", 5,
                (float) 0.12, (float) 0.6, (float) 0.6);

        // base character stats
        System.out.println(therta);
        System.out.println();
        // lc stats
        System.out.println(thertaSig);
        System.out.println();
        // character stats after lc equipped
        Lightcone.equipLC(therta, thertaSig);
        System.out.println(therta);

    }


}