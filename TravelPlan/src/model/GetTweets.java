package model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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

import utils.GeoInfo;
import utils.mapData;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import databeans.*;

/*
 * Processes the parameters from the form in login.jsp.
 * If successful, set the "user" session attribute to the
 * user's User bean and then redirects to view the originally
 * requested photo.  If there was no photo originally requested
 * to be viewed (as specified by the "redirect" hidden form
 * value), just redirect to manage.do to allow the user to manage
 * his photos.
 */
public class GetTweets {

	private static FormBeanFactory<SearchTweetsForm> formBeanFactory = FormBeanFactory
			.getInstance(SearchTweetsForm.class);

	public String getName() {
		return "getTweets.do";
	}

	private static mapData[] fetchGeo(String endPointUrl, String bearerToken)
			throws IOException {
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
			ArrayList<mapData> resultArrayList = new ArrayList<mapData>();
			//System.out.print("come 1 \n");
			while (iterator.hasNext()) {
				JSONObject next = iterator.next();
				//System.out.print("next" + next.toString() + "\n");
				JSONObject geoJsonBig = (JSONObject) next.get("geo");
				//System.out.print("?Null" + (geoJsonBig == null) + "\n");
				if (geoJsonBig != null) {
					JSONArray coordArray = (JSONArray) geoJsonBig
							.get("coordinates");
					if (coordArray.size() == 2) {
						Double lat = (Double) coordArray.get(0);
						Double lon = (Double) coordArray.get(1);
						mapData cor = new mapData(lat, lon);
						resultArrayList.add(cor);
					}
				}

			}

			System.out.print("resultArrayList length: "+resultArrayList.size() + "\n");
			mapData[] cdArray = new mapData[resultArrayList.size()];
			for (int i = 0; i < resultArrayList.size(); i++)
				cdArray[i] = resultArrayList.get(i);
			System.out.print("cdArray length: "+cdArray.length + "\n");
			return cdArray;
		} catch (MalformedURLException e) {
			throw new IOException("Invalid endpoint URL specified.", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static mapData[] getTweetGeo(String place, String key) {
		List<String> errors = new ArrayList<String>();
		//TweetGeoBean[] rs = new TweetGeoBean[0];
		try {

			if (errors.size() != 0) {
				// return "c_login.jsp";
			}
			System.out.println("search is \n" + place);
			int count = 99;
			if (place != null) {

				String token = requestBearerToken("https://api.twitter.com/oauth2/token");
				double [] locations = GeoInfo.getGeoCode(place);
				String queryUrlString = "https://api.twitter.com/1.1/search/tweets.json?q="
						+ URLEncoder.encode(key)
						+ "&count="
						+ count
						+ "&lang=en";
						//+ "goecode=" + locations[0] + "," + locations[1] + "," + "500mi";
				//System.out.println("*******url is " + queryUrlString);
				mapData[] coordArray = fetchGeo(queryUrlString, token);
				System.out
						.println("!!!!coordArray size is" + coordArray.length);
				
				
				return coordArray;

			}
			return null;
		} catch (Exception e) {
			errors.add(e.getMessage());
			return null;
		}
	}
	
	public static TweetBean[] performGetTweets(String place) {
		List<String> errors = new ArrayList<String>();
		try {

			if (errors.size() != 0) {
				// return "c_login.jsp";
			}
			int count = 30;
			if (place != null) {

				String token = requestBearerToken("https://api.twitter.com/oauth2/token");

				String queryUrlString = "https://api.twitter.com/1.1/search/tweets.json?q="
						+ URLEncoder.encode(place)
						+ "&count="
						+ count
						+ "&lang=en" + "&locations=" + URLEncoder.encode(place);
				System.out.print("after geo");
				TweetBean[] tweetBeanArray =
				 fetchTimelineTweet(queryUrlString,
				 token);
				getTweetGeo(place,"hotel");
				return tweetBeanArray;// tweetBeanArray;
			}
			return null;
		} catch (Exception e) {
			errors.add(e.getMessage());
			return null;
		}
	}
	
	public static TweetBean[]  performGetHashTags(String place, String keyword) {
		List<String> errors = new ArrayList<String>();

		try {

			if (errors.size() != 0) {
				// return "c_login.jsp";
			}
			System.out.println("search is \n"
					+place);
			int count = 300;
			if (place != null) {

				double [] location = GeoInfo.getGeoCode(place);
				
				String token = requestBearerToken("https://api.twitter.com/oauth2/token");
				
				String queryUrlString = "https://api.twitter.com/1.1/search/tweets.json?q=" + keyword
						+ "&count="+count+"&lang=en&geocode=" + location[0] + "," + location[1] + "," + "500mi";
			
				TweetBean[] tweetBeanArray = fetchTweetwithTags(queryUrlString,
						token);
				if (tweetBeanArray != null) {
					//request.setAttribute("tweets", tweetBeanArray);
					System.out.println("array length is " + tweetBeanArray.length);
					return tweetBeanArray;
					
				}
			}
			// System.out.println("Tweet result is \n" + tweet+"]]]]");
			//HttpSession session = request.getSession();

			return null;
		} catch (Exception e) {
			errors.add(e.getMessage());
			return null;
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
			}
			// System.out.print(resultArrayList.size() + "\n");
			TweetBean[] twArray = new TweetBean[resultArrayList.size()];
			for (int i = 0; i < resultArrayList.size(); i++)
				twArray[i] = resultArrayList.get(i);
			return twArray;
		} catch (MalformedURLException e) {
			throw new IOException("Invalid endpoint URL specified.", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	private static TweetBean[] fetchTweetwithTags(String endPointUrl,
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
			System.out.print("***********"+connection);
			JSONObject obj = (JSONObject) JSONValue
					.parse(readResponse(connection));

			JSONArray msg = (JSONArray) obj.get("statuses");
			Iterator<JSONObject> iterator = msg.iterator();
			// int i = 0;
			ArrayList<TweetBean> resultArrayList = new ArrayList<TweetBean>();
			while (iterator.hasNext()) {
				JSONObject next = iterator.next();
//				System.out.println("next " + next.toString());
				JSONObject entities = (JSONObject) next.get("entities");
//				System.out.println("entites " + entities.toString());
				JSONArray hashtags = (JSONArray) entities.get("hashtags");
				if ( hashtags == null || hashtags.size() == 0 ) {
					continue;
				} else {
					JSONObject tag = (JSONObject) hashtags.get(0);
					String content = (String) tag.get("text");
//					System.out.println(content );
					TweetBean tBean = new TweetBean();
					tBean.setTag(content);
					resultArrayList.add(tBean);
					
				}
				
				
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
//			System.out.println("!!!!!!"+connection.toString());
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
	
//	public static void main(String[] args) {
//		TweetBean[] tweetBeanArray = new GetTweets().performGetHashTags("pittsburgh" , "ktv");
//		System.out.println(tweetBeanArray.length);
//		for (TweetBean t : tweetBeanArray) {
//			System.out.println(t.getTag());
//		}
//		new GetTweets().getTweetGeo("pittsburgh", "hotel");
//	}

}
