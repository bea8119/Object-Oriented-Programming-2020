package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends ElementExt {
	
	private double flow;

	public Source(String name) {
		super(name);
		//TODO: complete
	}
	

	/**
	 * defines the flow produced by the source
	 * 
	 * @param flow
	 */
	public void setFlow(double flow){
		
		this.flow=flow;
		this.maxFlow=flow;
	}
	
	@Override
	StringBuffer layout(String pad) {
		 StringBuffer container = new StringBuffer();
		container.append("[").append(this.getName()).append("] Source ->");
		container.append(this.getOutput().layout(blanks(container.length())) );
		
		return container;
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer,  boolean enableMaxFlowChecks) {
		
		observer.notifyFlow("Source", getName(), SimulationObserver.NO_FLOW, flow);
		
		if(observer instanceof SimulationObserverExt && enableMaxFlowChecks && inFlow>maxFlow)
			((SimulationObserverExt)observer).notifyFlowError(this.getClass().getName(), getName(), inFlow, maxFlow);
		
		getOutput().simulate(flow,observer,enableMaxFlowChecks);
	}
	
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		simulate(inFlow, observer,false);
	}
	
}
