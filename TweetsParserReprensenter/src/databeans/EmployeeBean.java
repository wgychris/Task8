package databeans;

import org.genericdao.PrimaryKey;

/*
 * EmployeeBean 
 * Yusi Jan 19 Version
 * co-author:
 */
@PrimaryKey("username")
public class EmployeeBean {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
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
	public boolean checkPassword(String password2) {
		return password.equals(password2);
	}
	
	
}
