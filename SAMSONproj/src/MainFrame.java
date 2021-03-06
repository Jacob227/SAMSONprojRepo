import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import com.opencsv.CSVReader;


public class MainFrame extends JFrame  {
	
	private JDesktopPane desktop;
	private JPanel top;

	private int size_Main_frame_x = 900;
	private int size_Main_frame_y = 650;
	private int size_internal_Main_frame_x = size_Main_frame_x - 20;
	private int size_internal_Main_frame_y = size_Main_frame_y - size_Main_frame_y/2 + 60;
	private int size_internal_Param_frame_x = size_internal_Main_frame_x;
	private int size_internal_Param_frame_y = size_Main_frame_y - size_internal_Main_frame_y - 98;
	private File[] selectedCSVFile;
	private Boolean flagCSVFile = false;
	private ArrayList<String> csvFile;
	
	private MenuBarClass mb;
	private ParametersFrame paramFr;
	private Windows2DInternalFrame Window2d;
	private JFileChooser fileChooser;
	private ToolBarMenu toolbar;
	
	public MainFrame() throws InterruptedException {
		// TODO Auto-generated constructor stub	
		mb = new MenuBarClass();	//Menu bar 	
		mb.addActionlistenerOpenCSVFile(new addCSVFileActionListener());
		mb.addActionlistenerOpen2d(new ActionlistenerOpen2d() );
		mb.addActionlistenerExit(new ActionlistenerExit());

		toolbar = new ToolBarMenu();
		toolbar.setRollover(true);
		toolbar.addPlayActionListener(new RunActionListener());
		toolbar.addStopActionListener(new stopActionListener());
		toolbar.addPauseActionListener(new pauseActionListener());
		toolbar.addNextActionListener(new nextActionListener());
		toolbar.addClearActionListener(new ClearActionListener());
		toolbar.addallOrbitCheckBoxActionListener(new allOrbitCheckBoxActionListener());
		toolbar.addSat1CheckBoxActionListener(new Sat1CheckBoxActionListener());
		toolbar.addSat2CheckBoxActionListener(new Sat2CheckBoxActionListener());
		toolbar.addSat3CheckBoxActionListener(new Sat3CheckBoxActionListener());
		toolbar.addForwardActionListener(new ForwardActionListener());
		toolbar.addBackwardActionListener(new BackwardActionListener());
		this.getContentPane().add(toolbar, BorderLayout.NORTH);
		
		desktop = new JDesktopPane();
		Window2d = new Windows2DInternalFrame(size_internal_Main_frame_x, size_internal_Main_frame_y);
		
		desktop.add(Window2d);
		paramFr = new ParametersFrame(0, size_internal_Main_frame_y + 1, size_internal_Param_frame_x , size_internal_Param_frame_y);
		desktop.add(paramFr);
				
		validate();
		this.setJMenuBar(mb);
		this.setBounds(300, 70, size_Main_frame_x, size_Main_frame_y); 
		this.getContentPane().add(BorderLayout.CENTER, desktop);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		validate();

	}
	
	
	public class allOrbitCheckBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
			if(toolbar.getAllOrbitCheckBox().isSelected())
				Window2d.getBfImg().prevOrbits();
			else{
				Window2d.getBfImg().clearOrbit();
			}
		}
		
	}
	
	public class Sat1CheckBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(Window2d.getBfImg().getActiveSatellite(0) != null){
				if(toolbar.getSat1CheckBox().isSelected())			
					Window2d.getBfImg().setActiveSatellite(0);
				else
					Window2d.getBfImg().setUnActiveSatellite(0);
			}
			else{
				JOptionPane.showMessageDialog(null, "You must insert CSV file for this Satellite.", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class Sat2CheckBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(Window2d.getBfImg().getActiveSatellite(1) != null){
				if(toolbar.getSat2CheckBox().isSelected())
					Window2d.getBfImg().setActiveSatellite(1);
				else
					Window2d.getBfImg().setUnActiveSatellite(1);
			}
			else{
				JOptionPane.showMessageDialog(null, "You must insert CSV file for this Satellite.", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class Sat3CheckBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(Window2d.getBfImg().getActiveSatellite(2) != null){
				if(toolbar.getSat3CheckBox().isSelected())
					Window2d.getBfImg().setActiveSatellite(2);
				else
					Window2d.getBfImg().setUnActiveSatellite(2);
			}
			else{
				JOptionPane.showMessageDialog(null, "You must insert CSV file for this Satellite.", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class BackwardActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(flagCSVFile){
					Window2d.getBfImg().setBackwardSat(3);		
				}
			else{
				JOptionPane.showMessageDialog(null, "Insert CSV file first!\nEdit -> Open CSV File", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public class ForwardActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(flagCSVFile){
					Window2d.getBfImg().setForwardSat(3);		
				}
			else{
				JOptionPane.showMessageDialog(null, "Insert CSV file first!\nEdit -> Open CSV File", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public class ActionlistenerExit implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(1);
		}
	}
	
	public class ActionlistenerOpen2d implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (Window2d.getFlagExit() == true){
				Window2d.setClosable(true);
				Window2d = new Windows2DInternalFrame(size_internal_Main_frame_x, size_internal_Main_frame_y);
				desktop.add(Window2d);
			}
			else{
				JOptionPane.showMessageDialog(null, "2D Windows is already open", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}
	
	public class ClearOrbitActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Window2d.getBfImg().clearOrbit();
		}
	}
	
	public class ClearActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			paramFr.getParamText().setText("");
		}	
	}
	
	public class RunActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(flagCSVFile){
				try {
					initAllcheckBoxes();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			else{
				JOptionPane.showMessageDialog(null, "Insert CSV file first!\nEdit -> Open CSV File", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		public void initAllcheckBoxes() throws FileNotFoundException{
			if(!Window2d.getBfImg().getflagStartOverOrContinue())
			{
				if(toolbar.getAllOrbitCheckBox().isSelected())	//TODO
					Window2d.getBfImg().prevOrbits();
			
				else{
					Window2d.getBfImg().clearOrbit();
				}
			}
			
			if (toolbar.getSat1CheckBox().isSelected() || toolbar.getSat2CheckBox().isSelected()
					|| toolbar.getSat3CheckBox().isSelected())	//satellite Alpha selected
				Window2d.getBfImg().startNewSimulation(); 
			else{
				JOptionPane.showMessageDialog(null, "You have to choose a satellite before starting simulation", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public class stopActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(flagCSVFile){
					Window2d.getBfImg().StopAndInitOrbit();
					//Window2d.getBfImg().repaint();
				}
			else{
				JOptionPane.showMessageDialog(null, "Insert CSV file first!\nEdit -> Open CSV File", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class pauseActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(flagCSVFile){
				Window2d.getBfImg().puasePaintOrbit();
				}
			else{
				JOptionPane.showMessageDialog(null, "Insert CSV file first!\nEdit -> Open CSV File", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public class nextActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(flagCSVFile){
				Window2d.getBfImg().nextPaintOrbit();
				}
			else{
				JOptionPane.showMessageDialog(null, "Insert CSV file first!\nEdit -> Open CSV File", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}
	
	public class addCSVFileActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fileChooser = new JFileChooser("Open CSV File");
			fileChooser.setMultiSelectionEnabled(true);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(getParent());
			if (result == JFileChooser.APPROVE_OPTION) {
				selectedCSVFile = fileChooser.getSelectedFiles();
				 System.out.println("Selected file: " + selectedCSVFile[0].getAbsolutePath());
				 for (int i = 0; i < selectedCSVFile.length; i++){
					 String tempLowCase = selectedCSVFile[i].getAbsolutePath().toLowerCase();  //only for checking without any combination
					 if (tempLowCase.contains(".csv"))
					 {	
						 
						if (tempLowCase.contains("satalpha")) {
							System.out.println("Satellite: " +tempLowCase );							
							try {
								Window2d.getBfImg().ConversExcel(selectedCSVFile[i].getAbsolutePath(),0,"ImagesAndIcons\\sat_icon_Alpha.png","ImagesAndIcons\\R-on.png","ImagesAndIcons\\R-off.png",paramFr.getParamText(),"Alpha");
								if(toolbar.getSat1CheckBox().isSelected())
									Window2d.getBfImg().setActiveSatellite(0);
								
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
						
						if (tempLowCase.contains("satbeta")) {
							System.out.println("Satellite: " +tempLowCase );							
							try {
								Window2d.getBfImg().ConversExcel(selectedCSVFile[i].getAbsolutePath(),1,"ImagesAndIcons\\sat_icon_Beta.png","ImagesAndIcons\\yellowOn.png","ImagesAndIcons\\yellowOff.png",paramFr.getParamText(),"Beta");
								if(toolbar.getSat2CheckBox().isSelected())
									Window2d.getBfImg().setActiveSatellite(1);
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
						if (tempLowCase.contains("satgamma")) {
							System.out.println("Satellite: " +tempLowCase );
							try {
								Window2d.getBfImg().ConversExcel(selectedCSVFile[i].getAbsolutePath(),2,"ImagesAndIcons\\sat_icon_Gamma.png","ImagesAndIcons\\greenOn.png","ImagesAndIcons\\greenOff.png",paramFr.getParamText(),"Gamma");
								if(toolbar.getSat3CheckBox().isSelected())
									Window2d.getBfImg().setActiveSatellite(2);
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					 }

					 else{
						flagCSVFile = false;
						JOptionPane.showMessageDialog(null, "You must choose only CSV File!", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
						}
				 }
				 
					flagCSVFile = true;
				}

			}		
		}
	
}
