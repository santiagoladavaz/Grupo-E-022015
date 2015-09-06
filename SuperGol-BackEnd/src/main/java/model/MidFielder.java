package model;

public class MidFielder extends Position{

	@Override
	public String description() {
		return "Mid Fielder";
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
