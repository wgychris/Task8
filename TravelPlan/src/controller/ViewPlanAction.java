/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.PlanDAO;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import utils.ScheduleData;
import databeans.PlanBean;
import databeans.UserBean;

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
			// user from session;
			UserBean user = (UserBean) request.getSession()
					.getAttribute("user");
			//if user is not log in, find out if the url gives params to indicate the userid
			int user_id;
			if(user == null) {
				String userid = request.getParameter("userid");
				 user_id = Integer.parseInt(userid);
			} else { // user is login
				 user_id = user.getUser_id();
			}
			// int user_id = user.getUser_id();
//			int user_id = 1;

			Transaction.begin();
			PlanBean[] planBeans = planDAO.getPlanByUserId(user_id);
			if(planBeans==null){
				return "viewPlan.jsp";
			}else{
			ArrayList<ScheduleData> sDatas = new ArrayList<ScheduleData>();
			for (int i = 0; i < planBeans.length; i++) {
				if (planBeans[i].getDateFrom() != null) {
					PlanBean pb = planBeans[i];
					Calendar cfrom = Calendar.getInstance();
					cfrom.setTime(pb.getDateFrom());
					Calendar cto = Calendar.getInstance();
					cto.setTime(pb.getDateTo());
					sDatas.add(new ScheduleData(pb.getPlace(), cfrom
							.get(Calendar.YEAR), cfrom.get(Calendar.MONTH),
							cfrom.get(Calendar.DAY_OF_MONTH), cto
									.get(Calendar.YEAR), cto
									.get(Calendar.MONTH), cto
									.get(Calendar.DAY_OF_MONTH)));
				}
			}
			request.setAttribute("schedules", sDatas);
			request.setAttribute("planArray", planBeans);
			Transaction.commit();
			return "viewPlan.jsp";
			}
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "viewPlan.jsp";
		} catch (Exception e) {
			System.out.print("in exception: " + e.getMessage());
			errors.add(e.getMessage());
			return "viewPlan.jsp";
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}

	}

}
