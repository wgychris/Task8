package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchForm extends FormBean {
	private String place;

	public String getPlace() {
		return place;
	}

	public void setFundTicker(String fundTicker) {
		this.place = trimAndConvert(fundTicker, "<>\"");
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		if (place == null || place.length() == 0) {
			errors.add("FundTicker is required");
		}

		return errors;
	}
}