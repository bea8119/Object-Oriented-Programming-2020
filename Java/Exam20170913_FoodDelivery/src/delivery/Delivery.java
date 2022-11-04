package delivery;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Collections;

public class Delivery {
	
	public Integer custid=0;
	public Integer ordid=0;
	public Map<Integer, Customer> customers= new TreeMap<Integer, Customer>();
	public Map<String, Menu> menues= new TreeMap<String, Menu>();
	public Map<Integer, Order> orders= new TreeMap<Integer, Order>();
    
    public static enum OrderStatus { NEW, CONFIRMED, PREPARATION, ON_DELIVERY, DELIVERED } 
    
    /**
     * Creates a new customer entry and returns the corresponding unique ID.
     * 
     * The ID for the first customer must be 1.
     * 
     * 
     * @param name name of the customer
     * @param address customer address
     * @param phone customer phone number
     * @param email customer email
     * @return unique customer ID (positive integer)
     */
    public int newCustomer(String name, String address, String phone, String email) throws DeliveryException {
        
    	for(Customer c:customers.values()) {
    		if(c.getMail().equals(email))
    			throw new DeliveryException("Duplicate email");
    	}
    	custid++;
    	Customer c= new Customer(custid, name, address, phone, email);
    	customers.put(custid, c);
    	
    	
    	return custid;
    }
    
    /**
     * Returns a string description of the customer in the form:
     * <pre>
     * "NAME, ADDRESS, PHONE, EMAIL"
     * </pre>
     * 
     * @param customerId
     * @return customer description string
     */
    public String customerInfo(int customerId){
    	
    	
        return customers.get(customerId).toString();
    }
    
    /**
     * Returns the list of customers, sorted by name
     * 
     */
    public List<String> listCustomers(){
    	return customers.values().stream().sorted(Comparator.comparing(Customer::getName))
    	.map(x-> {
			return x.toString()+ "\n";
		}).collect(Collectors.toList())
    	;	
    	
        
    }
    
    /**
     * Add a new item to the delivery service menu
     * 
     * @param description description of the item (e.g. "Pizza Margherita", "Bunet")
     * @param price price of the item (e.g. 5 EUR)
     * @param category category of the item (e.g. "Main dish", "Dessert")
     * @param prepTime estimate preparation time in minutes
     */
    public void newMenuItem(String description, double price, String category, int prepTime){
        
    	Menu m= new Menu(description, price, category, prepTime);
    	menues.put(description, m);
    	
    }
    
    /**
     * Search for items matching the search string.
     * The items are sorted by category first and then by description.
     * 
     * The format of the items is:
     * <pre>
     * "[CATEGORY] DESCRIPTION : PRICE"
     * </pre>
     * 
     * @param search search string
     * @return list of matching items
     */
    public List<String> findItem(String search){
    	Stream<Menu> m= menues.values().stream();
    	
    	if(search.length()>0) {
    		m.filter(x-> x.match(search));
    	}
    	
    	return
    	m.sorted(Comparator.comparing(Menu::getCategory).thenComparing(Menu::getDescription))
    			.map(Menu::toString).collect(Collectors.toList());
    	
       
    }
    
    
    
    
    /**
     * Creates a new order for the given customer.
     * Returns the unique id of the order, a progressive
     * integer number starting at 1.
     * 
     * @param customerId
     * @return order id
     */
    public int newOrder(int customerId){
    	
    	ordid++;
    	Customer c= customers.get(customerId);
    	Order o= new Order(c, ordid);
    	orders.put(ordid, o);
    	
        return ordid;
    }
    
    /**
     * Add a new item to the order with the given quantity.
     * 
     * If the same item is already present in the order is adds the
     * given quantity to the current quantity.
     * 
     * The method returns the final total quantity of the item in the order. 
     * 
     * The item is found through the search string as in {@link #findItem}.
     * If none or more than one item is matched, then an exception is thrown.
     * 
     * @param orderId the id of the order
     * @param search the item search string
     * @param qty the quantity of the item to be added
     * @return the final quantity of the item in the order
     * @throws DeliveryException in case of non unique match or invalid order ID
     */
    public int addItem(int orderId, String search, int qty) throws DeliveryException {
       
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	
    	Order o= orders.get(orderId);
    	List<Menu> menu= menues.values().stream().filter(x-> x.match(search))
    			.collect(Collectors.toList());
    	if(menu.size()>1)
    		throw new DeliveryException("Search string must match exactly one item");
    	
    	
    	return o.addItem(menu.get(0), qty);
    }
    
