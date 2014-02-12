package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class CopyOfResearchFundForm extends FormBean {
	private String fundTicker;
	
	public String getFundTicker() {
		return fundTicker;
	}

	public void setFundTicker(String fundTicker) {
		this.fundTicker = trimAndConvert(fundTicker, "<>\"");
	}


	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		if (fundTicker == null || fundTicker.length() == 0) {
			errors.add("FundTicker is required");
		}
		
		return errors;
	}
}