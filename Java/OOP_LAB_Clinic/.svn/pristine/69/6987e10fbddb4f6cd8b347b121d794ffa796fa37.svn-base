package clinic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



public class Doctor extends Patient {

	
	private int ID;
	private String specialization;
	
	private List<Patient> patients= new ArrayList<Patient>();
	
	
	public Doctor(String first, String last, String ssn, int ID, String specialization) {
		super(first, last, ssn);
		
		this.ID = ID;
		this.specialization = specialization;
	}
	
	public int getId() {
		return ID;
	}
	public String getSpec() {
		return specialization;
	}
	
	@Override
	public String toString() {
		return    this.getLast() +" " + this.getFirst() + " (" + this.getSsn() +") "+ID+": "+specialization ;
	}
	public Collection<String> getPatients() {
		// patients.stream().map(p-> p.getSsn(), Collectors.toList());
		
		
			return 	patients.stream()
					.collect(Collectors.mapping(x-> x.getSsn(), 
							Collectors.toList()));
			
			
			
				
	}
	
	public void addPatient(Patient p) {
		
		patients.add(p);
		
	}

	public void removeMe(Patient patient) {
		
		patients.remove(patient);
		
	}
	
}
