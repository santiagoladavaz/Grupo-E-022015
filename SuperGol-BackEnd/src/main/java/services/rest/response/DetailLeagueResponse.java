package services.rest.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.League;
import model.Match;
import model.MatchDay;
import model.Team;
import services.interfaces.TeamService;

public class DetailLeagueResponse implements Serializable{

	
	private static final long serialVersionUID = 5379347369883242870L;
	
	
	List<DateResponse>dateResponse;
	List<RankingResponse> rankingResponse;
	
	
	public DetailLeagueResponse(League l,TeamService ts) {
		dateResponse = new ArrayList<DateResponse>();
		rankingResponse = new ArrayList<RankingResponse>();
		
		for(MatchDay md : l.getMatchesOfTheLeague()){
			for(Match m : md.getMatchesOfTheDay()){
				DateResponse dr = new DateResponse(md,m,ts);
				dateResponse.add(dr);
			}
		}
		
		Collections.sort(l.getTeams(), new Comparator<Team>() {

			@Override
			public int compare(Team o1, Team o2) {
				Integer i1 = new Integer(o1.getPointsOfTheTeam());
				Integer i2 = new Integer(o2.getPointsOfTheTeam());
				return i2.compareTo(i1);
			}
			
		});
		
		for(Team t : l.getTeams()){
			RankingResponse r = new RankingResponse(t);
			rankingResponse.add(r);
		}
	}
	public List<DateResponse> getDateResponse() {
		return dateResponse;
	}
	public void setDateResponse(List<DateResponse> dateResponse) {
		this.dateResponse = dateResponse;
	}
	public List<RankingResponse> getRankingResponse() {
		return rankingResponse;
	}
	public void setRankingResponse(List<RankingResponse> rankingResponse) {
		this.rankingResponse = rankingResponse;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
}
