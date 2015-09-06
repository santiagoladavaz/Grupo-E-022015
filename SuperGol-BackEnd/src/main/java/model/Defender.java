package model;

public class Defender extends Position{

	@Override
	public String description() {
		return "Defender";
	}

	@Override
	public int points() {
		return 3;
	}

	@Override
	public int totalOfPlayerInPositionAllowed() {
		return 4;
	}
	
	

}
