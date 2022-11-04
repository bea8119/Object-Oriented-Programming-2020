package it.polito.oop.menu;

public abstract class Dessert extends Dish {

	public Dessert(String name) {
		super(name);
	}
	
	@Override
	public boolean isSweet() {
		return true;   
	}
}
