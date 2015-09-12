package model;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.PlayerDoesntExistException;
import quartz.ReaderCSVQuartz;

public class TestQuartzReader {
	
	ReaderCSVQuartz reader;

	@Before
	public void setUp(){
		reader = new ReaderCSVQuartz();
	}
	
	@Test(expected=Exception.class)
	public void testReadFileInIcorrectPath() throws IOException{
		reader.readCSV("IncorrectPath");
	}
	
	@Test
	public void testReadFiles(){
		reader.readFiles();
	}
	
	@Test(expected=PlayerDoesntExistException.class)
	public void testReadIncorrectFile(){
		reader.DEFAULT_PATH = "src/main/resources/csvTest/";
		reader.readFiles();
	}
	
	
	@After
	public void tearDown(){
		File f = new File("src/main/resources/csv/pepe_15-09-2015_readed.txt");
		f.renameTo(new File("src/main/resources/csv/pepe_15-09_2015.txt"));
	}
	
	
	
}