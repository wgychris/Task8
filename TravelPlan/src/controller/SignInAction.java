package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import formbeans.SignInForm;

import org.genericdao.*;

import databeans.UserBean;

/*
 * Processes the parameters from the form in login.jsp.
 * If successful, set the "user" session attribute to the
 * user's User bean and then redirects to view the originally
 * requested photo.  If there was no photo originally requested
 * to be viewed (as specified by the "redirect" hidden form
 * value), just redirect to manage.do to allow the user to manage
 * his photos.
 */
public class SignInAction extends Action {
	private FormBeanFactory<SignInForm> formBeanFactory = FormBeanFactory
			.getInstance(SignInForm.class);

	private UserDAO userDAO;

	public SignInAction(Model model) {
		userDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "signin.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			SignInForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "signin.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "signin.jsp";
			}

			Transaction.begin();
			// Look up the user
			UserBean user = userDAO.login(form.getUserName(),
					form.getPassword());

			if (user == null) {
				errors.add("User Name not found");
				Transaction.commit();
				return "signin.jsp";
			}

			if (!user.checkPassword(form.getPassword())) {
				errors.add("Incorrect password");
				return "signin.jsp";
			}

			// Attach (this copy of) the user bean to the session
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(600);
			session.setAttribute("user", user);
			Transaction.commit();
			return "search.do";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "signin.jsp";
		} catch (RollbackException e) {
			return "signin.jsp";
		} catch (Exception e) {
			errors.add(e.getMessage());
			return "signin.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
}
