package model;

import java.io.Serializable;

public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8174077691361775476L;
	private Position position;
	private String name;
	private Team team;
	private int id;
	private String realTeam;
	private volatile int goals;
	




	public Player(){
		
	}



	public int maxOfPlayerInMyPosition(){
		return position.totalOfPlayerInPositionAllowed();
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj instanceof Player){
			Player p = (Player) obj;
			return p.name.equals(this.name);
		}
		return false;
	}
	
	
	public int getPoints(){
		return position.points();
	}
	
	public String getPositionDescription(){
		return position.description();
	}	
	
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	public int score() {
		return position.points();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getGoals() {
		return goals;
	}



	public void setGoals(int goals) {
		this.goals = goals;
	}



	public String getRealTeam() {
		return realTeam;
	}


	public void setRealTeam(String realTeam) {
		this.realTeam = realTeam;
	}


	public void setBoca(String s) {
		this.realTeam = s;
		
	}
	
	
	
	
	
	
	

}
