import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeddingRSVP {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wedding RSVP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 5, 5));

        // Color Scheme
        Color backgroundColor = new Color(173, 216, 230); // Light blue
        Color buttonColor = new Color(70, 130, 180); // Steel blue

        // Textbox (Non-editable for event details)
        JTextField eventTextBox = new JTextField("The joining of Matt and Melissa on March 22nd, 2025!");
        eventTextBox.setEditable(false);
        eventTextBox.setBackground(backgroundColor);
        eventTextBox.setHorizontalAlignment(JTextField.CENTER);
        frame.add(eventTextBox);
        frame.add(new JLabel("")); // Empty cell to balance grid

        // Your Name Label + Text Field
        frame.add(new JLabel("Your Name:"));
        JTextField nameField = new JTextField(15);
        frame.add(nameField);

        // Plus One Checkbox + Label
        JCheckBox plusOneCheckBox = new JCheckBox("Plus One");
        frame.add(plusOneCheckBox);
        JLabel plusOneLabel = new JLabel("Name of Plus One:");
        JTextField plusOneField = new JTextField(15);
        plusOneField.setEnabled(false); // Initially disabled
        frame.add(plusOneLabel);
        frame.add(plusOneField);

        // Enable Plus One Field When Checked
        plusOneCheckBox.addActionListener(e -> plusOneField.setEnabled(plusOneCheckBox.isSelected()));

        // Meal Choice Label + Radio Buttons
        frame.add(new JLabel("Meal Choice:"));
        JPanel mealPanel = new JPanel();
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
        frame.add(mealPanel);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(Color.WHITE);
        frame.add(submitButton);
        
        // Response Label
        JLabel responseLabel = new JLabel("", SwingConstants.CENTER);
        frame.add(responseLabel);

        // Submit Button Action
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String plusOne = plusOneCheckBox.isSelected() ? plusOneField.getText() : "No Plus One";
            String mealChoice = chicken.isSelected() ? "Chicken" : fish.isSelected() ? "Fish" : veggie.isSelected() ? "Veggie" : "None";

            responseLabel.setText("<html>RSVP Received!<br>" + name + " + " + plusOne + "<br>Meal: " + mealChoice + "</html>");
        });

        frame.getContentPane().setBackground(backgroundColor); // Set frame background
        frame.setVisible(true);
    }
}
