package services.interfaces;

import javax.transaction.Transactional;

import model.Player;

public interface PlayerService {

	@Transactional
	public void savePlayer(Player pl);
}
