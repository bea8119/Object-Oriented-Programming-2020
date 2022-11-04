package it.polito.oop.books;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Collections;

public class Question {
	
	private String question;
	private Topic mainTopic;
	private List<Answer> answers= new LinkedList<Answer>();
	
	protected class Answer{
		
		public Answer(String answer, boolean correct) {
			this.answer = answer;
			this.correct = correct;
		}
		protected String answer;
		protected boolean correct;
	}
	
	
	
	public Question(String question, Topic mainTopic) {
		this.question = question;
		this.mainTopic = mainTopic;
	}

	public String getQuestion() {
		return question;
	}
	
	public Topic getMainTopic() {
		return mainTopic;
	}

	public void addAnswer(String answer, boolean correct) {
		answers.add(new Answer(answer, correct));
		
	}
	
    @Override
    public String toString() {
        return question+" ("+mainTopic+")";
    }

	public long numAnswers() {
	    return answers.size();
	}

	public Set<String> getCorrectAnswers() {
		
		return answers.stream().filter(a-> a.correct==true).map(x-> x.answer).collect(Collectors.toSet());
	}

	public Set<String> getIncorrectAnswers() {
		return answers.stream().filter(a-> a.correct==false).map(x-> x.answer).collect(Collectors.toSet());
	}
}
