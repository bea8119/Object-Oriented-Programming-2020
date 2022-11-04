package delivery;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import delivery.Delivery.OrderStatus;

public class Order {
	
	private Integer custid;
	private Customer customer;
	private Integer ordid;
	private List<Item> items= new LinkedList<Item>();
	
	public Delivery.OrderStatus status;
	
	
			protected class Item{
				protected Menu menu;
				protected int quantity=0;
				
				
				public Item(Menu menu, int quantity) {
					this.menu = menu;
					this.quantity = quantity;
				}

				public Menu getMenu() {
					return menu;
				}
				
				public int getQuantity() {
					return quantity;
				}
				public void addQ(int quantity) {
					this.quantity += quantity;
				}
				
				public String toString() {
					return menu.getDescription()+ ", " + quantity;
				}
				
				public double totPrice() {
					return menu.getPrice()*quantity;
				}
				
				public int getTime() {
					return menu.getTime();
				}
				
			}
	
	public Order(Customer customer, Integer ordid) {		
		this.customer=customer;
		this.custid=customer.getId();
		this.ordid = ordid;
		this.status = OrderStatus.NEW;
	}

	public Integer getCustid() {
		return custid;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	public Integer getOrdid() {
		return ordid;
	}

	public List<Item> getItems() {
		return items;
	}

	public int addItem(Menu menu, int quantity) {
		Item it;
		for(Item i: items) {
			if(i.getMenu().equals(menu)) {
				i.addQ(quantity);
				return i.getQuantity();
			}			
		}
		it= new Item(menu, quantity);
		items.add(it);
		
		return quantity;
	}
	
	public double totPrice() {
		Double price=0.0;
		for(Item i:items)
			price +=i.totPrice();
		
		return price;
	}

	public Delivery.OrderStatus getStatus() {
		return status;
	}

	public void setStatus(Delivery.OrderStatus status) {
		this.status = status;
	}
	
	public int confirm() {
		
		this.status = OrderStatus.CONFIRMED;

		return 5+this.maxTime()+15;
	}
	
	public int maxTime() {
		List<Item> orderedit=
				items.stream().sorted(Comparator.comparing(Item::getTime))
						.collect(Collectors.toList());
		
		return orderedit.get(0).getTime();
	}
	
	public int preparation() {
		this.status = OrderStatus.PREPARATION;
		
		return this.maxTime() +15;
		
	}
	
	public int ondelivery(){
		this.status = OrderStatus.ON_DELIVERY;
		return 15;
	}
	
	public void delivered() {
		this.status = OrderStatus.DELIVERED;
	}
	

}
