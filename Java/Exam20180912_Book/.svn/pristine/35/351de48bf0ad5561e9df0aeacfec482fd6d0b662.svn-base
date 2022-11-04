package it.polito.oop.books;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Assignment {
	
	private String id;
	private ExerciseChapter chapter;
	private Map<Question, List<String>> responses= new TreeMap<Question, List<String>>();
	private double totalScore=0.0;
	

    public Assignment(String id, ExerciseChapter chapter) {
		this.id = id;
		this.chapter = chapter;
	}

	public String getID() {
        return null;
    }

    public ExerciseChapter getChapter() {
        return null;
    }

    public double addResponse(Question q, List<String> answers) {
    	
    	//responses.put(q, answers);
    	
    	totalScore= totalScore+ getScoreSingle(q, answers);
    	
        return getScoreSingle(q, answers);
    }
    
    public double getScoreSingle(Question q,List<String> answers) {
    	double fp= 0.0;
    	double right= 0.0;
    	double n= q.numAnswers();
    	for(String s: answers) {
    		if(q.getIncorrectAnswers().contains(s) || !q.getCorrectAnswers().contains(s))
    			fp=fp+1;
    		if(q.getCorrectAnswers().contains(s))
    			right= right+1;
    		
    	}
    	
    	return (n-fp-(q.getCorrectAnswers().size()-right))/n;
    }
    
    public double totalScore() {
    	
        return totalScore;
    }

}
