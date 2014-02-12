package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import formbeans.SearchTweetsForm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import databeans.TweetBean;

/*
 * Processes the parameters from the form in login.jsp.
 * If successful, set the "user" session attribute to the
 * user's User bean and then redirects to view the originally
 * requested photo.  If there was no photo originally requested
 * to be viewed (as specified by the "redirect" hidden form
 * value), just redirect to manage.do to allow the user to manage
 * his photos.
 */
public class T_SearchTweets extends Action {

	private FormBeanFactory<SearchTweetsForm> formBeanFactory = FormBeanFactory
			.getInstance(SearchTweetsForm.class);

	public String getName() {
		return "t_searchtweets.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {

			String searchString = (String) request.getAttribute("search");

			SearchTweetsForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			// if (!form.isPresent()) {
			// return "t_searchtweets.jsp";
			// }

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				// return "c_login.jsp";
			}
			System.out.println("search is \n"
					+ form.getSearch());
			int count = 30;
			if (form.getSearch() != null) {

				String token = requestBearerToken("https://api.twitter.com/oauth2/token");
				

				// String urlOriginalString =
				// "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=thewbp&count=2";

				String queryUrlString = "https://api.twitter.com/1.1/search/tweets.json?q="
						+ form.getSearch() + "&count="+count+"&result_type=popular";
				TweetBean[] tweetBeanArray = fetchTimelineTweet(queryUrlString,
						token);
				if (tweetBeanArray != null) {
					request.setAttribute("tweets", tweetBeanArray);
					System.out.println(tweetBeanArray.length);
				}
			}
			// System.out.println("Tweet result is \n" + tweet+"]]]]");
			HttpSession session = request.getSession();

			return "t_searchtweets.jsp";
		} catch (Exception e) {
			errors.add(e.getMessage());
			return "t_searchtweets.jsp";
		}
	}

	/**
	 * @param args
	 */

	// Encodes the consumer key and secret to create the basic authorization key
	private static String encodeKeys(String consumerKey, String consumerSecret) {
		try {
			String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
			String encodedConsumerSecret = URLEncoder.encode(consumerSecret,
					"UTF-8");

			String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;
			byte[] encodedBytes = Base64.encodeBase64(fullKey.getBytes());
			// taking binary data into text
			// it's more easily transmitted in things like e-mail and HTML form
			// data.
			return new String(encodedBytes);
		} catch (UnsupportedEncodingException e) {
			return new String();
		}
	}

	// Constructs the request for requesting a bearer token and returns that
	// token as a string
	private static String requestBearerToken(String endPointUrl)
			throws IOException {
		HttpsURLConnection connection = null;
		String encodedCredentials = encodeKeys("2Z6ryvrIAfHVTifQxeSzcQ",
				"DGSh6Mq3iKmTQWLhZ5LHvhYICj92bJueYk9HKDW0g60");

		try {
			URL url = new URL(endPointUrl);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Host", "twitter.com");
			connection.setRequestProperty("User-Agent", "yusizApp"); // ?
			connection.setRequestProperty("Authorization", "Basic "
					+ encodedCredentials);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			connection.setRequestProperty("Content-Length", "29");
			connection.setUseCaches(false);

			writeRequest(connection, "grant_type=client_credentials");

			// Parse the JSON response into a JSON mapped object to fetch fields
			// from.
			JSONObject obj = (JSONObject) JSONValue
					.parse(readResponse(connection));

			if (obj != null) {
				String tokenType = (String) obj.get("token_type");
				String token = (String) obj.get("access_token");

				return ((tokenType.equals("bearer")) && (token != null)) ? token
						: "";
			}
			return new String();
		} catch (MalformedURLException e) {
			throw new IOException("Invalid endpoint URL specified.", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	private static TweetBean[] fetchTimelineTweet(String endPointUrl,
			String bearerToken) throws IOException {
		HttpsURLConnection connection = null;

		try {
			URL url = new URL(endPointUrl);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Host", "api.twitter.com");
			connection.setRequestProperty("User-Agent", "yusizApp");
			connection.setRequestProperty("Authorization", "Bearer "
					+ bearerToken);
			connection.setUseCaches(false);

			JSONObject obj = (JSONObject) JSONValue
					.parse(readResponse(connection));

			JSONArray msg = (JSONArray) obj.get("statuses");
			Iterator<JSONObject> iterator = msg.iterator();
			// int i = 0;
			ArrayList<TweetBean> resultArrayList = new ArrayList<TweetBean>();
			while (iterator.hasNext()) {
				JSONObject next = iterator.next();
				String text = (String) next.get("text");
				TweetBean tBean = new TweetBean();
				tBean.setText(text);
				resultArrayList.add(tBean);
				System.out.println(text + "\n");
				// i++;
			}
			System.out.print(resultArrayList.size() + "\n");
			TweetBean[] twArray = new TweetBean[resultArrayList.size()];
			for (int i = 0; i < resultArrayList.size(); i++)
				twArray[i] = resultArrayList.get(i);
			// return (tweet != null) ? tweet : "";
			System.out.print(twArray.length + "\n");
			return twArray;
		} catch (MalformedURLException e) {
			throw new IOException("Invalid endpoint URL specified.", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	// Writes a request to a connection
	private static boolean writeRequest(HttpsURLConnection connection,
			String textBody) {
		try {
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
					connection.getOutputStream()));
			wr.write(textBody);
			wr.flush();
			wr.close();

			return true;
		} catch (IOException e) {
			return false;
		}
	}

	// Reads a response for a given connection and returns it as a string.
	private static String readResponse(HttpsURLConnection connection) {
		try {
			StringBuilder str = new StringBuilder();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = "";
			while ((line = br.readLine()) != null) {
				str.append(line + System.getProperty("line.separator"));
			}
			return str.toString();
		} catch (IOException e) {
			return new String();
		}
	}

}
