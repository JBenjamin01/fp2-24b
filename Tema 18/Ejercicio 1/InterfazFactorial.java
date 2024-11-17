import javax.swing.*;
import java.awt.event.*;

public class InterfazFactorial extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public InterfazFactorial() {
        setTitle("Calculadora de Factorial");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel inputLabel = new JLabel("x:");
        inputLabel.setBounds(20, 20, 20, 25);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(50, 20, 100, 25);
        add(inputField);

        JLabel factorialLabel = new JLabel("x!:");
        factorialLabel.setBounds(160, 20, 20, 25);
        add(factorialLabel);

        resultLabel = new JLabel("");
        resultLabel.setBounds(190, 20, 100, 25);
        add(resultLabel);

        JButton calculateButton = new JButton("Factorial");
        calculateButton.setBounds(100, 60, 100, 25);
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularFactorial();
            }
        });
    }

    private void calcularFactorial() {
        try {
            int n = Integer.parseInt(inputField.getText());
            if (n < 0) {
                resultLabel.setText("Indefinido");
            } else {
                resultLabel.setText(String.valueOf(factorial(n)));
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Indefinido");
        }
    }

    private long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}