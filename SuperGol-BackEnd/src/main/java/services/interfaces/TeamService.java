package services.interfaces;

import model.Team;

public interface TeamService {

	
	public void saveTeam(Team t);
	public Team obtainTeamById(int id);
}
