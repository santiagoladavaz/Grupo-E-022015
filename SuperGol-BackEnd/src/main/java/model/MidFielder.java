package model;

public class MidFielder extends Position{

	private String hola;
	
	
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
		return 4;
	}

	public String getHola() {
		return hola;
	}

	public void setHola(String hola) {
		this.hola = hola;
	}

	
	
	
}
