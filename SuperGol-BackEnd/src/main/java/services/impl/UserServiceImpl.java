package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import daos.interfaces.UserDAO;
import model.User;
import services.interfaces.UserService;

public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	@Override
	public void save(User usr) {
		userDAO.save(usr);		
	}

	@Override
	public User obtainUser(String usuario) {
		return userDAO.obtainUser(usuario);
	}

	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	
	
	
	
	
	

}
