package services.impl;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import daos.interfaces.LeagueDAO;
import model.League;
import services.interfaces.LeagueService;

public class LeagueServiceImpl implements LeagueService {

	private LeagueDAO leagueDAO;

	
	
	
	@Override
	@Transactional
	public List<League> obtainAllLeagues() {
		return leagueDAO.obtainLeagues();
	}

	@Override
	@Transactional
	public League createLeague(String name, int maxPlayers, int minPlayers) {
		return leagueDAO.createLeague(name, maxPlayers, minPlayers);		
	}

	@Override
	@Transactional
	public void editLeague(Integer id, String name, Integer maxPlayers, Integer minPlayers) {
		leagueDAO.editLeague(id, name, maxPlayers, minPlayers);
	}	
	
	@Override
	@Transactional
	public void save(League l) {
		leagueDAO.save(l);
		
	}
	
	
	public LeagueDAO getLeagueDAO() {
		return leagueDAO;
	}

	public void setLeagueDAO(LeagueDAO leagueDAO) {
		this.leagueDAO = leagueDAO;
	}

	
}
