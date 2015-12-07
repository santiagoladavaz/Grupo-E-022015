package model;

import java.util.List;

public class Match {
	
	Team visitorTeam;
	Team localTeam;
	Integer winner;
	boolean tie;
	int id;
	
	
	
	public void results(List<Player>players){
		for(Player p : players){
			visitorTeam.score(p);
			localTeam.score(p);
		}
		if(visitorTeam.getMatchPoints() > localTeam.getMatchPoints()){
			visitorTeam.setPointsOfTheTeam(visitorTeam.getPointsOfTheTeam() + 3);
			winner = visitorTeam.getId();
			return;
		}
		if(localTeam.getMatchPoints() > visitorTeam.getMatchPoints()){
			localTeam.setPointsOfTheTeam(localTeam.getPointsOfTheTeam() + 3);
			winner = localTeam.getId();
			return;
		}
		tie=true;
		localTeam.setMatchPoints(0);
		visitorTeam.setMatchPoints(0);
		localTeam.setPointsOfTheTeam(localTeam.getPointsOfTheTeam() + 1);
		visitorTeam.setPointsOfTheTeam(visitorTeam.getPointsOfTheTeam() + 1);
	}


	
	@Override
	public String toString(){
		return "LocalTeam: "+ localTeam.getName() + " VisitorTeam: " + visitorTeam.getName();
		
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
