package warehouse;

import java.util.LinkedList;
import java.util.List;

public class Product {
	private String code;
	private String description;
	private int quantity;
	
	List<Supplier> suppliers= new LinkedList<Supplier>();
	List<Order> orders = new LinkedList<Order>();
	
	
	
	
	public Product(String code, String description) {
		
		this.code = code;
		this.description = description;
	}

	public String getCode(){
		
		return code;
	}

	public String getDescription(){
		
		return description;
	}
	
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}

	public void decreaseQuantity(){
		this.quantity--;
	}

	public int getQuantity(){
	
		return quantity;
	}

	public List<Supplier> suppliers(){
		
		return suppliers;
	}

	public List<Order> pendingOrders(){
		
		return orders;
	}
}
