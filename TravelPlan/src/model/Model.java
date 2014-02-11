package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

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
			Transaction.begin();// necessary?
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL = config.getInitParameter("jdbcURL");

			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			uDAO = new UserDAO("customer", pool);
			statisticsDAO = new StatisticsDAO("position", pool);
			planDAO = new PlanDAO("plan", pool);
			Transaction.commit();
		} catch (DAOException e) {
			throw new ServletException(e);
		} catch (RollbackException e) {
			e.printStackTrace();
		}
	}

	public UserDAO getCustomerDAO() {
		return uDAO;
	}

	public PlanDAO getPlanDAO() {
		return planDAO;
	}
	
	public StatisticsDAO getStatisticsDAO(){
		return statisticsDAO;
	}


}
