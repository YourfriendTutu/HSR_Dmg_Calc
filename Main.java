import game_data.Character;
import game_data.Entity;
import game_data.Lightcone;
import game_data.Enemy;
import game_data.Relic;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Character therta = new game_data.Character(101,"The Herta",1164,679,485,99,
                0.05F,0.5F,0.0F,0.2F,"Erudition", "Ice", 5);
        Lightcone thertaSig = new Lightcone(1001,"Into the Unreachable Veil",952,635,463,
                0.12F,0,"Erudition",5);
        Enemy swarmking = new Enemy(10001,"Starcrusher Skaracabaz",330358,552,1000,144,0.2F);

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