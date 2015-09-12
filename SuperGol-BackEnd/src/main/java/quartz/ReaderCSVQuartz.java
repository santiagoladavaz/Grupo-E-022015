package quartz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exceptions.PlayerDoesntExistException;
import factories.PlayerFactory;
import model.Player;

public class ReaderCSVQuartz {
	
	final static Logger logger = Logger.getLogger(ReaderCSVQuartz.class);
	PlayerFactory playerFactory = new PlayerFactory();
	List<Player>players = new ArrayList<Player>();
	public static String DEFAULT_PATH = "src/main/resources/csv/";
	// se "mockea los jugadores en la 'BD'"
	
	
	public void initializePlayers(){
		players = new ArrayList<Player>();
		// se "mockea los jugadores en la 'BD'"
		players.add(playerFactory.createMidFielder("Tevez"));
		
	}
	
	
	public void readFiles(){
		logger.info("QUARTZ STARTED!!!");
		System.out.println("QUARTZ STARTED!!!");
		logger.info("QUARTZ -> Reading files of default path: " + DEFAULT_PATH);
		File folder = new File(DEFAULT_PATH);
		for (File f : folder.listFiles()){
			if(f.getName().contains("readed")){
				logger.info("QUARTZ: File named: " + f.getName() + "Has been readed already");
			}else{
				try{
					readCSV(f.getPath());
					String name = DEFAULT_PATH + f.getName();
					name= name.replaceFirst(".txt", "_readed.txt");
					f.renameTo(new File(name));
				}catch(IOException e){
					logger.error(e.getMessage());
				}
			}
		}
	}
	
	
	public void readCSV(String path) throws IOException{
		logger.info("Reading file: " + path);
		initializePlayers();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		while ((line = reader.readLine()) != null){
			validatePlayer(line.split(","));
		}
	}
	
	// este metodo despues va a hacer querys contra la DB
	public void validatePlayer(String[] line){
		Player pl = players.get(0);
		if (line[0] != null && pl.getName().equals(line[0]) && line[1] != null &&
				pl.getPositionDescription().equals(line[1])){
			// todos los equipos que tienen este jugador deben sumar puntos en su match
		}else{
			throw new PlayerDoesntExistException("The player: "+ line[0]+" doesn't exists! or it has an incorrect position");
		}
		
	}
	
	public static void main( String[] args ) throws Exception
    {
    	new ClassPathXmlApplicationContext("beans/quartz-cfg.xml");
    }

}
