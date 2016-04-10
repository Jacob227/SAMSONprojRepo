import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class ToolBarMenu extends JToolBar {
	
	private JButton playButt;
	private JButton StopButt;
	private JButton PauseButt;
	private JButton FastButt ;
	private JButton clearDataButt;
	private JButton clearOrbitButt;
	private JButton Forward;
	private JButton Backward;
	
	private JCheckBox sat1CheckBox;
	private JCheckBox sat2CheckBox;
	private JCheckBox sat3CheckBox;
	
	public ToolBarMenu() {
		// TODO Auto-generated constructor stub
		super();
		 playButt = new JButton(new ImageIcon("ImagesAndIcons\\playIcon1.png"));
		 StopButt = new JButton(new ImageIcon("ImagesAndIcons\\StopIcon.png"));
		 PauseButt = new JButton(new ImageIcon("ImagesAndIcons\\pauseIcin.png"));
		 FastButt = new JButton(new ImageIcon("ImagesAndIcons\\Faster.png"));
		 Forward  = new JButton(new ImageIcon("ImagesAndIcons\\forwardIcon.png"));
		 Backward = new JButton(new ImageIcon("ImagesAndIcons\\backwardIcon.png"));
		 
		 clearDataButt = new JButton("Clear Data");
		 clearDataButt.setFont(new Font("Serif",Font.BOLD,11));
		 clearOrbitButt = new JButton("Clear Orbit");
		 clearOrbitButt.setFont(new Font("Serif",Font.BOLD,11));
		 
		  sat1CheckBox = new JCheckBox("Sat Alpha");
		  sat1CheckBox.setFont(new Font("Serif",Font.BOLD,12));
		  sat2CheckBox = new JCheckBox("Sat Beta");
		  sat2CheckBox.setFont(new Font("Serif",Font.BOLD,12));
		  sat3CheckBox = new JCheckBox("Sat Gamma");
		  sat3CheckBox.setFont(new Font("Serif",Font.BOLD,12));
		  
		  sat1CheckBox.setSelected(true);
		  Backward.setSize(25,25);
		  Forward.setSize(25,25);
		playButt.setSize( 25, 25);
		StopButt.setSize( 25, 25);	
		PauseButt.setSize( 28, 28);
		FastButt.setSize(25 , 25);
		clearDataButt.setSize(90 , 18);
		clearOrbitButt.setSize(90, 18);
		

		Border blackline = BorderFactory.createLineBorder(Color.black);
		//this.setLayout(null);
		this.addSeparator();
		//this.setBounds(x, y, size_x, size_y);
		this.setBackground(Color.lightGray);
		this.setBorder(blackline);
		
		this.add(Backward);
		this.add(playButt);
		this.add(FastButt);
		this.add(Forward);
		this.add(PauseButt);
		this.add(StopButt);	
		this.addSeparator();
		this.add(clearDataButt);
		this.addSeparator();
		this.add(clearOrbitButt);
		this.addSeparator();
		this.add(sat1CheckBox);
		this.add(sat2CheckBox);
		this.add(sat3CheckBox);
	}
	
	public void addSat1CheckBoxActionListener(ActionListener al){
		sat1CheckBox.addActionListener(al);
	}
	public void addSat2CheckBoxActionListener(ActionListener al){
		sat2CheckBox.addActionListener(al);
	}
	public void addSat3CheckBoxActionListener(ActionListener al){
		sat3CheckBox.addActionListener(al);
	}
	
	public void addForwardActionListener(ActionListener al){
		Forward.addActionListener(al);
	}
	
	public void addBackwardActionListener(ActionListener al){
		Backward.addActionListener(al);
	}
	
	public void addClearOrbitActionListener(ActionListener al){
		clearOrbitButt.addActionListener(al);
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
	
	public JButton getClearOrbitButt() {
		return clearOrbitButt;
	}

	public void setClearOrbitButt(JButton clearOrbitButt) {
		this.clearOrbitButt = clearOrbitButt;
	}

	public JCheckBox getSat1CheckBox() {
		return sat1CheckBox;
	}

	public void setSat1CheckBox(JCheckBox sat1CheckBox) {
		this.sat1CheckBox = sat1CheckBox;
	}

	public JCheckBox getSat2CheckBox() {
		return sat2CheckBox;
	}

	public void setSat2CheckBox(JCheckBox sat2CheckBox) {
		this.sat2CheckBox = sat2CheckBox;
	}

	public JCheckBox getSat3CheckBox() {
		return sat3CheckBox;
	}

	public void setSat3CheckBox(JCheckBox sat3CheckBox) {
		this.sat3CheckBox = sat3CheckBox;
	}

}
