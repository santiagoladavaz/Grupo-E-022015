package services.interfaces;

import org.springframework.transaction.annotation.Transactional;

import model.User;

public interface UserService {

	@Transactional
	public void save(User usr);
}
