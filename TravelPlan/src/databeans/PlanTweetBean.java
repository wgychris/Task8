package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("planTweet_id")
public class PlanTweetBean {
	private int planTweet_id;
	private int plan_id;
	private String tweet;

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getPlanTweet_id() {
		return planTweet_id;
	}

	public void setPlanTweet_id(int planTweet_id) {
		this.planTweet_id = planTweet_id;
	}

	
	
}
