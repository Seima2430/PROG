// Import necessary libraries for GUI and data structures
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Main class that extends JFrame to create the application window
public class HospitalInspections extends JFrame {
    // Declare all the GUI components we will need
    private JTextField hospitalNameField;
    private JTextField hospitalLocationField;
    private JComboBox<String> yearsComboBox;
    private JButton saveButton, printButton, clearButton;
    private JList<String> displayList;
    private DefaultListModel<String> listModel; // This model holds the data for the JList

    // ArrayList to store inspection details. More flexible than a standard array.
    private ArrayList<String[]> inspectionsList;
    private int inspectionCount = 0; // Counter to track the number of inspections
    private final int MAX_INSPECTIONS = 5; // Constant for the maximum allowed inspections

    // Constructor to set up the GUI
    public HospitalInspections() {
        inspectionsList = new ArrayList<>(); // Initialize the list to store inspections
        initializeGUI(); // Call method to create the form
        attachEventHandlers(); // Call method to make buttons work
    }

    // Method to create and arrange all the visual components
    private void initializeGUI() {
        // Set the title and default close operation for the main window
        setTitle("Hospital Inspections");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout for overall structure

        // ==================== Create the Menu Bar ====================
        JMenuBar menuBar = new JMenuBar();

        // Create the "File" menu and its "Exit" item
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        // Create the "Tools" menu and its items
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem printMenuItem = new JMenuItem("Print");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        toolsMenu.add(saveMenuItem);
        toolsMenu.add(printMenuItem);
        toolsMenu.add(clearMenuItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar); // Attach the menu bar to the frame

        // ==================== Create the Input Panel ====================
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5)); // Grid layout for neat alignment

        // Create labels and input fields
        inputPanel.add(new JLabel("Hospital Name:"));
        hospitalNameField = new JTextField();
        inputPanel.add(hospitalNameField);

        inputPanel.add(new JLabel("Hospital Location:"));
        hospitalLocationField = new JTextField();
        inputPanel.add(hospitalLocationField);

        inputPanel.add(new JLabel("Years since inspection:"));
        // Create combo box with options from 1 to 5 years
        String[] years = {"1 Year", "2 Years", "3 Years", "4 Years", "5 Years"};
        yearsComboBox = new JComboBox<>(years);
        inputPanel.add(yearsComboBox);

        // ==================== Create the Button Panel ====================
        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("SAVE");
        printButton = new JButton("PRINT");
        clearButton = new JButton("CLEAR");
        buttonPanel.add(saveButton);
        buttonPanel.add(printButton);
        buttonPanel.add(clearButton);

        // ==================== Create the Display Area ====================
        listModel = new DefaultListModel<>(); // Initialize the data model for the list
        displayList = new JList<>(listModel); // Create the JList with the model
        JScrollPane scrollPane = new JScrollPane(displayList); // Put the list in a scroll pane

        // ==================== Add all panels to the main frame ====================
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Finalize the window
        pack(); // Size the window to fit its contents
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible

        // ==================== Attach Menu Item Listeners ====================
        // Exit the application when the Exit menu item is clicked
        exitMenuItem.addActionListener(e -> System.exit(0));

        // Connect menu items to the same functions as the buttons
        saveMenuItem.addActionListener(e -> saveInspection());
        printMenuItem.addActionListener(e -> printInspections());
        clearMenuItem.addActionListener(e -> clearForm());
    }

    // Method to link the buttons to their corresponding actions
    private void attachEventHandlers() {
        saveButton.addActionListener(e -> saveInspection());
        printButton.addActionListener(e -> printInspections());
        clearButton.addActionListener(e -> clearForm());
    }

    // Method to save a new hospital inspection
    private void saveInspection() {
        // Check if the maximum number of inspections has been reached
        if (inspectionCount >= MAX_INSPECTIONS) {
            JOptionPane.showMessageDialog(this, "Maximum inspection count reached!", "Message", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method without saving
        }

        // Get data from the input fields
        String name = hospitalNameField.getText().trim();
        String location = hospitalLocationField.getText().trim();
        String years = (String) yearsComboBox.getSelectedItem();

        // Basic validation to ensure fields are not empty
        if (name.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Hospital Name and Location.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Save the data as a String array and add it to the ArrayList
        String[] inspection = {name, location, years};
        inspectionsList.add(inspection);
        inspectionCount++; // Increment the counter

        // Clear the input fields after saving for the next entry
        clearForm();
        JOptionPane.showMessageDialog(this, "Inspection saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to print all saved inspections to the list box
    private void printInspections() {
        listModel.clear(); // Clear the list box before displaying new data

        // Check if there are any inspections to print
        if (inspectionsList.isEmpty()) {
            listModel.addElement("No inspections to display.");
            return;
        }

        // Loop through the ArrayList and format each entry for display
        for (int i = 0; i < inspectionsList.size(); i++) {
            String[] inspection = inspectionsList.get(i);
            String displayText = String.format("Hospital Name: %s | Location: %s | Years Since Inspection: %s",
                    inspection[0], inspection[1], inspection[2]);
            listModel.addElement(displayText); // Add the formatted string to the list box
        }
    }

    // Method to clear all input fields
    private void clearForm() {
        hospitalNameField.setText("");
        hospitalLocationField.setText("");
        yearsComboBox.setSelectedIndex(0); // Reset combo box to the first item
    }

    // Main method to launch the application
    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread-safe GUI creation
        SwingUtilities.invokeLater(() -> new HospitalInspections());
    }
}