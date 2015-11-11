package daos.interfaces;

import java.util.List;

import model.League;

public interface LeagueDAO {

	
	public List<League>obtainLeagues();
	public League createLeague(String name, int maxPlayers, int minPlayers);
	public void editLeague(Integer id,String name,Integer maxPlayers, Integer minPlayers);
	public void save(League l);
	
	
}
