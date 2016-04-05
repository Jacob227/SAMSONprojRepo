import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Image2DPanel extends JFrame  {
	
private BuffImage bfImg;
private JPanel pan;
private JLabel jlb;
private JButton jbut;
private int width;
private int Height;
private int R,G,B = 0;

public Image2DPanel() {
	// TODO Auto-generated constructor stub
	Height = 500;
	width = 800;
	R = 250;
	int ss = 5;
	bfImg = new BuffImage();
	pan = new JPanel();
	jbut = new JButton("RePaint");
	jbut.addActionListener(new RePaintActionListener());
		this.setBounds(300, 100, width, Height);
	this.add(pan);
	int col = (R <<16) | (G << 8) | R;
	//BufferedImage tempbuff = bfImg.getImg();
	for (int i = 0 ; i < 100 ; i++){
		for(int j = 0 ; j < 100 ; j++)
			bfImg.getImg().setRGB(i, j, col );
	}
	
	jlb = new JLabel(new ImageIcon(bfImg.getImg().getScaledInstance(width, Height, EXIT_ON_CLOSE)));
	//jlb.setBounds(100, 200 - 150, 50, 50);
	pan.add(jlb);


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
