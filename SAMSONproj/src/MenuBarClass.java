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
		posY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(posY.isSelected()){
					ExcelParameters.ValidParam[4] = true;
					System.out.println("EpochSecTime is ON");
				}
				else{
					ExcelParameters.ValidParam[4] = false;
				}
			}
		});
		posZ = new JCheckBoxMenuItem("posZ");
		Parameters.add(posZ);
		posZ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(posZ.isSelected()){
					ExcelParameters.ValidParam[5] = true;
					System.out.println("posZ is ON");
				}
				else{
					ExcelParameters.ValidParam[5] = false;
				}	
			}
		});
		velX = new JCheckBoxMenuItem("velX");
		Parameters.add(velX);
		velX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(velX.isSelected()){
					ExcelParameters.ValidParam[6] = true;
					System.out.println("velX is ON");
				}
				else{
					ExcelParameters.ValidParam[6] = false;
				}	
			}
		});
		velY = new JCheckBoxMenuItem("velY");
		Parameters.add(velY);
		velY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(velY.isSelected()){
					ExcelParameters.ValidParam[7] = true;
					System.out.println("velY is ON");
				}
				else{
					ExcelParameters.ValidParam[7] = false;
				}	
			}
		});
		velZ = new JCheckBoxMenuItem("velZ");
		Parameters.add(velZ);
		velZ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(velZ.isSelected()){
					ExcelParameters.ValidParam[8] = true;
					System.out.println("velZ is ON");
				}
				else{
					ExcelParameters.ValidParam[8] = false;
				}	
			}
		});
		OrbEl_SMA = new JCheckBoxMenuItem("OrbEl_SMA");
		Parameters.add(OrbEl_SMA);
		OrbEl_SMA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_SMA.isSelected()){
					ExcelParameters.ValidParam[9] = true;
					System.out.println("OrbEl_SMA is ON");
				}
				else{
					ExcelParameters.ValidParam[9] = false;
				}	
			}
		});
		OrbEl_Eccentricity = new JCheckBoxMenuItem("OrbEl_Eccentricity");
		Parameters.add(OrbEl_Eccentricity);
		OrbEl_Eccentricity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_Eccentricity.isSelected()){
					ExcelParameters.ValidParam[10] = true;
					System.out.println("OrbEl_Eccentricity is ON");
				}
				else{
					ExcelParameters.ValidParam[10] = false;
				}	
			}
		});
		OrbEl_Inclination = new JCheckBoxMenuItem("OrbEl_Inclination");
		Parameters.add(OrbEl_Inclination);
		OrbEl_Inclination.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_Inclination.isSelected()){
					ExcelParameters.ValidParam[11] = true;
					System.out.println("OrbEl_Inclination is ON");
				}
				else{
					ExcelParameters.ValidParam[11] = false;
				}	
			}
		});
		OrbEl_RAAN = new JCheckBoxMenuItem("OrbEl_RAAN");
		Parameters.add(OrbEl_RAAN);
		OrbEl_RAAN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_RAAN.isSelected()){
					ExcelParameters.ValidParam[12] = true;
					System.out.println("OrbEl_RAAN is ON");
				}
				else{
					ExcelParameters.ValidParam[12] = false;
				}	
			}
		});
		OrbEl_ArgOfPerigee = new JCheckBoxMenuItem("OrbEl_ArgOfPerigee");
		Parameters.add(OrbEl_ArgOfPerigee);
		OrbEl_ArgOfPerigee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_ArgOfPerigee.isSelected()){
					ExcelParameters.ValidParam[13] = true;
					System.out.println("OrbEl_ArgOfPerigee is ON");
				}
				else{
					ExcelParameters.ValidParam[13] = false;
				}	
			}
		});
		
		OrbEl_MeanAnomaly = new JCheckBoxMenuItem("OrbEl MeanAnomaly");
		Parameters.add(OrbEl_MeanAnomaly);
		OrbEl_MeanAnomaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_MeanAnomaly.isSelected()){
					ExcelParameters.ValidParam[14] = true;
					System.out.println("OrbEl_MeanAnomaly is ON");
				}
				else{
					ExcelParameters.ValidParam[14] = false;
				}	
			}
		});
		
		OrbEl_TrueAnomaly = new JCheckBoxMenuItem("OrbEl_TrueAnomaly");
		Parameters.add(OrbEl_TrueAnomaly);
		OrbEl_TrueAnomaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(OrbEl_TrueAnomaly.isSelected()){
					ExcelParameters.ValidParam[15] = true;
					System.out.println("OrbEl_TrueAnomaly is ON");
				}
				else{
					ExcelParameters.ValidParam[15] = false;
				}	
			}
		});
		Access = new JCheckBoxMenuItem("Access");
		Parameters.add(Access);
		Access.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Access.isSelected()){
					ExcelParameters.ValidParam[16] = true;
					System.out.println("Access is ON");
				}
				else{
					ExcelParameters.ValidParam[16] = false;
				}	
			}
		});
		Azimuth = new JCheckBoxMenuItem("Azimuth");
		Parameters.add(Azimuth);
		Azimuth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Azimuth.isSelected()){
					ExcelParameters.ValidParam[17] = true;
					System.out.println("Azimuth is ON");
				}
				else{
					ExcelParameters.ValidParam[17] = false;
				}	
			}
		});
		Elevation = new JCheckBoxMenuItem("Elevation");
		Parameters.add(Elevation);
		Elevation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Elevation.isSelected()){
					ExcelParameters.ValidParam[18] = true;
					System.out.println("Elevation is ON");
				}
				else{
					ExcelParameters.ValidParam[18] = false;
				}
			}
		});


		
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
