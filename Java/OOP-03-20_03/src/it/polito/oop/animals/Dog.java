package it.polito.oop.animals;

public class Dog {
	private String name;
	private Collar collar;

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private void privateBark() {
		System.out.println(name + " is barking (privately)");
	}
	
	void bark() {
		System.out.println(name + " is barking!");
	}
	
	public void publicMethod() {
		this.bark();
		if(this.collar != null) {
			System.out.println("Wearing a " + this.collar.getColor() + " collar");
		}
}
	
	public void buyCollar(String color) {
		this.collar = new Collar(color);
	}
}