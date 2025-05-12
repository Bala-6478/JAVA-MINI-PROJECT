import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatorpro extends JFrame implements ActionListener {
    JTextField textField;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculatorpro() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set RGB background color for the frame
        getContentPane().setBackground(new Color(180, 220, 240)); // light blue/teal

        textField = new JTextField();
        textField.setBounds(30, 40, 320, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        add(textField);

        String[] buttonLabels = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            ".", "0", "=", "+",
            "C"
        };

        JButton[] buttons = new JButton[buttonLabels.length];

        int x = 30, y = 100;
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(x, y, 70, 40);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(220, 230, 240)); // Button background
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            add(buttons[i]);

            x += 80;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
            num1 = num2 = result = 0;
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculatorpro().setVisible(true);
        });
    }
}
