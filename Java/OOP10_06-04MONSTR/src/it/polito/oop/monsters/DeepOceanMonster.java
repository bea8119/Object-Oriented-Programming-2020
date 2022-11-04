package it.polito.oop.monsters;

public class DeepOceanMonster extends MarineMonster {

	public DeepOceanMonster(String name, double horriblenessLevel, double swimmingSpeed) {
		super(name, horriblenessLevel, swimmingSpeed);
	}
	
	@Override
	public void move() {
		super.move();
		System.out.println("(in deep water)");
	}	
}
