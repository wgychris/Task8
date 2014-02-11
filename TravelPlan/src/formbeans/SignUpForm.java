package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

import utils.dataConversion;

public class SignUpForm extends FormBean {
	private String userName;
	private String password;
	private String confirmPassword;

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (userName == null || userName.length() == 0) {
			errors.add("customer name is required");
		}
		if (userName.matches(".*[<>\"].*")) {
			errors.add("Name may not contain angle brackets or quotes");
		}
		if (!dataConversion.validStringLength(userName)) {
			errors.add("Name should be no longer than 30 characters");
		}
		if (password == null || password.length() == 0) {
			errors.add("password is required");
		}
		if (password.matches(".*[<>\"].*")) {
			errors.add("Password may not contain angle brackets or quotes");
		}
		if (!password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$")) {
			errors.add("password must contain both character and number, the length is between 6 to 16");
		}
		if (confirmPassword == null || password.length() == 0) {
			errors.add("password is required");
		}
		if (!password.equals(confirmPassword)) {
			errors.add("Please enter the same password");
		}
		return errors;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
