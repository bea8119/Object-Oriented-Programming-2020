package it.polito.oop.milliways;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Hall {
	private int id;
	
	private List<String> facilities= new LinkedList<String>();
	
	

	public Hall(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void addFacility(String facility) throws MilliwaysException {
		
		if(facilities.contains(facility))
			throw new MilliwaysException();
		
		facilities.add(facility);
		
	}

	public List<String> getFacilities() {
		
        return facilities.stream().sorted().collect(Collectors.toList());
	}
	
	int getNumFacilities(){
        return facilities.size();
	}

	public boolean isSuitable(Party party) {	
		
		return facilities.containsAll(party.getRequirements());
	}

}
