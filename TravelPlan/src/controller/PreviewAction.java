/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.UserBean;
import model.Model;

import org.genericdao.*;

public class PreviewAction extends Action {

	// private PlanDAO planDAO;

	// ini DAOs
	public PreviewAction(Model model) {
		// planDAO = model.getPlanDAO();
	}

	public String getName() {
		return "reslut.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {

			UserBean user = (UserBean) request.getSession()
					.getAttribute("user");
			int user_id = user.getUser_id();

			Transaction.begin();
			
			/* logic business for tweets and flicker */
			ArrayList<String> tweets = (ArrayList<String>) request.getSession()
					.getAttribute("tweets");

			tweets.add("tweet 1");
			tweets.add("tweet 2");
			ArrayList<String> flickers = new ArrayList<String>();
			flickers.add("http://farm4.staticflickr.com/3133/2684857969_bfe473ac40_q.jpg");
			flickers.add("http://farm9.staticflickr.com/8393/8629407513_8c7479645f_q.jpg");
			flickers.add("http://farm4.staticflickr.com/3659/5820179578_322e783f2a_q.jpg");
			flickers.add("http://farm2.staticflickr.com/1152/1427067034_978812a3ec_q.jpg");

			request.setAttribute("tweets", tweets);
			request.setAttribute("flickers", flickers);

			Transaction.commit();
			return "result.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "result.jsp";
		} catch (Exception e) {
			System.out.print("in exception" + e.getMessage());
			errors.add(e.getMessage());
			return "result.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
