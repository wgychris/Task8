package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ResultForm extends FormBean {
	private String tweets;
	private String flickerbox;

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		/*
		 * if (flickers.length < 1) {
		 * errors.add("At least one tweet is required."); } if (tweets.length <
		 * 1) { errors.add("At least one tweet is required."); }
		 */
		return errors;
	}

	public String getTweets() {
		return "tweets";
//		return tweets;
	}

	public void setTweets(String tweets) {
		this.tweets = tweets;
	}


	public String getFlickerbox() {
		return flickerbox;
	}

	public void setFlickerbox(String flickerbox) {
		this.flickerbox = flickerbox;
	}
}