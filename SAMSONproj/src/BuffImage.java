
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.*;

public class BuffImage extends JPanel {
	
	private BufferedImage hugeImage;
	//private JPanel ImagePanel;
	private JLabel jlb;
	
	public BuffImage(int w, int h) {
		// TODO Auto-generated constructor stub
		super();
		this.setSize(w, h);	
		File str = new File("C:\\Earth2048x1024.jpg");
		 try {
			 hugeImage = ImageIO.read(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints( new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}
	
	public void addScaledImage(int w,int h){
		jlb = new JLabel(new ImageIcon(hugeImage.getScaledInstance(w, h, JFrame.EXIT_ON_CLOSE)));
		this.add(jlb);
	}
	
	public void addLabel(int w,int h){
		jlb.setIcon(new ImageIcon(hugeImage.getScaledInstance(w, h, JFrame.EXIT_ON_CLOSE)));
		this.add(jlb);
	}

	public BufferedImage getImg(){
		return hugeImage;
	}
	
	@Override
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		//arg0.fillRect(0, 0, 800, 900);		
		synchronized(hugeImage) {
		arg0.drawImage(hugeImage,0,0,getWidth(),getHeight(),null);
		repaint();
		}
	}
	
}
