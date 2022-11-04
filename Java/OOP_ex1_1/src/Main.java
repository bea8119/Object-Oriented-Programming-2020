
public class Main {

	public static void main(String[] args) {
	
			
		Person bob = new Person();
		bob.name = "Bob";
		bob.telljoke();
		bob.greet();
		
		Person jane = new Person();
		jane.name = "Jane";
		jane.greet();
		
		
		
		Planet earth= new Planet("Earth" , 141526374);
		earth.describe();
		
		Planet mars= new Planet("Mars", 23456789 );
		mars.describe();
		
		earth.set("Earth 2");
		earth.set(123456);
		
	}

}
