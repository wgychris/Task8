package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

import databeans.UserBean;

/*
 * General Model
 * Shiyuan Fang Version 1.0
 */

public class Model {
	private UserDAO uDAO;
	private PlanDAO planDAO;
	private StatisticsDAO statisticsDAO;
	private PlanFlickerDAO planFlickerDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL = config.getInitParameter("jdbcURL");

			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			uDAO = new UserDAO("user", pool);
			statisticsDAO = new StatisticsDAO("statistics", pool);
			planDAO = new PlanDAO("plan", pool);
			planFlickerDAO = new PlanFlickerDAO("planFlicker", pool);

			int count = uDAO.getCount();
			if (count == 0) {
				UserBean userBean = new UserBean();
				userBean.setUsername("user");
				userBean.setPassword("user123");
				uDAO.createAutoIncrement(userBean);
			}

		} catch (DAOException e) {
			throw new ServletException(e);
		} catch (RollbackException e) {
			e.printStackTrace();
		}
	}

	public UserDAO getUserDAO() {
		return uDAO;
	}

	public PlanDAO getPlanDAO() {
		return planDAO;
	}

	public StatisticsDAO getStatisticsDAO() {
		return statisticsDAO;
	}

	public PlanFlickerDAO getPlanFlickerDAO() {
		return planFlickerDAO;
	}
}
