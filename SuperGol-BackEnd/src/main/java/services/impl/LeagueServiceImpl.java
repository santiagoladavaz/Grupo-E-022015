package services.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import daos.interfaces.LeagueDAO;
import model.League;
import model.User;
import services.interfaces.LeagueService;
import services.interfaces.UserService;
import services.rest.response.LeagueResponse;

public class LeagueServiceImpl implements LeagueService {

	private LeagueDAO leagueDAO;
	private UserService userService;

	
	
	
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
	
	
	public List<LeagueResponse> toResponse(List<League>list){
		List<LeagueResponse> result = new ArrayList<LeagueResponse>();
		for(League l : list){
			result.add( new LeagueResponse(l));
		}
		
		return result;
	}
	
	
	public LeagueDAO getLeagueDAO() {
		return leagueDAO;
	}

	public void setLeagueDAO(LeagueDAO leagueDAO) {
		this.leagueDAO = leagueDAO;
	}
	
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void deleteLeagueById(int id) {
		leagueDAO.deleteById(id);		
	}

	@Override
	public void joinLeague(String username, int idLeague) {
		User u = userService.obtainUser(username);
		League l = leagueDAO.obtainLeagueById(idLeague);
		l.addTeam(u.getUserTeam());
		leagueDAO.save(l);
	}

	
}
