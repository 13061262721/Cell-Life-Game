package cell_machine;

import java.util.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MMenuBar extends JMenuBar{
	private HashMap<String, JMenu> menus = new HashMap<String, JMenu>();
	private HashMap<String, JMenuItem> fileItems = new HashMap<String, JMenuItem>();
	private HashMap<String, JMenuItem> windowItems = new HashMap<String, JMenuItem>();
	
	public MMenuBar() {
		menus.put("�ļ�", new JMenu("�ļ�"));
		menus.put("����", new JMenu("����"));
		for(JMenu jm : menus.values()) {
			add(jm);
		}
		
		fileItems.put("��", new JMenuItem("��"));
		fileItems.put("���浱ǰ����", new JMenuItem("���浱ǰ����"));
		fileItems.put("�����ʼ����", new JMenuItem("�����ʼ����"));
		fileItems.put("��ǰ�������Ϊ", new JMenuItem("��ǰ�������Ϊ"));
		fileItems.put("��ʼ�������Ϊ", new JMenuItem("��ʼ�������Ϊ"));
		windowItems.put("����ɫ", new JMenuItem("����ɫ"));
		windowItems.put("ǰ��ɫ", new JMenuItem("ǰ��ɫ"));
		
		for(JMenuItem mi : fileItems.values()) {
			menus.get("�ļ�").add(mi);
		}
		for(JMenuItem mi : windowItems.values()) {
			menus.get("����").add(mi);
		}
	}
}
