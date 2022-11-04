package it.polito.oop.university;

public class University {
	

	private String name;
	private Course[] courseArray = new Course[100];
	private int numCourses = 0; //technicallu useless
	private Student[] studentArray = new Student[300];
	private int numStudents = 0;
	
	
	
	
	public University(String name) {
		this.name = name;
	}
	
	public Course createCourse(String code, String title) {
		Course course= new Course(code, title);
		courseArray[numCourses++] = course;
		return course;
		
	}
	
	public void printCourses() {
		for(int i = 0; i < numCourses; ++i)
			System.out.println(i+1 + " : " + courseArray[i].getTitle() 
							+ " (" + courseArray[i].getCode() + ") ");
		
	}
	
	public Student createStudent(String id, String name) {
		Student student = new Student(id, name);
		studentArray[numStudents++] = student;
		return student;
		
	}
	
	public void printStudents() {
		for(int i = 0; i < numStudents; ++i)
			System.out.println(i+1 + " : " + studentArray[i].getName() 
							+ " (" + studentArray[i].getId() + ") ");
		
	}
	
	
	public void enroll(Course course, Student student) {
		course.addStudent(student);
		
	}
	
	

}
