
public class Dog {
	
	private String name;

	
	//constructor
	//Dog(){
	//	this.name = "Doggy";
	//}
	
	 public Dog(String name){
		this.name= name;
		
	}
	
	 public void setName(String name) {
		this.name = name;
	}
	
	 public String getName() {
		 return this.name;
	 }
	

	public void bark() {
		System.out.println(name + " is barking! ");
	}
	
}
