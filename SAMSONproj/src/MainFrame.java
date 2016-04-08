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
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private int size_internal_Main_frame_y = size_Main_frame_y - size_Main_frame_y/3;
	private int size_internal_Param_frame_x = size_internal_Main_frame_x;
	private int size_internal_Param_frame_y = size_Main_frame_y - size_internal_Main_frame_y - 65;
	private int sizeOfPanelPlay_X = 100;
	private int sizeOfPanelPlay_Y = size_internal_Param_frame_y - 35;
	private File selectedCSVFile = null;
	private Boolean flagCSVFile = false;
	
	private MenuBarClass mb;
	private ParametersFrame paramFr;
	private Windows2DInternalFrame Window2d;
	private SpeedPanel speedPan;
	private Vector<ExcelParameters> exParam;
	private JFileChooser fileChooser;
	
	public MainFrame() throws InterruptedException {
		// TODO Auto-generated constructor stub	
		mb = new MenuBarClass();	//Menu bar 	
		mb.addActionlistenerOpenCSVFile(new addCSVFileActionListener());
		mb.addActionlistenerOpen2d(new ActionlistenerOpen2d() );
		
		desktop = new JDesktopPane();
		Window2d = new Windows2DInternalFrame(size_internal_Main_frame_x, size_internal_Main_frame_y);
		
		desktop.add(Window2d);
		paramFr = new ParametersFrame(sizeOfPanelPlay_X, size_internal_Main_frame_y + 1, size_internal_Param_frame_x - sizeOfPanelPlay_X, size_internal_Param_frame_y);
		desktop.add(paramFr);
		
		speedPan = new SpeedPanel(0, size_internal_Main_frame_y +1, sizeOfPanelPlay_X, sizeOfPanelPlay_Y + 35);
		speedPan.addPlayActionListener(new RunActionListener());
		speedPan.addClearActionListener(new ClearActionListener());
		speedPan.setVisible(true);
		
		this.getContentPane().add(speedPan);		
		validate();
		this.setJMenuBar(mb);
		this.setBounds(300, 100, size_Main_frame_x, size_Main_frame_y); 
		this.getContentPane().add(BorderLayout.CENTER, desktop);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		validate();
		exParam = new Vector();

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
					Window2d.getBfImg().initAllParam();
					Window2d.getBfImg().paintOrbit1(paramFr.getParamText(),exParam);
				} catch (NumberFormatException | IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(getParent());
			if (result == JFileChooser.APPROVE_OPTION) {
				selectedCSVFile = fileChooser.getSelectedFile();
				 System.out.println("Selected file: " + selectedCSVFile.getAbsolutePath());
				if (selectedCSVFile.getAbsolutePath().contains(".csv") || selectedCSVFile.getAbsolutePath().contains(".CSV")){
					Window2d.getBfImg().setCsvFilename(selectedCSVFile.getAbsolutePath());
					flagCSVFile = true;
				}
				else{
					flagCSVFile = false;
					JOptionPane.showMessageDialog(null, "You must choose only CSV File!", "InfoBox: " + "File Error", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		}
		
	}
	
}
