package it.polito.oop.menu;

public class Tiramisu extends Dessert{
	public String biscuitType;
	
	public Tiramisu(String name, int price, String biscuittype) {
		
		super(name);
		this.calories = 18238;
		this.carbs = 323;
		this.price = price;
		this.biscuitType = biscuittype;
	}
	
	@Override
	public  boolean isGluenFree() {
		return false;
	}
	
	@Override
	public  boolean isVegan() {
		return false;
	}
	
	@Override 
	public String getName() {
		return this.name + " made with " + this.biscuitType;
	}
	
}
