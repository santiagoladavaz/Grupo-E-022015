package factories;

import java.util.ArrayList;
import java.util.List;

import model.League;
import model.Player;
import services.interfaces.LeagueService;
import services.interfaces.PlayerService;

public class StartUpFactory {

	
	private PlayerService playerService;
	private LeagueService leagueService;
	private PlayerFactory playerFactory = new PlayerFactory();
	private LeagueFactory leagueFactory = new LeagueFactory();
	
	
	
	public void build(){
		this.buildPlayers();
		this.buildLeagues();
	}
	
	
	public void buildLeagues(){
		List<League>leagues = new ArrayList<League>();
		leagues.add(leagueFactory.buildEmptyLeague("Liga - Argentina"));
		leagues.add(leagueFactory.buildEmptyLeague("Liga - Sarlanga"));
		leagues.add(leagueFactory.buildEmptyLeague("Liga - Macri de mierda"));
		
		
//		for (League l : leagues){
//			leagueService.save(l);
//		}
	}
	
	public void buildPlayers(){
		
		List<Player>players = new ArrayList<Player>();
		players.add(playerFactory.createDefender("Diaz Cata"));
		players.add(playerFactory.createDefender("Fernando Tobio"));
		players.add(playerFactory.createDefender("Alexis Rollin"));
		players.add(playerFactory.createDefender("Fabian monzon"));
		players.add(playerFactory.createGoalKeeper("Agustin Orion"));
		players.add(playerFactory.createMidFielder("Plablo Perez"));
		players.add(playerFactory.createMidFielder("Santiago Ladavaz"));
		players.add(playerFactory.createMidFielder("Clemente Rodriguez"));
		players.add(playerFactory.createForward("Fernando Gago"));
		players.add(playerFactory.createForward("Caracol "));
		players.add(playerFactory.createForward("Luis Zagarella"));
		players.add(playerFactory.createForward("Carlito Teve (Very Difficult)"));
		
		for(Player p :players){
			playerService.savePlayer(p);
		}
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}


	public LeagueService getLeagueService() {
		return leagueService;
	}


	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}


	public PlayerFactory getPlayerFactory() {
		return playerFactory;
	}


	public void setPlayerFactory(PlayerFactory playerFactory) {
		this.playerFactory = playerFactory;
	}


	public LeagueFactory getLeagueFactory() {
		return leagueFactory;
	}


	public void setLeagueFactory(LeagueFactory leagueFactory) {
		this.leagueFactory = leagueFactory;
	}
	
	
	
	
	
	
	
}
