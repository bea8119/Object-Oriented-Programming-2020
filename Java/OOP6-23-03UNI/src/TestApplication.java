import it.polito.oop.university.Course;
import it.polito.oop.university.University;
import it.polito.oop.university.Student;

public class TestApplication {

	public static void main(String[] args) {
		University polito = new University("Politecnico di Torino");
		
		Course oop = polito.createCourse("01234", "Object Oriented Programming");
		Course dat = polito.createCourse("22345", "Databases");
		
		polito.printCourses();
		
		Student alice = polito.createStudent("0001", "Alice");
		Student bob = polito.createStudent("0002", "Bob");
	
		polito.printStudents();
		
		polito.enroll(oop,  alice);
		polito.enroll(oop,  bob);
		
		
	}

}
