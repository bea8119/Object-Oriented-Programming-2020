package it.polito.oop.zombies;

public class Zombie {
	private int yearBirth = -1;
	private int yearDeath = -1;
	private int yearUndeath = -1;
	private double integrity = 1.0; 
	private String name;
	
	public double getIntegrity() {
		return integrity;
	}

	public void setIntegrity(double integrity) {
		this.integrity = integrity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zombie(String name) {
		this.name = name;
	}
	
	public int getYearBirth() {
		return yearBirth;
	}
	public void setYearBirth(int yearBirth) {
		this.yearBirth = yearBirth;
	}
	public int getYearDeath() {
		return yearDeath;
	}
	public void setYearDeath(int yearDeath) {
		this.yearDeath = yearDeath;
	}
	public int getYearUndeath() {
		return yearUndeath;
	}
	public void setYearUndeath(int yearUndeath) {
		this.yearUndeath = yearUndeath;
	}
	
	public String toString() {
		String out = this.name;
		if(this.yearBirth > 0) 
			out = out + " birth:" + this.yearBirth;
		if(this.yearDeath > 0) 
			out = out + " death:" + this.yearDeath;
		if(this.yearUndeath > 0) 
			out = out + " undeath:" + this.getYearUndeath();
		out = out + " (" + 100.0 * this.integrity + "%)";
		return out;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearBirth;
		result = prime * result + yearDeath;
		result = prime * result + yearUndeath;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Zombie))
			return false;
		Zombie other = (Zombie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearBirth != other.yearBirth)
			return false;
		if (yearDeath != other.yearDeath)
			return false;
		if (yearUndeath != other.yearUndeath)
			return false;
		return true;
	}
	


}
