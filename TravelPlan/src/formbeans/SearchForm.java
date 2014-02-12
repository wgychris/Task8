package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchForm extends FormBean {
	private String place;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = trimAndConvert(place, "<>\"");
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		if (place == null || place.length() == 0) {
			errors.add("Please enter a place");
		}
		return errors;
	}
}