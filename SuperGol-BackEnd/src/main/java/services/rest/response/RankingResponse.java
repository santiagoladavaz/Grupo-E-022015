package services.rest.response;

import java.io.Serializable;

import model.Team;

public class RankingResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7085019977662203355L;

	
	private Integer points;
	private String team;
	
	
	
	public RankingResponse(Team t) {
		team = t.getName();
		points = t.getPointsOfTheTeam();
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
}
