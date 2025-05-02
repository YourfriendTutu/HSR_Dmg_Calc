import javax.swing.*;
import game_data.Characters.Character;
import java.io.File;

public class DmgCalculator extends JFrame{
    private JPanel mainPanel;
    private JTextField characterName;
    private JTextField hpStat;
    private JTextField atkStat;
    private JTextField defStat;
    private JTextField spdStat;
    private JTextField crStat;
    private JTextField cdStat;
    private JTextField element;
    private JTextField rarity;
    private JTextField path;

    //get Methods for JTextFields
    public JTextField getCharacterName() {return characterName;}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Rail Calculator");
        DmgCalculator display = new DmgCalculator();

        // sets and displays JFrame
        frame.setContentPane(display.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Rebecca: Don't know how to retrieve data from json. Placeholder character creation to test functionality.
        Character the_herta = new Character(1061, "The Herta", 1164, 679, 485, 99, "Erudition", "Ice", 5);

        //setText methods for JTextFields to display character information
        //Rebecca: Don't know how to retrieve data from json. Placeholder gets from character object to test functionality.
        display.characterName.setText(the_herta.getName());
        display.element.setText(the_herta.getElement());
        display.path.setText(the_herta.getPath());
        display.hpStat.setText(String.valueOf(the_herta.getHp()));
        display.atkStat.setText(String.valueOf(the_herta.getAtk()));
        display.defStat.setText(String.valueOf(the_herta.getDef()));
        display.spdStat.setText(String.valueOf(the_herta.getSpd()));
        display.crStat.setText(String.valueOf(the_herta.getCr()));
        display.cdStat.setText(String.valueOf(the_herta.getCd()));

        display.rarity.setText(the_herta.printStars());
    }

}
