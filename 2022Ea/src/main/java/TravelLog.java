// Import necessary libraries for GUI and File I/O
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class TravelLog extends JFrame {

    // Declare GUI components
    private JComboBox<String> startLocationCombo, endLocationCombo, travelByCombo;
    private JButton submitButton;
    private JList<String> travelLogList;
    private DefaultListModel<String> listModel;
    private final String FILE_NAME = "travel.txt"; // Name of the file to save data

    // Constructor
    public TravelLog() {
        initializeGUI();
        attachEventHandlers();
        loadFromFile(); // Load existing data when the application starts
    }

    // Method to set up the GUI
    private void initializeGUI() {
        setTitle("Travel Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ==================== Create Input Panel ====================
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        // Q.3.4: Populate combo boxes with the correct values
        String[] locations = {"Cape Town", "Durban", "Port Elizabeth"};
        String[] travelTypes = {"Airplane", "Train"};

        inputPanel.add(new JLabel("Start Location:"));
        startLocationCombo = new JComboBox<>(locations);
        inputPanel.add(startLocationCombo);

        inputPanel.add(new JLabel("End Location:"));
        endLocationCombo = new JComboBox<>(locations);
        inputPanel.add(endLocationCombo);

        inputPanel.add(new JLabel("Travel By:"));
        travelByCombo = new JComboBox<>(travelTypes);
        inputPanel.add(travelByCombo);

        submitButton = new JButton("SUBMIT");
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(submitButton);

        // ==================== Create Display List ====================
        listModel = new DefaultListModel<>();
        travelLogList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(travelLogList);

        // Add a title for the list
        JLabel logTitle = new JLabel("TRAVEL LOG");
        logTitle.setHorizontalAlignment(SwingConstants.CENTER);

        // Add components to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(logTitle, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to handle button clicks
    private void attachEventHandlers() {
        submitButton.addActionListener(e -> saveTravelInfo());
    }

    // Q.3.1 & Q.3.2: Method to capture and save travel information
    private void saveTravelInfo() {
        // Get selected values from combo boxes
        String start = (String) startLocationCombo.getSelectedItem();
        String end = (String) endLocationCombo.getSelectedItem();
        String travelBy = (String) travelByCombo.getSelectedItem();

        // Q.3.5: Validate that start and end locations are different
        if (start.equals(end)) {
            JOptionPane.showMessageDialog(this, "Destinations cannot be the same!!!", "Message", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without saving
        }

        // Format the travel entry
        String travelEntry = "Start: " + start + " | End: " + end + " | By: " + travelBy;

        // Q.3.2: Save the entry to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(travelEntry); // Append the entry to the file
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Q.3.3: Immediately update the list box with the new entry
        listModel.addElement("*********************************************************************");
        listModel.addElement("Destination 1: " + start);
        listModel.addElement("Destination 2: " + end);
        listModel.addElement("Travel By: " + travelBy);
        listModel.addElement("*********************************************************************");

        // Clear the selections for the next entry
        startLocationCombo.setSelectedIndex(0);
        endLocationCombo.setSelectedIndex(0);
        travelByCombo.setSelectedIndex(0);
    }

    // Q.3.3: Method to load data from the file and populate the list box on startup
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // If the file doesn't exist, there's nothing to load
        }

        // Use try-with-resources to ensure the reader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            // Read the file line by line and add each line to the list box
            while ((line = reader.readLine()) != null) {
                // The file stores raw data, we break it down for display.
                // A more robust system would parse the line, but for simplicity, we display sections.
                if (line.startsWith("Start:")) {
                    listModel.addElement("*********************************************************************");
                    String[] parts = line.split(" \\| ");
                    for (String part : parts) {
                        listModel.addElement(part.replace("Start: ", "Destination 1: ")
                                                .replace("End: ", "Destination 2: ")
                                                .replace("By: ", "Travel By: "));
                    }
                    listModel.addElement("*********************************************************************");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TravelLog());
    }
}