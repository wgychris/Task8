package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("planFlicker_id")
public class PlanFlickerBean {
	private int planFlicker_id;
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

	public int getPlanFlicker_id() {
		return planFlicker_id;
	}

	public void setPlanFlicker_id(int planFlicker_id) {
		this.planFlicker_id = planFlicker_id;
	}
}
