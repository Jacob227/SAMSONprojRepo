import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SpeedPanel extends JPanel {
	
	private JButton playButt;
	private JButton StopButt;
	private JButton PauseButt;
	private JButton FastButt ;
	private JButton clearDataButt;
	
public SpeedPanel(int x, int y, int size_x, int size_y) {
	// TODO Auto-generated constructor stub
	super();
	 playButt = new JButton(new ImageIcon("ImagesAndIcons\\playIcon1.png"));
	 StopButt = new JButton(new ImageIcon("ImagesAndIcons\\StopIcon.png"));
	 PauseButt = new JButton(new ImageIcon("ImagesAndIcons\\pauseIcin.png"));
	 FastButt = new JButton(new ImageIcon("ImagesAndIcons\\Faster.png"));
	 clearDataButt = new JButton("Clear All");
	
	playButt.setBounds(7, 15, 37, 37);
	StopButt.setBounds(7, 60, 37, 37);	
	PauseButt.setBounds(55, 15, 37, 37);
	FastButt.setBounds(55, 60,37 , 37);
	clearDataButt.setBounds(5, 120, 90 , 25);
	
	Border blackline = BorderFactory.createLineBorder(Color.black);
	this.setLayout(null);
	this.setBounds(x, y, size_x, size_y);
	this.setBackground(Color.lightGray);
	this.setBorder(blackline);
	
	this.add(playButt);
	this.add(StopButt);
	this.add(PauseButt);
	this.add(FastButt);
	this.add(clearDataButt);
	
}

@Override
protected void paintComponent(Graphics arg0) {
	// TODO Auto-generated method stub
	super.paintComponent(arg0);
	repaint();
}


}
