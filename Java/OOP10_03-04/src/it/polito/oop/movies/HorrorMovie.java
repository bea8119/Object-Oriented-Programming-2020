package it.polito.oop.movies;

public class HorrorMovie extends Movie {
	
	private double scaringLevel = 0.5;

	
	public double getScaringLevel() {
		return scaringLevel;
	}

	public void setScaringLevel(double scaringLevel) {
		this.scaringLevel = scaringLevel;
	}

	@Override
	public void describe() {
		System.out.println("A horror movie. Title : \"" + this.Title + " \"");
		
		if(scaringLevel == 0.0) {
			System.out.println("Not scaring at all");
			
		} else if (scaringLevel < 0.5) {
			System.out.println("Mildly scaring");
		} else {
			System.out.println("Scaring");
		}
		
		System.out.println( " ");
		
	}
	

}
