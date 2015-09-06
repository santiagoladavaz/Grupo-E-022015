package model;

public class GoalKeeper extends Position{

	@Override
	public String description() {
		return "Goal Keeper";
	}

	@Override
	public int points() {
		return 0;
	}

	@Override
	public int totalOfPlayerInPositionAllowed() {
		return 1;
	}

}
