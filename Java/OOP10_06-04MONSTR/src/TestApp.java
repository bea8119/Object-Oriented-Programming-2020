import it.polito.oop.monsters.Monster;
import it.polito.oop.monsters.MarineMonster;
import it.polito.oop.monsters.FlyingMonster;
import it.polito.oop.monsters.DeepOceanMonster;

final public class TestApp {
	public static void main(String args[]) {
		MarineMonster godzilla = new MarineMonster("ゴジラ", .2, 4.2);
		godzilla.move();
		
		// upcast, always safe, remove something (less info)
		Monster puppy = godzilla;
		double x = godzilla.getSwimmingSpeed();
		//double y = puppy.getSwimmingSpeed();		// error!
		puppy.move();
		
		// downcast, NOT always safe, adding info
		if(puppy instanceof MarineMonster) {
			// asking for permission
			MarineMonster test = (MarineMonster)puppy;
		} else {
			System.out.println("Can't do it!");
		}

		// downcast, NOT always safe, adding info
		if(puppy instanceof FlyingMonster) {
				FlyingMonster test2 = (FlyingMonster)puppy;
		} else {
			System.out.println("Can't do it!");
		}

		DeepOceanMonster kraken = new DeepOceanMonster("Kraken", .5, 6345.23);
		kraken.move();
	}
}
