import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarClass extends JMenuBar {
	
	private JMenu file;
	private JMenu edit;
	private JMenu Parameters;
	private JMenuItem Open2d;
	
	
	  private int ddd;
	  private int rrr;
	private JCheckBoxMenuItem EpochSecTime;
	private JCheckBoxMenuItem JD0;
	private JCheckBoxMenuItem JD1;
	private JCheckBoxMenuItem posX, posY, posZ;
	private JCheckBoxMenuItem velX, velY, velZ;
	private JCheckBoxMenuItem OrbEl_SMA, OrbEl_Eccentricity, OrbEl_Inclination, OrbEl_RAAN, OrbEl_ArgOfPerigee;
	private JCheckBoxMenuItem OrbEl_MeanAnomaly, OrbEl_TrueAnomaly;
	private JCheckBoxMenuItem Access;
	private JCheckBoxMenuItem Azimuth, Elevation, Latitude, Longitude;
	
	

	private JMenuItem OpenCSVFile;
	private JMenuItem exit;
	
	public MenuBarClass() {
		// TODO Auto-generated constructor stub
		super();
		 file = new JMenu("File");	//Item in JmenuBar
		this.add(file);
		 edit = new JMenu("Edit");
		this.add(edit);
		Parameters = new JMenu("Parameters");
		this.add(Parameters);
		EpochSecTime = new JCheckBoxMenuItem("EpochSecTime");
		Parameters.add(EpochSecTime);
		
		EpochSecTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(EpochSecTime.isSelected()){
					ExcelParameters.ValidParam[0] = true;
					System.out.println("EpochSecTime is ON");
				}
				else{
					ExcelParameters.ValidParam[0] = false;
				}
			}
		});
		
		JD0 = new JCheckBoxMenuItem("JD0");
		Parameters.add(JD0);
		JD0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JD0.isSelected()){
					ExcelParameters.ValidParam[1] = true;
					System.out.println("EpochSecTime is ON");
				}
				else{
					ExcelParameters.ValidParam[1] = false;
				}
			}
		});
		
		JD1 = new JCheckBoxMenuItem("JD1");
		Parameters.add(JD1);
		JD1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JD1.isSelected()){
					ExcelParameters.ValidParam[2] = true;
					System.out.println("EpochSecTime is ON");
				}
				else{
					ExcelParameters.ValidParam[2] = false;
				}
			}
		});
		posX = new JCheckBoxMenuItem("posX");
		Parameters.add(posX);
		posX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(posX.isSelected()){
					ExcelParameters.ValidParam[3] = true;
					System.out.println("EpochSecTime is ON");
				}
				else{
					ExcelParameters.ValidParam[3] = false;
				}
			}
		});
		
		posY = new JCheckBoxMenuItem("posY");
		Parameters.add(posY);
		posZ = new JCheckBoxMenuItem("posZ");
		Parameters.add(posZ);
		velX = new JCheckBoxMenuItem("velX");
		Parameters.add(velX);
		velY = new JCheckBoxMenuItem("velY");
		Parameters.add(velY);
		velZ = new JCheckBoxMenuItem("velZ");
		Parameters.add(velZ);
		OrbEl_SMA = new JCheckBoxMenuItem("OrbEl_SMA");
		Parameters.add(OrbEl_SMA);
		OrbEl_Eccentricity = new JCheckBoxMenuItem("OrbEl_Eccentricity");
		Parameters.add(OrbEl_Eccentricity);
		OrbEl_Inclination = new JCheckBoxMenuItem("OrbEl_Inclination");
		Parameters.add(OrbEl_Inclination);
		OrbEl_RAAN = new JCheckBoxMenuItem("OrbEl_RAAN");
		Parameters.add(OrbEl_RAAN);
		OrbEl_ArgOfPerigee = new JCheckBoxMenuItem("OrbEl_ArgOfPerigee");
		Parameters.add(OrbEl_ArgOfPerigee);
		Access = new JCheckBoxMenuItem("Access");
		Parameters.add(Access);
		Azimuth = new JCheckBoxMenuItem("Azimuth");
		Parameters.add(Azimuth);
		Elevation = new JCheckBoxMenuItem("Elevation");
		Parameters.add(Elevation);


		
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
