package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.EnoughtPlayersInPositionException;
import exceptions.PlayerDoesntExistException;
import exceptions.PlayerInTeamException;
import exceptions.TeamAlreadyFullException;

public class Team {
	
	private List<Player>players;
	private String name;
	private String flag;
	private User owner;
	private int matchPoints;
	private int pointsOfTheTeam;
	
	public Team(){
		this.players = new ArrayList<Player>();
		matchPoints= 0;
	}
	
	public void score(Player p){
		if(players.contains(p)){
			matchPoints += p.score();			
		}
	}
	
	public void addPlayer(Player pl){
		validatePlayer(pl);
		players.add(pl);
	}
	
	
	public void validatePlayer(Player pl){
		if(players.contains(pl)){
			throw new PlayerInTeamException("The player: "+pl.getName()+" it's already in the team!");
		}
		if(players.size() == 11){
			throw new TeamAlreadyFullException("The team is full");
		}
		String position = pl.getPositionDescription();
		int maxAllowed= pl.maxOfPlayerInMyPosition();
		if( maxAllowed == playersInPosition(position)){
			throw new EnoughtPlayersInPositionException("There's enought players in position: "+ position );
		}
	}
	
	public Player getPlayer(String name){
		for (Player pl : players){
			if(pl.getName().equals(name)){
				return pl;
			}
		}
		throw new PlayerDoesntExistException("Player doesn't exist in the team");
	}
	
	public int playersInPosition(String position){
		int total = 0;
		for (Player pl : players){
			if(pl.getPositionDescription().equals(position)){
				total ++;
			}
		}
		return total;
	}
	
	public void removePlayerWithName(String string) {
		for(Player p : players){
			if (p.getName().equals(string)){
				players.remove(p);
				return;
			}
		}
		
	}
	
	
	
	
	
	
	public Team withPlayer(Player pl){
		this.addPlayer(pl);
		return this;
	}
	
	public Team withName(String name){
		this.setName(name);
		return this;
	}
	
	public Team withFlag(String flag){
		this.setFlag(flag);
		return this;
	}
	
	public Team withOwner(User owner){
		this.setOwner(owner);
		return this;
	}
	
	
	
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getMatchPoints() {
		return matchPoints;
	}
	public void setMatchPoints(int matchPoints) {
		this.matchPoints = matchPoints;
	}

	public int getPointsOfTheTeam() {
		return pointsOfTheTeam;
	}

	public void setPointsOfTheTeam(int pointsOfTheTeam) {
		this.pointsOfTheTeam = pointsOfTheTeam;
	}
	
	
	
	
	
	
	
	
	
	

}
