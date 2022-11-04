package hydraulic;

import java.util.Arrays;

/**
 * Represents the generic abstract element of an hydraulics system.
 * It is the base class for all elements.
 *
 * Any element can be connect to a downstream element
 * using the method {@link #connect(Element) connect()}.
 */
public abstract class Element {
	
	private String name;
	protected Element[] outputs;
	private Element input;
	private int input_ind = -1;
	
	/**
	 * Constructor
	 * @param name the name of the element
	 */
	public Element(String name){
		this.name=name;
		outputs=new Element[1];
	}
	
	Element(String name, int numoutputs) {
		this.name=name;
		
		outputs= new Element[numoutputs];
	}

	/**
	 * getter method
	 * @return the name of the element
	 */
	public String getName(){
			
		return this.name;  
	}
	
	/**
	 * Connects this element to a given element.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem){		
		outputs[0]=elem;
		if(elem!=null)
			elem.setInput(this, 0);
				
	}
	
	public void connect(Element elem, int index){
		outputs[index] = elem;
		if(elem!=null)
			elem.setInput(this, index);
	}
	
	abstract StringBuffer layout(String pad);
	
	protected static String blanks(int n) {
		char[] res = new char[n];
		Arrays.fill(res, ' ');
		return new String(res);
	}
	
	
	/**
	 * Retrieves the element connected downstream of this
	 * @return downstream element
	 */
	public Element getOutput(){
		
		return outputs[0];
	}
	
	public Element getInput()	{
		return input;
	}
	
	public int getInputInd()	{
		return input_ind;
	}	
	
	public void setInput(Element elem, int index)	{
		input = elem;
		input_ind = index;
	}
	
	
	
	abstract void simulate(double inFlow, SimulationObserver observer);
	abstract void simulate(double inFlow, SimulationObserver observer, boolean enableMaxFlowChecks);
}
