import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartridgeUsageApp extends JFrame implements ActionListener {
    // GUI Components
    private JComboBox<String> printerComboBox, yearComboBox;
    private JButton submitButton;
    private JLabel resultLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu, toolsMenu;
    private JMenuItem exitItem, submitItem, reportItem;

    // Data storage for printer cartridge usage [Printer][Year]
    // Years: 0=2018, 1=2019, 2=2020
    private int[][] usageData = {
        {10, 35, 20}, // HP Deskjesk 650
        {15, 22, 12}, // Epson K750
        {30, 31, 33}  // Canon Z100
    };
    private String[] printers = {"HP Deskjesk 650", "Epson K750", "Canon Z100"};
    private String[] years = {"2018", "2019", "2020"};

    // Constructor to set up the GUI
    public CartridgeUsageApp() {
        setTitle("Cartridge Usage");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and add components
        add(new JLabel("Select Printer:"));
        printerComboBox = new JComboBox<>(printers);
        add(printerComboBox);

        add(new JLabel("Select Year:"));
        yearComboBox = new JComboBox<>(years);
        add(yearComboBox);

        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);
        add(submitButton);

        resultLabel = new JLabel("USAGE: ");
        add(resultLabel);

        // Menu Bar Setup
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        toolsMenu = new JMenu("Tools");

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0)); // Exit application

        submitItem = new JMenuItem("Submit");
        submitItem.addActionListener(this); // Same functionality as submit button

        reportItem = new JMenuItem("Yearly Usage Report");
        reportItem.addActionListener(this); // Will display the report

        fileMenu.add(exitItem);
        toolsMenu.add(submitItem);
        toolsMenu.add(reportItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    // Handle button clicks and menu item selections
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton || e.getSource() == submitItem) {
            // Get selected printer and year indices
            int printerIndex = printerComboBox.getSelectedIndex();
            int yearIndex = yearComboBox.getSelectedIndex();

            // Retrieve and display the usage
            int usage = usageData[printerIndex][yearIndex];
            String printer = (String) printerComboBox.getSelectedItem();
            String year = (String) yearComboBox.getSelectedItem();

            resultLabel.setText("USAGE: " + usage);
            JOptionPane.showMessageDialog(this, 
                "PRINTER: " + printer + "\nYEAR: " + year + "\nUSAGE: " + usage);
        } 
        else if (e.getSource() == reportItem) {
            // Calculate and display total usage for each printer
            StringBuilder report = new StringBuilder();
            for (int i = 0; i < printers.length; i++) {
                int total = 0;
                for (int j = 0; j < years.length; j++) {
                    total += usageData[i][j];
                }
                report.append("Total cartridge usage for ").append(printers[i])
                      .append(" is ").append(total).append("\n");
            }
            JOptionPane.showMessageDialog(this, report.toString());
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Ensures GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> new CartridgeUsageApp());
    }
}