
package databeans;
import org.genericdao.PrimaryKey;
/*
 * Customer JavaBean
 * Yusi Jan 19 Version 1.0
 * co-author
 */

@PrimaryKey("customer_id")
public class CustomerBean {
	private int customer_id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String addr1;
	private String addr2;
	private String city;
	private String state;
	private String zip;
	private long cash;
	private long tempcash;
	
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddr1() {
		return addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public long getCash() {
		return cash;
	}
	public long getTempcash() {
		return tempcash;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setCash(long cash) {
		this.cash = cash;
	}
	
	public boolean checkPassword(String password) {
		return password.equals(password);
	}
	
	public void setTempcash(long tempcash) {
		this.tempcash = tempcash;
	}
	
}
