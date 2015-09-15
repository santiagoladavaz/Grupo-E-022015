package factories;

import model.Team;
import model.User;

public class TeamFactory {

	PlayerFactory factory = new PlayerFactory();
	
	public Team createFullTeam(String name,String suffix){
		Team t = new Team();
		t.withName("Boca")
		.withPlayer(factory.createGoalKeeperWithTeam("Arquero" + suffix, t))
		.withPlayer(factory.createDefenderWithTeam("Defensor1"+ suffix, t))
		.withPlayer(factory.createDefenderWithTeam("Defensor2"+ suffix, t))
		.withPlayer(factory.createDefenderWithTeam("Defensor3"+ suffix, t))
		.withPlayer(factory.createDefenderWithTeam("Defensor4"+ suffix, t))
		.withPlayer(factory.createMidFielderWithTeam("Medio1"+ suffix, t))
		.withPlayer(factory.createMidFielderWithTeam("Medio2"+ suffix, t))
		.withPlayer(factory.createMidFielderWithTeam("Medio3"+ suffix, t))
		.withPlayer(factory.createForwardWithTeam("Delantero1"+ suffix, t))
		.withPlayer(factory.createForwardWithTeam("Delantero2"+ suffix, t))
		.withFlag("Flag")
		.withOwner(new User()); 
		
		return t;
	}
	
}
