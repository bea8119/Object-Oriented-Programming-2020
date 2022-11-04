package it.polito.oop.milliways;


import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.*;


public class Restaurant {
	
	public Map<String, Race> races= new TreeMap<String, Race>();
	public Map<Integer, Hall> halls= new LinkedHashMap<Integer, Hall>();
	public List<Party> parties= new LinkedList< Party>();

    public Restaurant() {
	}
	
	public Race defineRace(String name) throws MilliwaysException{
		
		if(races.containsKey(name))
			throw new MilliwaysException();
		
		Race r= new Race(name);
		races.put(name, r);
		
	    return r;
	}
	
	public Party createParty() {
		Party p= new Party();
		
		parties.add(p);
	    return p;
	}
	
	public Hall defineHall(int id) throws MilliwaysException{
		if(halls.containsKey(id))
			throw new MilliwaysException();
		
		Hall h= new Hall(id);
		halls.put(id, h);
	    return h;
	}

	public List<Hall> getHallList() {
		
		return halls.values().stream().collect(Collectors.toList());
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {
		if(!hall.isSuitable(party))
			throw new MilliwaysException();
		
		party.setHall(hall);
        return hall;
	}

	public Hall seat(Party party) throws MilliwaysException {
		Hall hall= halls.values().stream().filter(x->x.isSuitable(party)).findFirst()
				.orElse(null);
		if(hall==null)
			throw new MilliwaysException();
        return hall;
	}

	public Map<Race, Integer> statComposition() {
		List<Party.Companion> companions= parties.stream().map(Party::getCompanions).collect(Collectors.toList())
							.stream().flatMap(Collection::stream).collect(Collectors.toList());
			
        return companions.stream().collect(Collectors.groupingBy((Party.Companion x)-> x.getRace(), 
				LinkedHashMap::new, Collectors.summingInt(Party.Companion::getNum)))
		;
	}

	public List<String> statFacility() {
		Comparator<Map.Entry<String,Long>> c = 
				Comparator.comparing(Map.Entry::getValue, 
						  Comparator.reverseOrder());
		c = c.thenComparing(Map.Entry::getKey);
		
		
        return halls.values().stream().flatMap(f-> f.getFacilities().stream())
				.collect(Collectors.groupingBy(x->x, Collectors.counting()))
			.entrySet().stream().sorted(c).map(Map.Entry::getKey).collect(Collectors.toList())

;
	}
	
	public Map<Integer,List<Integer>> statHalls() {
		
		
		
        return halls.values().stream().sorted(Comparator.comparingInt(Hall::getId)).
                collect(Collectors.groupingBy(
                	      Hall::getNumFacilities,
                	      TreeMap::new,
                	      Collectors.mapping(Hall::getId, Collectors.toList())
                	      ));
	}

}
