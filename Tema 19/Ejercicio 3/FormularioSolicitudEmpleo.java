import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSolicitudEmpleo extends JFrame {
    private JCheckBox certificadoJava, experienciaHelpDesk, buenCafe;
    private JRadioButton ciudadanoCumplidor, criminalViolento;
    private JComboBox<String> comboSalario;
    private JButton botonEnviar;

    public FormularioSolicitudEmpleo() {
        setTitle("Job Application Form");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel etiquetaHabilidades = new JLabel("Skills (check all that apply):");
        etiquetaHabilidades.setBounds(20, 10, 200, 20);
        add(etiquetaHabilidades);

        certificadoJava = new JCheckBox("Java Sun certified");
        certificadoJava.setBounds(20, 35, 200, 20);
        add(certificadoJava);

        experienciaHelpDesk = new JCheckBox("help-desk experience");
        experienciaHelpDesk.setBounds(20, 60, 200, 20);
        add(experienciaHelpDesk);

        buenCafe = new JCheckBox("able to make good coffee");
        buenCafe.setBounds(20, 85, 200, 20);
        add(buenCafe);

        JLabel etiquetaEstadoComunitario = new JLabel("Community standing:");
        etiquetaEstadoComunitario.setBounds(20, 110, 200, 20);
        add(etiquetaEstadoComunitario);

        ciudadanoCumplidor = new JRadioButton("law-abiding citizen");
        ciudadanoCumplidor.setBounds(20, 135, 200, 20);
        ciudadanoCumplidor.setSelected(true);
        add(ciudadanoCumplidor);

        criminalViolento = new JRadioButton("violent criminal");
        criminalViolento.setBounds(20, 160, 200, 20);
        add(criminalViolento);

        ButtonGroup grupoEstadoComunitario = new ButtonGroup();
        grupoEstadoComunitario.add(ciudadanoCumplidor);
        grupoEstadoComunitario.add(criminalViolento);

        JLabel etiquetaSalario = new JLabel("Salary requirements:");
        etiquetaSalario.setBounds(20, 185, 200, 20);
        add(etiquetaSalario);

        String[] opcionesSalario = {"$20,000-$59,000", "$60,000-$99,000", "$100,000+"};
        comboSalario = new JComboBox<>(opcionesSalario);
        comboSalario.setBounds(20, 210, 150, 20);
        add(comboSalario);

        botonEnviar = new JButton("Submit");
        botonEnviar.setBounds(180, 210, 80, 20);
        add(botonEnviar);

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluarSolicitud();
            }
        });
    }

    private void evaluarSolicitud() {
        boolean tieneHabilidad = certificadoJava.isSelected() || experienciaHelpDesk.isSelected() || buenCafe.isSelected();
        boolean esCumplidor = ciudadanoCumplidor.isSelected();
        String salarioSeleccionado = (String) comboSalario.getSelectedItem();

        if (tieneHabilidad && esCumplidor && !salarioSeleccionado.equals("$100,000+")) {
            JOptionPane.showMessageDialog(this,
                    "Thank you for your application submission.\nWe'll contact you after we process your information.",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Sorry, no jobs at this time.",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioSolicitudEmpleo formulario = new FormularioSolicitudEmpleo();
            formulario.setVisible(true);
        });
    }
}