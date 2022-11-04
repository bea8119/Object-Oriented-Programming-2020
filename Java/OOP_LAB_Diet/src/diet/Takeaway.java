package diet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Represents the main class in the
 * take-away system.
 * 
 * It allows adding restaurant, users, and creating orders.
 *
 */
public class Takeaway  {

	/**
	 * Adds a new restaurant to the take-away system
	 * 
	 * @param r the restaurant to be added
	 */
	private Map<String, Restaurant> restaurants=new HashMap<String, Restaurant>();
	private Collection<User> users=new ArrayList<User>();
	
	
	public void addRestaurant(Restaurant r) {
		
		restaurants.put(r.getName(), r);
		
	}
	
	/**
	 * Returns the collections of restaurants
	 * 
	 * @return collection of added restaurants
	 */
	public Collection<String> restaurants() {
		
		
		return new LinkedList<>(restaurants.keySet());
	}
	
	/**
	 * Define a new user
	 * 
	 * @param firstName first name of the user
	 * @param lastName  last name of the user
	 * @param email     email
	 * @param phoneNumber telephone number
	 * @return
	 */
	public User registerUser(String firstName, String lastName, String email, String phoneNumber) {
		User user=new User(firstName, lastName, email, phoneNumber );
		
		users.add(user);
		
		return user;
	}
	
	/**
	 * Gets the collection of registered users
	 * 
	 * @return the collection of users
	 */
	public Collection<User> users(){ 
		ArrayList<User> u = new ArrayList<User>(users);
		Collections.sort( (List<User>) u);
		return u;
	}
	
	/**
	 * Create a new order by a user to a given restaurant.
	 * 
	 * The order is initially empty and is characterized
	 * by a desired delivery time. 
	 * 
	 * @param user				user object
	 * @param restaurantName	restaurant name
	 * @param h					delivery time hour
	 * @param m					delivery time minutes
	 * @return
	 */
	public Order createOrder(User user, String restaurantName, int h, int m) {
		Restaurant r= restaurants.get(restaurantName);
		String hour = new String();
		hour= h+":"+m;
		Order order;
		 if(this.openedRestaurants(hour).contains(r)) {
			  order= new Order(user, r, h, m);
			  
			 
		 }
		 else {
			 int index=findindextime( r.getHours(), hour.split(":"));
			 String[] times=r.getHours()[index].split(":");
			 h=Integer.parseInt(times[0]);
			 m=Integer.parseInt(times[1]);
			 
			 order= new Order(user, r, h, m);
			 
			 	
			 
	     	 }	
		 r.addOrder(order);
		 
		 return order;
		 
		
	}
	
	

	/**
	 * Retrieves the collection of restaurant that are open
	 * at the given time.
	 * 
	 * @param time time to check open
	 * 
	 * @return collection of restaurants
	 */
	public Collection<Restaurant> openedRestaurants(String time){
		List<Restaurant> openRest= new ArrayList<Restaurant>();
		String[] hm= time.split(":");
			for(Restaurant r: restaurants.values()) {
				if(open(r.getHours(), hm) == 0) {
					//System.out.println("Got in");
					openRest.add(r);
				}
			//	System.out.println("\n\n");
			}
			
			Collections.sort( openRest);
		return openRest;
	}
	
	public int open(String[] hours, String[] hm) {
		
		
		String[] curropentime;
		String[] currclosetime;
		
		
		for(int i=0; i< hours.length; i= i+2 ) {
			 curropentime= hours[i].split(":");							
			 currclosetime= hours[i+1].split(":");
						
			
			if((comparing(curropentime, hm)== true || curropentime.equals(hm) ) && comparing(hm, currclosetime)== true) {
				return 0;
			}
			
			
										
		}
		
		
				
		return -1;
	}
	
	public boolean comparing(String[] first, String[] second) {
		boolean value=false;
		
		if(Integer.parseInt(first[0])< Integer.parseInt(second[0]) ) {
			value=true;
			
		} else if(Integer.parseInt(first[0])> Integer.parseInt(second[0])) {
			value= false;
			
		} else if(Integer.parseInt(first[0])== Integer.parseInt(second[0])) {
			
				if(Integer.parseInt(first[1])< Integer.parseInt(second[1]) ) {
					
					value= true;
					
				}else if(Integer.parseInt(first[1])> Integer.parseInt(second[1])) {
					value= false;
					
				}
			
		}
		
		
		return value;
	}
	
	public int findindextime(String[] hours, String[] hm) {
		int value=0;
		String[] prev= {"23", "59"};
		String[] curropentime;
		String[] smallest= {"23", "59"};
		String[] biggest= {"00", "00"};
		int smallindex=0;
		int bigindex=0;
		
		
		for(int i=0; i< hours.length; i= i+2 ) {
			 curropentime= hours[i].split(":");							
			 
			 
			 if(comparing(curropentime, hm)== false && comparing(curropentime, prev)== true) {
				 prev[0]=curropentime[0];
				 prev[1]=curropentime[1];
				// System.out.println(hours[i]+" "+ prev[0]+":"+prev[1] );
				 value = i;
			 }
			 if(comparing(curropentime, smallest)== true) {
				 smallest[0]=curropentime[0];
				 smallest[1]=curropentime[1]; 
				 smallindex=i;
			 }
			 if(comparing(curropentime, biggest)== false) {
				 biggest[0]=curropentime[0];
				 biggest[1]=curropentime[1]; 
				 bigindex=i;
			 }
			 
			 
		}
		
		String[] closetime=hours[bigindex].split(":");
		if(comparing(closetime, hm)== true) {
			value=smallindex;
			//System.out.println("Aiuto" );
		}
		
		//System.out.println("Fammi vedere va "+ value );
		return value;
	}
}
