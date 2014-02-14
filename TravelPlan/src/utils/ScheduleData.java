package utils;

public class ScheduleData {

	private String place;
	private int fy;
	private int fm;
	private int fd;
	private int ty;
	private int tm;
	private int td;

	public ScheduleData(String place, int fy, int fm, int fd, int ty, int tm,
			int td) {
		this.place = place;
		this.fy = fy;
		this.fm = fm;
		this.fd = fd;
		this.ty = ty;
		this.tm = tm;
		this.td = td;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getFy() {
		return fy;
	}

	public void setFy(int fy) {
		this.fy = fy;
	}

	public int getFm() {
		return fm;
	}

	public void setFm(int fm) {
		this.fm = fm;
	}

	public int getFd() {
		return fd;
	}

	public void setFd(int fd) {
		this.fd = fd;
	}

	public int getTy() {
		return ty;
	}

	public void setTy(int ty) {
		this.ty = ty;
	}

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public int getTd() {
		return td;
	}

	public void setTd(int td) {
		this.td = td;
	}
}
