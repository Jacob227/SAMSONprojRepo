import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

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
	private JButton clearOrbitButt;
	
public SpeedPanel(int x, int y, int size_x, int size_y) {
	// TODO Auto-generated constructor stub
	super();
	 playButt = new JButton(new ImageIcon("ImagesAndIcons\\playIcon1.png"));
	 StopButt = new JButton(new ImageIcon("ImagesAndIcons\\StopIcon.png"));
	 PauseButt = new JButton(new ImageIcon("ImagesAndIcons\\pauseIcin.png"));
	 FastButt = new JButton(new ImageIcon("ImagesAndIcons\\Faster.png"));
	 clearDataButt = new JButton("Clear Data");
	 clearOrbitButt = new JButton("Clear Orbit");
	
	playButt.setBounds(7, 5, 37, 37);
	StopButt.setBounds(7, 47, 37, 37);	
	PauseButt.setBounds(55, 47, 37, 37);
	FastButt.setBounds(55, 5,37 , 37);
	clearDataButt.setBounds(5, 120, 90 , 25);
	clearOrbitButt.setBounds(5, 90, 90, 25);
	
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
	this.add(clearOrbitButt);
	
}

@Override
protected void paintComponent(Graphics arg0) {
	// TODO Auto-generated method stub
	super.paintComponent(arg0);
	repaint();
}

public void addPlayActionListener(ActionListener al){
	playButt.addActionListener(al);
}

public void addClearActionListener(ActionListener al){
	clearDataButt.addActionListener(al);
}

public void addStopActionListener(ActionListener al){
	StopButt.addActionListener(al);
}

public void addPauseActionListener(ActionListener al){
	PauseButt.addActionListener(al);
}

public void addNextActionListener(ActionListener al){
	FastButt.addActionListener(al);
}

public JButton getPlayButt() {
	return playButt;
}

public void setPlayButt(JButton playButt) {
	this.playButt = playButt;
}

public JButton getStopButt() {
	return StopButt;
}

public void setStopButt(JButton stopButt) {
	StopButt = stopButt;
}

public JButton getPauseButt() {
	return PauseButt;
}

public void setPauseButt(JButton pauseButt) {
	PauseButt = pauseButt;
}

public JButton getFastButt() {
	return FastButt;
}

public void setFastButt(JButton fastButt) {
	FastButt = fastButt;
}

public JButton getClearDataButt() {
	return clearDataButt;
}

public void setClearDataButt(JButton clearDataButt) {
	this.clearDataButt = clearDataButt;
}

}
