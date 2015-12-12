package services.rest.response;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.Match;
import model.MatchDay;
import services.interfaces.TeamService;

public class DateResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1949937411722316982L;
	
	private String visitor;
	private String local;
	private String date;
	private String winner;
	
	
	public DateResponse(MatchDay md ,Match m,TeamService t) {
		visitor = m.getVisitorTeam().getName();
		local = m.getLocalTeam().getName();
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		date =f.format(md.getDate());
		if(m.getWinner() != null){
			this.winner = t.obtainTeamById(m.getWinner()).getName();			
		}else if(m.isTie()){
			this.winner = "Tie";
		}else{
			this.winner = "The Game Hasn't started";
		}
	}
	public String getVisitor() {
		return visitor;
	}
	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	
	
}
