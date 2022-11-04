package hydraulic;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystemExt extends HSystem{
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	@Override
	public String layout(){
		 StringBuffer container = new StringBuffer();
		 for(Element e: elements) {
			 if(e!=null && e instanceof Source) {
				 container.append(e.layout(" "));  
			 }
		 }
		
		return container.toString();
	}
	
	/**
	 * Deletes a previously added element with the given name from the system
	 */
	public void deleteElement(String name) {
		boolean found=false;
		int i;
		for( i=0; i<count; i++) {
			if(elements[i].getName().equals(name) && !found) {
				found=true;
				if(elements[i] instanceof Split)
					return;
				
				Element input = elements[i].getInput();
				int input_ind = elements[i].getInputInd();
				Element output = elements[i].getOutput();
				
				if(input!=null) {
					input.connect(output, input_ind);
				}
				if(output!=null) {
					output.setInput(input, 0);
				}				
			}
			if(found) {
				elements[i]=elements[i+1];
			}			
		}
		elements[i]=null;
		count--;
		
	}

	/**
	 * starts the simulation of the system; if enableMaxFlowCheck is true,
	 * checks also the elements maximum flows against the input flow
	 */
	public void simulate(SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		// TODO: to be implemented
	}
	
}
