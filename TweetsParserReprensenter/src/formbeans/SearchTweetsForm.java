package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchTweetsForm extends FormBean {
	private String search;
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = trimAndConvert(search, "<>\"");
	}


	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		return errors;
	}
}