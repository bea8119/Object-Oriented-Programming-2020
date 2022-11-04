package it.polito.oop.constants;

public class Singleton {
	private static Singleton instance;
	private Singleton() {
		System.out.println("... long inizialization");
		
	}
	
	public static Singleton getInstance() {
		if(instance == null)
			Singleton.instance = new Singleton();
		return Singleton.instance;
	}

}