package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.StatisticsBean;

public class StatisticsDAO extends GenericDAO<StatisticsBean>{
	
	public StatisticsDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(StatisticsBean.class, tableName, cp);
	}
	
	/*
	 * Create New Statistics row (used by employee and customer)
	 * @param statisticsBean(both primary keys shall not be empty)
	 * @return void
	 */
	public void createNewStatistics(StatisticsBean sb) throws RollbackException{
			create(sb);
	}
	
	
	/*
	 * Get statistics for specific place
	 * @param place
	 * @return statisticsBean[]
	 */
	public StatisticsBean[] getStatisticsByPlace(String place) throws RollbackException {
		StatisticsBean[] sb = match(MatchArg.equals("place", place));
		return sb;
	}
	
}
