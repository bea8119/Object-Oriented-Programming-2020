package diet;

import java.util.LinkedList;

/**
 * Represent a take-away system user
 *  
 */
public class User implements Comparable<User>{
		
	/**
	 * get user's last name
	 * @return last name
	 */
	
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	
	
	private LinkedList<Order> orderHistory;
	
	public User(String Firstname, String Lastname, String Email, String Phone) {
		this.FirstName = Firstname;
		this.LastName = Lastname;
		this.Email = Email;		
		this.Phone= Phone;
		this.orderHistory = new LinkedList<Order>();
		
	}
	
	
	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	

	public String getPhone() {
		return Phone;
	}

	/**
	 * change user's email
	 * @param email new email
	 */
	
	
	/**
	 * change user's phone number
	 * @param phone new phone number
	 */
	public void setPhone(String phone) {
		Phone= phone;
	}

	public void addOrder(Order order) {
		orderHistory.add(order);
	}
	
	public int numOrders(Restaurant r) {
		int sum=0;
		
		for(Order o: orderHistory) {
			if(o.getRestaurant() == r)
				sum++;
		}
		
		return sum;
	}
	
	
	@Override
	public String toString() {
		return this.FirstName + " " + this.LastName;
	}

	@Override
	public int compareTo(User o) {
		int last = this.LastName.compareTo(o.getLastName());
		
		if(last==0)
			return this.FirstName.compareTo(o.getFirstName());
		
		return last;
	}
	
}
