//import com.sun.org.apache.xpath.internal.operations.Bool;

public class ExcelParameters {
	private int EpochSecTime;
	private float JD0;
	private float JD1;
	private float posX, posY, posZ;
	private float velX, velY, velZ;
	private float OrbEl_SMA, OrbEl_Eccentricity, OrbEl_Inclination, OrbEl_RAAN, OrbEl_ArgOfPerigee;
	private float OrbEl_MeanAnomaly, OrbEl_TrueAnomaly;
	private Boolean Access;
	private float Azimuth, Elevation, Latitude, Longitude;
	private String[] allData; 
	
	public ExcelParameters(int EpochSecTime ,float JD0,float JD1, float posX,float posY,float posZ, float velX, float velY, float velZ,float OrbEl_SMA,float OrbEl_Eccentricity,float OrbEl_Inclination,float OrbEl_RAAN, float OrbEl_ArgOfPerigee, float OrbEl_MeanAnomaly, float OrbEl_TrueAnomaly, Boolean Access, float Azimuth,float Elevation,float Latitude, float Longitude,String[] allData) {
		// TODO Auto-generated constructor stub
		this.EpochSecTime = EpochSecTime;
		this.JD0 = JD0;
		this.JD1 = JD1;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.velX = velX;
		this.velY = velY;
		this.velZ = velZ;
		this.OrbEl_SMA = OrbEl_SMA;
		this.OrbEl_Eccentricity = OrbEl_Eccentricity;
		this.OrbEl_Inclination = OrbEl_Inclination;
		this.OrbEl_RAAN = OrbEl_RAAN;
		this.OrbEl_ArgOfPerigee = OrbEl_ArgOfPerigee;
		this.OrbEl_MeanAnomaly = OrbEl_MeanAnomaly;
		this.OrbEl_TrueAnomaly = OrbEl_TrueAnomaly;
		this.Access = Access;
		this.Azimuth = Azimuth;
		this.Elevation = Elevation;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		
		this.allData = new String[allData.length];
		this.allData = allData;
		
	}
	
	public String[] getAllData() {
		return allData;
	}

	public void setAllData(String[] allData) {
		this.allData = allData;
	}

	
	public int getEpochSecTime() {
		return EpochSecTime;
	}

	public void setEpochSecTime(int epochSecTime) {
		EpochSecTime = epochSecTime;
	}

	public float getJD0() {
		return JD0;
	}

	public void setJD0(int jD0) {
		JD0 = jD0;
	}

	public float getJD1() {
		return JD1;
	}

	public void setJD1(int jD1) {
		JD1 = jD1;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public float getPosZ() {
		return posZ;
	}

	public void setPosZ(int posZ) {
		this.posZ = posZ;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public float getVelZ() {
		return velZ;
	}

	public void setVelZ(float velZ) {
		this.velZ = velZ;
	}

	public float getOrbEl_SMA() {
		return OrbEl_SMA;
	}

	public void setOrbEl_SMA(float orbEl_SMA) {
		OrbEl_SMA = orbEl_SMA;
	}

	public float getOrbEl_Eccentricity() {
		return OrbEl_Eccentricity;
	}

	public void setOrbEl_Eccentricity(float orbEl_Eccentricity) {
		OrbEl_Eccentricity = orbEl_Eccentricity;
	}

	public float getOrbEl_Inclination() {
		return OrbEl_Inclination;
	}

	public void setOrbEl_Inclination(float orbEl_Inclination) {
		OrbEl_Inclination = orbEl_Inclination;
	}

	public float getOrbEl_RAAN() {
		return OrbEl_RAAN;
	}

	public void setOrbEl_RAAN(float orbEl_RAAN) {
		OrbEl_RAAN = orbEl_RAAN;
	}

	public float getOrbEl_ArgOfPerigee() {
		return OrbEl_ArgOfPerigee;
	}

	public void setOrbEl_ArgOfPerigee(float orbEl_ArgOfPerigee) {
		OrbEl_ArgOfPerigee = orbEl_ArgOfPerigee;
	}

	public float getOrbEl_MeanAnomaly() {
		return OrbEl_MeanAnomaly;
	}

	public void setOrbEl_MeanAnomaly(float orbEl_MeanAnomaly) {
		OrbEl_MeanAnomaly = orbEl_MeanAnomaly;
	}

	public float getOrbEl_TrueAnomaly() {
		return OrbEl_TrueAnomaly;
	}

	public void setOrbEl_TrueAnomaly(float orbEl_TrueAnomaly) {
		OrbEl_TrueAnomaly = orbEl_TrueAnomaly;
	}

	public Boolean getAccess() {
		return Access;
	}

	public void setAccess(Boolean access) {
		Access = access;
	}

	public float getAzimuth() {
		return Azimuth;
	}

	public void setAzimuth(float azimuth) {
		Azimuth = azimuth;
	}

	public float getElevation() {
		return Elevation;
	}

	public void setElevation(float elevation) {
		Elevation = elevation;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(float latitude) {
		Latitude = latitude;
	}

	public float getLongitude() {
		return Longitude;
	}

	public void setLongitude(float longitude) {
		Longitude = longitude;
	}

}
