package it.polito.oop.books;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ExerciseChapter {
	private String title;
	private int numPages;
	
	private List<Question> questions= new LinkedList<Question>();
	
	
	

    public ExerciseChapter(String title, int numPages) {
		this.title = title;
		this.numPages = numPages;
		
	}

	

 

	public List<Topic> getTopics() {
		
        return questions.stream().sorted(Comparator.comparing(x-> x.getMainTopic().getKeyword())).map(x-> x.getMainTopic())
        		.distinct().collect(Collectors.toList())
        		;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
    	this.title=newTitle;
    }

    public int getNumPages() {
        return numPages;
    }
    
    public void setNumPages(int newPages) {
    	this.numPages=newPages;
    }
    
   
    

	public void addQuestion(Question question) {
		questions.add(question);
	}	
}
