package it.polito.oop.milliways;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Party {
	
	private Hall hall;
	
	protected class Companion{
		private Race race;
		private int num;
		
		public Companion(Race race, int num) {
			this.race = race;
			this.num = num;
		}
		public Race getRace() {
			return race;
		}
		public int getNum() {
			return num;
		}
		
	}
	private List<Companion> companions= new LinkedList<Companion>();

    public void addCompanions(Race race, int num) {
    	
    	companions.add(new Companion(race, num));
	}

	public int getNum() {
		
        return companions.stream().collect(Collectors.summingInt(Companion::getNum));
	}

	public int getNum(Race race) {
		
	    return companions.stream().filter(a-> a.getRace().equals(race)).collect(Collectors.summingInt(Companion::getNum));
	}

	public List<String> getRequirements() {
		List<Race> races= companions.stream().map(Companion::getRace).distinct()
				.collect(Collectors.toList());

        return races.stream().map(Race::getRequirements).collect(Collectors.toList())
				.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
	}

    public Map<String,Integer> getDescription(){
    	  	
        return companions.stream().collect(Collectors.groupingBy(a->a.getRace().getName(), ()-> new TreeMap<String, Integer>(),
    			Collectors.summingInt(Companion::getNum)));
    }

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public List<Companion> getCompanions() {
		return companions;
	}
    
    

}
