package it.polito.oop.books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Book {

   private Map<String, Topic> topics= new TreeMap<String, Topic>();
   private Map<String, Question> questions= new TreeMap<String, Question>();
   private Map<String, TheoryChapter> thchapters= new TreeMap<String, TheoryChapter>();
   private Map<String, ExerciseChapter> exchapters= new TreeMap<String, ExerciseChapter>();
   
	
	public Topic getTopic(String keyword) throws BookException {
		if(keyword==null || keyword=="")
			throw new BookException();
		if(topics.containsKey(keyword))
			return topics.get(keyword);
		else {
			Topic t= new Topic(keyword);
			topics.put(keyword, t);
			return t;
		}
		
	   
	}

	public Question createQuestion(String question, Topic mainTopic) {
		
		Question q= new Question(question, mainTopic);
		questions.put(question, q);
		
        return q;
	}

	public TheoryChapter createTheoryChapter(String title, int numPages, String text) {
		TheoryChapter th= new TheoryChapter(title, numPages, text);
		thchapters.put(title, th);		
        return th;
	}

	public ExerciseChapter createExerciseChapter(String title, int numPages) {
		ExerciseChapter ex= new ExerciseChapter(title, numPages);
		exchapters.put(title, ex);
        return ex;
	}

	public List<Topic> getAllTopics() {
		List<Topic> thch=thchapters.values().stream().map(x-> x.getTopics()).flatMap(x-> x.stream()).collect(Collectors.toList())
		;
		List<Topic> exch=exchapters.values().stream().map(x-> x.getTopics()).flatMap(x-> x.stream()).collect(Collectors.toList())
				;
		List<List<Topic>> tot= new ArrayList<List<Topic>>();
		tot.add(thch);
		tot.add(exch);
		
        return tot.stream().flatMap(x->x.stream()).distinct()
        		.sorted(Comparator.comparing(Topic::getKeyword))
        		.collect(Collectors.toList());
	}

	public boolean checkTopics() {
		List<Topic> thch=thchapters.values().stream().map(x-> x.getTopics()).flatMap(x-> x.stream()).collect(Collectors.toList())
				;
		
        return thch.containsAll(topics.values());
	}

	public Assignment newAssignment(String ID, ExerciseChapter chapter) {
		
		Assignment a= new Assignment(ID, chapter);
		
        return a;
	}
	
    /**
     * builds a map having as key the number of answers and 
     * as values the list of questions having that number of answers.
     * @return
     */
    public Map<Long,List<Question>> questionOptions(){
    	
    	
        return questions.values().stream().collect(Collectors.toMap(x-> x, x-> x.numAnswers()))
            	.entrySet().stream().collect(Collectors.groupingBy(x-> x.getValue(), ()-> new TreeMap<Long, List<Question>>(), 
            			Collectors.mapping(x->x.getKey(), Collectors.toList())))
            	;
    }
}
