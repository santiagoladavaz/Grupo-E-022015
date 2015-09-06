package model;

import java.util.List;

public class Match {
	
	Team visitorTeam;
	Team localTeam;
	Team winner;
	boolean tie;
	
	
	
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
	}

}
