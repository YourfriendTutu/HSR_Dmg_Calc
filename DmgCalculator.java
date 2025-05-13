import javax.swing.*;

import game_data.Character_Abilities.CharacterAbilities;
import game_data.Characters.Character;
import game_data.Lightcones.Lightcone;
import game_data.Enemies.Enemy;
import game_data.Utility_Classes.EnemyFormation;
import game_data.Damage_Calculator.*;
import game_data.Utility_Classes.Enums.ElementTypes;
import game_data.Utility_Classes.Enums.StatTypes;
import game_data.Utility_Classes.Enums.TargetBehaviors;
import game_data.Utility_Classes.HitComponent;
import game_data.Character_Abilities.BasicAbility;
import game_data.Utility_Classes.HitComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
    private JComboBox characterSelect;
    private JPanel characterPanel;
    private JPanel lightconePanel;
    private JTextField LCrarity;
    private JTextField LCpath;
    private JTextField lightconeName;
    private JComboBox lightconeSelect;
    private JTextField LCatkStat;
    private JTextField LCdefStat;
    private JTextField LCcrStat;
    private JTextField LCcdStat;
    private JTextField LChpStat;
    private JPanel enemyPanel;
    private JPanel selections;
    private JComboBox abilitySelect;
    private JComboBox enemySelect;
    private JTextField enemyName;
    private JButton button;
    private JTextField dmg;
    private JTextField weaknesses;
    private JTextField EhpStat;
    private JTextField EatkStat;
    private JTextField EdefStat;
    private JTextField EspdStat;

    //Rebecca: enemy information and damage calculation action events still need to be implemented
    public DmgCalculator() {
        //Rebecca: Don't know how to retrieve data from json. Placeholder object creation to test functionality.
        // Cannot figure out how to use objects initialized under CharacterCreator directly.
        Character the_herta = new Character(1061, "The Herta", 1164, 679, 485, 99, "Erudition", "Ice", 5);
        Character anaxa = new Character(1066,"Anaxa", 1164, 679, 485, 99, "Erudition", "Wind", 5);
        Lightcone unreachable_veil = new Lightcone(10061, "Into the Unreachable Veil", 952, 635, 463, 0.12F, 0.0F, "Erudition", 5, "resources/lightcone_images/Light_Cone_Into_the_Unreachable_Veil_Artwork.png");
        Lightcone cast_to_flames = new Lightcone(10066, "Life Should Be Cast to Flames", 953, 582, 529, 0.0F, 0.0F, "Erudition", 5, "resources/lightcone_images/Light_Cone_Life_Should_Be_Cast_to_Flames_Artwork.png");
        Enemy skaracabaz = new Enemy(1500, "Skaracabaz", 812090, 773, 1199, 158, Arrays.asList("Physical", "Ice", "Imaginary"));
        Enemy flame_reaver = new Enemy(1550, "Flame Reaver", 1099706, 773, 1199, 174, Arrays.asList("Ice", "Lightning", "Quantum"));

        //Rebecca: Don't know how to retrieve data from json. Placeholder gets from objects to test functionality.
        characterSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) characterSelect.getSelectedItem();
                Character c;
                switch (selected) {
                    case "The Herta":
                        c = the_herta;
                        break;
                    case "Anaxa":
                        c = anaxa;
                        break;
                    default:
                        c = null;
                        characterName.setText("");
                        element.setText("");
                        path.setText("");
                        hpStat.setText("");
                        atkStat.setText("");
                        defStat.setText("");
                        spdStat.setText("");
                        crStat.setText("");
                        cdStat.setText("");
                        rarity.setText("");
                        break;
                }
                if (c != null) {
                    characterName.setText(c.getName());
                    element.setText(c.getElement());
                    path.setText(c.getPath());
                    hpStat.setText(String.valueOf(c.getHp()));
                    atkStat.setText(String.valueOf(c.getAtk()));
                    defStat.setText(String.valueOf(c.getDef()));
                    spdStat.setText(String.valueOf(c.getSpd()));
                    crStat.setText(String.valueOf(c.getCr()));
                    cdStat.setText(String.valueOf(c.getCd()));
                    rarity.setText(c.printStars());
                }
            }
        });
        lightconeSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) lightconeSelect.getSelectedItem();
                Lightcone lc;
                switch (selected) {
                    case "Into the Unreachable Veil":
                        lc = unreachable_veil;
                        break;
                    case "Life Should Be Cast to Flames":
                        lc = cast_to_flames;
                        break;
                    default:
                        lc = null;
                        lightconeName.setText("");
                        LCpath.setText("");
                        LChpStat.setText("");
                        LCatkStat.setText("");
                        LCdefStat.setText("");
                        LCcrStat.setText("");
                        LCcdStat.setText("");
                        LCrarity.setText("");
                        break;
                }
                if (lc != null) {
                    lightconeName.setText(lc.getName());
                    LCpath.setText(lc.getPath());
                    LChpStat.setText(String.valueOf(lc.getHp()));
                    LCatkStat.setText(String.valueOf(lc.getAtk()));
                    LCdefStat.setText(String.valueOf(lc.getDef()));
                    LCcrStat.setText(String.valueOf(lc.getCr()));
                    LCcdStat.setText(String.valueOf(lc.getCd()));
                    LCrarity.setText(lc.printStars());
                }
            }
        });
        enemySelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) enemySelect.getSelectedItem();
                Enemy y;
                switch (selected) {
                    case "Skaracabaz":
                        y = skaracabaz;
                        break;
                    case "Flame Reaver":
                        y = flame_reaver;
                        break;
                    default:
                        y = null;
                        enemyName.setText("");
                        weaknesses.setText("");
                        EhpStat.setText("");
                        EatkStat.setText("");
                        EdefStat.setText("");
                        EspdStat.setText("");
                        break;
                }
                if (y != null) {
                    enemyName.setText(y.getName());
                    weaknesses.setText(y.getWeakness());
                    EhpStat.setText(String.valueOf(y.getHp()));
                    EatkStat.setText(String.valueOf(y.getAtk()));
                    EdefStat.setText(String.valueOf(y.getDef()));
                    EspdStat.setText(String.valueOf(y.getSpd()));
                }
            }
        });
        abilitySelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Rebecca: Ideally, after reading damage formula code, I can implement reads from .json
            }
        });

        HitComponent basic = new HitComponent(StatTypes.ATK, 120.0F, TargetBehaviors.SINGLEATK);
        BasicAbility therta_basic = new BasicAbility(100500, "Did You Get It", ElementTypes.ICE, TargetBehaviors.SINGLEATK, Arrays.asList(basic), 1);
        EnemyFormation boss = new EnemyFormation(Arrays.asList(skaracabaz));
        DamageCalculator d = new DamageCalculator(the_herta, therta_basic, boss, 0);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("The Herta".compareTo((String) characterSelect.getSelectedItem()) == 0) {
                    if ("Basic".compareTo((String) abilitySelect.getSelectedItem()) == 0) {
                        if ("Skaracabaz".compareTo((String) enemySelect.getSelectedItem()) == 0) {
                            dmg.setText(String.valueOf(d.calculateBaseDamage()));
                        }
                    }
                }
                else {
                    dmg.setText("");
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Rail Calculator");
        JPanel mainPanel = new JPanel();
        DmgCalculator display = new DmgCalculator();

        // displays JFrame
        frame.setContentPane(display.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
