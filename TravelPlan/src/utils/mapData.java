package utils;

public class mapData {
	private double lat;
	private double lon;
	private String des;

	public mapData(double lat, double lon, String des) {
		this.lat = lat;
		this.lon = lon;
		this.des = des;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
