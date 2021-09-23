import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
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
	public int firstPlayerId = 1;
	public int secondPlayerId = 2;
	public int firstPlayerPieces = 8;
	public int secondPlayerPieces = 8;

	public Checkers() {
		int width = 500;
		this.setSize(width + 20, width + 40);
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
					jLabelCheckers[i][j].addMouseListener(new MouseAdapter() {
						public void mouseRelease(MouseEvent evt) {
							dropCheckers(evt);
						}
					});
				}
			}

		}

		for (int i = 0; i < checkersPerRow; i++) {

			for (int j = 0; j < checkersPerCol; j++) {
				jLabelCells[i][j] = new JLabel();
				jLabelCells[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
				jLabelCells[i][j].setOpaque(true);
				jLabelCells[i][j].setLocation(i * size, j * size);
				jLabelCells[i][j].setSize(size, size);
				jLabelCells[i][j].setVisible(true);
				this.add(jLabelCells[i][j]);
			}
		}
		this.setLayout(null);
	}

	public boolean canMove(int sourceRow, int sourceCol, int destRow, int destCol) {

		if (destRow >= 0 && destRow < checkersPerRow && destCol >= 0 && destCol < checkersPerRow
				&& cellState[destRow][destCol] == 0
				&& (sourceRow + 1 == destRow && sourceCol + 1 == destCol
						|| sourceRow + 1 == destRow && sourceCol - 1 == destCol
						|| sourceRow - 1 == destRow && sourceCol + 1 == destCol
						|| sourceRow - 1 == destRow && sourceCol - 1 == destCol
						|| sourceRow + 2 == destRow && destRow + 2 == destCol
						|| cellState[destRow + 1][destCol + 1] != 0
						|| sourceRow + 2 == destRow && destRow - 2 == destCol
						|| cellState[destRow + 1][destCol - 1] != 0
						|| sourceRow - 2 == destRow && destRow + 2 == destCol
						|| cellState[destRow - 1][destCol + 1] != 0
						|| sourceRow - 2 == destRow && destRow - 2 == destCol
						|| cellState[destRow - 1][destCol - 1] != 0)) {
			return true;
		}
		return false;
	}

	public void moveChecker(int sourceRow, int sourceCol, int destRow, int destCol) {
		int secondPlayerCellState=cellState[destRow][destCol]==1 ? 2:1;
		jLabelCheckers[destRow][destCol].move(jLabelCells[sourceRow][sourceCol].getX()+size/4, jLabelCells[sourceRow][sourceCol].getY()+size/4);
		jLabelCheckers[sourceRow][sourceCol]=jLabelCheckers[destRow][destCol];
		jLabelCheckers[destRow][destCol]=null;
		jLabelCells[sourceRow][sourceCol]=jLabelCells[destRow][destCol];
		//jLabelCells[destRow][destCol]=0;
		
		if(destRow+2==sourceRow && destCol+2==sourceCol && cellState[destRow+1][destCol+1]==secondPlayerCellState) {
			
				if(cellState[destRow+1][destCol+1]==firstPlayerId) {
					firstPlayerPieces--;
				}
				else {
					secondPlayerPieces--;
				}
				cellState[destRow][destCol]=0;
				this.remove(jLabelCheckers[destRow+1][destCol=1]);
			}
		
		//---------------
		
		if(destRow+2==sourceRow && destCol-2==sourceCol && cellState[destRow+1][destCol-1]==secondPlayerCellState) {
			
				if(cellState[destRow+1][destCol-1]==firstPlayerId) {
					firstPlayerPieces--;
				}
				else {
					secondPlayerPieces--;
				}
				cellState[destRow][destCol]=0;
				this.remove(jLabelCheckers[destRow+1][destCol-1]);
			}
		//-------------------
		
		if(destRow-2==sourceRow && destCol+2==sourceCol && cellState[destRow-1][destCol+1]==secondPlayerCellState) {
			
			if(cellState[destRow-1][destCol+1]==firstPlayerId) {
				firstPlayerPieces--;
			}
			else {
				secondPlayerPieces--;
			}
			cellState[destRow][destCol]=0;
			this.remove(jLabelCheckers[destRow-1][destCol+1]);
		}
		//---------------------
		
		if(destRow-2==sourceRow && destCol-2==sourceCol && cellState[destRow-1][destCol-1]==secondPlayerCellState) {
			
			if(cellState[destRow-1][destCol-1]==firstPlayerId) {
				firstPlayerPieces--;
			}
			else {
				secondPlayerPieces--;
			}
			cellState[destRow][destCol]=0;
			this.remove(jLabelCheckers[destRow-1][destCol-1]);
		}
		}

	private void dropCheckers(MouseEvent evt) {
		Component source=evt.getComponent();
		int sourceRow=(evt.getX()+source.getX())/size;
		int sourceCol=(evt.getY()+source.getY())/size;
		int destRow=source.getX();
		int destCol=source.getY();
		if(
			cellState[destRow][destCol]==firstPlayerId &&
			canMove(destRow, destCol, sourceRow, sourceCol){
				move(destRow, destCol, sourceRow, sourceCol);
			}
				)
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
