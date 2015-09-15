package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MatchDay {

	private List<Match>matchsOfTheDay;
	private Calendar date;
	
	
	public MatchDay(){
		matchsOfTheDay = new ArrayList<Match>();
		date = Calendar.getInstance();
	}
	
	public void playersScore(List<Player> p){
		for (Match m : matchsOfTheDay){
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
		matchsOfTheDay.add(m);
	}
	
	
	
	public List<Match> getMatchesOfTheDay() {
		return matchsOfTheDay;
	}
	public void setMatchsOfTheDay(List<Match> matchsOfTheDay) {
		this.matchsOfTheDay = matchsOfTheDay;
	}
	
	
	
	
	
}