    /**
     * Show the items of the order using the following format
     * <pre>
     * "DESCRIPTION, QUANTITY"
     * </pre>
     * 
     * @param orderId the order ID
     * @return the list of items in the order
     * @throws DeliveryException when the order ID in invalid
     */
    public List<String> showOrder(int orderId) throws DeliveryException {
    	
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	
    	List<Order.Item> i= orders.get(orderId).getItems();
    	
    	
        return i.stream().map(Order.Item::toString).collect(Collectors.toList());
    }
    
    /**
     * Retrieves the total amount of the order.
     * 
     * @param orderId the order ID
     * @return the total amount of the order
     * @throws DeliveryException when the order ID in invalid
     */
    public double totalOrder(int orderId) throws DeliveryException {
        
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	
    	return orders.get(orderId).totPrice();
    }
    
    /**
     * Retrieves the status of an order
     * 
     * @param orderId the order ID
     * @return the current status of the order
     * @throws DeliveryException when the id is invalid
     */
    public OrderStatus getStatus(int orderId) throws DeliveryException {
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	
    	return orders.get(orderId).getStatus();
    	
        
    }
    
    /**
     * Confirm the order. The status goes from {@code NEW} to {@code CONFIRMED}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>start-up delay (conventionally 5 min)
     * <li>preparation time (max of all item preparation time)
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code NEW}
     */
    public int confirm(int orderId) throws DeliveryException {
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	Order o= orders.get(orderId);
    	if(o.status!=OrderStatus.NEW)
    		throw new DeliveryException("Order not existing");
    	
        return o.confirm();
    }

    /**
     * Start the order preparation. The status goes from {@code CONFIRMED} to {@code PREPARATION}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>preparation time (max of all item preparation time)
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code CONFIRMED}
     */
    public int start(int orderId) throws DeliveryException {
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	Order o= orders.get(orderId);
    	if(o.status!=OrderStatus.CONFIRMED)
    		throw new DeliveryException("Order not existing");
    	
        return o.preparation();
    }

    /**
     * Begins the order delivery. The status goes from {@code PREPARATION} to {@code ON_DELIVERY}
     * 
     * Returns the delivery time estimate computed as the sum of:
     * <ul>
     * <li>transportation time (conventionally 15 min)
     * </ul>
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code PREPARATION}
     */
    public int deliver(int orderId) throws DeliveryException {
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	Order o= orders.get(orderId);
    	if(o.status!=OrderStatus.PREPARATION)
    		throw new DeliveryException("Order not existing");
    	
        return o.ondelivery();
        
    }
    
    /**
     * Complete the delivery. The status goes from {@code ON_DELIVERY} to {@code DELIVERED}
     * 
     * 
     * @param orderId the order id
     * @return delivery time estimate in minutes
     * @throws DeliveryException when order ID invalid to status not {@code ON_DELIVERY}
     */
    public void complete(int orderId) throws DeliveryException {
    	if(!orders.containsKey(orderId))
    		throw new DeliveryException("Order not existing");
    	Order o= orders.get(orderId);
    	if(o.status!=OrderStatus.ON_DELIVERY)
    		throw new DeliveryException("Order not existing");
    }
    
    /**
     * Retrieves the total amount for all orders of a customer.
     * 
     * @param customerId the customer ID
     * @return total amount
     */
    public double totalCustomer(int customerId){
    	return
    	orders.values().stream().filter(x->x.getCustid().equals(customerId))
    			. filter(o->o.getStatus()!=OrderStatus.NEW)
    			.mapToDouble(Order::totPrice).sum();
    }
    
    /**
     * Computes the best customers by total amount of orders.
     *  
     * @return the classification
     */
    public SortedMap<Double,List<String>> bestCustomers(){
    	return
    	orders.values().stream() .sorted(Comparator.comparing(Order::totPrice))
		. filter(o->o.getStatus()!=OrderStatus.NEW)
		.collect(Collectors.groupingBy(o->o.getCustomer().toString(), Collectors.summingDouble(Order::totPrice)))
		
		.entrySet().stream().collect(Collectors.groupingBy(e->e.getValue(), 
				()->new TreeMap<Double, List<String>>(Comparator.reverseOrder()),
							Collectors.mapping(e-> e.getKey(), Collectors.toList())))
		;
    	
      
    }
    
// NOT REQUIRED
//
//    /**
//     * Computes the best items by total amount of orders.
//     *  
//     * @return the classification
//     */
//    public List<String> bestItems(){
//        return null;
//    }
//    
//    /**
//     * Computes the most popular items by total quantity ordered.
//     *  
//     * @return the classification
//     */
//    public List<String> popularItems(){
//        return null;
//    }

}
