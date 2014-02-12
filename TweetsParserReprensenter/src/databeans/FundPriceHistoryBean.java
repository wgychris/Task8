package databeans;

import org.genericdao.PrimaryKey;

/*
 * FundPriceHistory JavaBean
 * Daisy Jan 19 Version 1.0
 * co-author
 */

@PrimaryKey("fund_price_history_id")
public class FundPriceHistoryBean {
	private int fund_price_history_id;
	private int fund_id;
	private long price;
	private String date;
	
	public int getFund_id() {
		return fund_id;
	}
	public void setFund_id(int fund_id) {
		this.fund_id = fund_id;
	}
	
	public int getFund_price_history_id() {
		return fund_price_history_id;
	}
	public void setFund_price_history_id(int fund_price_history_id) {
		this.fund_price_history_id = fund_price_history_id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
