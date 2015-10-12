package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import daos.interfaces.TeamDAO;
import factories.TeamFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans/service-beans.xml",
					 "/config/dataSource.xml"})
public class TestTeamDAO {

	@Autowired
	public TeamDAO teamDAO;
	public TeamFactory teamFactory = new TeamFactory();
	
	
	
	@Before
	public void setUp(){
		Team t = teamFactory.createFullTeam("Boca", "a");
		teamDAO.saveTeam(t);
	}
	
	@Test
	public void testDAONotNull(){
		assertNotNull(teamDAO);
	}
	
//	@Test
//	public void testGetTeamByName(){
//		Team t1 = teamDAO.getTeamByName("Boca");
//		assertNotNull(t1);
//		assertNotNull(t1.getPlayers());
//	}
	
//	@Test
//	public void testGetTeamByUser(){
//		Team t1 = teamDAO.getTeamByUser("Fede");
//		assertNotNull(t1);
//		assertNotNull(t1.getPlayers());
//	}
	
	
	
}
