import game_data.Character;
import game_data.Entity;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Entity character1 = new Entity("The Herta");
        Character Therta = new game_data.Character("Erudition", "Ice", 5, character1);

        System.out.println(character1);
        System.out.println(Therta);

    }
}