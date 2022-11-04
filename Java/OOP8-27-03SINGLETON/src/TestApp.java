
import static it.polito.oop.constants.CrazyConstants.*;
import it.polito.oop.constants.Singleton;

public class TestApp {

	private String foo;
	private String bar;
	static String baz;
	
	public static void main(String[] args) {
		// I can use STATIC methods & access STATIC attributes
		TestApp.baz = "Foo";
		TestApp.simpleStaticFunction();
		System.out.println("GARGLE is " + GARGLE);
		System.out.println("ZAP: " + ZAP);
		System.out.println("ZAP: " + ZAP);
		System.out.println("SINGLETON: " + Singleton.getInstance());
		
		// ... but I need an object to call NON-STATIC ones
		TestApp tapp = new TestApp();
		tapp.simpleFunction();
	}
	
	void simpleFunction() {
		System.out.println("Hello!? I'm a simple function...");
		System.out.println("SINGLETON: " + Singleton.getInstance());
	}

	static void simpleStaticFunction() {
		final int yeah;
		yeah = 13;
		System.out.println("Hello!? I'm simply a static function...");
		System.out.println("Yeah: " + yeah);
		System.out.println("SINGLETON: " + Singleton.getInstance());
	}

}
