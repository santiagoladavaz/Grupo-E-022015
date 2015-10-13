package model;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
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
	Team t1;
	
	
	@Before
	public void setUp(){
		t1 = teamFactory.createFullTeam("Atlanta", "a");
		teamDAO.saveTeam(t1);
	}
	
	@Test
	public void testDAONotNull(){
		assertNotNull(teamDAO);
	}
	
	@Test
	public void testGetTeamByName(){
		t1 = teamDAO.getTeamByName("Atlanta");
		assertNotNull(t1);
		assertNotNull(t1.getPlayers());
	}
	
	@After
	public void tearDown(){
		if(t1 != null){
			teamDAO.deleteTeam(t1);			
		}
	}
	
	
}
