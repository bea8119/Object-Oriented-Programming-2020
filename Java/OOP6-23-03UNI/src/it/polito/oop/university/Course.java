package it.polito.oop.university;

public class Course {
	private String code;
	private String title;
	private Student[] enrolledStudents = new Student[300];
	private int numStudents;
	
	
	 Course(String code, String title) {		
		this.code = code;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	
	public String getCode() {
			return code;
		}
	public void setTitle(String title) {
		this.title = title;
	}

	
	void addStudent(Student student) {
        enrolledStudents[numStudents++] = student;
    }
	
	
	public void printStudents() {
		for(int i = 0; i < numStudents; ++i)
		System.out.println(i+1 + " : " + enrolledStudents[i].getName() 
				+ " (" + enrolledStudents[i].getId() + ") ");
		
	}
	

}
