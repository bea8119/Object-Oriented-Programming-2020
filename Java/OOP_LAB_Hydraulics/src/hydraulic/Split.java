package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends ElementExt {

	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name, 2);
		
	}
	public Split(String name, int numOutputs) {
		super(name, numOutputs);
		
	}
    
	 /**
     * connect one of the outputs of this split to a
     * downstream component.
     * 
     * @param elem  the element to be connected downstream
     * @param noutput the output number to be used to connect the element
     */
	
		public void connect(Element elem, int index){
		outputs[index]=elem;	
		}

   
	
		/**
		 * returns the downstream elements
		 * @return array containing the two downstream element
		 */
	public Element[] getOutputs(){
		return outputs;
	}
	
	@Override
	StringBuffer layout(String pad) {
		StringBuffer container = new StringBuffer();
		container.append("[").append(this.getName()).append("] Split +-> ");
		
		String subPad= pad + blanks(container.length()-4);
		
		for(int i=0; i< getOutputs().length; i++) {
			if(i>0) {
				container.append("\n");
				container.append(subPad).append("|\n");
				container.append(subPad + "+-> ");
				
			}
			container.append(getOutputs()[i].layout(subPad+ "|   ") );
		}
	return container;
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer,  boolean enableMaxFlowChecks) {
		
		double outFlow= inFlow/2;
		
		observer.notifyFlow("Split",getName(),inFlow, outFlow, outFlow);
		
		if(observer instanceof SimulationObserverExt && enableMaxFlowChecks && inFlow>maxFlow)
			((SimulationObserverExt)observer).notifyFlowError("Tap", getName(), inFlow, maxFlow);
		
		for(Element e:getOutputs()) {
			e.simulate(outFlow, observer, enableMaxFlowChecks);
	         }
		}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		simulate(inFlow, observer, false);
	}
	
	
		
		
	

}
