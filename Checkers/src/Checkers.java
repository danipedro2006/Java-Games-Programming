import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
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
					 
					jLabelCheckers[i][j].addMouseListener(
							new MouseAdapter() {
								public void mouseReleased(MouseEvent evt) {
							dropCheckers(evt);
						}
					}
					);
					
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
				jLabelCells[i][j].setSize(size, size);
				jLabelCells[i][j].setVisible(true);
				this.add(jLabelCells[i][j]);
			}
		}
		this.setLayout(null);
	}

	public boolean canMove(int e, int f, int i, int j
			) {
		if (i >= 0 && i < checkersPerRow 
				&& j >= 0 && j < checkersPerRow
				&& cellState[i][j] == 0
				&& 		  (e + 1 == i && f + 1 == j
						|| e + 1 == i && f - 1 == j
						|| e - 1 == i && f + 1 == j
						|| e - 1 == i && f - 1 == j
						|| e + 2 == i && f + 2 == j	&& cellState[e + 1][f + 1] != 0
						|| e + 2 == i && f - 2 == j	&& cellState[e + 1][f - 1] != 0
						|| e - 2 == i && f + 2 == j	&& cellState[e - 1][f + 1] != 0
						|| e - 2 == i && f - 2 == j	&& cellState[e - 1][f - 1] != 0)) 
		{
			return true;
		}
		return false;
	}

	public void moveChecker(int e, int f, int i, int j) {
		int secondPlayerCellState=cellState[i][j]==1 ? 2:1;
		jLabelCheckers[e][f].move(jLabelCells[i][j].getX()+size/4, jLabelCells[i][j].getY()+size/4);
		jLabelCheckers[i][j]=jLabelCheckers[e][f];
		jLabelCheckers[e][f]=null;
		 cellState[i][j]=cellState[e][f];
		 cellState[e][f]=0;
		
		if(e+2==i && f+2==j && cellState[e+1][f+1]==secondPlayerCellState) {
			
				if(cellState[e+1][f+1]==firstPlayerId) {
					firstPlayerPieces--;
				}
				else {
					secondPlayerPieces--;
				}
				cellState[e+1][f+1]=0;
				this.remove(jLabelCheckers[e+1][f+1]);
			}
		
		
		if(e+2==i && f-2==j && cellState[e+1][f-1]==secondPlayerCellState) {
			
				if(cellState[e+1][f-1]==firstPlayerId) {
					firstPlayerPieces--;
				}
				else {
					secondPlayerPieces--;
				}
				cellState[e+1][f-1]=0;
				this.remove(jLabelCheckers[e+1][f-1]);
			}
		
		if(e-2==i && f+2==j && cellState[e-1][f+1]==secondPlayerCellState) {
			
			if(cellState[e-1][f+1]==firstPlayerId) {
				firstPlayerPieces--;
			}
			else {
				secondPlayerPieces--;
			}
			cellState[e-1][f+1]=0;
			this.remove(jLabelCheckers[i-1][j+1]);
		}
		
		if(e-2==i && f-2==j && cellState[e-1][f-1]==secondPlayerCellState) {
			
			if(cellState[e-1][f-1]==firstPlayerId) {
				firstPlayerPieces--;
			}
			else {
				secondPlayerPieces--;
			}
			cellState[e-1][f-1]=0;
			this.remove(jLabelCheckers[i-1][j-1]);
		}
		}

	private void dropCheckers(MouseEvent evt) {
		Component source=evt.getComponent();
		int i=(evt.getX()+source.getX())/size;
		int j=(evt.getY()+source.getY())/size;
		int e=source.getX()/size;
		int f=source.getY()/size;
		
		if(cellState[e][f]==firstPlayerId && canMove(e, f, i, j))
			{
			moveChecker(e, f, i, j);
			  if(secondPlayerPieces==0) { 
				  JOptionPane.showMessageDialog(null, "Ai castigat!","Jocul s-a terminat",JOptionPane.INFORMATION_MESSAGE); 
				  }
			 		 System.exit(0);
			}
		
		int moveDirections[][]= {{-1,-1},{-1,+1},{+1,-1},{+1,+1},{-2,-2},{-2,+2},{+2,-2},{+2,+2}};
		Vector<CheckersMove> moves=new Vector<CheckersMove>();
		for(int m=0;m<checkersPerRow;m++) {
			for(int n=0;n<checkersPerCol;n++) {
				if (cellState[m][n]==secondPlayerId) {
					for(int k=0;k<moveDirections.length;k++) {
						if (canMove(m,n,m+moveDirections[k][0],n+moveDirections[k][1])) {
							CheckersMove move=new CheckersMove();
							move.srcX=m;
							move.srcY=n;
							move.destX=m+moveDirections[k][0];
							move.destY=n+moveDirections[k][1];
							moves.add(move);
							
						}
					}
				}
			}
		}
		
		CheckersMove selectedMove=moves.get((int)(Math.random()*moves.size()));
		moveChecker(selectedMove.srcX,selectedMove.srcY,selectedMove.destX,selectedMove.destY);
		if(firstPlayerPieces==0) {
			JOptionPane.showMessageDialog(null, "Ai pierdut!","Jocul s-a terminat", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
				repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	

	public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Checkers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkers().setVisible(true);
            }
        });
    }
}
