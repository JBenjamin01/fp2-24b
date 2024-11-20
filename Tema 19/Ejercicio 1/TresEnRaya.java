import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TresEnRaya extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private boolean turnoDeX = true;

    public TresEnRaya() {
        setTitle("Juego de tres en raya");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        initializeButtons();

        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].addActionListener(new ButtonClickListener());
                add(buttons[i][j]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText().equals("")) {
                buttonClicked.setText(turnoDeX ? "X" : "O");
                turnoDeX = !turnoDeX;
            }
        }
    }

    public static void main(String[] args) {
        new TresEnRaya();
    }
}