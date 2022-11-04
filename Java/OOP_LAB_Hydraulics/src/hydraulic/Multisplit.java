



package hydraulic;

import java.util.Arrays;

/**
 * Represents a multisplit element, an extension of the Split that allows many outputs
 * 
 * During the simulation each downstream element will
 * receive a stream that is determined by the proportions.
 */

public class Multisplit extends Split {
	
	private double[] proportions;
	private int numOutput;

	/*
	 * Constructor
	 * @param name
	 * @param numOutput
	 */
	public Multisplit(String name, int numOutputs) {
		super(name, numOutputs); 
		this.numOutput=numOutputs;
		
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){

        return outputs;
    }

    /**
     * connect one of the outputs of this split to a
     * downstream component.
     * 
     * @param elem  the element to be connected downstream
     * @param noutput the output number to be used to connect the element
     */
	public void connect(Element elem, int noutput){
		outputs[noutput]=elem;
		
	}
	
	/**
	 * Define the proportion of the output flows w.r.t. the input flow.
	 * 
	 * The sum of the proportions should be 1.0 and 
	 * the number of proportions should be equals to the number of outputs.
	 * Otherwise a check would detect an error.
	 * 
	 * @param proportions the proportions of flow for each output
	 */
	public void setProportions(double... proportions) {
		
		this.proportions=proportions;				
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer, boolean enableMaxFlowChecks) {
		double[] Outflow= new double[numOutput];
		
		
		for(int i=0; i<numOutput; i++) {
			Outflow[i]= proportions[i]*inFlow;
			
		}
			
		
		((SimulationObserverExt)observer).notifyFlow("Multisplit", getName(), inFlow, Outflow);
		
		if(observer instanceof SimulationObserverExt && enableMaxFlowChecks && inFlow>maxFlow)
			((SimulationObserverExt)observer).notifyFlowError("Tap", getName(), inFlow, maxFlow);
		
		for(int i=0; i<numOutput; i++) {
			 Element e = getOutputs()[i];
			e.simulate(Outflow[i], observer, enableMaxFlowChecks );
		}
		
	}
	
	
}
