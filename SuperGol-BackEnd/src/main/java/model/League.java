package model;

import java.util.Calendar;
import java.util.List;

public class League {
	
	private String name;
	private List<MatchDay>matchesOfTheDay;
	
	
	
	
	
	
	public MatchDay getMatchOfTheDay(Calendar date){
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
	
	

	
	
	
	
}
