package warehouse;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class Warehouse {
	
	public Map<String, Product> products = new TreeMap<String, Product>();
	public Map<String, Supplier> suppliers = new TreeMap<String, Supplier>();
	public Map<String, Order> orders = new TreeMap<String, Order>();
	public int n=0;
	
	public Product newProduct(String code, String description){
		Product p= new Product(code, description);
		
		products.put(code, p);
		return p;
	}
	
	public Collection<Product> products(){
		
		return products.values();
	}

	public Product findProduct(String code){
		
		return products.get(code);
	}

	public Supplier newSupplier(String code, String name){
		Supplier s= new Supplier(code, name);
		
		suppliers.put(code, s);
		return s;
	}
	
	public Supplier findSupplier(String code){
		
		return suppliers.get(code);
	}

	public Order issueOrder(Product prod, int quantity, Supplier supp)
		throws InvalidSupplier {
		
		if(!supp.supplies().contains(prod)) throw new InvalidSupplier();
		n++;
		String code="ORD"+n;
		Order o= new Order(code, quantity,  prod, supp);
		
		orders.put(code, o);
		
		return o;
	}

	public Order findOrder(String code){
		// TODO: completare
		return orders.get(code);
	}
	
	public List<Order> pendingOrders(){
		
		return orders.values().stream().filter(x->( !x.delivered()))
				.collect(Collectors.toList());
	}

	public Map<String,List<Order>> ordersByProduct(){
		return orders.values().stream().collect(Collectors.groupingBy(x -> x.getProduct().getCode(), 
				TreeMap::new, Collectors.toList()));
		
		
		
	}
	
	public Map<String,Long> orderNBySupplier(){
		return orders.values().stream().filter(x->( x.delivered()))
		.collect(Collectors.groupingBy(x-> x.getSupplier().getNome()
				, TreeMap::new, Collectors.counting()))
		;
	    
	}
	
	public List<String> countDeliveredByProduct(){
		
	return orders.values().stream().filter(x->( x.delivered()))
		.collect(Collectors.groupingBy(x-> x.getProduct().getCode()
				, Collectors.counting())).entrySet()
		.stream().sorted(Comparator.comparing((Map.Entry<String, Long> e)->e.getValue())
				.reversed()).map(e->e.getKey()+" - "+ e.getValue())
		.collect(Collectors.toList());
	  
	}
}
