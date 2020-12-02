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
		buttons.put("�ƶ�", new JButton("�ƶ�"));
		buttons.put("ѡ��", new JButton("ѡ��"));
		buttons.put("����", new JButton("����"));
		buttons.put("��һ��", new JButton("��һ��"));
		buttons.put("��ѡ", new JButton("��ѡ"));
		buttons.put("��ʼ", new JButton("��ʼ"));
		buttons.put("��ͣ", new JButton("��ͣ"));
		buttons.put("���", new JButton("���"));
		buttons.put("�ָ���ʼ", new JButton("�ָ���ʼ"));
		textFields.put("�����", new JTextField());
		textFields.put("�����", new JTextField("30"));
		textFields.put("�����", new JTextField("30"));
		
		jl[0] = new JLabel();
		jl[1] = new JLabel();
		jl[2] = new JLabel();
		jl[0].setLayout(new GridLayout(1, 2));
		jl[0].add(new JLabel("�����", JLabel.RIGHT));
		jl[0].add(textFields.get("�����"));
		
		jl[1].setLayout(new GridLayout(1, 2));
		jl[1].add(new JLabel("�����", JLabel.RIGHT));
		jl[1].add(textFields.get("�����"));
		jl[2].setLayout(new GridLayout(1, 2));
		jl[2].add(new JLabel("�����", JLabel.RIGHT));
		jl[2].add(textFields.get("�����"));
		GridLayout grid = new GridLayout(buttons.size() + textFields.size(), 1);
		grid.setVgap(10);
		setLayout(grid);
		
		//add(buttons.get("�ƶ�"));
		add(buttons.get("ѡ��"));
		add(buttons.get("����"));
		add(buttons.get("��һ��"));
		//add(buttons.get("��ѡ"));
		//add(buttons.get("��ʼ"));
		//add(buttons.get("��ͣ"));
		add(buttons.get("���"));
		add(buttons.get("�ָ���ʼ"));	
		//add(jl[0]);
		add(jl[1]);
		add(jl[2]);
	}
	
}