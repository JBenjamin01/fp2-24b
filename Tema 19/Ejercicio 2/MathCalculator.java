import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathCalculator extends JFrame {
    private JTextField entrada, resultadoRaiz, resultadoLogaritmo;

    public MathCalculator() {
        setTitle("Math Calculator");
        setSize(350, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Configuración de componentes
        JLabel etiquetaEntrada = new JLabel("x:");
        etiquetaEntrada.setBounds(10, 15, 20, 25);

        entrada = new JTextField();
        entrada.setBounds(40, 15, 120, 25);

        JButton botonRaiz = new JButton("sqrt x");
        botonRaiz.setBounds(185, 15, 75, 25);

        resultadoRaiz = new JTextField();
        resultadoRaiz.setBounds(270, 15, 60, 25);
        resultadoRaiz.setEditable(false);

        JButton botonLog = new JButton("log x");
        botonLog.setBounds(195, 55, 65, 25);

        resultadoLogaritmo = new JTextField();
        resultadoLogaritmo.setBounds(270, 55, 60, 25);
        resultadoLogaritmo.setEditable(false);

        add(etiquetaEntrada);
        add(entrada);
        add(botonRaiz);
        add(resultadoRaiz);
        add(botonLog);
        add(resultadoLogaritmo);

        botonRaiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(entrada.getText());
                    resultadoRaiz.setText(String.valueOf(Math.sqrt(x)));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        botonLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(entrada.getText());
                    if (x <= 0) {
                        JOptionPane.showMessageDialog(null, 
                                            "El logaritmo no está definido para valores menores o iguales a 0.");
                    } else {
                        resultadoLogaritmo.setText(String.valueOf(Math.log(x)));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MathCalculator calculadora = new MathCalculator();
            calculadora.setVisible(true);
        });
    }
}