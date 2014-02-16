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
				request.setAttribute("place", place);
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
