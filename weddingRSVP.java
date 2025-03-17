import javax.swing.*;
import java.awt.*;

public class WeddingRSVPGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wedding RSVP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Color Scheme
        Color backgroundColor = new Color(173, 216, 230); // Light blue
        Color buttonColor = new Color(70, 130, 180); // Steel blue

        // Title Textbox (Non-editable)
        JTextField eventTextBox = new JTextField("The joining of Matt and Melissa on March 22nd, 2025!");
        eventTextBox.setEditable(false);
        eventTextBox.setBackground(backgroundColor);
        eventTextBox.setHorizontalAlignment(JTextField.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(eventTextBox, gbc);

        // Your Name Label + Text Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        frame.add(new JLabel("Your Name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        frame.add(nameField, gbc);

        // Plus One Checkbox
        gbc.gridx = 0;
        gbc.gridy = 2;
        JCheckBox plusOneCheckBox = new JCheckBox("Plus One");
        frame.add(plusOneCheckBox, gbc);

        // Name of Plus One Label + Text Field (same row)
        gbc.gridx = 1;
        JPanel plusOnePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JLabel plusOneLabel = new JLabel("Name of Plus One:");
        JTextField plusOneField = new JTextField(10);
        plusOneField.setEnabled(false); // Initially disabled
        plusOnePanel.add(plusOneLabel);
        plusOnePanel.add(plusOneField);
        frame.add(plusOnePanel, gbc);

        // Enable Plus One Field When Checked
        plusOneCheckBox.addActionListener(e -> plusOneField.setEnabled(plusOneCheckBox.isSelected()));

        // Meal Choice Label + Radio Buttons
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Meal Choice:"), gbc);

        gbc.gridx = 1;
        JPanel mealPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JRadioButton chicken = new JRadioButton("Chicken");
        JRadioButton fish = new JRadioButton("Fish");
        JRadioButton veggie = new JRadioButton("Veggie");
        ButtonGroup mealGroup = new ButtonGroup();
        mealGroup.add(chicken);
        mealGroup.add(fish);
        mealGroup.add(veggie);
        mealPanel.add(chicken);
        mealPanel.add(fish);
        mealPanel.add(veggie);
        frame.add(mealPanel, gbc);

        // Submit Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(Color.WHITE);
        frame.add(submitButton, gbc);

        // Response Label
        gbc.gridy = 5;
        JLabel responseLabel = new JLabel("", SwingConstants.CENTER);
        frame.add(responseLabel, gbc);

        // Submit Button Action
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String plusOne = plusOneCheckBox.isSelected() ? plusOneField.getText() : "No Plus One";
            String mealChoice = chicken.isSelected() ? "Chicken" : fish.isSelected() ? "Fish" : veggie.isSelected() ? "Veggie" : "None";

            responseLabel.setText("<html>RSVP Received!<br>" + name + " + " + plusOne + "<br>Meal: " + mealChoice + "</html>");
        });

        frame.getContentPane().setBackground(backgroundColor); // Set background color
        frame.setVisible(true);
    }
}

