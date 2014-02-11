/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.PlanBean;
import databeans.UserBean;
import model.Model;
import model.PlanDAO;

import org.genericdao.*;

public class ViewPlanAction extends Action {

	private PlanDAO planDAO;

	// ini DAOs
	public ViewPlanAction(Model model) {
		planDAO = model.getPlanDAO();
	}

	public String getName() {

		return "viewPlan.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {

			// customer from session;
			UserBean user = (UserBean) request.getSession().getAttribute(
					"user");
			int user_id = user.getUser_id();

			Transaction.begin();
			PlanBean[] planArray = planDAO.getPlanByUserId(user_id);


			request.setAttribute("planArray", planArray); 
														
			Transaction.commit();
			return "viewPlan.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "viewPlan.jsp";
		} catch (Exception e) {
			System.out.print("in exception" + e.getMessage());
			errors.add(e.getMessage());
			return "viewPlan.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
