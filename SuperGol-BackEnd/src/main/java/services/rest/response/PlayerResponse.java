package services.rest.response;

import java.io.Serializable;

import model.Player;

public class PlayerResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4919884323953750356L;
	
	
	private String name;
	private String lastName = "default last name";
	private Integer id;
	private String position;
	private String team;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer idPlayer) {
		this.id = idPlayer;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public PlayerResponse(Player pl){
		this.name = pl.getName();
		this.position = pl.getPositionDescription();
		this.id = pl.getId();
		this.team = pl.getRealTeam();
	}
	

}
