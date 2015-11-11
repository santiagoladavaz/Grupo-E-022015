package daos.interfaces;

import java.util.List;

import model.Player;

public interface PlayerDAO {

	
	public void savePlayer(Player pl);
	public Player searchPlayerByName(String value);
	public void erase();
	public void delete(Player player);
	public List<Player> getAll();
	public Player findByID(Integer string);
	public void updatePlayer(Player pl);
	
}
