package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class League {
	
	private String name;
	private List<MatchDay>matchesOfTheLeague;
	
	
	public League(){
		matchesOfTheLeague = new ArrayList<MatchDay>();	
	}
	
	
	
	public MatchDay getListOfMatchDay(Calendar date){
		for (MatchDay m : matchesOfTheLeague){
			if(m.isToday(date)){
				return m;
			}
		}
		return null;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MatchDay> getMatchDays() {
		return matchesOfTheLeague;
	}
	public void setMatchDays(List<MatchDay> m) {
		this.matchesOfTheLeague = m;
	}


	public void calculateGoals(Calendar date, List<Player> playerss) {
		MatchDay match = getListOfMatchDay(date);
		match.playersScore(playerss);
	}



	public void addMatchDay(MatchDay md) {
		matchesOfTheLeague.add(md);
	}	

	
	
	
	
}
