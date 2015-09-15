package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import factories.LeagueFactory;

public class TestLeague {
	
	LeagueFactory factory;
	League l;
	
	
	@Before
	public void setUp(){
		factory = new LeagueFactory();
		l = factory.createLeague("LigaArgentina");
	}
	
	@Test
	public void testCalculateGoals(){
		List<Player>ps = new ArrayList<Player>();
		Match match = l.getListOfMatchDay(Calendar.getInstance()).getMatchesOfTheDay().get(0);
		ps.add(match.getLocalTeam().getPlayers().get(3));
		l.calculateGoals(Calendar.getInstance(), ps);
		assertEquals(match.winner,match.getLocalTeam());
		
	}

}
