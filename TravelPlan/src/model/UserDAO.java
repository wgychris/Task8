package model;

/*
 * UserDAO
 * Yusi Jan 19 Version 1.0
 * co-author
 */

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.UserBean;

public class UserDAO extends GenericDAO<UserBean> {

	public UserDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(UserBean.class, tableName, cp);
	}

	/*
	 * int getUserId
	 * 
	 * @description Get user id
	 * 
	 * @param username
	 * 
	 * @return userid or -1 if the username not existed.
	 */

	public int getUserId(String username) throws RollbackException {

		UserBean[] user = match(MatchArg.equals("username", username));
		if (user.length > 0)
			return user[0].getUser_id();
		else
			return -1;
	}

	/*
	 * void changePassword
	 * 
	 * @description Change password
	 * 
	 * @param User_id, password
	 * 
	 * @return void
	 */
	public void changePassword(int User_id, String password)
			throws RollbackException {
		UserBean user = read(User_id);

		if (user == null) {
			throw new RollbackException("User no longer exists");
		}

		user.setPassword(password);

		update(user);
	}

	/*
	 * boolean checkPassword
	 * 
	 * @description Check Password
	 * 
	 * @param User_id, password
	 * 
	 * @return true if the password is correct otherwise false
	 */
	public boolean checkPassword(int User_id, String password)
			throws RollbackException {

		UserBean user = read(User_id);
		if (user == null) {
			return false;
		}
		if (user.getPassword().equals(password))
			return true;
		else
			return false;

	}

	/*
	 * UserBean getUserInfo
	 * 
	 * @description Get all information of a certain User
	 * 
	 * @param User id
	 * 
	 * @return UserBean or null if User_id not exist
	 */
	public UserBean getUserInfo(int User_id) throws RollbackException {
		UserBean user = read(User_id);
		if (user == null)
			return null;
		return user;
	}

	/*
	 * UserBean[] getAllUsers
	 * 
	 * @description Get all Users beans
	 * 
	 * @param none
	 * 
	 * @return UserBean[]
	 */
	public UserBean[] getAllUsers() throws RollbackException {
		UserBean[] users = match();
		return users;
	}

	/*
	 * void createNewUser
	 * 
	 * @description Create New User Account (used by employee)
	 * 
	 * @param Userbean
	 * 
	 * @return void
	 */
	public void createNewUser(UserBean user) throws RollbackException {
		create(user);
	}

	public UserBean login(String userName, String password)
			throws RollbackException {
		UserBean[] user = match(new MatchArg[] {
				MatchArg.equals("username", userName),
				MatchArg.equals("password", password) });
		if (user.length == 0)
			return null;
		return user[0];
	}

	public UserBean[] getRelateUsers(String username) throws RollbackException {
		UserBean[] users = match(MatchArg.contains("username", username));
		return users;
	}

}
