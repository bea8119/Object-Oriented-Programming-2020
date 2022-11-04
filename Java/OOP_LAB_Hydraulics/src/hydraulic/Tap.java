package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends ElementExt {
	
	private boolean open;

	public Tap(String name) {
		super(name);
		//TODO: complete
	}
	
	/**
	 * Defines whether the tap is open or closed.
	 * 
	 * @param open  opening level
	 */
	public void setOpen(boolean open){
		this.open=open;
	}
	
	@Override
	StringBuffer layout(String pad) {
		StringBuffer container = new StringBuffer();
		container.append("[").append(this.getName()).append("] Tap ->");
		container.append(this.getOutput().layout(pad+blanks(container.length())) );
		return container;
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer,  boolean enableMaxFlowChecks) {

		Double outFlow= (open? inFlow:0);
		
		observer.notifyFlow("Tap",getName(),inFlow, outFlow);
		
		if(observer instanceof SimulationObserverExt && enableMaxFlowChecks && inFlow>maxFlow)
			((SimulationObserverExt)observer).notifyFlowError("Tap", getName(), inFlow, maxFlow);
		
		getOutput().simulate(outFlow, observer, enableMaxFlowChecks);
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		simulate(inFlow, observer,false);
	}

}
