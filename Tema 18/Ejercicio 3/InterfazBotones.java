import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class InterfazBotones extends JFrame {
    public InterfazBotones() {
        setTitle("Background color chooser");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton botonStop = new JButton("Stop");
        JButton botonGo = new JButton("Go");

        botonStop.setBackground(Color.RED);
        botonStop.setForeground(Color.BLACK);
        botonStop.setBounds(50, 40, 80, 40);

        botonGo.setBackground(Color.GREEN);
        botonGo.setForeground(Color.BLACK);
        botonGo.setBounds(160, 40, 80, 40);

        add(botonStop);
        add(botonGo);

        botonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.RED);
            }
        });

        botonGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }
        });
    }
}