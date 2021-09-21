import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Checkers extends JFrame implements MouseListener {

	public JLabel[][] jLabelCells;
	public JLabel[][] jLabelCheckers;
	public int[][] cellState;
	public int checkersPerRow = 8;
	public int checkersPerCol = 8;
	public int size;
	public int firstPlayer = 1;
	public int secondPlayer = 2;
	public int firstPlayerPieces = 8;
	public int secondPlayerPieces = 8;


	public Checkers() {
		int width = 500;
		this.setSize(width+20, width+40);
		this.setResizable(false);
		this.setTitle("Checkers");
		this.setLocationRelativeTo(null);
		size = width / checkersPerRow;

		jLabelCells = new JLabel[checkersPerRow][checkersPerCol];
		jLabelCheckers = new JLabel[checkersPerRow][checkersPerCol];
		cellState = new int[checkersPerRow][checkersPerCol];

		for (int i = 0; i < checkersPerRow; i++) {

			for (int j = 0; j < checkersPerCol; j++) {

				boolean isPlayer1 = j <= 1 && ((i + j) % 2 == 0);
				boolean isPlayer2 = j >= 6 && ((i + j) % 2 == 0);

				if (isPlayer1) {

					cellState[i][j] = 1;
				}

				else if (isPlayer2) {

					cellState[i][j] = 2;
				}

				else {
					cellState[i][j] = 0;
				}

				if (isPlayer1 || isPlayer2) {

					Color color = isPlayer1 ? Color.RED : Color.BLUE;

					jLabelCheckers[i][j] = new JLabel();
					jLabelCheckers[i][j].setOpaque(false);
					jLabelCheckers[i][j].setLocation(i * size + size / 4, j * size + size / 4);
					jLabelCheckers[i][j].setSize(size / 2, size / 2);
					jLabelCheckers[i][j].setVisible(true);

					LineBorder line = new LineBorder(color, 100, true);
					jLabelCheckers[i][j].setBorder(line);
					this.add(jLabelCheckers[i][j]);
				}
			}

		}

		for (int i = 0; i < checkersPerRow; i++) {

			for (int j = 0; j < checkersPerCol; j++) {
				jLabelCells[i][j] = new JLabel();
				jLabelCells[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
				jLabelCells[i][j].setOpaque(true);
				jLabelCells[i][j].setLocation(i * size, j * size);
				jLabelCells[i][j].setSize(size,size);
				jLabelCells[i][j].setVisible(true);
				this.add(jLabelCells[i][j]);
			}
		}
		this.setLayout(null);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Checkers().setVisible(true);
	}
}
