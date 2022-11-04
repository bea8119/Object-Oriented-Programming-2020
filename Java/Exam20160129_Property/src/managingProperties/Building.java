package managingProperties;

public class Building implements Comparable  {

	private String Id;
	private int napartments;
	
	public Building(String id, int napartments) {
		
		Id = id;
		this.napartments = napartments;
	}

	public String getId() {
		return Id;
	}

	public int getNapartments() {
		return napartments;
	}

	@Override
	public int compareTo(Object o) {
				
		return this.Id.compareTo(((Building) o).getId());
	}
	
	
	
	
}
