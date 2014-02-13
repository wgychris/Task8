package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.*;

public class PlanDAO extends GenericDAO<PlanBean> {

	public PlanDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(PlanBean.class, tableName, cp);
	}

	/*
	 * void createNewPlan
	 * 
	 * @param transactionBean
	 * 
	 * @return void
	 */
	public void createNewPlan(PlanBean bean) throws RollbackException {
		createAutoIncrement(bean);
	}

	/*
	 * TransactionBean[] getAllPlans
	 * 
	 * @description Get all Transactions
	 * 
	 * @return TransactionBean[]
	 */
	public PlanBean[] getAllPlans() throws RollbackException {
		PlanBean[] planArray = match();
		return planArray;
	}

	/*
	 * TransactionBean[] getPlanByUserId
	 * 
	 * @description Get all Plans of a certain user
	 * 
	 * @param user_id
	 * 
	 * @return TransactionBean[]
	 */
	public PlanBean[] getPlanByUserId(int user_id) throws RollbackException {
		PlanBean[] planArray = match(MatchArg.equals("user_id", user_id));
		if (planArray != null && planArray.length > 0)
			return planArray;
		else
			return null;

	}

	public PlanBean getPlanByPlaceAndUserId(String place, int user_id)
			throws RollbackException {
		PlanBean[] pb = match(MatchArg.and(MatchArg.equals("user_id", user_id),MatchArg.equals(
				"place", place)));
		if (pb == null || pb.length == 0) {
			return null;
		}
		return pb[0];
	}

}
