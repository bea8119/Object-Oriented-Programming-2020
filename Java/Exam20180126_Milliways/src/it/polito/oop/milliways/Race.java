package it.polito.oop.milliways;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
	private String name;
	private List<String> requirements= new LinkedList<String>();
	
	
    
	public Race(String name) {
		this.name = name;
	}

	public void addRequirement(String requirement) throws MilliwaysException {
		
		if(requirements.contains(requirement))
			throw new MilliwaysException();
		
		requirements.add(requirement);
	}
	
	public List<String> getRequirements() {
		
        return requirements.stream().sorted().collect(Collectors.toList());
	}
	
	public String getName() {
        return name;
	}

	@Override
	public String toString() {
		return "Race [name=" + name + "]";
	}
	
}
