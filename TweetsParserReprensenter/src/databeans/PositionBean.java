package databeans;

import org.genericdao.PrimaryKey;

/*
 * Position Bean 
 * Yusi Jan 19 Version 1.0
 * co-author:
 */

@PrimaryKey("customer_id,fund_id")
// primarykey must list in order
public class PositionBean {
	private int fund_id;
	private int customer_id;
	private long shares;
	private long tempshares;

	public long getTempshares() {
		return tempshares;
	}

	public void setTempshares(long tempshares) {
		this.tempshares = tempshares;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public int getFund_id() {
		return fund_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public void setFund_id(int fund_id) {
		this.fund_id = fund_id;
	}

	public long getShares() {
		return shares;
	}

	public void setShares(long shares) {
		this.shares = shares;
	}

}
