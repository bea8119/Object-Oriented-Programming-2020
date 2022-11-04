import it.polito.oop.movies.HorrorMovie;
import it.polito.oop.movies.Movie;
import it.polito.oop.movies.ZombieApocalypseMovie;
import it.polito.oop.movies.JapaneseMovie;

public class TestApp2 {

	public static void main(String[] args) {
		System.out.println("Test App 2!");
		
		ZombieApocalypseMovie zam =  new ZombieApocalypseMovie();
		zam.setTitle("Dawn of the Dead");
		zam.setBradPitt(false);
		zam.setScaringLevel(-1);
		zam.describe();
		
		HorrorMovie h;
		h=zam;
		//h.setBradPitt(true); not working
		h.describe();
		

		ZombieApocalypseMovie temp = (ZombieApocalypseMovie)h; 
		temp.setBradPitt(true);
		System.out.println("________________");
		h.describe();
		
		
		JapaneseMovie j = new JapaneseMovie();
		Movie genericMovie= j;
		HorrorMovie horror = (HorrorMovie)genericMovie;
		//HorrorMovie horror2 = (HorrorMovie)genericMovie;
		horror.describe();  //wrong because i'm not able to cast it bc the compiler knows it's a japanese movie

		
	}

}
