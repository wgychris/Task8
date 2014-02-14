package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("planFlickr_id")
public class PlanFlickrBean {
	private int planFlickr_id;
	private int plan_id;
	private String url;

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPlanFlickr_id() {
		return planFlickr_id;
	}

	public void setPlanFlickr_id(int planFlickr_id) {
		this.planFlickr_id = planFlickr_id;
	}
}
