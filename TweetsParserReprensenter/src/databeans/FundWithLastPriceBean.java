package databeans;

import org.genericdao.PrimaryKey;

/*
 * Fund JavaBean
 * Daisy Jan 19 Version 1.0
 * co-author
 */

@PrimaryKey("fund_id")
public class FundWithLastPriceBean {
	private int fund_id;
	private String name;
	private String symbol;
	private long price;

	public int getFund_id() {
		return fund_id;
	}

	public void setFund_id(int fund_id) {
		this.fund_id = fund_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	
}
