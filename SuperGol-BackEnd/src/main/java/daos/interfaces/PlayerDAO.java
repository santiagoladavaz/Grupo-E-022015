package daos.interfaces;

import model.Player;

public interface PlayerDAO {

	
	public void savePlayer(Player pl);
	public Player searchPlayerByName(String value);
	
}
