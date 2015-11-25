package services.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.League;
import services.rest.response.LeagueResponse;

public interface LeagueService {

	@Transactional
	public List<League> obtainAllLeagues();
	
	@Transactional
	public League createLeague(String name, int maxPlayers, int minPlayers);
	
	@Transactional
	public void editLeague(final Integer id, final String name,final Integer maxPlayers,final Integer minPlayers);
	@Transactional
	public void save(League l);
	@Transactional
	public void deleteLeagueById(int id);

	public List<LeagueResponse> toResponse(List<League> leagues);
	@Transactional
	public void joinLeague(String username, int idLeague);
}
