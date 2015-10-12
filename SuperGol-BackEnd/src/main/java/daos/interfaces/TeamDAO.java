package daos.interfaces;

import model.Team;

public interface TeamDAO {

	
	public void saveTeam(Team t);

	public Team getTeamByName(String string);

	public Team getTeamByUser(String string);
}
