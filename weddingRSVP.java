import javax.swing.*;
import java.awt.*;

public class weddingRSVP {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wedding RSVP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());

        // Color Scheme
        Color backgroundColor = new Color(173, 216, 230); // Light blue
        Color panelColor = new Color(240, 248, 255); // Alice Blue for contrast
        Color buttonColor = new Color(70, 130, 180); // Steel Blue for buttons

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(backgroundColor);
        JLabel titleLabel = new JLabel("The joining of Matt and Melissa on March 22nd, 2025!");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 14));
        headerPanel.add(titleLabel);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBackground(panelColor);
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Your Name:"));
        JTextField nameField = new JTextField(15);
        formPanel.add(nameField);

        formPanel.add(new JLabel("Plus One Name:"));
        JTextField plusOneField = new JTextField(15);
        formPanel.add(plusOneField);

        formPanel.add(new JLabel("Meal Choice:"));
        String[] meals = {"Chicken", "Fish", "Veggie"};
        JComboBox<String> mealDropdown = new JComboBox<>(meals);
        formPanel.add(mealDropdown);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(Color.WHITE);

        // Response Label
        JLabel responseLabel = new JLabel("", SwingConstants.CENTER);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String plusOne = plusOneField.getText().isEmpty() ? "No plus one" : plusOneField.getText();
            String mealChoice = (String) mealDropdown.getSelectedItem();
            responseLabel.setText("<html>RSVP received!<br>" + name + " + " + plusOne + "<br>Meal: " + mealChoice + "</html>");
        });

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(backgroundColor);
        footerPanel.add(submitButton);

        // Add Panels to Frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);
        frame.add(responseLabel, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}