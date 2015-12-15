package factories;

import model.Defender;
import model.Forward;
import model.GoalKeeper;
import model.MidFielder;
import model.Player;
import model.Team;
import services.rest.request.PlayerRequest;

public class PlayerFactory {

	

	public Player createGoalKeeper(String name){
		Player p = new Player();
		p.setName(name);
		p.setPosition(new  GoalKeeper());
		return p;
	}
	
	public Player createForward(String name){
		Player p = new Player();
		p.setName(name);
		p.setPosition(new Forward());
		return p;
	}
	
	public Player createMidFielder(String name){
		Player p = new Player();
		p.setName(name);
		p.setPosition(new MidFielder());
		return p;
	}
	
	public Player createDefender(String name){
		Player p = new Player();
		p.setName(name);
		p.setPosition(new Defender());
		return p;
	}
	
	public Player createDefenderWithTeam(String name,Team t){
		Player p = this.createDefender(name);
		p.setTeam(t);
		p.setRealTeam(t.getName());
		return p;
	}
	
	public Player createMidFielderWithTeam(String name, Team t){
		Player p = this.createMidFielder(name);
		p.setTeam(t);
		p.setRealTeam(t.getName());
		return p;
	}
	
	public Player createGoalKeeperWithTeam(String name, Team t){
		Player p = this.createGoalKeeper(name);
		p.setRealTeam(t.getName());
		p.setTeam(t);
		return p;
	}
	
	public Player createForwardWithTeam(String name, Team t){
		Player p = this.createForward(name);
		p.setRealTeam(t.getName());
		p.setTeam(t);
		return p;
	}

	public Player createPlayerByRequest(PlayerRequest request) {
		Player pl = new Player();
		if (request.getPosition().equals("Mid Fielder")){
			pl = this.createMidFielder(request.getName());
		}
		if(request.getPosition().equals("Goal Keeper")){
			pl = this.createGoalKeeper(request.getName());
		}
		if(request.getPosition().equals("Defender")){
			pl = this.createDefender(request.getName());
		}
		if(request.getPosition().equals("Forward")){
			pl = this.createForward(request.getName());
		}
		
		pl.setRealTeam(request.getTeam());
		return pl;
	}
	
	
	
}
