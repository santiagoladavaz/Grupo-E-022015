package services.rest.response;

import model.League;

public class LeagueResponse {

	
	private int id;
	private String name;
	private int cantMin;
	private int cantMax;
	
	
	
	
	public LeagueResponse(League l) {
		this.id = l.getId();
		this.cantMin = l.getMinUsers();
		this.cantMax = l.getMaxUsers();
		this.name = l.getName();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCantMin() {
		return cantMin;
	}
	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	
	
	
	
	
	
	
	
}
