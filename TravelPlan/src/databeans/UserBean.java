package databeans;

import org.genericdao.PrimaryKey;

/*
 * Customer JavaBean
 * Yusi Jan 19 Version 1.0
 * co-author
 */

@PrimaryKey("user_id")
public class UserBean {
	private int user_id;
	private String username;
	private String password;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkPassword(String password) {
		return password.equals(password);
	}

}
