import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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

import com.opencsv.CSVReader;


public class MainFrame extends JFrame  {
	
	private BuffImage bfImg;
	private JDesktopPane desktop;
	private JInternalFrame newWindow;
	private JPanel top;
	private int size_Main_frame_x = 900;
	private int size_Main_frame_y = 600;
	private int size_internal_Main_frame_x = size_Main_frame_x - 20;
	private int size_internal_Main_frame_y = size_Main_frame_y - size_Main_frame_y/3;
	
	private int R,G,B = 0;
	private float x_pix_size = 0;
	private float y_pix_size = 0;
	private int mid_x = 0;
	private int mid_y = 0;
	
	
	
	public MainFrame() throws InterruptedException {
		// TODO Auto-generated constructor stub
		
		JMenuBar mb = new JMenuBar();	//Menu bar 
		JMenu file = new JMenu("File");	//Item in JmenuBar
		mb.add(file);
		JMenu edit = new JMenu("Edit");
		mb.add(edit);
		JMenuItem Open2d = new JMenuItem("Open 2d mode");
		edit.add(Open2d);
		JMenuItem exit = new JMenuItem("Exit       ");	//Item in Jmenu
		file.add(exit);
			
		this.setJMenuBar(mb);
		
		desktop = new JDesktopPane();
		newWindow = new JInternalFrame(("2D Window"), true, true, true, true); //1st boolean - Resizable //2nd boolean - Closable //3rd boolean - Maximizable //4th boolean - Iconifiable 
		bfImg = new BuffImage(size_internal_Main_frame_x - 10,size_internal_Main_frame_y - 10);
		//bfImg.addScaledImage(size_internal_Main_frame_x - 15 , size_internal_Main_frame_y - 15);
		newWindow.add(bfImg);
		newWindow.setVisible(true);
		newWindow.setSize(size_internal_Main_frame_x, size_internal_Main_frame_y );
		newWindow.setMinimumSize(new Dimension(300, 240));	
		desktop.add(newWindow);
		newWindow.moveToFront();
		
		top = new JPanel(); // we can add parameters panel at the top of page
		this.add(BorderLayout.NORTH, top); 
		this.add(BorderLayout.CENTER, desktop);
		this.setSize(size_Main_frame_x,size_Main_frame_y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setLocationRelativeTo(null);
		try {
			paintOrbit();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintOrbit() throws NumberFormatException, IOException, InterruptedException{
		String csvFilename = "C:\\Users\\jacob1\\Desktop\\param\\OutFileSatAlpha.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row = null;
		int count = 0;
		x_pix_size = (float) (((float)bfImg.getImg().getWidth() / 360) - 0.1);
		y_pix_size = (float)bfImg.getImg().getHeight() / 180;
		mid_x = bfImg.getImg().getWidth() / 2;
		mid_y = bfImg.getImg().getHeight() / 2;
		boolean first = false;
		R = 255;
		int col = (R <<16) | (G << 8) | B;
		//TODO add sync on bfImg.getImg() param
		/*
		for (int i = 1; i < 303 ; i++){
			for (int j = 1 ; j < 404; j++ )
			bfImg.getImg().setRGB( i, j, col ); // check why some of my line doesn't show.	
			} 
			*/
		//bfImg.repaint();
		//bfImg.addLabel(size_internal_Main_frame_x - 2, size_internal_Main_frame_y - 40);
		
		while((row = csvReader.readNext()) != null) {
			if (first){
				count++;
				int x = Math.round(Float.valueOf(row[20]));
				int y = Math.round(Float.valueOf(row[19]));
				int x1 = Math.round(mid_x + x_pix_size * x);
				int y1 = Math.round(mid_y - y_pix_size * y );
				if (x1 > 0 && x1 <130)
					System.out.println(x1 + " " + y1);
				//synchronized (bfImg.getImg()){
				bfImg.getImg().setRGB( x1, y1, col );
				bfImg.getImg().setRGB( x1 + 1, y1 + 1, col );
				bfImg.getImg().setRGB( x1 + 2, y1 + 2, col );
			   }
			if (count == 500){
				count = 0;
				//bfImg.setFlag(true);
				//bfImg.addLabel(size_internal_Main_frame_x, size_internal_Main_frame_y);
				Thread.sleep(2000);
				//bfImg.setFlag(false);
				//bfImg.addScaledImage(size_internal_Main_frame_x, size_internal_Main_frame_y);;
				//newWindow.add(bfImg);
				//this.setVisible(true);
			}
			first = true;
		 } 
		bfImg.setFlag(true);
	}
}


/*
public class MainFrame extends JFrame  {
	
private BuffImage bfImg;
private JLabel jlb;
private JButton jbut;
private int width;
private int Height;
private int R,G,B = 0;


private float x_pix_size = 0;
private float y_pix_size = 0;

private int mid_x = 0;
private int mid_y = 0;
//private JPanel ImagePanel;

public MainFrame() throws IOException  {
	// TODO Auto-generated constructor stub
	Height = 500;
	width = 800;
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	R = 250;
	int ss = 5;
	bfImg = new BuffImage();
	this.setBounds(300, 100, width + 20, Height + 20);
	int col = (R <<16) | (G << 8) | R;
	String csvFilename = "C:\\Users\\jelzam\\Desktop\\sat\\OutFileSatAlpha.csv";
	CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
	String[] row = null;
	int count = 0;
	x_pix_size = bfImg.getImg().getWidth() / 360;
	y_pix_size = bfImg.getImg().getHeight() / 180;
	
	mid_x = bfImg.getImg().getWidth() / 2;
	mid_y = bfImg.getImg().getHeight() / 2;
	boolean first = false;
	
	while((row = csvReader.readNext()) != null) {
		if (first){
			count++;
			int x = Math.round(Float.valueOf(row[20]));
			int y = Math.round(Float.valueOf(row[19]));
			int x1 = Math.round(mid_x + x_pix_size * x);
			int y1 = Math.round(mid_y - y_pix_size * y);
			bfImg.getImg().setRGB( x1, y1, col );
		}
		if (count == 4000){
			count = 0;
			bfImg.addScaledImage(width,Height);
			this.add(bfImg);
			this.setVisible(true);
		}
		first = true;
	}
	//...
	//csvReader.close();
	
	//ImagePanel = new JPanel();
	jbut = new JButton("RePaint");
	jbut.addActionListener(new RePaintActionListener());
	
	//this.add(ImagePanel);
	
	//BufferedImage tempbuff = bfImg.getImg();

	for (int i = 0 ; i < 2000 ; i++){
		for(int j = 0 ; j < 1000 ; j++)
			bfImg.getImg().setRGB(i, j, col );
	}

	//jlb = new JLabel(new ImageIcon(bfImg.getImg().getScaledInstance(width, Height, EXIT_ON_CLOSE)));
	//jlb.setBounds(100, 200 - 150, 50, 50);
	//ImagePanel.add(jlb);


	for (int i = 0 ; i < 200 ; i++){
		for(int j = 0 ; j < 200 ; j++)
			bfImg.getImg().setRGB(i, j, col );
	} 
	
	//this.setSize(800, 500);
	
	this.setVisible(true);
	//pan.setVisible(true);
}

@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.drawImage(bfImg.getImg(), 0, 0, null);
	}

public class RePaintActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

}
*/