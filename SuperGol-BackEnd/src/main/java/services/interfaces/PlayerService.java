package services.interfaces;



import org.springframework.transaction.annotation.Transactional;

import model.Player;

public interface PlayerService {

	@Transactional
	public void savePlayer(Player pl);
}
