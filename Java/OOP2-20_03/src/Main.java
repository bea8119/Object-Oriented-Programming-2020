
public class Main {

	public static void main(String[] args) {
		//Dog bobby = new Dog();
		//bobby.name = "Bobby";
		//bobby.bark();
		
		
		
		Dog dog= new Dog("Pluto");
		dog.bark();
		dog.setName("Fluffy"); 
		dog.bark();
		
		
		Dog dog2 = new Dog("Rex");
	    dog2.bark();
	     
		System.out.println("The name of dog2 is " + dog2.getName());
	    }
		

	}


