package model;

public class User {

	String userName;
	String email;
	String password;
	int points;	
	Team userTeam;
	
	
	
	
	
	
	
	public Team getUserTeam() {
		return userTeam;
	}
	public void setUserTeam(Team userTeam) {
		this.userTeam = userTeam;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
