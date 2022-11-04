
package it.polito.oop.monsters;

public class FlyingMonster extends Monster {
	private double flyingSpeed;

	public double getFlyingSpeed() {
		return flyingSpeed;
	}

	public void setFlyingSpeed(double flyingSpeed) {
		this.flyingSpeed = flyingSpeed;
	}

	public void move() {
		System.out.println(name + " is flying, fiuuu...");
	}
	
}