package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.*;


public class PlanTweetDAO extends GenericDAO<PlanTweetBean> {

	public PlanTweetDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(PlanTweetBean.class, tableName, cp);
	}

	/*
	 * void createNewPlan
	 * 
	 * @param transactionBean
	 * 
	 * @return void
	 */
	public void createNewPlan(PlanTweetBean bean) throws RollbackException {
		createAutoIncrement(bean);
	}


	/*
	 * PlanFlickerBean[] getPlanFlikcrByPlanId
	 * 
	 * @description Get all PlanFlickrs of a certain user
	 * 
	 * @param user_id
	 * 
	 * @return PlanFlickrBean[]
	 */
	public PlanTweetBean[] getPlanTweetByPlanId(int plan_id) throws RollbackException {
		PlanTweetBean[] pfb = match(MatchArg.equals("plan_id", plan_id));
		if (pfb != null && pfb.length > 0)
			return pfb;
		else
			return null;

	}
}
