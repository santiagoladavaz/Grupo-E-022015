package model;

public abstract class Position {
	
	int id;
	
	public abstract String description();
	public abstract int points();
	public abstract int totalOfPlayerInPositionAllowed();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
	
}
