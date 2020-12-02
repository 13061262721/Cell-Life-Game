package cell_machine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import gui.MyPanel;

public class MPanel extends JPanel{
	private MDeployer deployer;
	private int width, height;
	private boolean[][] cellsStates;

	public MPanel(int width, int height) {
		setSize(width, height);
		this.width = getWidth();
		this.height = getHeight();
		int gridHeight = height / MDeployer.GRIDSIZE;
		int gridWidth = width / MDeployer.GRIDSIZE;
		deployer = new MDeployer(height / MDeployer.GRIDSIZE,
				width/ MDeployer.GRIDSIZE);
		cellsStates = new boolean[height / MDeployer.GRIDSIZE][width/ MDeployer.GRIDSIZE];
		
		MCell[][] cells = deployer.getCells();
		
	}
	
	
	public void reverse(int x, int y) {
		deployer.reverse(x, y);
		cellsStates[y / MDeployer.GRIDSIZE][x / MDeployer.GRIDSIZE] = 
				cellsStates[y / MDeployer.GRIDSIZE][x / MDeployer.GRIDSIZE] 
				== true ? false : true;
		
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		deployer.paintAll(g);
	}
	public void nextStep() {
		
		int gridWidth = deployer.getWidth();
		int gridHeight = deployer.getHeight();
		boolean[][] oldStates = new boolean[gridHeight][gridWidth];
		MCell[][] cells = deployer.getCells();
		for ( int row = 0; row < gridHeight; row++ ) {
			for ( int col = 0; col < gridWidth; col++ ) {
				oldStates[row][col] = cells[row][col].isAlive();
			}
		}
		for ( int row = 0; row < gridHeight; row++ ) {
			for ( int col = 0; col < gridWidth; col++ ) {
				System.out.println("oldStates[" + row + "][" + 
						col + "] = " + oldStates[row][col]);
				System.out.println("cells[" + row + "][" + 
						col + "] = " + cells[row][col].isAlive());
				MCell cell = cells[row][col];
				int cnt = 0;
				for(int i = -1; i < 2; i++) {
					for(int j = -1; j < 2; j++) {
						int x1 = row + i, y1 = col + j;
						if(!(x1 < 0 || x1 >= gridHeight || y1 < 0 
								|| y1 >= gridWidth || i == 0 && j == 0)) {
							if(oldStates[x1][y1] == true) {
								cnt++;
							}
						}
					}
				}
				if ( cell.isAlive() ) {
					if ( cnt <2 || cnt >3 ) {
						deployer.setDead(row, col);
					}
				}
				else if ( cnt == 3 ) {
					deployer.setAlive(row, col);
				}
			}
		}
		
	}
	public void clearAll() {
		deployer.setAllDead();
	}
	public void setAlive(int x, int y) {
		int gridHeight = y / MDeployer.GRIDSIZE;
		int gridWidth = x / MDeployer.GRIDSIZE;
		System.out.println("Set cells[" + gridHeight 
				+ "][" + gridWidth + "] alive\n" );
		deployer.setAlive(gridHeight, gridWidth);
		cellsStates[gridHeight][gridWidth] = true;
	}
	
	public void setGridSize(int gridHeight, int gridWidth) {
		deployer.setSize(gridHeight, gridWidth);
		cellsStates = new boolean[gridHeight][gridWidth];
	}
	
	public void saveState() {// save the current state
		System.out.println("Calling saveState()...");
		int gridHeight = deployer.getHeight();
		int gridWidth = deployer.getWidth();
		MCell[][] cells = deployer.getCells();
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridWidth; j++) {
				cellsStates[i][j] = cells[i][j].isAlive();
			}
		}
	}
	
	public void loadState() {// load the state has been saved
		int gridHeight = deployer.getHeight();
		int gridWidth = deployer.getWidth();
		MCell[][] cells = deployer.getCells();
		boolean[][] states = deployer.getState();
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridWidth; j++) {
				System.out.println("Load cells[" + i + "][" + j + "]");
				 cells[i][j].setState(cellsStates[i][j]);
				 states[i][j] = cellsStates[i][j];
			}
		}
	}
}
