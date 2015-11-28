package factories;

import java.util.ArrayList;
import java.util.List;

import model.League;
import model.Player;
import model.Team;
import services.interfaces.LeagueService;
import services.interfaces.PlayerService;
import services.interfaces.TeamService;
import services.rest.impl.UserServiceRestImpl;

public class StartUpFactory {

	
	private PlayerService playerService;
	private LeagueService leagueService;
	private PlayerFactory playerFactory = new PlayerFactory();
	private LeagueFactory leagueFactory = new LeagueFactory();
	private TeamFactory teamFactory = new TeamFactory();
	private TeamService teamService;
	private UserServiceRestImpl userService;
	
	
	
	public TeamService getTeamService() {
		return teamService;
	}


	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}


	public void build(){
		this.buildPlayers();
		this.buildLeagues();
	}
	
	
	public void buildLeagues(){
		List<League>leagues = new ArrayList<League>();
		leagues.add(leagueFactory.buildEmptyLeague("Liga - Argentina"));
		leagues.add(leagueFactory.buildEmptyLeague("Liga - Sarlanga"));
		leagues.add(leagueFactory.buildEmptyLeague("Liga - Macri de mierda"));
		
		
		for (League l : leagues){
			leagueService.save(l);
			
		}
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
			p.setBoca("Boca");
		}
		
		Team t = new Team();
		t.setName("Boca");
		t.setPlayers(players);
//		teamService.saveTeam(t);
		
		
		Team t1 = teamFactory.createFullTeam("River", "r");
		Team t2 = teamFactory.createFullTeam("Yupanqui", "y");
		Team t3 = teamFactory.createFullTeam("Independiente","i");
		Team t4 = teamFactory.createFullTeam("Racing", "ra"); 
		Team t5 = teamFactory.createFullTeam("Belgrano", "b");
		Team t6 = teamFactory.createFullTeam("San lorenzo", "s");
		Team t7 = teamFactory.createFullTeam("Huracan", "h");
		Team t8 = teamFactory.createFullTeam("Quilmes", "q");
		
		saveTeams(t,t1,t2,t3,t4,t5,t6,t7,t8);
		
//		userService.getPlayer(2);
		
	}

	
	public UserServiceRestImpl getUserService() {
		return userService;
	}


	public void setUserService(UserServiceRestImpl userService) {
		this.userService = userService;
	}


	private void saveTeams(Team...teams ){
		for (int i = 0; i < teams.length; i++){
			teamService.saveTeam(teams[i]);
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
