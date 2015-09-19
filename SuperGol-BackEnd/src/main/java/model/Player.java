package model;

public class Player {
	
	private Position position;
	private String name;
	private Team team;
	private int ID;
	
	
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


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	
	
	
	

}
