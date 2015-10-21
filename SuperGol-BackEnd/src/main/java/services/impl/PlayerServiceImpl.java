package services.impl;

import java.util.List;

import daos.interfaces.PlayerDAO;
import model.Player;
import services.interfaces.PlayerService;

public class PlayerServiceImpl implements PlayerService{

	
	private PlayerDAO playerDAO;	
	
	
	@Override
	public void savePlayer(Player pl) {
		playerDAO.savePlayer(pl);
	}
	
	public PlayerDAO getPlayerDAO() {
		return playerDAO;
	}
	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	public List<Player> getAll(){
		return playerDAO.getAll();
	}
	
	
	
	
	
	
	
	
	

}
