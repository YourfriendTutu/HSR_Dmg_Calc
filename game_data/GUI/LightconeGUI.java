package game_data.GUI;

import game_data.Lightcones.Lightcone;
import game_data.Lightcones.LightconeCreator;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class LightconeGUI extends JFrame {

    private JList<String> lightconeList;
    private JTextArea statsArea;
    private List<Lightcone> lightcones;
    private JLabel imageLabel;
    private JLabel nameLabel;

    public LightconeGUI() {
        setTitle("Lightcone Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize stats area (for displaying Lightcone stats)
        statsArea = new JTextArea();
        statsArea.setEditable(false);

        // Label for image and another for the name/title
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(150, 210)); // Size of the image

        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Panel to hold name and image vertically
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.add(nameLabel);
        imagePanel.add(imageLabel);

        // Right panel holds stats + image section
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JScrollPane(statsArea), BorderLayout.CENTER);
        rightPanel.add(imagePanel, BorderLayout.SOUTH); // Put it below the stats

        // Load the lightcones from the JSON file
        lightcones = LightconeCreator.loadLightcones("game_data/Lightcones/lightcone_data.json");

        // Left side list to show Lightcone names and rarity
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Lightcone lc : lightcones) {
            listModel.addElement(lc.getName() + " (" + lc.printStars() + ")");
        }

        // Create the list with the Lightcone names
        lightconeList = new JList<>(listModel);
        lightconeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add selection listener to handle stats and image updates
        lightconeList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                showStats(lightconeList.getSelectedIndex());
            }
        });

        // Set up the split pane with the list on the left and the right panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(lightconeList), rightPanel);
        splitPane.setDividerLocation(200);

        // Add the split pane to the frame
        add(splitPane);
    }

    private void showStats(int index) {
        if (index >= 0 && index < lightcones.size()) {
            Lightcone selected = lightcones.get(index);

            // Display Lightcone stats
            statsArea.setText(selected.printStats());

            // Image path
            String imagePath = selected.getImagePath();
            System.out.println("Image Path: " + imagePath);  // Debugging line

            // Check if image path is valid
            if (imagePath != null && !imagePath.isEmpty()) {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    // Load and display the image
                    ImageIcon icon = new ImageIcon(imagePath);
                    Image image = icon.getImage();
                    if (image != null) {
                        Image scaledImage = image.getScaledInstance(150, 210, Image.SCALE_SMOOTH);
                        imageLabel.setIcon(new ImageIcon(scaledImage)); // Set the image to the label
                        imageLabel.setVisible(true);  // Explicitly make the label visible
                    } else {
                        imageLabel.setText("Error loading image.");
                        imageLabel.setVisible(true);  // Ensure the label is visible
                    }
                } else {
                    imageLabel.setText("Image not found at: " + imagePath);
                    imageLabel.setVisible(true);  // Ensure the label is visible even if image not found
                }
            } else {
                imageLabel.setIcon(null); // If no image path, clear the label
                nameLabel.setText("No image available");
                imageLabel.setVisible(true);  // Ensure the label is visible
            }

            // Set the Lightcone name on the image label (optional)
            nameLabel.setText(selected.getName());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LightconeGUI gui = new LightconeGUI();
            gui.setVisible(true);
        });
    }
}


