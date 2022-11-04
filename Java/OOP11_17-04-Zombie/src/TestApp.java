
import it.polito.oop.zombies.Zombie;

public final class TestApp {

	public static void main(String[] args) {
		Zombie romero = new Zombie("George Romero");
		romero.setYearBirth(1940);
		romero.setYearDeath(2017);
		System.out.println(romero);
		romero.setYearUndeath(2020);
		System.out.println(romero);

		Zombie romero2 = new Zombie("George Romero");
		romero2.setYearBirth(1940);
		romero2.setYearDeath(2017);
		romero2.setYearUndeath(2020);
		System.out.println(romero2);
	
		System.out.println(romero == romero2);
		System.out.println(romero.equals(romero2));
		
		System.out.println(romero.hashCode() + " vs. " + romero2.hashCode());
	}

}