package daos.interfaces;

import exceptions.PlayerDoesntExistException;
import model.User;

public interface UserDAO {
	
	public void save(User usr);
	public User obtainUser(String userName) throws PlayerDoesntExistException;
	public void deleteUser(User u1);

}
