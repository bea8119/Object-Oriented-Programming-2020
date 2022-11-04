package it.polito.oop.monsters;

public class MarineMonster extends Monster {
	private double swimmingSpeed;

	public MarineMonster(String name, double horriblenessLevel, double swimmingSpeed) {
		super(name, horriblenessLevel);
		this.swimmingSpeed = swimmingSpeed;
	}

	public double getSwimmingSpeed() {
		return swimmingSpeed;
	}

	@Override
	public void move() {
		System.out.println(name + " is swimming, blurbl...");
	}
}