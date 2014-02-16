package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CloudMaker {

	public static String getWordCloud (String[] args) {
		try {
			HttpResponse<JsonNode> request = Unirest.post("https://gatheringpoint-word-cloud-maker.p.mashape.com/index.php")
					  .header("X-Mashape-Authorization", "X7BgaL6YVe953dH7vdUwK1PciBWYYDlX")
					  .field("height", "300")
					  .field("textblock", "beijing shenyang shenyang shenyang beijing newyork pittsburgh")
					  .field("width", "400")
					  .asJson();
			JsonNode node = request.getBody();
//			node.getObject().get("url");
			try {
//				System.out.println(node.getObject().get("url"));
				return node.getObject().get("url") + "";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "no key words";
			}
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "no key words";
		}
	}
	
	

}
