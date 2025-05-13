package game_data.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import game_data.Character_Abilities.*;
import game_data.Utility_Classes.HitComponent;
import game_data.Utility_Classes.Enums.*;

public class AbilityCreatorGUI extends JFrame {

    private JTable abilityTable;
    private DefaultTableModel tableModel;
    private List<CharacterAbilities> abilities;

    private static final String FILE_PATH = "game_data/Character_Abilities/abilities.ser";

    public AbilityCreatorGUI() {
        setTitle("Ability Viewer and Creator");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("View Abilities", createViewPanel());
        tabbedPane.addTab("Add Ability", createAddPanel());

        add(tabbedPane);
    }

    private JPanel createViewPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"ID", "Type", "Name", "Element", "Target Behavior", "Max Units", "Actions"};
        tableModel = new DefaultTableModel(columnNames, 0);
        abilityTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(abilityTable);

        loadAbilitiesFromFile();
        updateTable(); // Update the table with abilities and delete buttons

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createAddPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JComboBox<AbilityTypes> typeBox = new JComboBox<>(AbilityTypes.values());
        JComboBox<ElementTypes> elementBox = new JComboBox<>(ElementTypes.values());
        JComboBox<TargetBehaviors> behaviorBox = new JComboBox<>(TargetBehaviors.values());
        JTextField splitRatioField = new JTextField("1.0");
        JComboBox<StatTypes> statTypeBox = new JComboBox<>(StatTypes.values());
        JTextField maxUnitsField = new JTextField("1");

        JButton saveButton = new JButton("Add Ability");

        saveButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                AbilityTypes type = (AbilityTypes) typeBox.getSelectedItem();
                ElementTypes element = (ElementTypes) elementBox.getSelectedItem();
                TargetBehaviors behavior = (TargetBehaviors) behaviorBox.getSelectedItem();
                String splitRatioText = splitRatioField.getText().trim();
                String[] splitRatioStrings = splitRatioText.split(",");
                List<Float> splitRatios = new ArrayList<>();
                for (String s : splitRatioStrings) {
                    splitRatios.add(Float.parseFloat(s.trim()));
                }
                StatTypes stat = (StatTypes) statTypeBox.getSelectedItem();
                int maxUnits = Integer.parseInt(maxUnitsField.getText().trim());

                List<HitComponent> hits = new ArrayList<>();
                for (Float splitRatio : splitRatios) {
                    hits.add(new HitComponent(stat, splitRatio, behavior));
                }

                CharacterAbilities ability = switch (type) {
                    case BASIC -> new BasicAbility(id, name, element, behavior, hits, maxUnits);
                    case SKILL -> new SkillAbility(id, name, element, behavior, hits, maxUnits);
                    case ULTIMATE -> new UltimateAbility(id, name, element, behavior, hits, maxUnits);
                    case TALENT -> new TalentAbility(id, name, element, behavior, hits, maxUnits);
                    case TECHNIQUE -> new TechniqueAbility(id, name, element, behavior, hits, maxUnits);
                    default -> null;
                };

                abilities.add(ability);
                saveAbilitiesToFile();
                updateTable();

                JOptionPane.showMessageDialog(this, "Ability added!");

                // Clear fields
                idField.setText("");
                nameField.setText("");
                splitRatioField.setText("1.0");
                maxUnitsField.setText("1");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Type:"));
        panel.add(typeBox);
        panel.add(new JLabel("Element:"));
        panel.add(elementBox);
        panel.add(new JLabel("Target Behavior:"));
        panel.add(behaviorBox);
        panel.add(new JLabel("Split Ratio:"));
        panel.add(splitRatioField);
        panel.add(new JLabel("Stat Type:"));
        panel.add(statTypeBox);
        panel.add(new JLabel("Max Units Affected:"));
        panel.add(maxUnitsField);
        panel.add(new JLabel(""));
        panel.add(saveButton);

        return panel;
    }

    private void loadAbilitiesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            abilities = (List<CharacterAbilities>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            abilities = new ArrayList<>();
        }
    }

    private void saveAbilitiesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(abilities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0); // Clear table
        for (int i = 0; i < abilities.size(); i++) {
            CharacterAbilities ability = abilities.get(i);

            final int rowIndex = i;

            // Add a row with the delete button
            tableModel.addRow(new Object[]{
                    ability.getId(),
                    ability.getClass().getSimpleName().replace("Ability", "").toUpperCase(),
                    ability.getName(),
                    ability.getElementType(),
                    ability.getTargetBehavior(),
                    ability.getMaxUnitsAffected(),
            });
        }
    }

    //No Delete Function yet because of Abstract Class complications with GUI code.

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AbilityCreatorGUI().setVisible(true);
        });
    }
}
