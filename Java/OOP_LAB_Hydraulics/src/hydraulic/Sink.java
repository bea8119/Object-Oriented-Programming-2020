package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends ElementExt {

	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
		//TODO: complete
	}
	
	@Override
	public void connect(Element elem){
		// no effect!
	}
	
	@Override
	StringBuffer layout(String pad) {
		StringBuffer container = new StringBuffer();
		container.append("[").append(this.getName()).append("] Sink *");

		return container;
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer,  boolean enableMaxFlowChecks) {
		
		if(observer instanceof SimulationObserverExt && enableMaxFlowChecks && inFlow>maxFlow)
			((SimulationObserverExt)observer).notifyFlowError("Sink", getName(), inFlow, maxFlow);
		observer.notifyFlow("Sink",getName(),inFlow, SimulationObserver.NO_FLOW);
		
	}
	
	@Override
	void simulate(double inFlow, SimulationObserver observer) {
		simulate(inFlow, observer,false);
	}
	
}
