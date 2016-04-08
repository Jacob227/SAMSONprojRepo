
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.opencsv.CSVReader;

import java.awt.image.*;

public class BuffImage extends JPanel {
	
	private BufferedImage hugeImage;
	//private JPanel ImagePanel;
	private JLabel jlb;
	//private boolean flagStart,flagStop,flagPause,flagNext;
	private boolean flagPaint;
	private static Vector<Point> PointList = null;
	private CSVReader csvReader;
	private PaintThread paintThr;
	private int indexStop;
	private int indexStart;

	private String imageFile = "ImagesAndIcons\\Earth2048x1024.jpg";
	
	private int Width,Height;
	private int size_Main_frame_x = 900;
	private int size_Main_frame_y = 600;
	private int size_internal_Main_frame_x = size_Main_frame_x - 20;
	private int size_internal_Main_frame_y = size_Main_frame_y - size_Main_frame_y/3;
	private Vector<ExcelParameters> exParam;
	private JTextArea param;
	
	private int R,G,B = 0;
	private float x_pix_size = 0,y_pix_size = 0;
	private int mid_x = 0;
	private int mid_y = 0;
	private String csvFilename= "";
	
	public BuffImage(int w, int h) {
		// TODO Auto-generated constructor stub
		super();
		this.setSize(w, h);	
		flagPaint = false;
		//flagStart = false; flagNext = false;
		//flagPause = false; flagStop = false;
		File str = new File(imageFile);
		 try {
			 hugeImage = ImageIO.read(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isFlag() {
		return flagPaint;
	}

	public void setFlag(boolean flag) {
		this.flagPaint = flag;
	}

	public BufferedImage getImg(){
		return hugeImage;
	}
	
	public int getIndexStart() {
		return indexStart;
	}

	public void setIndexStart(int indexStart) {
		this.indexStart = indexStart;
	}
	
	public int getIndexStop() {
		return indexStop;
	}

	public void setIndexStop(int indexStop) {
		this.indexStop = indexStop;
	} 
	
	public JTextArea getParam() {
		return param;
	}

	public void setParam(JTextArea param) {
		this.param = param;
	}

	public void clearOrbit(){
		indexStart = indexStop;
		param.setText("");
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);		
			
			if (flagPaint){
				arg0.drawImage(hugeImage,0,0,getWidth(),getHeight(),null);
				param.setText("");
				for (int i = indexStart ; i < indexStop - 1; i++){
					int x0 = PointList.get(i).x;
					int y0 = PointList.get(i).y;
					arg0.setColor(Color.RED);
					if ((x0 - PointList.get(i+1).x) < (getWidth() / 10) && (y0 - PointList.get(i+1).y) < (getHeight() / 7) 
							&&(x0 != mid_x && x0 < getWidth() - 2 && x0 > 1 && y0 > 1 && y0 < getHeight() - 2))
						arg0.drawLine(PointList.get(i).x, PointList.get(i).y, PointList.get(i + 1).x, PointList.get(i + 1).y); // (x0,y0,x1,y1)
							param.append("Latitude: " +exParam.get(i).getAllData()[19] + ",	Longitude: " + exParam.get(i).getAllData()[20] + "\n");
				}	
			}
			else{
				arg0.drawImage(hugeImage,0,0,getWidth(),getHeight(),null);
				repaint();
			}
	}
	
	public void initAllParam() throws FileNotFoundException{
		x_pix_size = (float)getWidth() / 360;
		y_pix_size = (float)getHeight() / 180;
		mid_x = getWidth() / 2; 
		mid_y = getHeight() / 2;
		R = 255;
		int col = (R <<16) | (G << 8) | B;
		Width = getWidth();
		Height = getHeight();
	}
/*	
	public void paintOrbit1(JTextArea param,Vector<ExcelParameters> exPar) throws NumberFormatException, IOException, InterruptedException{
		 csvReader = new CSVReader(new FileReader(csvFilename));
		 param.setFont(new Font("Serif",Font.BOLD,14));
		String[] row = null;
		int count = 0;
		boolean first = false;
		//TODO add sync on bfImg.getImg() param
		PointList = new Vector<>();
		while((row = csvReader.readNext()) != null) {
			if (first){
				count++;
				initAllParam();
				int x = Math.round(Float.valueOf(row[20]));
				int y = Math.round(Float.valueOf(row[19]));
				int x1 = Math.round(mid_x + x_pix_size * x);
				int y1 = Math.round(mid_y - y_pix_size * y );
				
				//TODO add support for less param
				if (row.length == 22){	//have to be 21 param 
					exPar.add(new ExcelParameters(Integer.parseInt(row[0]), Float.parseFloat(row[1]), Float.parseFloat(row[2]), Float.parseFloat(row[3]), Float.parseFloat(row[4]), Float.parseFloat(row[5]), Float.parseFloat(row[6]), Float.parseFloat(row[7]), Float.parseFloat(row[8]), Float.parseFloat(row[9]),Float.parseFloat(row[10]), 
							Float.parseFloat(row[11]), Float.parseFloat(row[12]), Float.parseFloat(row[13]), Float.parseFloat(row[14]), Float.parseFloat(row[15]), Boolean.parseBoolean(row[16]), Float.parseFloat(row[17]), Float.parseFloat(row[18]), Float.parseFloat(row[19]), Float.parseFloat(row[20]),row));
					
				}
				
				if (x1 != mid_x && x1 < getWidth() - 2 && x1 > 1 && y1 > 1 && y1 < getHeight() - 2)
					PointList.add(new Point(x1,y1));	
			   }
			if (count == 1000){
				count = 0;
				Thread.sleep(200);
				repaint();
				Thread.sleep(200);
				param.setText("");
				for (int i = 0; i < exPar.size(); i++){
					param.append("Latitude: " +exPar.get(i).getAllData()[19] + ",	Longitude: " + exPar.get(i).getAllData()[20] + "\n");
				}
				
			}
			first = true;
		 }
		Thread.sleep(200);		
	}
*/
	
	public void StopAndInitOrbit(){
	flagPaint = false;
	indexStart = 0;
	indexStop = 0;
	param.setText("");
	repaint();
	}
	
	public void nextPaintOrbit(){

		Boolean flag = true;
		while(flag) {
			//for one round of earth
			if ((indexStop < NumOfParam - 2)){
				if ((exParam.get(indexStop ).getLongitude() - exParam.get(indexStop + 1).getLongitude()) > Width / 3
					|| (exParam.get(indexStop).getLatitude() - exParam.get(indexStop + 1).getLatitude()) > Height / 3){
				System.out.println(exParam.get(indexStop).getLongitude() + "  " + exParam.get(indexStop + 1).getLongitude());
				flagPaint = true;
				flag = false;
				}
				System.out.println(exParam.get(indexStop).getLongitude() + "  " + exParam.get(indexStop + 1).getLongitude());
				indexStop++;
			}
			else{
				flag = false;
			}
		}
		repaint();
	}
	
	public void startNewPaintThread() throws FileNotFoundException{
		initAllParam();
		paintThr = new PaintThread();
		paintThr.start();
	}
	//-----------------------------------------Paint Thread-----------------------------------//

	public class PaintThread extends Thread {
			
		    public PaintThread() {
			// TODO Auto-generated constructor stub
		    	indexStop = 0;
		    	indexStart = 0;
		}

			public void run(){
		       System.out.println("Play Thread running");
				 try {
					csvReader = new CSVReader(new FileReader(csvFilename));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 param.setFont(new Font("Serif",Font.BOLD,14));
				flagPaint = false;
				Boolean flag = true;
				while(flag) {
					//for one round of earth
					if ((indexStop >= NumOfParam) || (exParam.get(indexStop ).getLongitude() - exParam.get(indexStop + 1).getLongitude()) > Width / 3
							|| (exParam.get(indexStop).getLatitude() - exParam.get(indexStop + 1).getLatitude()) > Height / 3){
						System.out.println(exParam.get(indexStop).getLongitude() + "  " + exParam.get(indexStop + 1).getLongitude());
						flagPaint = true;
						flag = false;
					}
					System.out.println(exParam.get(indexStop).getLongitude() + "  " + exParam.get(indexStop + 1).getLongitude());
					indexStop++;
				}

				repaint();
		  }
	}
	
	//-------------------------------------------------Getters and setters---------------------------------//
	private int NumOfParam;
	public void ConversExcel() throws NumberFormatException, IOException{
		csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row;
		NumOfParam = 0;
		PointList = new Vector<>();
		exParam = new Vector<>();
		while((row = csvReader.readNext()) != null){
			if(NumOfParam != 0){
				initAllParam();
				int x = Math.round(Float.valueOf(row[20]));
				int y = Math.round(Float.valueOf(row[19]));
				int x1 = Math.round(mid_x + x_pix_size * x);
				int y1 = Math.round(mid_y - y_pix_size * y );
				
			if (row.length >= 21){	//have to be 21 param 
				exParam.add(new ExcelParameters(Integer.parseInt(row[0]), Float.parseFloat(row[1]), Float.parseFloat(row[2]), Float.parseFloat(row[3]), Float.parseFloat(row[4]), Float.parseFloat(row[5]), Float.parseFloat(row[6]), Float.parseFloat(row[7]), Float.parseFloat(row[8]), Float.parseFloat(row[9]),Float.parseFloat(row[10]), 
						Float.parseFloat(row[11]), Float.parseFloat(row[12]), Float.parseFloat(row[13]), Float.parseFloat(row[14]), Float.parseFloat(row[15]), Boolean.parseBoolean(row[16]), Float.parseFloat(row[17]), Float.parseFloat(row[18]), Float.parseFloat(row[19]), Float.parseFloat(row[20]),row));
			}
			synchronized(PointList){
				PointList.add(new Point(x1,y1));
			}
			}
			NumOfParam++;
		}		
	}
	
	public BufferedImage getHugeImage() {
		return hugeImage;
	}

	public void setHugeImage(BufferedImage hugeImage) {
		this.hugeImage = hugeImage;
	}

	public JLabel getJlb() {
		return jlb;
	}

	public void setJlb(JLabel jlb) {
		this.jlb = jlb;
	}

	public Vector<Point> getPointList() {
		return PointList;
	}

	public void setPointList(Vector<Point> pointList) {
		PointList = pointList;
	}

	public CSVReader getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getSize_Main_frame_x() {
		return size_Main_frame_x;
	}

	public void setSize_Main_frame_x(int size_Main_frame_x) {
		this.size_Main_frame_x = size_Main_frame_x;
	}

	public int getSize_Main_frame_y() {
		return size_Main_frame_y;
	}

	public void setSize_Main_frame_y(int size_Main_frame_y) {
		this.size_Main_frame_y = size_Main_frame_y;
	}

	public int getSize_internal_Main_frame_x() {
		return size_internal_Main_frame_x;
	}

	public void setSize_internal_Main_frame_x(int size_internal_Main_frame_x) {
		this.size_internal_Main_frame_x = size_internal_Main_frame_x;
	}

	public int getSize_internal_Main_frame_y() {
		return size_internal_Main_frame_y;
	}

	public void setSize_internal_Main_frame_y(int size_internal_Main_frame_y) {
		this.size_internal_Main_frame_y = size_internal_Main_frame_y;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public float getX_pix_size() {
		return x_pix_size;
	}

	public void setX_pix_size(float x_pix_size) {
		this.x_pix_size = x_pix_size;
	}

	public float getY_pix_size() {
		return y_pix_size;
	}

	public void setY_pix_size(float y_pix_size) {
		this.y_pix_size = y_pix_size;
	}

	public int getMid_x() {
		return mid_x;
	}

	public void setMid_x(int mid_x) {
		this.mid_x = mid_x;
	}

	public int getMid_y() {
		return mid_y;
	}

	public void setMid_y(int mid_y) {
		this.mid_y = mid_y;
	}

	public String getCsvFilename() {
		return csvFilename;
	}

	public void setCsvFilename(String csvFilename) {
		this.csvFilename = csvFilename;
	}
	
}

