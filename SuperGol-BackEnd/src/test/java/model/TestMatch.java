package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import factories.MatchFactory;
import factories.PlayerFactory;

public class TestMatch {
	
	MatchFactory factory = new MatchFactory();
	Match match;
	PlayerFactory playerFactory = new PlayerFactory();
	
	
	@Before
	public void setUp(){
		match = factory.createMatch("River", "Boca");
	}
	
	
	@Test
	public void testGetLocal(){
		assertEquals(match.getLocalTeam() != null,true);
	}
	
	@Test
	public void testGetVisitor(){
		assertEquals(match.getVisitorTeam() != null,true);
	}
	
	@Test
	public void testResultsLocalTeam(){
		List<Player>players = new ArrayList<Player>();
		players.add(playerFactory.createMidFielder("Medio1"));
		match.results(players);
		assertEquals(match.winner,match.getLocalTeam());
		assertFalse(match.tie);
	}
	
	@Test
	public void testResultsVisitorTeam(){
		List<Player>players = new ArrayList<Player>();
		players.add(playerFactory.createMidFielder("MedioV1"));
		match.results(players);
		assertEquals(match.winner,match.getVisitorTeam());
		assertFalse(match.tie);
	}
	
	@Test
	public void testResultsTie(){
		List<Player>players = new ArrayList<Player>();
		players.add(playerFactory.createMidFielder("MedioV1"));
		players.add(playerFactory.createMidFielder("Medio1"));
		match.results(players);
		assertNull(match.winner);
		assertTrue(match.tie);
	}
}
