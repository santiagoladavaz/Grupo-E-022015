package services.impl;

import java.util.ArrayList;
import java.util.List;

import daos.interfaces.PlayerDAO;
import exceptions.PlayerDoesntExistException;
import factories.PlayerFactory;
import model.Defender;
import model.Forward;
import model.GoalKeeper;
import model.MidFielder;
import model.Player;
import services.interfaces.PlayerService;
import services.rest.request.PlayerRequest;
import services.rest.response.PlayerResponse;

public class PlayerServiceImpl implements PlayerService{

	
	private PlayerDAO playerDAO;	
	private PlayerFactory factory = new PlayerFactory();
	
	
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
	
	
	public List<PlayerResponse> toResponse(List<Player> all) {
		List<PlayerResponse> response = new ArrayList<PlayerResponse>();
		for (Player l : all){
			response.add(new PlayerResponse(l));
		}
		
		return response;
	}
	
	private PlayerResponse toPlayerResponse(Player pl){
		return new PlayerResponse(pl);
	}

	@Override
	public void editPlayerByRequest(PlayerRequest request) {
		Player pl = playerDAO.findByID(request.getId());
		if( pl != null){
			pl.setName(request.getName());
			if(request.getPosition() != null && request.getPosition().equals("Goal Keeper")){
				pl.setPosition(new GoalKeeper());
			}
			if(request.getPosition() != null && request.getPosition().equals("Forward")){
				pl.setPosition(new Forward());
			}
			
			if(request.getPosition() != null && request.getPosition().equals("Defender")){
				pl.setPosition(new Defender());
			}
			if(request.getPosition() !=null && request.getPosition().equals("Mid Fielder")){
				pl.setPosition(new MidFielder());
			}
			pl.setRealTeam(request.getTeam());
			
			playerDAO.updatePlayer(pl);
		}else{
			throw new PlayerDoesntExistException("There's no player with name: " + request.getName());
		}
		
		
	}

	@Override
	public PlayerResponse createPlayerByRequest(PlayerRequest request) {
		Player p = factory.createPlayerByRequest(request);
		playerDAO.savePlayer(p);
		return this.toPlayerResponse(p);
	}

	@Override
	public Player searchPlayerByName(String name) {
		return playerDAO.searchPlayerByName(name);
	}

	
	
	
	
	
	
	
	
	

}
