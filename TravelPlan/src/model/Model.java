package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

/*
 * General Model
 * Shiyuan Fang Version 1.0
 */

public class Model {
	private UserDAO uDAO;
	private PlanDAO planDAO;
	private StatisticsDAO statisticsDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL = config.getInitParameter("jdbcURL");

			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			uDAO = new UserDAO("user", pool);
			statisticsDAO = new StatisticsDAO("statistics", pool);
			planDAO = new PlanDAO("plan", pool);
		} catch (DAOException e) {
			throw new ServletException(e);
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

}
