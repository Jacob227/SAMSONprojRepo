
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BuffImage extends Image {
	
	private java.awt.image.BufferedImage hugeImage;
	
	public BuffImage() {
		// TODO Auto-generated constructor stub
		File str = new File("C:\\Earth2048x1024.jpg");
		 try {
			hugeImage = ImageIO.read(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showImage(){
	System.out.println(hugeImage.getWidth() + " " + hugeImage.getHeight());	
	System.out.println(hugeImage.getRGB(30, 30));
	}

	public BufferedImage getImg(){
		return hugeImage;
	}
	@Override
	public Graphics getGraphics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight(ImageObserver arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getProperty(String arg0, ImageObserver arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageProducer getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth(ImageObserver arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
