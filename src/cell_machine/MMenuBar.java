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
		menus.put("文件", new JMenu("文件"));
		menus.put("窗口", new JMenu("窗口"));
		for(JMenu jm : menus.values()) {
			add(jm);
		}
		
		fileItems.put("打开", new JMenuItem("打开"));
		fileItems.put("保存当前界面", new JMenuItem("保存当前界面"));
		fileItems.put("保存初始界面", new JMenuItem("保存初始界面"));
		fileItems.put("当前界面另存为", new JMenuItem("当前界面另存为"));
		fileItems.put("初始界面另存为", new JMenuItem("初始界面另存为"));
		windowItems.put("背景色", new JMenuItem("背景色"));
		windowItems.put("前景色", new JMenuItem("前景色"));
		
		for(JMenuItem mi : fileItems.values()) {
			menus.get("文件").add(mi);
		}
		for(JMenuItem mi : windowItems.values()) {
			menus.get("窗口").add(mi);
		}
	}
}
