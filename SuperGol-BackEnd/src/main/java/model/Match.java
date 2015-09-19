package model;

import java.util.List;

public class Match {
	
	Team visitorTeam;
	Team localTeam;
	Team winner;
	boolean tie;
	int id;
	
	
	
	public void results(List<Player>players){
		for(Player p : players){
			visitorTeam.score(p);
			localTeam.score(p);
		}
		if(visitorTeam.getMatchPoints() > localTeam.getMatchPoints()){
			winner = visitorTeam;
			return;
		}
		if(localTeam.getMatchPoints() > visitorTeam.getMatchPoints()){
			winner = localTeam;
			return;
		}
		tie=true;
		localTeam.setMatchPoints(0);
		visitorTeam.setMatchPoints(0);
	}


	
	

	public Team getVisitorTeam() {
		return visitorTeam;
	}
	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}
	public Team getLocalTeam() {
		return localTeam;
	}
	public void setLocalTeam(Team localTeam) {
		this.localTeam = localTeam;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	

}
