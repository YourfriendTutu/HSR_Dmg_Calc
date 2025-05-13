package game_data.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

import game_data.Enemies.*;
import game_data.Utility_Classes.Enums.StatTypes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EnemyCreatorGUI extends JFrame {

    private JTable enemyTable;
    private DefaultTableModel tableModel;
    private List<Enemy> enemies;

    private static final String FILE_PATH = "game_data/Enemies/enemy_data.json";

    public EnemyCreatorGUI() {
        setTitle("Enemy Viewer and Creator");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("View Enemies", createViewPanel());
        tabbedPane.addTab("Add Enemy", createAddPanel());

        add(tabbedPane);
    }

    private JPanel createViewPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"ID", "Name", "Element", "HP", "ATK", "DEF", "Actions"};
        tableModel = new DefaultTableModel(columnNames, 0);
        enemyTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(enemyTable);

        loadEnemiesFromFile();
        updateTable(); // Update the table with enemies and delete buttons

        // Add mouse listener to handle delete clicks
        enemyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = enemyTable.rowAtPoint(evt.getPoint());
                int col = enemyTable.columnAtPoint(evt.getPoint());

                if (col == 6) { // "Actions" column index
                    Object value = tableModel.getValueAt(row, col);
                    if ("Delete".equals(value)) {
                        int option = JOptionPane.showConfirmDialog(
                                EnemyCreatorGUI.this,
                                "Are you sure you want to delete this enemy?",
                                "Confirm Deletion",
                                JOptionPane.YES_NO_OPTION
                        );
                        if (option == JOptionPane.YES_OPTION) {
                            deleteEnemy(row);
                            saveEnemiesToFile();
                            updateTable();
                            JOptionPane.showMessageDialog(EnemyCreatorGUI.this, "Enemy deleted!");
                        }
                    }
                }
            }
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createAddPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField hpField = new JTextField("1000");
        JTextField atkField = new JTextField("100");
        JTextField defField = new JTextField("50");
        JTextField spdField = new JTextField("50");
        JTextField weaknessesField = new JTextField("Physical, Quantum");

        JButton saveButton = new JButton("Add Enemy");

        saveButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                int hp = Integer.parseInt(hpField.getText().trim());
                int atk = Integer.parseInt(atkField.getText().trim());
                int def = Integer.parseInt(defField.getText().trim());
                int spd = Integer.parseInt(spdField.getText().trim());
                List<String> weaknesses = List.of(weaknessesField.getText().split(",\\s*"));

                Enemy enemy = new Enemy(id, name, hp, atk, def, spd, weaknesses);
                enemies.add(enemy);
                saveEnemiesToFile();
                updateTable();

                JOptionPane.showMessageDialog(this, "Enemy added!");

                idField.setText("");
                nameField.setText("");
                hpField.setText("1000");
                atkField.setText("100");
                defField.setText("50");
                spdField.setText("50");
                weaknessesField.setText("Physical, Quantum");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("HP:"));
        panel.add(hpField);
        panel.add(new JLabel("ATK:"));
        panel.add(atkField);
        panel.add(new JLabel("DEF:"));
        panel.add(defField);
        panel.add(new JLabel("SPD:"));
        panel.add(spdField);
        panel.add(new JLabel("Weaknesses (comma-separated):"));
        panel.add(weaknessesField);
        panel.add(new JLabel(""));
        panel.add(saveButton);

        return panel;
    }

    private void loadEnemiesFromFile() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Gson gson = new Gson();
            Enemy[] enemyArray = gson.fromJson(reader, Enemy[].class);
            enemies = new ArrayList<>(List.of(enemyArray));
        } catch (IOException e) {
            enemies = new ArrayList<>();
        }
    }

    private void saveEnemiesToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(enemies));
            System.out.println("Written updated enemy data to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Enemy enemy : enemies) {
            tableModel.addRow(new Object[]{
                    enemy.getId(),
                    enemy.getName(),
                    enemy.getWeakness(),
                    enemy.getStatValue(StatTypes.HP, Integer.class),
                    enemy.getStatValue(StatTypes.ATK, Integer.class),
                    enemy.getStatValue(StatTypes.DEF, Integer.class),
                    "Delete" // Use plain text, not JLabel
            });
        }
    }

    private void deleteEnemy(int index) {
        enemies.remove(index);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EnemyCreatorGUI().setVisible(true);
        });
    }
}
