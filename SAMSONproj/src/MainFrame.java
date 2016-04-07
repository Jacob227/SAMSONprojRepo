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
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import com.opencsv.CSVReader;


public class MainFrame extends JFrame  {
	
	//private BuffImage bfImg;
	private JDesktopPane desktop;
	//private JInternalFrame Window2d;
	//private JInternalFrame paramWindow;
	private JPanel top;
	//private JTextArea paramText;
	//private JScrollPane scroller1;
	
	private int size_Main_frame_x = 1000;
	private int size_Main_frame_y = 750;
	private int size_internal_Main_frame_x = size_Main_frame_x - 20;
	private int size_internal_Main_frame_y = size_Main_frame_y - size_Main_frame_y/3;
	private int size_internal_Param_frame_x = size_internal_Main_frame_x;
	private int size_internal_Param_frame_y = size_Main_frame_y - size_internal_Main_frame_y - 65;
	private int sizeOfPanelPlay_X = 100;
	private int sizeOfPanelPlay_Y = size_internal_Param_frame_y - 35;
	
	private MenuBarClass mb;
	private ParametersFrame paramFr;
	private Windows2DInternalFrame Window2d;
	private SpeedPanel speedPan;
	private Vector<ExcelParameters> exParam;
	//private String csvFilename= "C:\\Users\\jacob1\\Desktop\\param\\OutFileSatAlpha.csv";
	
	public MainFrame() throws InterruptedException {
		// TODO Auto-generated constructor stub		
		mb = new MenuBarClass();	//Menu bar 	
		desktop = new JDesktopPane();
		Window2d = new Windows2DInternalFrame(size_internal_Main_frame_x, size_internal_Main_frame_y);
		desktop.add(Window2d);
		paramFr = new ParametersFrame(sizeOfPanelPlay_X, size_internal_Main_frame_y + 1, size_internal_Param_frame_x - sizeOfPanelPlay_X, size_internal_Param_frame_y);
		desktop.add(paramFr);
		speedPan = new SpeedPanel(0, size_internal_Main_frame_y +1, sizeOfPanelPlay_X, sizeOfPanelPlay_Y + 35);
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
		try {
			Window2d.getBfImg().initAllParam();
			Window2d.getBfImg().paintOrbit1(paramFr.getParamText(),exParam);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
