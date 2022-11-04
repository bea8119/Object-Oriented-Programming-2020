package clinic;

public class Patient {
	
	
	private String first;
	private String last;
	private String ssn;
	private Doctor doc=null;
	public Patient(String first, String last, String ssn) {
		
		this.first = first;
		this.last = last;
		this.ssn = ssn;
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public String getSsn() {
		return ssn;
	}
	@Override
	public String toString() {
		return    last +" " + first + " (" + ssn +")" ;
	}
	public int getDoc() throws NoSuchDoctor {
		if(doc == null) 
			throw new NoSuchDoctor("There is no such doctor");
		
		return doc.getId();
	}
	public void setDoc(Doctor doc) {
		if(doc != null)
			doc.removeMe(this);
		
		this.doc = doc;
		doc.addPatient(this);
	}
	
	
	
	

}
