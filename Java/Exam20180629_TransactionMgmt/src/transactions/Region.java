package transactions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Region {
	
	private String name;
	private List<String> places= new LinkedList<String>();
	private List<String> carriers= new LinkedList<String>();
	
	
	
	
	public Region(String name, List<String> places) {
		this.name = name;
		this.places = places;
	}
	
	public String getName() {
		return name;
	}
	public List<String> getPlaces() {
		return places;
	}
	
	public void addCarrier(String carrier) {
		carriers.add(carrier);
	}
	
	public List<String> getCarriers() {		
		
		return carriers.stream().sorted().collect(Collectors.toList());
		
	}

}
