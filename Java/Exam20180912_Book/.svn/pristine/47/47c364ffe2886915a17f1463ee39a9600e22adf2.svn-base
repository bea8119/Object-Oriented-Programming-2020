package it.polito.oop.books;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Topic {
	
	private String keyword;
	
	private List<Topic> subtopic= new LinkedList<Topic>();

	public Topic(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
        return keyword;
	}
	
	@Override
	public String toString() {
	    return keyword;
	}

	public boolean addSubTopic(Topic topic) {
		
		if(subtopic.contains(topic))
			return false;
		
		subtopic.add(topic);	
		
        return true;
	}

	/*
	 * Returns a sorted list of subtopics. Topics in the list *MAY* be modified without
	 * affecting any of the Book topic.
	 */
	public List<Topic> getSubTopics() {
        return subtopic.stream().sorted(Comparator.comparing(Topic::getKeyword)).collect(Collectors.toList());
	}
}
