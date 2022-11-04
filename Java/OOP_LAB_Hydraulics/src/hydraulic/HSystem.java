package hydraulic;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystem {
	
	public int Max=100;
	public Element[] elements= new Element[Max];
	public int count=0;
	
	/**
	 * Adds a new element to the system
	 * @param elem
	 */
	public void addElement(Element elem){
		
		elements[count++]=elem;
		
	}
	
	/**
	 * returns the element added so far to the system.
	 * If no element is present in the system an empty array (length==0) is returned.
	 * 
	 * @return an array of the elements added to the hydraulic system
	 */ 
	public Element[] getElements(){
		Element[] result =new Element[count];
		
		for(int i=0; i<result.length; i++) {
			result[i]= elements[i];
			
		}
		
				
		return result ;
	}
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		// TODO: to be implemented
		return null;
		
	}
	
	/**
	 * starts the simulation of the system
	 */
	public void simulate(SimulationObserver observer){
		
		for(Element e: elements) {
			if(e != null && e instanceof Source) {
				e.simulate(-1, observer);
			}
		}
		
	}

}
