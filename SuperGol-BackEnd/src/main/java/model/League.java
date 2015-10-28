package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.cxf.common.util.StringUtils;

public class League {
	
	private String name;
	private List<MatchDay>matchesOfTheLeague;
	private int id;
	private int maxUsers;
	private int minUsers;
	
	
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public League(){
		matchesOfTheLeague = new ArrayList<MatchDay>();	
	}
	
	public League(String name, int maxPlayers, int miPlayers){
		this.matchesOfTheLeague = new ArrayList<MatchDay>();	
		if(miPlayers < 0 || maxPlayers < 0 ){
			throw new RuntimeException("Min users or max users cannot be minor to zero");
		}
		this.minUsers=miPlayers;
		this.maxUsers = maxPlayers;
		this.name = name;
	}
	
	public int getMaxUsers() {
		return maxUsers;
	}



	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}



	public int getMinUsers() {
		return minUsers;
	}



	public void setMinUsers(int minUsers) {
		this.minUsers = minUsers;
	}



	public List<MatchDay> getMatchesOfTheLeague() {
		return matchesOfTheLeague;
	}



	public void setMatchesOfTheLeague(List<MatchDay> matchesOfTheLeague) {
		this.matchesOfTheLeague = matchesOfTheLeague;
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



	public void editWith(String name, Integer maxPlayers, Integer minPlayers) {
		if ( maxPlayers != null &&  (maxPlayers < 0)){
			throw new RuntimeException("Max users cannot be minor to zero");
		}
		
		if( minPlayers != null && (minPlayers < 0)){
			throw new RuntimeException("Min users cannot be minor to zero");
		}
		
		if (StringUtils.isEmpty(name)){
			throw new RuntimeException("Name cannot be Empty");
		}
		this.setName(name);
		this.setMaxUsers(maxPlayers);
		this.setMinUsers(minPlayers);
		
	}	

	
	
	
	
}
