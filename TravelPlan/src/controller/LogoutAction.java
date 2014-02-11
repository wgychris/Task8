package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;

/*
 * Logs out by setting the "user" session attribute to null.
 * (Actions don't be much simpler than this.)
 */
public class LogoutAction extends Action {

	public LogoutAction(Model model) {
	}

	public String getName() {
		return "logout.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("customer", null);

		request.setAttribute(
				"message",
				"You are now logged out <br></br><a type=\"button\" class=\"btn btn-primary btn-lg\" href=\"entry.do\">Homepage</a>");
		return "c_success.jsp";
	}
}
