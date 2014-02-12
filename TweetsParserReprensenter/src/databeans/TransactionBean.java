package databeans;

import org.genericdao.PrimaryKey;

/*
 * Transaction JavaBean
 * Daisy Jan 19 Version 1.0
 * co-author
 */

@PrimaryKey("transaction_id")
public class TransactionBean {
	private int transaction_id;
	private int customer_id;
	private String execute_date;
	private int fund_id;
	private long shares;
	private String transaction_type;
	private long amount;

	
	



	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getExecute_date() {
		return execute_date;
	}

	public void setExecute_date(String execute_date) {
		this.execute_date = execute_date;
	}
	

	public long getShares() {
		return shares;
	}

	public void setShares(long shares) {
		this.shares = shares;
	}
	public int getFund_id() {
		return fund_id;
	}

	public void setFund_id(int fund_id) {
		this.fund_id = fund_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
