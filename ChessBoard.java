import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChessBoard {

JFrame frame;
JPanel squares[][];
int solution = 1;
public ChessBoard(int n) {
    squares = new JPanel[n][n];

    frame = new JFrame("N-Queens");
    frame.setSize(800, 900);
    GridLayout gridLayout = new GridLayout(n, n);
    frame.setLayout(new BorderLayout());

    JPanel mainPanel = new JPanel(gridLayout);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            squares[i][j] = new JPanel();

            if ((i + j) % 2 == 0) {
                squares[i][j].setBackground(Color.gray);
            } else {
                squares[i][j].setBackground(Color.white);
            }
            mainPanel.add(squares[i][j]);
        }
    }

    List<List<Integer>> nQueenBoard = NQueen.nQueen(n);

    if(nQueenBoard.size() > 0) {
        for (int i = 0; i < n; i++) {
            squares[i][nQueenBoard.get(0).get(i) - 1].add(new JLabel(new ImageIcon("image/Queen_black.png")));
        }
    }

    JButton nextSolutionButton = new JButton("Next solution");
    nextSolutionButton.addActionListener(e -> {
        if (nQueenBoard.size() > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    squares[i][j].removeAll();
                    squares[i][j].revalidate();
                    squares[i][j].repaint();
                }
            }


            for (int i = 0; i < n; i++) {
                squares[i][nQueenBoard.get(solution % nQueenBoard.size()).get(i)-1].add(new JLabel(new ImageIcon("image/Queen_black.png")));
            }
            frame.revalidate();
            solution++;
        }
    });

    frame.add(nextSolutionButton, BorderLayout.SOUTH);
    frame.add(mainPanel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

}