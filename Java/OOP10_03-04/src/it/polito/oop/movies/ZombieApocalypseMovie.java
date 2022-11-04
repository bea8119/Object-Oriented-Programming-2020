package it.polito.oop.movies;

public class ZombieApocalypseMovie extends HorrorMovie{
		
	private boolean bradPitt = false;

	public boolean isBradPitt() {
		return bradPitt;
	}

	public void setBradPitt(boolean bradPitt) {
		this.bradPitt = bradPitt;
	}


	public void describe() {
	System.out.println("A horror movie. Title : \"" + this.getTitle() + " \"");
		
		if(this.getScaringLevel() == 0.0) {
			System.out.println("Not scaring at all");
			
		} else if (this.getScaringLevel() < 0.5) {
			System.out.println("Mildly scaring");
		} else {
			System.out.println("Scaring");
		}
		
		if(bradPitt) {
			System.out.println("With Brad Pitt");
		}
		else {
			System.out.println("Without Brad Pitt");
		}
		
		System.out.println( " ");
	}
	
	
	
	
	
}
