
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
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
	//common
	private BufferedImage hugeImage;
	private boolean flagPaint;
	private CSVReader csvReader;
	private javax.swing.Timer[] drawtimerSat;
	private TimerActionListener[] timerActionListener;
	private int intervalDrawing;
	private Boolean flagStartOverOrContinue = false;	//startOver = 0, continu = 1
	private Boolean flagPrevOrbits;
	private String imageFile = "ImagesAndIcons\\Earth2048x1024.jpg";
	private int size_Main_frame_x = 900;
	private int size_Main_frame_y = 600;
	private int size_internal_Main_frame_x = size_Main_frame_x - 20;
	private int size_internal_Main_frame_y = size_Main_frame_y - size_Main_frame_y/3;	
	private int R,G,B = 0;
	private float x_pix_size = 0,y_pix_size = 0;
	private int mid_x = 0;
	private int mid_y = 0;
	private Color[] colArr = {Color.red,Color.yellow,Color.green};
	
	private Satellite[] satellites = null;

	
	public BuffImage(int w, int h) {
		// TODO Auto-generated constructor stub
		super();
		this.setSize(w, h);	
		satellites = new Satellite[3];
		timerActionListener = new TimerActionListener[3];
		flagPaint = false;
		intervalDrawing = 20;
		flagPrevOrbits = false;
		drawtimerSat = new javax.swing.Timer[3];	
		
		 try {
			 hugeImage = ImageIO.read(new File(imageFile));

			 for(int i=0;i<21;i++)
			 {
				 ExcelParameters.ValidParam[i]=false;	//TODO
			 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);		
			
			if (flagPaint){
				((Graphics2D) arg0).setStroke(new BasicStroke(2));
				arg0.drawImage(hugeImage,0,0,getWidth(),getHeight(),null);
				for(int j = 0; j < satellites.length ; j++) {
					if (satellites[j] != null && satellites[j].getFlagActive()){ 
						arg0.setColor(colArr[j]);
						for (int i = satellites[j].getIndexStart() ; i < satellites[j].getIndexStop() - 1; i++){
							int x0 = satellites[j].getPointList().get(i).x;
							int y0 = satellites[j].getPointList().get(i).y;
							if ((x0 - satellites[j].getPointList().get(i + 1).x) < (getWidth() / 10) && (y0 - satellites[j].getPointList().get(i + 1).y) < (getHeight() / 7) 
									&&(x0 != mid_x && x0 < getWidth() - 2 && x0 > 1 && y0 > 1 && y0 < getHeight() - 2))
								arg0.drawLine(satellites[j].getPointList().get(i).x, satellites[j].getPointList().get(i).y, satellites[j].getPointList().get(i + 1).x, satellites[j].getPointList().get(i + 1).y); // (x0,y0,x1,y1)
								if(satellites[j].getIndexSatStart() < satellites[j].getIndexSatStop())
									arg0.drawImage(satellites[j].getSatelliteImg(), satellites[j].getPointList().get(satellites[j].getIndexSatStart()).x - (satellites[j].getSatelliteImg().getWidth() / 2) , satellites[j].getPointList().get(satellites[j].getIndexSatStart()).y - (satellites[j].getSatelliteImg().getHeight() / 2) , satellites[j].getSatelliteImg().getWidth(), satellites[j].getSatelliteImg().getHeight(), null);
									if(satellites[j].getExParam().get(satellites[j].getIndexSatStart()).getAccess() == 1){
										arg0.drawImage(satellites[j].getIconOnImg(), satellites[j].getSizeOfIconX(), getHeight() - satellites[j].getIconOnImg().getHeight() - 5,satellites[j].getIconOnImg().getWidth(),satellites[j].getIconOnImg().getHeight(),null);
									}
									else{
										arg0.drawImage(satellites[j].getIconOffImg(),satellites[j].getSizeOfIconX() , getHeight() - satellites[j].getIconOffImg().getHeight() - 5,satellites[j].getIconOffImg().getWidth(),satellites[j].getIconOffImg().getHeight(),null);
									}
					
						}
					}//inner for	
				}// big for
			}
			else{
				arg0.drawImage(hugeImage,0,0,getWidth(),getHeight(),null);
				repaint();
			}
	}
	
	public void allocateSatellite(int satNum,String satDir,String OnDirFile,String OffDirFile,JTextArea param1,String name) throws IOException{
			satellites[satNum] = new Satellite(satDir,OnDirFile,OffDirFile,param1,5 + satNum*30,name);
			timerActionListener[satNum] = new TimerActionListener(satellites[satNum]);
			drawtimerSat[satNum] = new javax.swing.Timer(intervalDrawing, timerActionListener[satNum]);
			timerActionListener[satNum].setDrawT(drawtimerSat[satNum]);
	}
	
	public void initAllParam() throws FileNotFoundException{
		x_pix_size = (float)getWidth() / 360;
		y_pix_size = (float)getHeight() / 180;
		mid_x = getWidth() / 2; 
		mid_y = getHeight() / 2;
		R = 255;
		int col = (R <<16) | (G << 8) | B;
		//Width = getWidth();
		//Height = getHeight();
	}
	
	public void prevOrbits(){
		for (int j = 0; j < satellites.length; j++){
			if (satellites[j] != null && satellites[j].getFlagActive()){
				if (satellites[j].getParam() != null){
					satellites[j].setIndexStart(0);
					satellites[j].getParam().setText("");
					flagPrevOrbits = true;
				}
			}
		}
		repaint();
	}
	
	public void clearOrbit(){
		for (int j = 0; j < satellites.length; j++)
			if (satellites[j] != null && satellites[j].getFlagActive()){
				satellites[j].setIndexStart(satellites[j].getIndexStop());
				flagPrevOrbits = false;
				satellites[j].getParam().setText("");
				}
		repaint();
	}
	
	public void StopAndInitOrbit(){
	flagPaint = false;
	synchronized (drawtimerSat) {
		for (int j = 0; j < satellites.length; j++)
			if (drawtimerSat[j] != null && satellites[j] != null && satellites[j].getFlagActive()) {
				drawtimerSat[j].stop();
				satellites[j].setIndexStart(0);
				satellites[j].setIndexStop(0);;
				satellites[j].getParam().setText("");
			}
		}
	flagStartOverOrContinue = false;
	repaint();
	}
	
	public void nextPaintOrbit(){
		
		for (int j = 0; j < satellites.length; j++)
			if (drawtimerSat[j] != null && satellites[j] != null && satellites[j].getFlagActive()) {
				if (drawtimerSat[j].isRunning() ){
					drawtimerSat[j].stop();
				}
				satellites[j].setIndexSatStart(satellites[j].getIndexStop());
				
				if (!flagPrevOrbits)
					satellites[j].setIndexStart(satellites[j].getIndexStop());
				Boolean flag = true;
				while(flag) {
					//for one round of earth
					if ((satellites[j].getIndexStop() < satellites[j].getNumOfParam() - 2)){
						if ((satellites[j].getExParam().get(satellites[j].getIndexStop() ).getLongitude() - satellites[j].getExParam().get(satellites[j].getIndexStop() +1).getLongitude()  > (getWidth() / 3))
							|| (satellites[j].getExParam().get(satellites[j].getIndexStop()).getLatitude() - satellites[j].getExParam().get(satellites[j].getIndexStop() + 1).getLatitude()) > (getHeight() / 3)){
					
						flag = false;
						}
						satellites[j].setIndexStop(satellites[j].getIndexStop() + 1);
					}
					else{
						flag = false;
					}
				}	
			}
				
		flagPaint = true;
		repaint();
		for(int i = 0; i < satellites.length ; i++)
			if (satellites[i] != null && satellites[i].getFlagActive())
				startTimer(i);
	}
	
	public void setForwardSat(int addForward){
		if ((intervalDrawing - addForward) > 4){
			intervalDrawing = intervalDrawing - addForward;
			for(int i = 0; i < drawtimerSat.length; i++)
				if (drawtimerSat[i] != null && satellites[i].getFlagActive())
					drawtimerSat[i].setDelay(intervalDrawing);
		}
	}
	
	public void setBackwardSat(int addBackward){
		if ((intervalDrawing - addBackward) < 200){
			intervalDrawing = intervalDrawing + addBackward;
			for(int i = 0; i < drawtimerSat.length; i++)
				if (drawtimerSat[i] != null && satellites[i].getFlagActive())
					drawtimerSat[i].setDelay(intervalDrawing);
		}

	}
	
	public void puasePaintOrbit(){
		synchronized(drawtimerSat){
			for(int i = 0; i < drawtimerSat.length; i++)
				if (drawtimerSat[i] != null && satellites[i].getFlagActive())
					drawtimerSat[i].stop();
			}
		flagStartOverOrContinue = true;
	}
	
	public Boolean getflagStartOverOrContinue(){
		return flagStartOverOrContinue;
	}
	
	public void startTimer(int satIndex){
			satellites[satIndex].setIndexSatStop(satellites[satIndex].getIndexStop()) ;
			satellites[satIndex].getParam().setText("");
			drawtimerSat[satIndex].setDelay(intervalDrawing);	
			drawtimerSat[satIndex].start();

	}
	
	public class TimerActionListener implements ActionListener {
		
		private Satellite satRef = null;
		private javax.swing.Timer drawT;

		public TimerActionListener(Satellite satRef) {
	// TODO Auto-generated constructor stub
			this.satRef = satRef;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	    	//System.out.println("hiiiiii i'm hereeee");
<<<<<<< HEAD
=======
	    	if (indexSatStart < indexSatStop){
	    		param.setFont(new Font("Sarif",Font.BOLD,12));
	    		param.append("Latitude: " +exParam.get(indexSatStart).getAllData()[19].trim() + ",	Longitude: " + exParam.get(indexSatStart).getAllData()[20]+",  " );
	    		int cnt = 0;
	    		for(int k=0;k<19;k++){
	    			if(ExcelParameters.ValidParam[k]==true){
	    				cnt++;
	    				param.append(ExcelParameters.NameParams[k].trim()+": " +exParam.get(indexSatStart).getAllData()[k].trim()+",  ");			
	    				if(cnt%4 == 0){
	    					param.append("\n");
>>>>>>> branch '2d_branch_new' of https://github.com/Jacob227/SAMSONprojRepo.git

<<<<<<< HEAD
	    	if (satRef.getIndexSatStart() < satRef.getIndexSatStop()){

	    		satRef.getParam().setFont(new Font("Sarif",Font.BOLD,12));
	    		satRef.getParam().append(satRef.getSatelliteName() + ":  Latitude: " + satRef.getExParam().get(satRef.getIndexSatStart()).getAllData()[19].trim() + ",  Longitude: " + satRef.getExParam().get(satRef.getIndexSatStart()).getAllData()[20]+",  " );
	    		int cnt = 0;
	    		for(int k=0;k<19;k++){
	    			if(ExcelParameters.ValidParam[k]==true){
	    				cnt++;
	    				satRef.getParam().append(ExcelParameters.NameParams[k].trim()+": " +satRef.getExParam().get(satRef.getIndexSatStart()).getAllData()[k].trim()+",  ");			
	    				if(cnt%4 == 0){
	    					satRef.getParam().append("\n");

=======
>>>>>>> branch '2d_branch_new' of https://github.com/Jacob227/SAMSONprojRepo.git
	    				}
	    			}
	    		}
				if (cnt>=4)
				{
<<<<<<< HEAD
					satRef.getParam().append("\n----------------------------------------------------------------------------------\n");
				}
				else 
					satRef.getParam().append("\n");
				
	    		satRef.setIndexSatStart(satRef.getIndexSatStart() + 1);
=======
					param.append("\n----------------------------------------------------------------------------------\n");
				}
				else param.append("\n");

	    		indexSatStart++;
>>>>>>> branch '2d_branch_new' of https://github.com/Jacob227/SAMSONprojRepo.git
	    		repaint();
	    	}
	    	else{
	    		drawT.stop();
	    		flagStartOverOrContinue = false;
	    	}	
	    	
		}
		
		public javax.swing.Timer getDrawT() {
			return drawT;
		}

		public void setDrawT(javax.swing.Timer drawT) {
			this.drawT = drawT;
		}
	}

	
	public void startNewSimulation() throws FileNotFoundException{
		
		for (int j = 0; j < satellites.length; j++){
			if (satellites[j] != null && satellites[j].getFlagActive()){
				if (flagStartOverOrContinue){
					drawtimerSat[j].start();
				}
				else{	 //start new simulation	
					initAllParam();
					satellites[j].setIndexStop(0);
					satellites[j].setIndexStart(0);
					satellites[j].getParam().setFont(new Font("Serif",Font.BOLD,14));
				
					flagPaint = false;
					Boolean flag = true;
					while(flag) {
						//for one round of earth
						if ((satellites[j].getIndexStop() < satellites[j].getNumOfParam() - 2))
							if ((satellites[j].getExParam().get(satellites[j].getIndexStop() ).getLongitude() - satellites[j].getExParam().get(satellites[j].getIndexStop() +1).getLongitude()  > (getWidth() / 3))
									|| (satellites[j].getExParam().get(satellites[j].getIndexStop()).getLatitude() - satellites[j].getExParam().get(satellites[j].getIndexStop() + 1).getLatitude()) > (getHeight() / 3)){
								flag = false;
							}
						satellites[j].setIndexStop(satellites[j].getIndexStop() + 1);
						}
					satellites[j].setIndexSatStart(0); 
					flagPaint = true;
					repaint();
					startTimer(j);
		 }
		}
		}
	}

	
	public void ConversExcel(String csvFilename, int indexSat,String satDir,String OnDirFile,String OffDirFile,JTextArea param1,String name) throws NumberFormatException, IOException{
		csvReader = new CSVReader(new FileReader(csvFilename));
		String[] row;
		allocateSatellite(indexSat, satDir, OnDirFile, OffDirFile,param1,name);
		
		while((row = csvReader.readNext()) != null){
			if(satellites[indexSat].getNumOfParam() != 0){
				initAllParam();
				int x = Math.round(Float.valueOf(row[20]));
				int y = Math.round(Float.valueOf(row[19]));
				int x1 = Math.round(mid_x + x_pix_size * x);
				int y1 = Math.round(mid_y - y_pix_size * y );
				
			if (row.length >= 21){	//have to be 21 param 
				satellites[indexSat].getExParam().add(new ExcelParameters(Integer.parseInt(row[0]), Float.parseFloat(row[1]), Float.parseFloat(row[2]), Float.parseFloat(row[3]), Float.parseFloat(row[4]), Float.parseFloat(row[5]), Float.parseFloat(row[6]), Float.parseFloat(row[7]), Float.parseFloat(row[8]), Float.parseFloat(row[9]),Float.parseFloat(row[10]), 
						Float.parseFloat(row[11]), Float.parseFloat(row[12]), Float.parseFloat(row[13]), Float.parseFloat(row[14]), Float.parseFloat(row[15]), Integer.parseInt(row[16]), Float.parseFloat(row[17]), Float.parseFloat(row[18]), Float.parseFloat(row[19]), Float.parseFloat(row[20]),row));
			}
			satellites[indexSat].getPointList().add(new Point(x1,y1));
			}
			satellites[indexSat].setNumOfParam(satellites[indexSat].getNumOfParam() + 1);
		}
	}

	
	
	//-------------------------------------------------Getters and setters---------------------------------//
	
	public void setActiveSatellite(int index){
		if (satellites[index] != null)
			satellites[index].setFlagActive(true);
	}
	
	public void setUnActiveSatellite(int index){
		if (satellites[index] != null)
			satellites[index].setFlagActive(false);
	}
	
	public Boolean getActiveSatellite (int index){
		if (satellites[index] != null)
			return satellites[index].getFlagActive();
		return null;
	}
	
	
	
	public BufferedImage getHugeImage() {
		return hugeImage;
	}

	public void setHugeImage(BufferedImage hugeImage) {
		this.hugeImage = hugeImage;
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


	public boolean isFlag() {
		return flagPaint;
	}

	public void setFlag(boolean flag) {
		this.flagPaint = flag;
	}

	public BufferedImage getImg(){
		return hugeImage;
	}
	public int getIntervalDrawing() {
		return intervalDrawing;
	}

	public void setIntervalDrawing(int intervalDrawing) {
		this.intervalDrawing = intervalDrawing;
	}

}

