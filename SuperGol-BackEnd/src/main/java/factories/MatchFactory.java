package factories;

import model.Match;
import model.Team;

public class MatchFactory {
	
	PlayerFactory factory = new PlayerFactory();
	public Match createMatch(String local, String visitor){
		Team localTeam = new Team();
									localTeam.withName(local)
									.withPlayer(factory.createGoalKeeperWithTeam("Arquero", localTeam))
									.withPlayer(factory.createDefenderWithTeam("Defensor1", localTeam))
									.withPlayer(factory.createDefenderWithTeam("Defensor2", localTeam))
									.withPlayer(factory.createDefenderWithTeam("Defensor3", localTeam))
									.withPlayer(factory.createDefenderWithTeam("Defensor4", localTeam))
									.withPlayer(factory.createMidFielderWithTeam("Medio1", localTeam))
									.withPlayer(factory.createMidFielderWithTeam("Medio2", localTeam))
									.withPlayer(factory.createMidFielderWithTeam("Medio3", localTeam))
									.withPlayer(factory.createForwardWithTeam("Delantero1", localTeam))
									.withPlayer(factory.createForwardWithTeam("Delantero2", localTeam))
									.withPlayer(factory.createForwardWithTeam("Delantero3", localTeam))
									.withFlag("Flag1");
		Team visitorTeam = new Team();
									visitorTeam.withName(visitor)
									.withFlag("Flag2")
									.withPlayer(factory.createGoalKeeperWithTeam("ArqueroV", visitorTeam))
									.withPlayer(factory.createDefenderWithTeam("DefensorV1", visitorTeam))
									.withPlayer(factory.createDefenderWithTeam("DefensorV2", visitorTeam))
									.withPlayer(factory.createDefenderWithTeam("DefensorV3", visitorTeam))
									.withPlayer(factory.createDefenderWithTeam("DefensorV4", visitorTeam))
									.withPlayer(factory.createMidFielderWithTeam("MedioV1", visitorTeam))
									.withPlayer(factory.createMidFielderWithTeam("MedioV2", visitorTeam))
									.withPlayer(factory.createMidFielderWithTeam("MedioV3", visitorTeam))
									.withPlayer(factory.createForwardWithTeam("DelanteroV1", visitorTeam))
									.withPlayer(factory.createForwardWithTeam("DelanteroV2", visitorTeam))
									.withPlayer(factory.createForwardWithTeam("DelanteroV3", visitorTeam));
		
		Match match = new Match();
		match.setLocalTeam(localTeam);
		match.setVisitorTeam(visitorTeam);
		return match;
	}

}
