package factories;

import java.util.Calendar;

import model.League;
import model.Match;
import model.MatchDay;
import model.Team;

public class LeagueFactory {
	
	PlayerFactory playerFactory = new PlayerFactory();
	
	public static League createLeague(String leaguename){
		League l = new League();
		l.setName(leaguename);
		Team t1 = new Team().withName("River");
		Team t2 = new Team().withName("Boca");
		Match match = new Match();
		match.setLocalTeam(t1);
		match.setVisitorTeam(t2);
		MatchDay md = new MatchDay();
		md.setDate(Calendar.getInstance());
		md.addMatch(match);
		return l;
	}

}
