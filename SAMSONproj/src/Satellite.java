import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.opencsv.CSVReader;

public class Satellite {
	
	private int NumOfParam;
	private String csvFilename= "";
	private int indexSatStart = 0;
	private int indexSatStop = 0;
	private Vector<ExcelParameters> exParam;
	private JTextArea param = null;
	private String satDir = "ImagesAndIcons\\sat_icon_";
	//private String OnDirFile = "ImagesAndIcons\\R-on.png";
	//private String OffDirFile = "ImagesAndIcons\\R-off.png";
	private int indexStop;
	private int indexStart;
	private Vector<Point> PointList = null;
	private BufferedImage IconOnImg;
	private BufferedImage IconOffImg;
	private BufferedImage satelliteImg;
	private int sizeOfIconX;
	private Boolean flagActive;
	private String satelliteName = "";

	public Satellite(String satDir,String OnDirFile,String OffDirFile,JTextArea param1,int sizeOfIconX,String name) throws IOException {
	// TODO Auto-generated constructor stub
		 satelliteImg = ImageIO.read(new File(satDir));
		 IconOnImg = ImageIO.read(new File(OnDirFile));
		 IconOffImg = ImageIO.read(new File(OffDirFile));
		 PointList = new Vector<>();
		 NumOfParam = 0;
		 exParam = new Vector<>();
		 param = param1;
		 this.sizeOfIconX = sizeOfIconX;
		 flagActive = false;
		 satelliteName = name;
	}
		
	public String getSatelliteName() {
		return satelliteName;
	}

	public void setSatelliteName(String satelliteName) {
		this.satelliteName = satelliteName;
	}
	
	public Boolean getFlagActive() {
		return flagActive;
	}

	public void setFlagActive(Boolean flagActive) {
		this.flagActive = flagActive;
	}

	public int getSizeOfIconX() {
		return sizeOfIconX;
	}


	public void setSizeOfIconX(int sizeOfIconX) {
		this.sizeOfIconX = sizeOfIconX;
	}

	
	public BufferedImage getSatelliteImg() {
		return satelliteImg;
	}

	public void setSatelliteImg(BufferedImage satelliteImg) {
		this.satelliteImg = satelliteImg;
	}
	
	public int getNumOfParam() {
		return NumOfParam;
	}

	public void setNumOfParam(int numOfParam) {
		NumOfParam = numOfParam;
	}

	public String getCsvFilename() {
		return csvFilename;
	}

	public void setCsvFilename(String csvFilename) {
		this.csvFilename = csvFilename;
	}

	public int getIndexSatStart() {
		return indexSatStart;
	}

	public void setIndexSatStart(int indexSatStart) {
		this.indexSatStart = indexSatStart;
	}

	public int getIndexSatStop() {
		return indexSatStop;
	}

	public void setIndexSatStop(int indexSatStop) {
		this.indexSatStop = indexSatStop;
	}

	public Vector<ExcelParameters> getExParam() {
		return exParam;
	}

	public void setExParam(Vector<ExcelParameters> exParam) {
		this.exParam = exParam;
	}

	public JTextArea getParam() {
		return param;
	}

	public void setParam(JTextArea param) {
		this.param = param;
	}

	public String getSatDir() {
		return satDir;
	}

	public void setSatDir(String satDir) {
		this.satDir = satDir;
	}


	public int getIndexStop() {
		return indexStop;
	}

	public void setIndexStop(int indexStop) {
		this.indexStop = indexStop;
	}

	public int getIndexStart() {
		return indexStart;
	}

	public void setIndexStart(int indexStart) {
		this.indexStart = indexStart;
	}

	public  Vector<Point> getPointList() {
		return PointList;
	}

	public  void setPointList(Vector<Point> pointList) {
		PointList = pointList;
	}
	

	public BufferedImage getIconOnImg() {
		return IconOnImg;
	}

	public void setIconOnImg(BufferedImage redIconOnImg) {
		this.IconOnImg = redIconOnImg;
	}

	public BufferedImage getIconOffImg() {
		return IconOffImg;
	}

	public void setIconOffImg(BufferedImage redIconOffImg) {
		this.IconOffImg = redIconOffImg;
	}
}
