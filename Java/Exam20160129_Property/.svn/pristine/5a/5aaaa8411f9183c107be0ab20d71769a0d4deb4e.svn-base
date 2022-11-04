package managingProperties;

public class Request {
	
	private int id;
	private String owner;
	private String apartment;
	private String profession;
	private String professional;
	private Request.status status;
	private int cost;
	
	public static enum status {
		pending,
		assigned,
		completed;
		
	}
	
	
	public Request(int id,String owner, String apartment, String profession) {
		
		this.id = id;
		this.owner=owner;
		this.apartment = apartment;
		this.profession = profession;
		this.setStatus(status.pending);
	}


	public int getId() {
		return id;
	}


	public String getApartment() {
		return apartment;
	}


	public String getProfession() {
		return profession;
	}


	public Request.status getStatus() {
		return status;
	}


	public void setStatus(Request.status status) {
		this.status = status;
	}


	public String getProfessional() {
		return professional;
	}


	public void setProfessional(String professional) {
		this.professional = professional;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
		this.setStatus(status.completed);
	}


	public String getOwner() {
		return owner;
	}
	
	public String getBuilding() {
		String[] b=this.apartment.split(":");
		return b[0];
	}
	

}
