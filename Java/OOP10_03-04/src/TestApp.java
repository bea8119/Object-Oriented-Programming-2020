import it.polito.oop.movies.HorrorMovie;
import it.polito.oop.movies.Movie;
import it.polito.oop.movies.ZombieApocalypseMovie;
import it.polito.oop.movies.JapaneseMovie;

public class TestApp {
	
	public static void main(String[] args) {
		
		
		 // HorrorMovie hm2 = new Movie();   cannot do it bc horror movie has more properties
		 
		// we can do:
		//Movie hm2 = new HorrorMovie();
		 // hm2.setScaringLevel(0.0);
		//Reference cannot see some properties only of horror movie
		
		Movie gone = new Movie();
		gone.setTitle("Gone with the wind");
		//gone.describe();
		
		HorrorMovie oneCut = new HorrorMovie();
		oneCut.setTitle("fsadfasdsad");		// One Cut of the Dead
		oneCut.setScaringLevel(0.0);
		//oneCut.describe();
		
		//Movie[] library = new Movie[2];
		//library[0] = gone;
		//library[1] = oneCut;
		//for(Movie m: library)
		//	m.describe();		// polymorphism
		
		
		
		ZombieApocalypseMovie wwz = new ZombieApocalypseMovie();
		wwz.setTitle("World War Z");
		wwz.setScaringLevel(0.4);
		wwz.setBradPitt(true);
		
		
		ZombieApocalypseMovie days = new ZombieApocalypseMovie();
		wwz.setTitle("W28 Days later");
		wwz.setScaringLevel(0.6);
		wwz.setBradPitt(false);
		
		JapaneseMovie tokyoStory = new JapaneseMovie();
		tokyoStory.setTitle("Tokyo STory");
		
		System.out.println( " Library []--------------");
		
		Movie[] library = {gone, oneCut, wwz, days, tokyoStory};
		
		for(Movie m: library)
			m.describe();
		System.out.println(" ");
		
	}


	}


