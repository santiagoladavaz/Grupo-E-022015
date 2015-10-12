package services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import daos.interfaces.UserDAO;
import model.User;
import services.interfaces.UserService;

public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void save(User usr) {
		userDAO.save(usr);		
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	
	
	
	
	

}
