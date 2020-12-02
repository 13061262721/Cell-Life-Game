package cell_machine;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.Cell;
import gui.Deployer;

public class MDeployer {
	public static final int GRIDSIZE = 20;
	protected MCell[][] cells;
	protected int width, height;// not the pixel width/height
	private boolean[][] currentStates;
	public MDeployer(int height, int width) {
		
		this.width = width;
		this.height = height;
		cells = new MCell[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j ++){
				cells[i][j] = new MCell();
			}
		}
		currentStates = new boolean[height][width];
		for ( int row = 0; row < height; row++ ) {
			for ( int col = 0; col < width; col++ ) {
				currentStates[row][col] = false;
			}
		}
		System.out.println("This is contructor:\nWidth = " + width + "\nHeight = " + height);

	}
	public void initilize(int height, int width) {
		this.width = width;
		this.height = height;
	}
	public void setSize(int height, int width) {
		System.out.println("Calling deployer.setSize()...");
		this.width = width;
		this.height = height;
		cells = new MCell[height][width];
		currentStates = new boolean[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j ++){
				cells[i][j] = new MCell();
			}
		}
	}
	public void setCells(MCell[][] cells) {
		this.cells = cells;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public boolean[][] getState(){
		return currentStates;
	}
	public MCell getCellS(int x, int y) {// get the cell at (x, y) on screen
		return cells[y / GRIDSIZE][x / GRIDSIZE]; 
	}
	public MCell getCell(int row, int col) { return cells[row][col]; }
	public MCell[][] getCells() { return cells; }
	
	public MCell[] getNeighbors(int x, int y) {
		ArrayList<MCell> list = new ArrayList<MCell>();
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				int x1 = x + i, y1 = y + j;
				if(!(x1 < 0 || x1 >= height || y1 < 0 || y1 >= width || i == 0 & j == 0)) {
					list.add(cells[x1][y1]);
				}
			}
		}
		return list.toArray(new MCell[list.size()]);
	}
	public void paintAll(Graphics g) {
		System.out.println("Calling paintAll()");
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				cells[i][j].drawSquare(g, j * GRIDSIZE, i * GRIDSIZE, GRIDSIZE);
			}
		}
	}
	public void setAlive(int row, int col) {
		cells[row][col].setAlive();
		currentStates[row][col] = true;
	}
	public void setDead(int row, int col) {
		cells[row][col].setDead();
		currentStates[row][col] = false;
	}
	public void setAllDead() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				cells[i][j].setDead();
				currentStates[i][j] = false;
			}
		}
	}
	public void reverse(int x, int y) {
		System.out.println("Calling MDeployer.reverse(), cells[" 
			+ y/GRIDSIZE+ "][" + x/GRIDSIZE + "]");
		if(cells[y / GRIDSIZE][x / GRIDSIZE].isAlive()) {
			cells[y / GRIDSIZE][x / GRIDSIZE].setDead();
			currentStates[y / GRIDSIZE][x / GRIDSIZE] = false;
		}
		else {
			cells[y / GRIDSIZE][x / GRIDSIZE].setAlive();
			currentStates[y / GRIDSIZE][x / GRIDSIZE] = true;
		}
		
	}
}
