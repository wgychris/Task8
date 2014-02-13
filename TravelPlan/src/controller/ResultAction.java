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
import databeans.PlanFlickerBean;
import databeans.UserBean;
import formbeans.ResultForm;
import model.GetFlickr;
import model.Model;
import model.PlanDAO;
import model.PlanFlickerDAO;

import org.genericdao.*;
import org.mybeans.form.FormBeanFactory;

public class ResultAction extends Action {
	private FormBeanFactory<ResultForm> formBeanFactory = FormBeanFactory
			.getInstance(ResultForm.class);
	private PlanDAO planDAO;
	private PlanFlickerDAO planFlickerDAO;

	// ini DAOs
	public ResultAction(Model model) {
		planDAO = model.getPlanDAO();
		planFlickerDAO = model.getPlanFlickerDAO();
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
			if(user==null){
				System.out.println("no user");
			}
			ArrayList<PhotoBean> res = new ArrayList<PhotoBean>();
			String place = (String) request.getSession().getAttribute("place");
			System.out.println("place " + place );
			try {
				res = GetFlickr.getPhotos(place, 10);
				// System.out.println(res.size());
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			// System.out.println(res.size()+"+++");

			request.getSession().setAttribute("flickers", res);

			// ArrayList<PhotoBean> flickers = (ArrayList<PhotoBean>) request
			// .getSession().getAttribute("flickers");
			// System.out.println(flickers.size() + "========");
			// request.setAttribute("flickers", flickers);
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

			String[] flickerbox = request.getParameterValues("flickerbox");
			System.out.println(flickerbox[0]);
			for (String s : flickerbox) {
				System.out.println(s);
			}
			/* problem of getting session again */
			if (flickerbox.length == 0) {
				errors.add("Please choose at least 1 picture.");
				return "result.jsp";
			}

			Transaction.begin();
			/*
			 * ArrayList<String> tweets = new ArrayList<String>();
			 * tweets.add("tweet 1"); tweets.add("tweet 2"); ArrayList<String>
			 * flickers = new ArrayList<String>(); flickers.add(
			 * "http://farm9.staticflickr.com/8160/7572579946_d3c5091482_b.jpg"
			 * ); flickers.add(
			 * "http://farm4.staticflickr.com/3217/2685676056_321559e444_b.jpg"
			 * ); flickers.add(
			 * "http://farm9.staticflickr.com/8393/8629407513_8c7479645f.jpg");
			 * flickers
			 * .add("http://farm4.staticflickr.com/3659/5820179578_322e783f2a_b.jpg"
			 * );
			 */

			// request.setAttribute("tweets", tweets);
			// request.setAttribute("flickers", flickers);

			PlanBean planBean = new PlanBean();
			/* process of plan bean */
			planBean.setPlace(place);
			planBean.setUser_id(1);
			planDAO.createAutoIncrement(planBean);
			/*
			 * assume no duplicate place for the same user
			 */
			int plan_id = planDAO.getPlanByPlaceAndUserId(place, 1)
					.getPlan_id();
			for (int i = 0; i < flickerbox.length; i++) {
				PlanFlickerBean pfb = new PlanFlickerBean();
				pfb.setPlan_id(plan_id);
				pfb.setUrl(flickerbox[i]);
				planFlickerDAO.createAutoIncrement(pfb);
			}
			request.setAttribute("message",
					"You have sucessfully shared your travel plan on Twitter");
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
