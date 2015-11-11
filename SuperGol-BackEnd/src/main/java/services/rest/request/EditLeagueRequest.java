package services.rest.request;

public class EditLeagueRequest {

	
	private int id;
	private String name;
	private int cantMin;
	private int cantMax;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCantMin() {
		return cantMin;
	}
	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	
	
	
	
	
	
	
}
