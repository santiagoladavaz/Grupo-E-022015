package services.impl;

import org.springframework.transaction.annotation.Transactional;

import daos.interfaces.TeamDAO;
import model.Team;
import services.interfaces.TeamService;

public class TeamServiceImpl implements TeamService{
	
	private TeamDAO teamDAO;

	
	@Transactional
	public void saveTeam(Team t){
		teamDAO.saveTeam(t);
	}
	
	
	
	
	
	
	
	
	
	public TeamDAO getTeamDAO() {
		return teamDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}









	@Override
	public Team obtainTeamById(int id) {
		return teamDAO.getTeamById(id);
		
	}	

}
