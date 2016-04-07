import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarClass extends JMenuBar {
	
	private JMenu file;
	private JMenu edit;
	private JMenuItem Open2d;
	private JMenuItem OpenCSVFile;
	private JMenuItem exit;
	
	public MenuBarClass() {
		// TODO Auto-generated constructor stub
		super();
		JMenu file = new JMenu("File");	//Item in JmenuBar
		this.add(file);
		JMenu edit = new JMenu("Edit");
		this.add(edit);
		JMenuItem Open2d = new JMenuItem("Open 2d mode");
		edit.add(Open2d);
		JMenuItem OpenCSVFile = new JMenuItem("Open CSV File");
		edit.add(OpenCSVFile);
		JMenuItem exit = new JMenuItem("Exit       ");	//Item in Jmenu
		file.add(exit);
	}

}
