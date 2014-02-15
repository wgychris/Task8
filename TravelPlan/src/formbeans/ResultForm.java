package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ResultForm extends FormBean {
	private String tweetbox;
	public String getTweetbox() {
		return tweetbox;
	}

	public void setTweetbox(String tweetbox) {
		this.tweetbox = tweetbox;
	}

	private String flickrbox;

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		/*
		 * if (flickers.length < 1) {
		 * errors.add("At least one tweet is required."); } if (tweets.length <
		 * 1) { errors.add("At least one tweet is required."); }
		 */
		return errors;
	}

	public String getFlickrbox() {
		return flickrbox;
	}

	public void setFlickerbox(String flickerbox) {
		this.flickrbox = flickerbox;
	}
}