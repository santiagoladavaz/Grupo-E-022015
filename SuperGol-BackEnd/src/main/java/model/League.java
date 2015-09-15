package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class League {
	
	private String name;
	private List<MatchDay>matchesOfTheDay;
	
	
	public League(){
		matchesOfTheDay = new ArrayList<MatchDay>();	
	}
	
	
	
	public MatchDay getListOfMatchDay(Calendar date){
		for (MatchDay m : matchesOfTheDay){
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
		return matchesOfTheDay;
	}
	public void setMatchDays(List<MatchDay> m) {
		this.matchesOfTheDay = m;
	}


	public void calculateGoals(Calendar date, List<Player> playerss) {
		MatchDay match = getListOfMatchDay(date);
		match.playersScore(playerss);
	}



	public void addMatchDay(MatchDay md) {
		matchesOfTheDay.add(md);
	}	

	
	
	
	
}
