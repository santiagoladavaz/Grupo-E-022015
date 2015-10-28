package quartz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exceptions.DateException;
import exceptions.PlayerDoesntExistException;
import factories.PlayerFactory;
import model.League;
import model.Player;

public class ReaderCSVQuartz {
	
	final static Logger logger = Logger.getLogger(ReaderCSVQuartz.class);
	PlayerFactory playerFactory = new PlayerFactory();
	// "MOCK DE LA DB POR EL MOMENTO"
	// se "mockea los jugadores en la 'BD'"
	List<Player>players = new ArrayList<Player>();

	
	// lista de jugadores que metieron goles
	List<Player>playerss = new ArrayList<Player>();
	public static String DEFAULT_PATH = "src/main/resources/csv/";
	
	private League league = new League();
	
	
	public void initializePlayers(){
		players = new ArrayList<Player>();
		// se "mockea los jugadores en la 'BD'"
		players.add(playerFactory.createMidFielder("Tevez"));
		
	}
	
	
	public void readFiles(){
//		System.out.println("QUARTZS");
		logger.info("QUARTZ STARTED!!!");
		logger.info("QUARTZ -> Reading files of default path: " + DEFAULT_PATH);
		File folder = new File(DEFAULT_PATH);
		for (File f : folder.listFiles()){
			if(f.getName().contains("readed")){
				logger.info("QUARTZ: File named: " + f.getName() + "Has been readed already");
			}else{
				try{
					if (isTodaysFile(f.getName())){
						readCSV(f.getPath(),toDate(f.getName()));
						String name = DEFAULT_PATH + f.getName();
						name= name.replaceFirst(".txt", "_readed.txt");
						f.renameTo(new File(name));
					}
				}catch(IOException e){
					logger.error(e.getMessage());
				}
			}
		}
		
	}
	
	public Calendar toDate(String name){
		try{
			String[] split = name.split("_");
			String date = split[1].split("\\.")[0];
			DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
			Calendar today = Calendar.getInstance();
			today.setTimeInMillis((f.parse(date).getTime()));
			return today;			
		}catch(Exception e){
			 throw new DateException("The given String cannot be parsed to a date");
		}
	}
	
	public boolean isTodaysFile(String name){
		try{
			Calendar today = toDate(name);
			return (today.get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
		}catch(Exception e){
			return false;
		}
	}
	
	public void readCSV(String path,Calendar date) throws IOException{
		logger.info("Reading file: " + path);
		initializePlayers();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while ((line = reader.readLine()) != null){
			Player pl = validatePlayer(line.split(","));
			playerss.add(pl);
		}
	//	league.calculateGoals(date,playerss);
	}
	
	// este metodo despues va a hacer querys contra la DB
	public Player validatePlayer(String[] line){
		Player pl = players.get(0);
		if (line[0] != null && pl.getName().equals(line[0]) && line[1] != null &&
				pl.getPositionDescription().equals(line[1])){
			// todos los equipos que tienen este jugador deben sumar puntos en su match
		}else{
			throw new PlayerDoesntExistException("The player: "+ line[0]+" doesn't exists! or it has an incorrect position");
		}
		
		return pl;
		
	}
	
	public static void main( String[] args ) throws Exception {
		BasicConfigurator.configure();
    	new ClassPathXmlApplicationContext("beans/quartz-cfg.xml");
    }

}
