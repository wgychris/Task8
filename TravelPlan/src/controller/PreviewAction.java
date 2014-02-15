/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.PlanFlickrBean;
import databeans.PlanTweetBean;
import model.Model;
import model.PlanFlickrDAO;
import model.PlanTweetDAO;

import org.genericdao.*;

public class PreviewAction extends Action {

	private PlanFlickrDAO planFlickrDAO;
	private PlanTweetDAO planTweetDAO;

	// ini DAOs
	public PreviewAction(Model model) {
		planFlickrDAO = model.getPlanFlickerDAO();
		planTweetDAO = model.getPlanTweetDAO();
	}

	public String getName() {
		return "preview.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			String idString = request.getParameter("id");
			if (idString == null || idString == "") {
				errors.add("Please select a plan to preview");
				return "viewPlan.do";
			}
			Transaction.begin();
			int plan_id = Integer.parseInt(idString);
			PlanFlickrBean[] pfBeans = planFlickrDAO
					.getPlanFlikcerByPlanId(plan_id);
			request.setAttribute("pfBeans", pfBeans);
			PlanTweetBean[] ptBeans = planTweetDAO.getPlanTweetByPlanId(plan_id);
			request.setAttribute("ptBeans", ptBeans);

			Transaction.commit();
			return "preview.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "preview.jsp";
		} catch (Exception e) {
			System.out.print("in exception" + e.getMessage());
			errors.add(e.getMessage());
			return "preview.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
