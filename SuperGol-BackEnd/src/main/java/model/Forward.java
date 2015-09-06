package model;

public class Forward extends Position{

	@Override
	public String description() {
		return "Forward";
	}

	@Override
	public int points() {
		return 1;
	}

	@Override
	public int totalOfPlayerInPositionAllowed() {
		return 3;
	}

	
	
}
