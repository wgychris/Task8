package databeans;

import org.genericdao.PrimaryKey;


@PrimaryKey("plan_id")
public class PlanBean {
	private int plan_id;
	private int user_id;
	private String date;
	private String place;
	private String[] tweets;
	private String[] flickers;
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String[] getTweets() {
		return tweets;
	}
	public void setTweets(String[] tweets) {
		this.tweets = tweets;
	}
	public String[] getFlickers() {
		return flickers;
	}
	public void setFlickers(String[] flickers) {
		this.flickers = flickers;
	}

	
	




}
