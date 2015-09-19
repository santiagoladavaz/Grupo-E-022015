package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MatchDay {

	private List<Match>matchesOfTheDay;
	private Calendar date;
	
	
	public MatchDay(){
		matchesOfTheDay = new ArrayList<Match>();
		date = Calendar.getInstance();
	}
	
	public void playersScore(List<Player> p){
		for (Match m : matchesOfTheDay){
			m.results(p);
		}
	}
	
	public boolean isToday(Calendar date){
		if (date.get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR)){
			return true;
		}
		return false;
	}


	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}





	public void addMatch(Match m){
		matchesOfTheDay.add(m);
	}
	
	
	
	public List<Match> getMatchesOfTheDay() {
		return matchesOfTheDay;
	}
	public void setMatchsOfTheDay(List<Match> matchsOfTheDay) {
		this.matchesOfTheDay = matchsOfTheDay;
	}
	
	
	
	
	
}
