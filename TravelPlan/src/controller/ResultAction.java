/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLStreamException;

import org.genericdao.RollbackException;

import databeans.PhotoBean;
import databeans.PlanBean;
import databeans.PlanFlickrBean;
import databeans.PlanTweetBean;
import databeans.TweetBean;
import databeans.UserBean;
import formbeans.ResultForm;
import model.GetFlickr;
import model.GetTweets;
import model.Model;
import model.PlanDAO;
import model.PlanFlickrDAO;
import model.PlanTweetDAO;

import org.genericdao.*;
import org.mybeans.form.FormBeanFactory;

public class ResultAction extends Action {
	private FormBeanFactory<ResultForm> formBeanFactory = FormBeanFactory
			.getInstance(ResultForm.class);
	private PlanDAO planDAO;
	private PlanFlickrDAO planFlickrDAO;
	private PlanTweetDAO planTweetDAO;

	// ini DAOs
	public ResultAction(Model model) {
		planDAO = model.getPlanDAO();
		planFlickrDAO = model.getPlanFlickerDAO();
		planTweetDAO = model.getPlanTweetDAO();
	}

	public String getName() {
		return "result.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			ResultForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			UserBean user = (UserBean) request.getSession()
					.getAttribute("user");
			int user_id = user.getUser_id();
			
			System.out.println("user is " + user_id);
			
			if (user == null) {
				System.out.println("no user");
			}
			ArrayList<PhotoBean> res = new ArrayList<PhotoBean>();
			String place = (String) request.getSession().getAttribute("place");
			System.out.println("place " + place);
			try {
				res = GetFlickr.getPhotos(place, 15);
				//System.out.println(res.size());
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			// System.out.println(res.size()+"+++");

			
				
			request.getSession().setAttribute("flickrs", res);
			TweetBean[] tweetBeanArray  = GetTweets.performGetTweets(place); // ???Request
			request.getSession().setAttribute("tweets", tweetBeanArray);
			System.out.print("tweets string "+ tweetBeanArray.toString());
			
			if (!form.isPresent()) {
				return "result.jsp";
			}
			// UserBean user = (UserBean) request.getSession()
			// .getAttribute("user");
			// int user_id = user.getUser_id();

			// ArrayList<PhotoBean> arr=(ArrayList<PhotoBean>)
			// request.getSession().getAttribute("photos");
			// System.out.println(arr.size());
			// request.setAttribute("photos", arr);

			String[] flickrbox = request.getParameterValues("flickrbox");
			System.out.println(flickrbox[0]);
			for (String s : flickrbox) {
				System.out.println(s);
			}
			
			String[] tweetbox = request.getParameterValues("tweetbox");
			
			/* problem of getting session again */
			if (flickrbox.length == 0) {
				errors.add("Please choose at least 1 picture.");
				return "result.jsp";
			}

			Transaction.begin();
			
			PlanBean planBean = new PlanBean();
			/* process of plan bean */
			planBean.setPlace(place);
			planBean.setUser_id(user_id);
			planDAO.createAutoIncrement(planBean);
			/*
			 * assume no duplicate place for the same user
			 */
			int plan_id = planDAO.getPlanByPlaceAndUserId(place, user_id)
					.getPlan_id();
			for (int i = 0; i < flickrbox.length; i++) {
				PlanFlickrBean pfb = new PlanFlickrBean();
				pfb.setPlan_id(plan_id);
				pfb.setUrl(flickrbox[i]);
				planFlickrDAO.createAutoIncrement(pfb);
			}
			
			for (int i = 0; i < tweetbox.length; i++) {
				PlanTweetBean ptb = new PlanTweetBean();
				ptb.setPlan_id(plan_id);
				ptb.setTweet(tweetbox[i]);
				planTweetDAO.createAutoIncrement(ptb);
			}
			request.setAttribute("message",
					"You have sucessfully made your travel plan.");
			Transaction.commit();
			return "success.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "result.jsp";
		} catch (Exception e) {
			System.out.print("exception: " + e.getMessage());
			errors.add(e.getMessage());
			return "result.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
