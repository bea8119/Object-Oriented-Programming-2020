package diet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Represents an order in the take-away system
 */
public class Order  implements Comparable<Order>{
	
	private float price;
	private PaymentMethod method;
	private OrderStatus status;
	
	private Restaurant restaurant;
	private User user;
	private String time;
	
	private SortedMap<String,  MenuSelection> menues_qty= new TreeMap< String, MenuSelection>();
	
	protected static class MenuSelection{
		final Menu m;
		final int quantity;
		
		MenuSelection(Menu menu,int  qty) {
			this.m=menu;
			this.quantity=qty;
		}		
	}
 
	public Order(User u, Restaurant R, int h, int m) {
		
		this.user=u;
		this.restaurant = R;
		this.time=String.format("%02d:%02d", h, m);
		//System.out.println("eh proviamo questo "+time );
		method=PaymentMethod.CASH;
		status= OrderStatus.ORDERED;
		
	}
	
	/**
	 * Defines the possible order status
	 */
	public enum OrderStatus {
		ORDERED, READY, DELIVERED;
	}
	/**
	 * Defines the possible valid payment methods
	 */
	public enum PaymentMethod {
		PAID, CASH, CARD;
	}
		
	/**
	 * Total order price
	 * @return order price
	 */
	public double Price() {
		return price;
	}
	
	/**
	 * define payment method
	 * 
	 * @param method payment method
	 */
	public void setPaymentMethod(PaymentMethod method) {
		this.method=method;
		
	}
	
	/**
	 * get payment method
	 * 
	 * @return payment method
	 */
	public PaymentMethod getPaymentMethod() {
		
		return method;
	}
	
	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * change order status
	 * @param newStatus order status
	 */
	public void setStatus(OrderStatus newStatus) {
		
		this.status=newStatus;
	}
	
	/**
	 * get current order status
	 * @return order status
	 */
	public OrderStatus getStatus(){
		return status;
	}
	
	public User getUser(){
		return user;
	}
	
	private String getTime() {
		
		return time;
	}
	
	
	
	/**
	 * Add a new menu with the relative order to the order.
	 * The menu must be defined in the {@link Food} object
	 * associated the restaurant that created the order.
	 * 
	 * @param menu     name of the menu
	 * @param quantity quantity of the menu
	 * @return this order to enable method chaining
	 */
	public Order addMenus(String menu, int quantity) {
		Menu m= restaurant.getMenu(menu);
		MenuSelection e= new MenuSelection(m, quantity);
		menues_qty.put(menu, e);
		
		return this;
	}
	
	/**
	 * Converts to a string as:
	 * <pre>
	 * RESTAURANT_NAME, USER_FIRST_NAME USER_LAST_NAME : DELIVERY(HH:MM):
	 * 	MENU_NAME_1->MENU_QUANTITY_1
	 * 	...
	 * 	MENU_NAME_k->MENU_QUANTITY_k
	 * </pre>
	 */
	@Override
	public String toString() {
		String buffer= "";
		buffer += restaurant.getName()+", "+user.getFirstName()+" "+user.getLastName()+" : ("
				+this.time+"):";
		
		for(MenuSelection ms: menues_qty.values()){
			buffer +="\n\t"+ms.m.getName()+ "->"+ ms.quantity;
		}
		
		return buffer;
	}
	
	public int compareTo(Order o) {
		int userr=this.getUser().compareTo(o.getUser());
		
		if(userr == 0) {
			return this.time.compareTo(o.getTime());
		}
		else
		return  userr;
	}

	
	
}
