import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ProductInventoryApp extends JFrame implements ActionListener {
    // GUI Components
    private JTextField idField, nameField, priceField;
    private JTextArea displayArea;
    private JButton submitButton, searchButton;

    // File path for storing products
    private final String FILE_PATH = "Products.txt";

    // Constructor to set up the GUI
    public ProductInventoryApp() {
        setTitle("Products Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input fields
        add(new JLabel("Product ID:"));
        idField = new JTextField(10);
        add(idField);

        add(new JLabel("Product Name:"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("Product Price:"));
        priceField = new JTextField(10);
        add(priceField);

        // Buttons
        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this);
        add(submitButton);

        searchButton = new JButton("SEARCH");
        searchButton.addActionListener(this);
        add(searchButton);

        // Non-editable text area for display
        displayArea = new JTextArea(15, 30);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        // Load existing products on startup
        loadProducts();

        setVisible(true);
    }

    // Load products from file and display them
    private void loadProducts() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Read three lines for each product (ID, Name, Price)
                String id = line;
                String name = reader.readLine();
                String price = reader.readLine();

                if (name != null && price != null) {
                    content.append("ID: ").append(id)
                           .append(" NAME: ").append(name)
                           .append(" PRICE: R ").append(price).append("\n");
                }
            }
        } catch (IOException e) {
            // File might not exist on first run - that's okay
        }
        displayArea.setText(content.toString());
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            saveProduct();
        } else if (e.getSource() == searchButton) {
            searchProduct();
        }
    }

    // Save new product to file
    private void saveProduct() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println(idField.getText());
            writer.println(nameField.getText());
            writer.println(priceField.getText());
            writer.flush();

            // Clear fields and reload display
            idField.setText("");
            nameField.setText("");
            priceField.setText("");
            loadProducts(); // Refresh the display

            JOptionPane.showMessageDialog(this, "Product saved successfully!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving product: " + e.getMessage());
        }
    }

    // Search for product by ID
    private void searchProduct() {
        String searchId = JOptionPane.showInputDialog(this, "Enter the Product ID");
        if (searchId == null || searchId.trim().isEmpty()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(searchId.trim())) {
                    // Found the ID, next two lines are name and price
                    String name = reader.readLine();
                    String price = reader.readLine();
                    JOptionPane.showMessageDialog(this, 
                        name + ", R " + price);
                    return;
                }
                // Skip next two lines if this isn't the matching ID
                reader.readLine(); // name
                reader.readLine(); // price
            }
            // If we get here, product wasn't found
            JOptionPane.showMessageDialog(this, "Product not found!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductInventoryApp());
    }
}