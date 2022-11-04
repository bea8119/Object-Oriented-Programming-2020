package it.polito.oop.elective;

import java.util.LinkedList;
import java.util.List;

public class Student {
	private String id;
	private double avg;
	private List<Course> courses= new LinkedList<Course>();
	
	public Student(String id, double avg) {
		this.id = id;
		this.avg = avg;
	}

	public String getId() {
		return id;
	}

	public double getAvg() {
		return avg;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	public int choiceNo(String course) {
        for(int i=0; i<courses.size(); ++i) {
            if(courses.get(i).getName().equals(course)) 
            	return i+1;
        }
        return -1;
    }
	
	

}
