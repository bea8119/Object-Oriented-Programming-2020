
public class Person {
	String name;
	boolean happy = false;
	
	void telljoke() {
		happy = true;
	}
	
	void greet() {
		System.out.println("Hello, my name is " + name);
		if(happy) {
			System.out.print(" and i am happy...");
		}
		System.out.println("");
		
	}

}
