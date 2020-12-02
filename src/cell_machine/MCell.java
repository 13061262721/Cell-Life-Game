package cell_machine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import gui.Cell;

public class MCell {
	private boolean alive = false;
	public boolean isAlive() { return alive; }
	public void setAlive() { alive = true; }
	public void setDead() { alive = false; }
	public void setState(boolean state) { alive = state; }
	public void drawSquare(Graphics g, int x, int y, int length) {
		if(alive == true) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, length, length);
			//System.out.println("fillRect\n");
		}
		else {
			g.drawRect(x, y, length, length);
		}
	}
}
