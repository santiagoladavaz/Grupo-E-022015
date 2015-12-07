package services.impl;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import daos.interfaces.LeagueDAO;
import exceptions.WritingFileException;
import model.League;
import model.User;
import services.interfaces.LeagueService;
import services.interfaces.UserService;
import services.rest.request.UploadFileRequest;
import services.rest.response.LeagueResponse;

public class LeagueServiceImpl implements LeagueService {

	private LeagueDAO leagueDAO;
	private UserService userService;
	
	public static String PATH = "src/main/resources/csv/";

	
	
	
	@Override
	@Transactional
	public List<League> obtainAllLeagues() {
		return leagueDAO.obtainLeagues();
	}

	@Override
	@Transactional
	public League createLeague(String name, int maxPlayers, int minPlayers) {
		return leagueDAO.createLeague(name, maxPlayers, minPlayers);		
	}

	@Override
	@Transactional
	public void editLeague(Integer id, String name, Integer maxPlayers, Integer minPlayers) {
		leagueDAO.editLeague(id, name, maxPlayers, minPlayers);
	}	
	
	@Override
	@Transactional
	public void save(League l) {
		leagueDAO.save(l);
		
	}
	
	
	public List<LeagueResponse> toResponse(List<League>list){
		List<LeagueResponse> result = new ArrayList<LeagueResponse>();
		for(League l : list){
			result.add( new LeagueResponse(l));
		}
		
		return result;
	}
	
	
	public LeagueDAO getLeagueDAO() {
		return leagueDAO;
	}

	public void setLeagueDAO(LeagueDAO leagueDAO) {
		this.leagueDAO = leagueDAO;
	}
	
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void deleteLeagueById(int id) {
		leagueDAO.deleteById(id);		
	}

	@Override
	@Transactional
	public void joinLeague(String username, int idLeague) {
		User u = userService.obtainUser(username);
		League l = leagueDAO.obtainLeagueById(idLeague);
		l.addTeam(u.getUserTeam());
		leagueDAO.save(l);
	}

	@Override
	public void saveFile(UploadFileRequest request) {
		String[] splitContent = request.getContent().split(";");
		String name = splitContent[0];
		File file = new File(PATH + name + ".txt");
		file.setWritable(true);
		try{
			Writer out = new BufferedWriter(new FileWriter(file));
			for (int i = 1 ;i < splitContent.length;i++){
				String content = splitContent[i];
				out.write(content);			
		
			}
			out.close();
		}catch(Exception e){
			throw new WritingFileException("An error occrurs when trying to write file: "+ name + "CAUSE: " +e.getMessage());
		}
	}

	
}
