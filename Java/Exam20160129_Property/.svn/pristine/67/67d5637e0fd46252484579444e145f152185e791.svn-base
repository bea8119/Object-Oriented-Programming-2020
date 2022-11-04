package managingProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.stream.Collectors.*;
import java.util.stream.Collectors;
public class PropertyManager {
	
	private SortedMap<String, Building> buildings = new TreeMap<String, Building>();
	private SortedMap<String, List<String>> owners = new TreeMap<String, List<String>>();
	private Map<String, String> aptOwner = new HashMap<>();
	private SortedMap<String, List<String>> professions = new TreeMap<String, List<String>>();
	private Map<String, String> regprofessionals = new HashMap<>();
	private List<Request> requests= new ArrayList<Request>();
	
	private int request=0;
	
	/**
	 * Add a new building 
	 */
	public void addBuilding(String building, int n) throws PropertyException {
		
		if(buildings.containsKey(building) || (n<0 || n>100))
			throw new PropertyException();
		
		Building b= new Building(building, n);
		buildings.put(building , b);
		
	}

	public void addOwner(String owner, String... apartments) throws PropertyException {
		
		List<String> ap= new LinkedList();
		if(owners.containsKey(owner))
			throw new PropertyException();
		
		for(String s: apartments) {
			String[] build= s.split(":");
			int n= Integer.parseInt(build[1]);
			if( !buildings.containsKey(build[0]) || n<0 || n>buildings.get(build[0]).getNapartments() ) 
				throw new PropertyException();
			if (aptOwner.containsKey(s)) throw new PropertyException ("");
			aptOwner.put(s, owner);				
		}
		
	
		Collections.addAll(ap, apartments);
		
		owners.put(owner, ap);
		
	}

	/**
	 * Returns a map ( number of apartments => list of buildings ) 
	 * 
	 */
	public SortedMap<Integer, List<String>> getBuildings() {
						
		return buildings.values().stream().collect(Collectors.groupingBy(Building::getNapartments, 
				TreeMap:: new, Collectors.mapping(Building::getId, 
						Collectors.toList())));
	}

	public void addProfessionals(String profession, String... professionals) throws PropertyException {
				
		List<String> prof= new LinkedList();
		if(professions.containsKey(profession))
			throw new PropertyException();
		
		for(String s: professionals) {
						
			if (regprofessionals.containsKey(s)) throw new PropertyException ("");
			regprofessionals.put(s, profession);				
		}
			
		Collections.addAll(prof, professionals);
		
		professions.put(profession, prof);
				
	}

	/**
	 * Returns a map ( profession => number of workers )
	 *
	 */
	public SortedMap<String, Integer> getProfessions() {
		
		
		return regprofessionals.values().stream()
				.collect(Collectors.groupingBy(x-> x,  
						TreeMap :: new, 
						Collectors.collectingAndThen(Collectors.counting(),
								l->l.intValue())));
	}

	public int addRequest(String owner, String apartment, String profession) throws PropertyException {
		
		if (!owners.containsKey(owner)) throw new PropertyException ("");
		if (!aptOwner.containsKey(apartment)) throw new PropertyException ("");
		//System.out.println(professions);
		if(!professions.containsKey(profession)) throw new PropertyException("Bohh");
		if(aptOwner.get(apartment) !=owner) throw new PropertyException();
		
		request++;
		Request r= new Request(request, owner, apartment, profession);
		requests.add(r);
				
		return request;
	}

	public void assign(int requestN, String professional) throws PropertyException {
		
		if (requests.size()<requestN) throw new PropertyException ();
		//System.out.println(requests.get(requestN-1).getStatus());
		if (requests.get(requestN-1).getStatus()!=Request.status.pending ) throw new PropertyException ();
		if (!regprofessionals.get(professional).equals(requests.get(requestN-1).getProfession())) throw new PropertyException ();
		
		Request r= requests.get(requestN-1);
		r.setProfessional(professional);
		r.setStatus(Request.status.assigned);
		
	}

	public List<Integer> getAssignedRequests() {
		
		return requests.stream().sorted(Comparator.comparing(Request::getId))
				.filter( x -> x.getStatus()==Request.status.assigned)
				.map(Request::getId).collect(Collectors.toList());
						 
	}

	
	public void charge(int requestN, int amount) throws PropertyException {
		
		if (requests.size()<requestN) throw new PropertyException ();
		if (requests.get(requestN-1).getStatus()!=(Request.status.assigned) ) throw new PropertyException ();
		if (amount<0 || amount>1000) throw new PropertyException ();
		
		Request r= requests.get(requestN-1);
		r.setCost(amount);
	}

	/**
	 * Returns the list of request ids
	 * 
	 */
	public List<Integer> getCompletedRequests() {
		
		return requests.stream().sorted(Comparator.comparing(Request::getId))
						.filter(x -> x.getStatus()==Request.status.completed)
						.map(r -> r.getId()).collect(Collectors.toList());
				
	}
	
	/**
	 * Returns a map ( owner => total expenses )
	 * 
	 */
	public SortedMap<String, Integer> getCharges() {
		
		return requests.stream().filter(x -> x.getStatus() == Request.status.completed)
						.collect(Collectors.groupingBy(Request::getOwner, 
						TreeMap:: new, Collectors.summingInt(Request::getCost)));
				 
	}

	/**
	 * Returns the map ( building => ( profession => total expenses) ).
	 * Both buildings and professions are sorted alphabetically
	 * 
	 */
	public SortedMap<String, Map<String, Integer>> getChargesOfBuildings() {
		
		return  requests.stream().filter(x -> x.getStatus() == Request.status.completed)
				.collect(Collectors.groupingBy(Request::getBuilding, TreeMap::new,
									Collectors.groupingBy(Request::getProfessional,
									TreeMap::new, Collectors.summingInt(Request::getCost))))
				
				
				;
		
		
	}

}
