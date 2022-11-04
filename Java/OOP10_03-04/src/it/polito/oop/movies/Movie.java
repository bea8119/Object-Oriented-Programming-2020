package it.polito.oop.movies;

public class Movie {
	public String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	
	
	public void describe() {
		System.out.println("A movie. Title : \"" + this.Title + " \"");
		
		System.out.println( " ");
		
		
		
	}
	

}
