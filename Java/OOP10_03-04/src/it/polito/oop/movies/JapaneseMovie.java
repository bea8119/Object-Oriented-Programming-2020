package it.polito.oop.movies;

public class JapaneseMovie extends Movie {
	
	@Override
	public void describe() {
		System.out.println("A Japanese movie. Title: \"" + this.getTitle() + "\"");
		
		System.out.println( " ");
	}

}
