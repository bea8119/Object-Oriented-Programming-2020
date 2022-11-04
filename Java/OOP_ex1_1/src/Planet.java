
public class Planet {
	
	String name;
	
	double orbitalRadius;
	
	Planet(){
		this.name= "";
		this.orbitalRadius= 0;
	}
	
	Planet(String name, double orbitalRadius){
		this.name= name;
		this.orbitalRadius= orbitalRadius;
	}
	
	void describe() {
		System.out.println("Planet " + this.name + " with semimajor axis of " + orbitalRadius + " km ");
		
	}
	
	void set(String name) {
		this.name = name;
	}
	
	void set(double orbitalRadius) {
		this.orbitalRadius = orbitalRadius;
	}

	
	void set(String name, double orbitalRadius ) {
		this.name = name;
		this.orbitalRadius = orbitalRadius;
	}
}


