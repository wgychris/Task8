/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.UserBean;
import formbeans.ResultForm;
import model.Model;

import org.genericdao.*;
import org.mybeans.form.FormBeanFactory;

public class ResultAction extends Action {
	private FormBeanFactory<ResultForm> formBeanFactory = FormBeanFactory
			.getInstance(ResultForm.class);

	// ini DAOs
	public ResultAction(Model model) {
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

			if (!form.isPresent()) {
				return "result.jsp";
			}
			UserBean user = (UserBean) request.getSession()
					.getAttribute("user");
			int user_id = user.getUser_id();

			Transaction.begin();
			ArrayList<String> tweets = new ArrayList<String>();
			tweets.add("tweet 1");
			tweets.add("tweet 2");
			ArrayList<String> flickers = new ArrayList<String>();
			flickers.add("http://farm9.staticflickr.com/8160/7572579946_d3c5091482_b.jpg");
			flickers.add("http://farm4.staticflickr.com/3217/2685676056_321559e444_b.jpg");
			flickers.add("http://farm9.staticflickr.com/8393/8629407513_8c7479645f.jpg");
			flickers.add("http://farm4.staticflickr.com/3659/5820179578_322e783f2a_b.jpg");

			request.setAttribute("tweets", tweets);
			request.setAttribute("flickers", flickers);

			String[] checkboxes = request.getParameterValues("checkbox");
			// checkbox process in both front and back end needed.
			request.setAttribute(
					"message",
					"You have sucessfully shared your travel plan on Twitter");
			Transaction.commit();
			return "success.jsp";
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
