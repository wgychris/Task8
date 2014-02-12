package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.UserBean;
import formbeans.SignUpForm;

/*
 * Processes the parameters from the form in signup.jsp.
 * If successful, set the "user" session attribute to the
 * user's User bean and then redirects to view the originally
 * requested photo.  If there was no photo originally requested
 * to be viewed (as specified by the "redirect" hidden form
 * value), just redirect to manage.do to allow the user to manage
 * his photos.
 */

public class SignUpAction extends Action {
	private FormBeanFactory<SignUpForm> formBeanFactory = FormBeanFactory
			.getInstance(SignUpForm.class);

	private UserDAO userDAO;

	public SignUpAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "signup.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			SignUpForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "signup.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "signup.jsp";
			}

			Transaction.begin();
			if (userDAO.getUserId(form.getUserName()) != -1) {
				errors.add("UserName is already existed!");
				Transaction.commit();
				return "signup.jsp";
			}
			Transaction.commit();

			// Look up the user
			UserBean cb = new UserBean();
			cb.setUsername(form.getUserName());
			cb.setPassword(form.getPassword());
			Transaction.begin();
			userDAO.createAutoIncrement(cb);
			request.setAttribute("message", "new user has been created");
			Transaction.commit();
			return "success.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "signup.jsp";
		} catch (RollbackException e) {
			return "signup.jsp";
		} catch (Exception e) {
			errors.add(e.getMessage());
			return "signup.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
}
