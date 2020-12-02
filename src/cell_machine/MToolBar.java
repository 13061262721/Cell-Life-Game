package cell_machine;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MToolBar extends JPanel{	
	private JTextField probability = new JTextField();
	private JTextField winWidth = new JTextField();
	private JTextField winHeight = new JTextField();
	public HashMap<String, JButton> buttons = new HashMap<String, JButton>();
	public HashMap<String, JTextField> textFields = new HashMap<String, JTextField>();
	public JLabel[] jl = new JLabel[3];
	public MToolBar() {
		buttons.put("移动", new JButton("移动"));
		buttons.put("选择", new JButton("选择"));
		buttons.put("画笔", new JButton("画笔"));
		buttons.put("下一步", new JButton("下一步"));
		buttons.put("框选", new JButton("框选"));
		buttons.put("开始", new JButton("开始"));
		buttons.put("暂停", new JButton("暂停"));
		buttons.put("清空", new JButton("清空"));
		buttons.put("恢复初始", new JButton("恢复初始"));
		textFields.put("存活率", new JTextField());
		textFields.put("网格宽", new JTextField("30"));
		textFields.put("网格高", new JTextField("30"));
		
		jl[0] = new JLabel();
		jl[1] = new JLabel();
		jl[2] = new JLabel();
		jl[0].setLayout(new GridLayout(1, 2));
		jl[0].add(new JLabel("存活率", JLabel.RIGHT));
		jl[0].add(textFields.get("存活率"));
		
		jl[1].setLayout(new GridLayout(1, 2));
		jl[1].add(new JLabel("网格宽", JLabel.RIGHT));
		jl[1].add(textFields.get("网格宽"));
		jl[2].setLayout(new GridLayout(1, 2));
		jl[2].add(new JLabel("网格高", JLabel.RIGHT));
		jl[2].add(textFields.get("网格高"));
		GridLayout grid = new GridLayout(buttons.size() + textFields.size(), 1);
		grid.setVgap(10);
		setLayout(grid);
		
		//add(buttons.get("移动"));
		add(buttons.get("选择"));
		add(buttons.get("画笔"));
		add(buttons.get("下一步"));
		//add(buttons.get("框选"));
		//add(buttons.get("开始"));
		//add(buttons.get("暂停"));
		add(buttons.get("清空"));
		add(buttons.get("恢复初始"));	
		//add(jl[0]);
		add(jl[1]);
		add(jl[2]);
	}
	
}
