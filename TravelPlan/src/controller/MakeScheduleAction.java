/**
 * 
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.PlanBean;
import databeans.PlanFlickrBean;
import databeans.UserBean;
import formbeans.MakeScheduleForm;
import model.Model;
import model.PlanDAO;
import model.PlanFlickrDAO;

import org.genericdao.*;
import org.mybeans.form.FormBeanFactory;

import utils.ScheduleData;

public class MakeScheduleAction extends Action {
	private FormBeanFactory<MakeScheduleForm> formBeanFactory = FormBeanFactory
			.getInstance(MakeScheduleForm.class);
	private PlanFlickrDAO planFlickrDAO;
	private PlanDAO planDAO;

	// ini DAOs
	public MakeScheduleAction(Model model) {
		planFlickrDAO = model.getPlanFlickerDAO();
		planDAO = model.getPlanDAO();
	}

	public String getName() {
		return "makeSchedule.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		String idString;
		ArrayList<ScheduleData> schedules = new ArrayList<ScheduleData>();
		try {
			MakeScheduleForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			if (!form.isPresent()) {
				idString = request.getParameter("id");
				request.setAttribute("id", idString);
//				schedules = (ArrayList<ScheduleData>) request.getAttribute("schedules");
//				System.out.println(schedules.size());
//				request.setAttribute("schedules", schedules);
				if (idString == null || idString == "") {
					errors.add("Please select a plan to make schedule");
					return "viewPlan.jsp";
				}
				return "makeSchedule.jsp";
			}
			Transaction.begin();
			idString = request.getParameter("id");
			request.setAttribute("id", idString);
			if (idString == null || idString == "") {
				errors.add("Please select a plan to make schedule");
				return "viewPlan.jsp";
			}
//			schedules = (ArrayList<ScheduleData>) request.getAttribute("schedules");
//			request.setAttribute("schedules", schedules);
//			System.out.println(schedules.size());
			int plan_id = Integer.parseInt(idString);
			PlanFlickrBean[] pfBeans = planFlickrDAO
					.getPlanFlikcerByPlanId(plan_id);
			request.setAttribute("pfBeans", pfBeans);

			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date dateFrom = sFormat.parse(form.getDateFrom());
			Date dateTo = sFormat.parse(form.getDateTo());
			if (!dateFrom.before(dateTo)) {
				errors.add("Second date no earlier than first date.");
				return "makeSchedule.jsp";
			}

			PlanBean planBean = planDAO.getPlanByPlanId(plan_id);
			planBean.setDateFrom(dateFrom);
			planBean.setDateTo(dateTo);
			planDAO.update(planBean);

			Transaction.commit();
			request.setAttribute(
					"message",
					"You have sucessfully made a schedule");
			return "success.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "makeSchedule.jsp";
		} catch (Exception e) {
			System.out.print("in exception" + e.getMessage());
			errors.add(e.getMessage());
			return "makeSchedule.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
