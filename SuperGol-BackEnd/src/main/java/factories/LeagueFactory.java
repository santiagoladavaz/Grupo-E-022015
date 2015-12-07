package factories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.League;
import model.Match;
import model.MatchDay;
import model.Team;

public class LeagueFactory {
	
	TeamFactory teamFactory = new TeamFactory();
	
	public League createLeague(String leaguename){
		League l = new League();
		l.setName(leaguename);
		Team t1 = teamFactory.createFullTeam("Boca","b");
		Team t2 = teamFactory.createFullTeam("River","r");
		Match match = new Match();
		match.setLocalTeam(t1);
		match.setVisitorTeam(t2);
		MatchDay md = new MatchDay();
		md.addMatch(match);
		l.addMatchDay(md);
		return l;
	}
	
	
	public League buildEmptyLeague(String name){
		League l = new League();
		l.setName(name);
		l.setMaxUsers(5);
		l.setMinUsers(5);
		return l;
	}
	
	public void createFixture(League l){
		if( l.getTeams().size()  % 2 != 0 && l.getTeams().size() < 4){
			throw new RuntimeException("There arent enough teams to build a fixture!");
		}
		
		l.setMatchesOfTheLeague(buildMatchsDay(l.getTeams()));
	}


	private List<MatchDay> buildMatchsDay(List<Team> teams) {
		List<MatchDay>totalOfMatches = new ArrayList<MatchDay>();
		int i = 0;
		Calendar date = Calendar.getInstance();
		List<List<Match>> totalmatches =createDate(teams);
		while ( i < totalmatches.size() ){
			MatchDay match = new MatchDay();			
			date.set(Calendar.DAY_OF_YEAR, date.get(Calendar.DAY_OF_YEAR) + 1);
			createMatchDayByDate(match,totalmatches.get(i));
			match.setDate(new Date(date.getTimeInMillis()));
			totalOfMatches.add(match);
			i++;
		}
		return totalOfMatches;
	}
	
	private List<List<Match>> createDate( List<Team> tss){
		List<List<Match>> result = new ArrayList<List<Match>>();
		ArrayList <Team> clubes=(ArrayList<Team>) tss;
		   int auxT=clubes.size();
		   boolean impar=(auxT%2!=0);
		   if(impar){
		      ++auxT;
		   }
		   int totalP=(auxT*(auxT-1))/2;//total de partidos de una ronda
		   Team [] local=new Team [totalP];
		   Team [] visita=new Team [totalP];
		   int modIF=(auxT/2);//para hacer mod cada inicio de fecha
		   int indiceInverso=auxT-2;
		   for(int i=0;i<totalP;i++){
		      if (i%modIF==0){//seria el partido inicial de cada fecha
		         //si es impar el numero de clubes la primera fecha se borra poniendo null
		         if (impar){
		            local[i]=null;
		            visita[i]=null;
		         }
		         else{
		            //se pone uno local otro  visita al ultimo equipo
		            if(i%2==0){
		               local[i]=clubes.get(i%(auxT-1));
		               visita[i]=clubes.get(auxT-1);
		            }
		            else{
		               local[i]=clubes.get(auxT-1);
		                visita[i]=clubes.get(i%(auxT-1));
		            }
		         }
		      }
		      else{
		         local[i]=clubes.get(i%(auxT-1));
		         visita[i]=clubes.get(indiceInverso);           
		         --indiceInverso;
		         if (indiceInverso<0){
		            indiceInverso=auxT-2;
		         }
		      }
		   }
		   for(int i=0;i<totalP;){
		      if(local[i]!=null){
		    	  List<Match>l = new ArrayList<Match>();
		    	  Match m = new Match();
		    	  m.setLocalTeam(local[i]);
		    	  m.setVisitorTeam(visita[i]);
		    	  l.add(m);
		    	  Match m2 = new Match();
		    	  m2.setLocalTeam(local[i + 1]);
		    	  m2.setVisitorTeam(visita[i+1]);
		    	  l.add(m2);
		         result.add(l);
		      }
		      i += 2;
		   }		
		
		return result;
	}
	
	
	private void createMatchDayByDate(MatchDay md,List<Match>list){
		
		for(Match l : list){
			md.getMatchesOfTheDay().add(l);							
		}
	}


	private List<Match> createMatchAgainstOthers(Team t, List<Team> tss) {
		List<Match>matches = new ArrayList<Match>();
		for(Team team :tss){
			if(team.getId() != t.getId()){
				Match match = new Match();
				match.setLocalTeam(team);
				match.setVisitorTeam(t);
				matches.add(match);
			}			
		}
		return matches;
	}

}
