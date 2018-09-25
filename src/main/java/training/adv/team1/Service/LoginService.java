package training.adv.team1.Service;

import training.adv.team1.DAO.UsersDaoImpl;
import training.adv.team1.Domain.User;

public class LoginService {
	private UsersDaoImpl userDaoImpl;

	public UsersDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UsersDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	
	public User findUserById(int id){
		return this.findUserById(id);
	}
	
	
}
