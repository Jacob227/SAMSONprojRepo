import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class ToolBarMenu extends JToolBar {
	
	private JButton playButt;
	
	private JButton StopButt;
	private JButton PauseButt;
	private JButton FastButt ;
	private JButton clearDataButt;
	private JButton clearOrbitButt;
	
	public ToolBarMenu() {
		// TODO Auto-generated constructor stub
		super();
		 playButt = new JButton(new ImageIcon("ImagesAndIcons\\playIcon1.png"));
		 StopButt = new JButton(new ImageIcon("ImagesAndIcons\\StopIcon.png"));
		 PauseButt = new JButton(new ImageIcon("ImagesAndIcons\\pauseIcin.png"));
		 FastButt = new JButton(new ImageIcon("ImagesAndIcons\\Faster.png"));
		 clearDataButt = new JButton("Clear Data");
		 clearDataButt.setFont(new Font("Serif",Font.BOLD,11));
		 clearOrbitButt = new JButton("Clear Orbit");
		 clearOrbitButt.setFont(new Font("Serif",Font.BOLD,11));
		 

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
		
		this.add(playButt);
		this.add(FastButt);
		this.add(PauseButt);
		this.add(StopButt);	
		this.addSeparator();
		this.add(clearDataButt);
		this.addSeparator();
		this.add(clearOrbitButt);
		this.addSeparator();
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
}
