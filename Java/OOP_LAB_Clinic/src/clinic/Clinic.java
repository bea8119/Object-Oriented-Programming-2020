package clinic;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

/**
 * Represents a clinic with patients and doctors.
 * 
 */
public class Clinic {
	SortedMap<String, Patient> patients = new TreeMap<String, Patient>();
	SortedMap<Integer, Doctor> doctors = new TreeMap<Integer, Doctor>();
	
	/**
	 * Add a new clinic patient.
	 * 
	 * @param first first name of the patient
	 * @param last last name of the patient
	 * @param ssn SSN number of the patient
	 */
	public void addPatient(String first, String last, String ssn) {
		
		Patient p= new Patient(first, last, ssn);
		
		patients.put(ssn, p);

	}


	/**
	 * Retrieves a patient information
	 * 
	 * @param ssn SSN of the patient
	 * @return the object representing the patient
	 * @throws NoSuchPatient in case of no patient with matching SSN
	 */
	public String getPatient(String ssn) throws NoSuchPatient {
		
		return getPatient(ssn,true).toString();
	}
	public Patient getPatient(String ssn, boolean boh) throws NoSuchPatient {
		if(patients.get(ssn) == null) 
			throw new NoSuchPatient("There is no such patient");
		
		return patients.get(ssn);
	}

	/**
	 * Add a new doctor working at the clinic
	 * 
	 * @param first first name of the doctor
	 * @param last last name of the doctor
	 * @param ssn SSN number of the doctor
	 * @param docID unique ID of the doctor
	 * @param specialization doctor's specialization
	 */
	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		Doctor d= new Doctor(first, last, ssn, docID, specialization);
		
		doctors.put(docID, d);
		patients.put(ssn, d);
	}

	/**
	 * Retrieves information about a doctor
	 * 
	 * @param docID ID of the doctor
	 * @return object with information about the doctor
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public String getDoctor(int docID) throws NoSuchDoctor {
	
		return getDoctor(docID, true).toString();
	}
	
	
	public Doctor getDoctor(int docID, boolean boh) throws NoSuchDoctor {
		if(doctors.get(docID) == null) 
			throw new NoSuchDoctor("There is no such doctor");
		
		return doctors.get(docID);
	}
	
	/**
	 * Assign a given doctor to a patient
	 * 
	 * @param ssn SSN of the patient
	 * @param docID ID of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public void assignPatientToDoctor(String ssn, int docID) 
				throws NoSuchPatient, NoSuchDoctor {
		Doctor doc=getDoctor(docID, true);
		Patient pat=getPatient(ssn, true);
		
		
		pat.setDoc(doc);
		
	}
	
	/**
	 * Retrieves the id of the doctor assigned to a given patient.
	 * 
	 * @param ssn SSN of the patient
	 * @return id of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor has been assigned to the patient
	 */
	public int getAssignedDoctor(String ssn) throws NoSuchPatient, NoSuchDoctor {
		Patient pat=getPatient(ssn, true);
				
		return pat.getDoc();
	}
	
	/**
	 * Retrieves the patients assigned to a doctor
	 * 
	 * @param id ID of the doctor
	 * @return collection of patient SSNs
	 * @throws NoSuchDoctor in case the {@code id} does not match any doctor 
	 */
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {
		Doctor doc=getDoctor(id, true);
		
		return doc.getPatients();
	}


	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about
	 * either a patient or a doctor.</p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by first name,
	 * last name, and SSN. Rows containing doctor's info start with letter {@code "M"},
	 * followed by badge ID, first name, last name, SSN, and specialization.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.</p>
	 * <p>
	 * In case of error in the data present on a given row, the method should be able
	 * to ignore the row and skip to the next one.<br>

	 * 
	 * @param readed linked to the file to be read
	 * @throws IOException in case of IO error
	 */
	public void loadData(Reader reader) throws IOException {
		
		
		
		
	}


	/**
	 * Retrieves the collection of doctors that have no patient at all.
	 * The doctors are returned sorted in alphabetical order
	 * 
	 * @return the collection of doctors' ids
	 */
	public Collection<Integer> idleDoctors(){
		
		return
		doctors.values().stream().sorted(Comparator.comparing(Doctor::getLast).thenComparing(Doctor::getFirst))
		.filter(x-> x.getPatients().isEmpty())
		.map(Doctor::getId).collect(Collectors.toList())
		;
		
		
		
	}

	/**
	 * Retrieves the collection of doctors having a number of patients larger than the average.
	 * 
	 * @return  the collection of doctors' ids
	 */
	public Collection<Integer> busyDoctors(){
		double avgpatients=
				doctors.values().stream().mapToInt(d-> d.getPatients().size()).average().orElse(0.0);
		return				
		doctors.values().stream().filter(x-> x.getPatients().size()>avgpatients)
		.map(Doctor::getId).collect(Collectors.toList());
		
		
	}

	/**
	 * Retrieves the information about doctors and relative number of assigned patients.
	 * <p>
	 * The method returns list of strings formatted as "{@code ### : ID SURNAME NAME}" where {@code ###}
	 * represent the number of patients (printed on three characters).
	 * <p>
	 * The list is sorted by decreasing number of patients.
	 * 
	 * @return the collection of strings with information about doctors and patients count
	 */
	public Collection<String> doctorsByNumPatients(){
		return
		doctors.values().stream()
		.sorted(Comparator.comparing((Doctor x)->x.getPatients().size()).reversed())
		.map(d-> String.format("%3d", d.getPatients().size())+ " : " + d.getId()+ " "+ 
						d.getLast()+" "+d.getFirst()).collect(Collectors.toList())
		;
		
		
	}
	
	/**
	 * Retrieves the number of patients per (their doctor's)  speciality
	 * <p>
	 * The information is a collections of strings structured as {@code ### - SPECIALITY}
	 * where {@code SPECIALITY} is the name of the speciality and 
	 * {@code ###} is the number of patients cured by doctors with such speciality (printed on three characters).
	 * <p>
	 * The elements are sorted first by decreasing count and then by alphabetic speciality.
	 * 
	 * @return the collection of strings with speciality and patient count information.
	 */
	public Collection<String> countPatientsPerSpecialization(){
		return
		doctors.values().stream().collect(Collectors.groupingBy(Doctor::getSpec,
				()->new TreeMap<String,Integer>(), Collectors.summingInt((Doctor x)->x.getPatients().size())))
		.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
				.map(e->String.format("%3d", e.getValue())+ " - "+ e.getKey())
				.collect(Collectors.toList())
				;
	
	}
	
}
