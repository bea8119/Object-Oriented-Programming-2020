package it.polito.oop.monsters;

public class Monster {
	protected String name;
	protected double horriblenessLevel;
	
	//Monster(){}
		
	Monster(String name, double horriblenessLevel) {
		this.name = name;
		this.horriblenessLevel = horriblenessLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHorriblenessLevel() {
		return horriblenessLevel;
	}

	public void setHorriblenessLevel(double horriblenessLevel) {
		this.horriblenessLevel = horriblenessLevel;
	}
	
	public void move() {
		System.out.println(this.name + " is moving, roar!");
	}

}