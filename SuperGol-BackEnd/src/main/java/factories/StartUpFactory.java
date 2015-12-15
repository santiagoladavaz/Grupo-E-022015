package factories;

import java.util.ArrayList;
import java.util.List;

import daos.interfaces.LeagueDAO;
import model.League;
import model.Match;
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
	private LeagueDAO leagueDAO;
	
	
	
	public LeagueDAO getLeagueDAO() {
		return leagueDAO;
	}


	public void setLeagueDAO(LeagueDAO leagueDAO) {
		this.leagueDAO = leagueDAO;
	}


	public TeamService getTeamService() {
		return teamService;
	}


	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

//
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
		players.add(playerFactory.createGoalKeeper("Orion"));
		players.add(playerFactory.createDefender("Tobio"));
		players.add(playerFactory.createDefender("Rollin"));
		players.add(playerFactory.createDefender("Monzon"));
		players.add(playerFactory.createMidFielder("Perez"));
		players.add(playerFactory.createMidFielder("Ladavaz"));
		players.add(playerFactory.createMidFielder("Rodriguez"));
		players.add(playerFactory.createMidFielder("Gago"));
		players.add(playerFactory.createForward("Caracol"));
		players.add(playerFactory.createForward("Zagarella"));
		players.add(playerFactory.createForward("Tevez"));
		
		
		
		players.add(playerFactory.createGoalKeeper("Saja"));
		players.add(playerFactory.createDefender("Agued"));
		players.add(playerFactory.createDefender("Castro"));
		players.add(playerFactory.createDefender("Lolo"));
		players.add(playerFactory.createMidFielder("Limi"));
		players.add(playerFactory.createMidFielder("Chavez"));
		players.add(playerFactory.createMidFielder("Luguercio"));
		players.add(playerFactory.createMidFielder("Ponzio"));
		players.add(playerFactory.createForward("Masche"));
		players.add(playerFactory.createForward("Zagarella2"));
		players.add(playerFactory.createForward("Franchescoli"));
		
		
		players.add(playerFactory.createGoalKeeper("Roa"));
		players.add(playerFactory.createDefender("Zanneti"));
		players.add(playerFactory.createDefender("Redondo"));
		players.add(playerFactory.createDefender("Venzini"));
		players.add(playerFactory.createMidFielder("Mas"));
		players.add(playerFactory.createMidFielder("Ortigoza"));
		players.add(playerFactory.createMidFielder("Mercier"));
		players.add(playerFactory.createMidFielder("Buffa"));
		players.add(playerFactory.createForward("Cannigia"));
		players.add(playerFactory.createForward("Zagarella3"));
		players.add(playerFactory.createForward("Batistuta"));
		
		
		
		players.add(playerFactory.createGoalKeeper("Burgos"));
		players.add(playerFactory.createDefender("Zorin"));
		players.add(playerFactory.createDefender("Trota"));
		players.add(playerFactory.createDefender("Flores"));
		players.add(playerFactory.createMidFielder("Paez"));
		players.add(playerFactory.createMidFielder("Fidel"));
		players.add(playerFactory.createMidFielder("Loba"));
		players.add(playerFactory.createMidFielder("Silver"));
		players.add(playerFactory.createForward("Boli"));
		players.add(playerFactory.createForward("Zagarella4"));
		players.add(playerFactory.createForward("Toti"));
		
		
		
		for(Player p :players){
			playerService.savePlayer(p);
		}
		
//		Team t = new Team();
//		t.setName("Boca");
//		t.setPlayers(players);
////		teamService.saveTeam(t);
		
		
//		Team t1 = teamFactory.createFullTeam("River", "r");
//		Team t2 = teamFactory.createFullTeam("Yupanqui", "y");
//		Team t3 = teamFactory.createFullTeam("Independiente","i");
//		Team t4 = teamFactory.createFullTeam("Racing", "ra"); 
//		Team t5 = teamFactory.createFullTeam("Belgrano", "b");
//		Team t6 = teamFactory.createFullTeam("San lorenzo", "s");
//		Team t7 = teamFactory.createFullTeam("Huracan", "h");
//		Team t8 = teamFactory.createFullTeam("Quilmes", "q");
//		
//		saveTeams(t,t1,t2,t3,t4,t5,t6,t7,t8);
		
//		List<Team> tss = new ArrayList<Team>();
//		tss.add(t1);
//		tss.add(t2);
//		tss.add(t3);
//		tss.add(t4);
//		League l = leagueFactory.buildEmptyLeague("Liga - PRUEBA FIXTURE");
//		l.setTeams(tss);
//		leagueFactory.createFixture(l);
//		leagueService.save(l);
		
		
		
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
