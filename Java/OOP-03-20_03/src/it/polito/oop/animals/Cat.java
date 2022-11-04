package it.polito.oop.animals;

public class Cat {
	private String name;
	private boolean raw = true;

	public Cat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void cook() {
		System.out.println("Cooking " + this.name + "...");
		this.raw = false;
		System.out.println("Cooked");
	}
	
	public void publicMethod() {
		if(this.raw) {
			System.out.println("Meow!");
		} else {
			System.out.println(this.name + " is cooked");
		}
	}
}