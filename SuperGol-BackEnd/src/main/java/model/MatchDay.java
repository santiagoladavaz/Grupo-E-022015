package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MatchDay {

	private List<Match>matchesOfTheDay;
	private Date date;
	private int id;
	
	public MatchDay(){
		matchesOfTheDay = new ArrayList<Match>();
		date = new Date();
	}
	
	public void setMatchesOfTheDay(List<Match> matchesOfTheDay) {
		this.matchesOfTheDay = matchesOfTheDay;
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


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addMatch(Match m){
		matchesOfTheDay.add(m);
	}
	
	
	
	public List<Match> getMatchesOfTheDay() {
		return matchesOfTheDay;
	}
	
	
	
	
	
	
}
