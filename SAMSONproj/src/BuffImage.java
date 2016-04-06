
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuffImage extends JPanel {
	
	private static java.awt.image.BufferedImage hugeImage;
	private JPanel ImagePanel;
	private JLabel jlb;
	
	public BuffImage() {
		// TODO Auto-generated constructor stub
		super();
		ImagePanel = new JPanel();
		
		File str = new File("C:\\Earth2048x1024.jpg");
		 try {
			hugeImage = ImageIO.read(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addScaledImage(int w,int h){
		jlb = new JLabel(new ImageIcon(hugeImage.getScaledInstance(w, h, JFrame.EXIT_ON_CLOSE)));
		this.add(jlb);
	}
	public void showImage(){
	System.out.println(hugeImage.getWidth() + " " + hugeImage.getHeight());	
	System.out.println(hugeImage.getRGB(30, 30));
	}

	public BufferedImage getImg(){
		return hugeImage;
	}
	
	@Override
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.drawImage(hugeImage,0,0,null);
		repaint();		
	}
	
}
