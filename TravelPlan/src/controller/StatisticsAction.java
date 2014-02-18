/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.TweetBean;
import databeans.UserBean;
import model.GetTweets;
import model.Model;

import org.genericdao.*;

import utils.CloudMaker;
import utils.mapData;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class StatisticsAction extends Action {

	// private PlanDAO planDAO;

	// ini DAOs
	public StatisticsAction(Model model) {
		// planDAO = model.getPlanDAO();
	}

	public String getName() {
		return "statistics.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {

			UserBean user = (UserBean) request.getSession()
					.getAttribute("user");

			Transaction.begin();
			
			if(request.getParameter("place")!=null) {
				String place = request.getParameter("place");
				TweetBean[] tbarray =  GetTweets.performGetHashTags(place, "vacation");
				StringBuilder sb = new StringBuilder();
				for (TweetBean tweet : tbarray) {
					sb.append(tweet.getTag());
					sb.append(" ");
				}
				String words = sb.toString();
//				String [] words = {"Peking", "Pittsburgh","NewYord","CMU","Nanjing"};
				String url = CloudMaker.getWordCloud(words);
				mapData[] maps=GetTweets.getTweetGeo(place,"restaurant");
				//System.out.println("length:"+maps.length);
				request.setAttribute("maps", maps);
				request.setAttribute("place", place);
				request.setAttribute("url", url);
			} else {
				request.setAttribute("place", "Your Choice");
				request.setAttribute("url", "");
			}
			
			

			Transaction.commit();
			return "statistics.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "statistics.jsp";
		} catch (Exception e) {
			System.out.print("in exception" + e.getMessage());
			errors.add(e.getMessage());
			return "statistics.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
