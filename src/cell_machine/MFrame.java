package cell_machine;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;



public class MFrame extends JFrame{
	private int gridWidth = 30, gridHeight = 30;
	private MPanel gamePanel = new MPanel(gridWidth * MDeployer.GRIDSIZE, 
			gridHeight * MDeployer.GRIDSIZE);
	private MToolBar toolBar = new MToolBar();
	private MMenuBar menuBar = new MMenuBar();
	private boolean isInitial = true;
	
	
	public MFrame() {		
		
		addPanelListeners();
		addButtonListeners();
		addTextFieldListeners();
		
		setLayout(new BorderLayout());
		add(BorderLayout.WEST, toolBar);
		add(BorderLayout.CENTER, gamePanel);
		
		setJMenuBar(menuBar);
	}
	
	private void addPanelListeners() {
		gamePanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				int x= e.getX();
				int y = e.getY();
				isInitial = true;
				
				gamePanel.reverse(x, y);
				repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				System.out.println("Calling mousePressed..");
				gamePanel.saveState();
			}
			
		});
		gamePanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				super.mouseDragged(e);
				isInitial = true;
				gamePanel.setAlive(x, y);
				repaint();
			}
			
		});
	}
	private void addButtonListeners() {
		toolBar.buttons.get("下一步").addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(isInitial) {	
					gamePanel.saveState();
					isInitial = false;
				}
				gamePanel.nextStep();
				repaint();
			}
		});
		toolBar.buttons.get("清空").addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				gamePanel.clearAll();
				repaint();
			}
		});
		toolBar.buttons.get("恢复初始").addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
					gamePanel.loadState();
					isInitial = true;
					repaint();
			}
		});
	}
	private void addTextFieldListeners() {
		JTextField jf0 = toolBar.textFields.get("网格宽");
		JTextField jf1 = toolBar.textFields.get("网格高");
		
		
		jf0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				System.out.println("The width of Grid is: " + jf0.getText());
				gridWidth = Integer.valueOf(jf0.getText());
				gamePanel.setGridSize(gridHeight, gridWidth);
				repaint();
			}
		});
		jf1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				System.out.println("The height of Grid is: " + jf1.getText());
				gridHeight = Integer.valueOf(jf1.getText());
				gamePanel.setGridSize(gridHeight, gridWidth);
				repaint();
			}
		});
	}

}
