package services.interfaces;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Player;

public interface PlayerService {

	@Transactional
	public void savePlayer(Player pl);

	public List<Player> getAll();
}
