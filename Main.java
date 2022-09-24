import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("N-Queens");
        frame.setBounds(100, 100, 300, 200);
        frame.getContentPane().setLayout(null);




        JLabel jLabel = new JLabel("Enter the size of the checkers");
        jLabel.setBounds(40, 20, 500, 14);

        JTextField textField = new JTextField();
        textField.setBounds(40, 40, 200, 20);

        JButton jButton = new JButton("OK");
        jButton.setBounds(40, 100, 100, 50);

        jButton.addActionListener(e -> {
            int n;
            try {
                n = Integer.parseInt(textField.getText());
                new ChessBoard(n);
                frame.setVisible(false);
                frame.dispose();
            } catch (NumberFormatException ignored) {
            }
        });

        frame.getContentPane().add(jLabel);
        frame.getContentPane().add(textField);
        frame.getContentPane().add(jButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
