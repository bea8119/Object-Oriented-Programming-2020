package it.polito.oop.menu;

public abstract class Dish {
	protected int calories;
	protected int carbs;
	protected int price;
	
	protected String name;
	
	Dish(String name) {
		this.name = name;
	}

	
	
	public int getCalories() {
		return calories;
	}



	public void setCalories(int calories) {
		this.calories = calories;
	}



	public int getCarbs() {
		return carbs;
	}



	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public abstract boolean isSweet();
	public abstract boolean isGluenFree();
	public abstract boolean isVegan();
	
	@Override
	public String toString() {
		String str = this.getName();
		String note = "";
		if(! this.isVegan())
			note += " not";
		note += " Vegan";
		if(! this.isGluenFree())
			note += " not";
		note += " gluten free";
		note += " ";
		return str + "(" + note + ")";
		
	}
}