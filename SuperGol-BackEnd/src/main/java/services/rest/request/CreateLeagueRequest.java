package services.rest.request;

public class CreateLeagueRequest {

	
	private String name;
	private int cantMax;
	private int cantMin;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	public int getCantMin() {
		return cantMin;
	}
	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
	
	
	
	
	
	
}
