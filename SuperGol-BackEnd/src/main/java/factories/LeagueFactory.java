package factories;

import model.League;
import model.Match;
import model.MatchDay;
import model.Team;

public class LeagueFactory {
	
	TeamFactory teamFactory = new TeamFactory();
	
	public League createLeague(String leaguename){
		League l = new League();
		l.setName(leaguename);
		Team t1 = teamFactory.createFullTeam("Boca","b");
		Team t2 = teamFactory.createFullTeam("River","r");
		Match match = new Match();
		match.setLocalTeam(t1);
		match.setVisitorTeam(t2);
		MatchDay md = new MatchDay();
		md.addMatch(match);
		l.addMatchDay(md);
		return l;
	}
	
	
	public League buildEmptyLeague(String name){
		League l = new League();
		l.setName(name);
		l.setMaxUsers(5);
		l.setMinUsers(5);
		return l;
	}

}
