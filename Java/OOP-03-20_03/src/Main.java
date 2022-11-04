import it.polito.oop.animals.Dog;
import it.polito.oop.animals.Cat;

// import it.polito.oop.animal.Collar; -- can't do it!

public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog("Doggy");
		dog.publicMethod();
		dog.buyCollar("blue");
		dog.publicMethod();
				
		// Collar collar = new Collar("gold"); -- can't do it
		
		Cat cat = new Cat("Kitty");
		cat.publicMethod();
		cat.cook();
		cat.publicMethod();
		
	}

}
