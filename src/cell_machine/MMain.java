package cell_machine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import gui.Cell;

public class MMain{
	
	
	public MMain() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MFrame frame = new MFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		//frame.setResizable(false);
		frame.setVisible(true); 
	}
}
