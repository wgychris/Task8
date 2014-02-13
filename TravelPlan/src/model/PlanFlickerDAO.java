package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.*;


public class PlanFlickerDAO extends GenericDAO<PlanFlickerBean> {

	public PlanFlickerDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(PlanFlickerBean.class, tableName, cp);
	}

	/*
	 * void createNewPlan
	 * 
	 * @param transactionBean
	 * 
	 * @return void
	 */
	public void createNewPlan(PlanFlickerBean bean) throws RollbackException {
		createAutoIncrement(bean);
	}


	/*
	 * PlanFlickerBean[] getPlanFlikcerByPlanId
	 * 
	 * @description Get all PlanFlickers of a certain user
	 * 
	 * @param user_id
	 * 
	 * @return PlanFlickerBean[]
	 */
	public PlanFlickerBean[] getPlanFlikcerByPlanId(int plan_id) throws RollbackException {
		PlanFlickerBean[] pfb = match(MatchArg.equals("plan_id", plan_id));
		if (pfb != null && pfb.length > 0)
			return pfb;
		else
			return null;

	}
}
