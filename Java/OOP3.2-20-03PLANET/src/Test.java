import it.polito.oop.space.Planet;

public class Test {

	static void describePlanet(Planet p) {
		System.out.println(p.getName() + ": " + p.getHabitableZone());
	}
	
	public static void main(String[] args) {
		Planet earth = new Planet("Earth");
		Planet mars = new Planet("Mars", 75348.0, 2131342, 'M');
		
		describePlanet(earth);
		describePlanet(mars);
		
		int[] v = {1, 2, 3};
	}

}
