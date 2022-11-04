import it.polito.oop.menu.Dish;
import it.polito.oop.menu.Dessert;
import it.polito.oop.menu.Tiramisu;


public final class TestApplication {

	public static void main(String[] args) {
		
		Tiramisu t = new Tiramisu("House Tiramisu", 8, "Savoiardi");
		System.out.println(t.toString());
	}

}