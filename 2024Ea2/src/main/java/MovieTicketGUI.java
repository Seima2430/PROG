// File: MovieTicketGUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A GUI application for processing and reporting movie ticket sales.
 */
public class MovieTicketGUI extends JFrame {
    // Declare the components we will use on the form
    private JComboBox<String> movieComboBox;
    private JTextField ticketsField;
    private JTextField priceField;
    private JTextArea reportArea;

    // Create an instance of the business logic class
    private MovieTicketsGUI ticketProcessor = new MovieTicketsGUI();

    public MovieTicketGUI() {
        // Set up the main window (JFrame)
        setTitle("MOVIE TICKETS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout(10, 10));

        // --- Create the Menu Bar (Q2.2) ---
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> exitApplication()); // Q2.3
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processTicket()); // Q2.4
        clearItem.addActionListener(e -> clearForm());       // Q2.6
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // --- Create the input panel (Q2.1) ---
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("MOVIE:"));
        String[] movies = {"Napoleon", "Oppenheimer", "Damsel"};
        movieComboBox = new JComboBox<>(movies);
        inputPanel.add(movieComboBox);

        inputPanel.add(new JLabel("NUMBER OF TICKETS:"));
        ticketsField = new JTextField();
        inputPanel.add(ticketsField);

        inputPanel.add(new JLabel("TICKET PRICE:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        // --- Create the report area (Q2.1) ---
        reportArea = new JTextArea(10, 30);
        reportArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(reportArea);

        // Add panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Exits the application (Q2.3).
     */
    private void exitApplication() {
        System.exit(0);
    }

    /**
     * Processes the ticket sale, generates the report, and saves to file (Q2.4, Q2.5).
     */
    private void processTicket() {
        try {
            // 1. Capture input from the form
            String movieName = (String) movieComboBox.getSelectedItem();
            int numberOfTickets = Integer.parseInt(ticketsField.getText());
            double ticketPrice = Double.parseDouble(priceField.getText());

            // 2. Create a data object for validation and calculation
            MovieTicketData ticketData = new MovieTicketData(movieName, numberOfTickets, ticketPrice);

            // 3. Validate the data using the MovieTickets class (Q2.7)
            if (!ticketProcessor.ValidateData(ticketData)) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please check your values.\n- All fields are required.\n- Tickets and Price must be greater than 0.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop processing if validation fails
            }

            // 4. Calculate the total price including VAT (Q2.4)
            double totalPrice = ticketProcessor.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

            // 5. Generate the report string
            String report = generateReportString(movieName, ticketPrice, numberOfTickets, totalPrice);

            // 6. Display the report in the text area
            reportArea.setText("TICKET REPORT:\n\n" + report);

            // 7. Save the report to a file (Q2.5)
            saveReportToFile(report);

        } catch (NumberFormatException ex) {
            // This catch block handles cases where the user enters non-numeric data in tickets or price fields.
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for tickets and price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Generates a formatted string for the sales report.
     */
    private String generateReportString(String movie, double price, int tickets, double total) {
        return String.format(
            "MOVIE NAME: %s%n" +
            "MOVIE TICKET PRICE: R %.2f%n" +
            "NUMBER OF TICKETS: %d%n" +
            "TOTAL TICKET PRICE: R %.2f%n",
            movie, price, tickets, total
        );
    }

    /**
     * Saves the generated report to a text file named 'report.txt' (Q2.5).
     * @param reportContent The string content of the report to be saved.
     */
    private void saveReportToFile(String reportContent) {
        // Using try-with-resources to ensure the FileWriter is closed automatically
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write("MOVIE TICKET REPORT\n");
            writer.write("******************************\n");
            writer.write(reportContent);
            writer.write("******************************\n");
            JOptionPane.showMessageDialog(this, "Report saved successfully to report.txt!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears all input fields and the report area (Q2.6).
     */
    private void clearForm() {
        movieComboBox.setSelectedIndex(0);
        ticketsField.setText("");
        priceField.setText("");
        reportArea.setText("");
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread: creating and showing the GUI.
        SwingUtilities.invokeLater(MovieTicketGUI::new);
    }

    private static class MovieTicketsGUI {

        public MovieTicketsGUI() {
        }

        private boolean ValidateData(MovieTicketData ticketData) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class MovieTicketData {

        public MovieTicketData() {
        }

        private MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}