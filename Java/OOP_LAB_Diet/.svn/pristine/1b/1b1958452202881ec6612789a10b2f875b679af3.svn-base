package diet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import diet.Order.OrderStatus;

/**
 * Represents a restaurant in the take-away system
 *
 */
public class Restaurant implements Comparable<Restaurant> {
	
	/**
	 * Constructor for a new restaurant.
	 * 
	 * Materials and recipes are taken from
	 * the food object provided as argument.
	 * 
	 * @param name	unique name for the restaurant
	 * @param food	reference food object
	 */
	private String name;
	private Food food;
	private List<String> hours= new LinkedList<String>();
	private SortedMap< String, Menu> menues= new TreeMap<String,  Menu>();
	private List<Order> orders= new LinkedList<Order>();
	
	
	public Restaurant(String name, Food food) {
		// TODO: implement constructor
		
		this.name=name;
		this.food=food;
		
	}
	
	/**
	 * gets the name of the restaurant
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Define opening hours.
	 * 
	 * The opening hours are considered in pairs.
	 * Each pair has the initial time and the final time
	 * of opening intervals.
	 * 
	 * for a restaurant opened from 8:15 until 14:00 and from 19:00 until 00:00, 
	 * is thoud be called as {@code setHours("08:15", "14:00", "19:00", "00:00")}.
	 * 
	 * @param hm a list of opening hours
	 */
	public void setHours(String ... hm) {
		
		for(String h: hm)
			this.hours.add(h);
		
	}
	public String[] getHours(){
		
		for(String s: hours.toArray(new String[0]) ) {
			 //System.out.println("Prove "+s);
		}
		return hours.toArray(new String[0]);
	}
	
	public Menu createMenu(String name) {
		
		Menu m= food.createMenu(name);
		
		menues.put(name, m);
		return m; 
		
	}

	
	public Menu getMenu(String name) {
		
		return menues.get(name);
	}
	
	public void addOrder(Order o) {
		
		orders.add(o);
	}
	
	/**
	 * Creates a new menu
	 * 
	 * @param name name of the menu
	 * 
	 * @return the newly created menu
	 */
	
	/**
	 * Find all orders for this restaurant with 
	 * the given status.
	 * 
	 * The output is a string formatted as:
	 * <pre>
	 * Napoli, Judi Dench : (19:00):
	 * 	M6->1
	 * Napoli, Ralph Fiennes : (19:00):
	 * 	M1->2
	 * 	M6->1
	 * </pre>
	 * 
	 * The orders are sorted by name of restaurant, name of the user, and delivery time.
	 * 
	 * @param status the status of the searched orders
	 * 
	 * @return the description of orders satisfying the criterion
	 */
	public String ordersWithStatus(OrderStatus status) {
		Collections.sort(orders);
		
		
		StringBuffer buffer= new StringBuffer();
		//System.out.println("Ma entra?");
		
		for(Order o: orders) {
			//System.out.println("Ma entra?");
			//System.out.println("Prova "+o.getUser().getFirstName());
			if(o.getStatus().equals(status)) {
				buffer.append(o).append("\n");
			}
			
			
		}
		
		
		
		
		return buffer.toString();
	}
	
	@Override
	public int compareTo(Restaurant o) {
		return this.getName().compareTo(o.getName());
	}
}
