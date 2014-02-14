package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class MakeScheduleForm extends FormBean {
	private String dateFrom;
	private String dateTo;
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		return errors;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
}
