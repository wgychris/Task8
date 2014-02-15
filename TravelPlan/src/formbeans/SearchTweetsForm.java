package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchTweetsForm extends FormBean {
	private String place;
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String search) {
		this.place = trimAndConvert(place, "<>\"");
	}


	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		return errors;
	}
}