import java.awt.event.ActionListener;

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
		 file = new JMenu("File");	//Item in JmenuBar
		this.add(file);
		 edit = new JMenu("Edit");
		this.add(edit);
		 Open2d = new JMenuItem("Open 2d mode");
		edit.add(Open2d);
		 OpenCSVFile = new JMenuItem("Open CSV File");
		edit.add(OpenCSVFile);
		 exit = new JMenuItem("Exit       ");	//Item in Jmenu
		file.add(exit);
	}
	
	public void addActionlistenerOpen2d(ActionListener al) {
		Open2d.addActionListener(al);
	}
	
	public void addActionlistenerOpenCSVFile(ActionListener al) {
		OpenCSVFile.addActionListener(al);
	}
	
	public void addActionlistenerExit(ActionListener al) {
		exit.addActionListener(al);
	}
	
	public JMenu getFile() {
		return file;
	}

	public void setFile(JMenu file) {
		this.file = file;
	}

	public JMenu getEdit() {
		return edit;
	}

	public void setEdit(JMenu edit) {
		this.edit = edit;
	}

	public JMenuItem getOpen2d() {
		return Open2d;
	}

	public void setOpen2d(JMenuItem open2d) {
		Open2d = open2d;
	}

	public JMenuItem getOpenCSVFile() {
		return OpenCSVFile;
	}

	public void setOpenCSVFile(JMenuItem openCSVFile) {
		OpenCSVFile = openCSVFile;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}


}
