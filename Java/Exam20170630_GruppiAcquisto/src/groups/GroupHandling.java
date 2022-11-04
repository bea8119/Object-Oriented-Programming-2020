package groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import  java.util.Comparator;
import java.util.stream.*;


public class GroupHandling {
	
	
	public Map<String, List<Supplier>> products= new TreeMap<String, List<Supplier>>();
	public Map<String, Supplier> suppliers = new TreeMap<String, Supplier>();
	public Map<String, Group> groups = new TreeMap<String, Group>();
	public List<Bid> bids= new LinkedList<Bid>();
	
	
//R1	
	public void addProduct (String productTypeName, String... supplierNames) 
			throws GroupHandlingException {
		
		if(products.containsKey(productTypeName)) throw new GroupHandlingException("product already existing");
		
		List<Supplier> supp= new ArrayList<Supplier>();
		
		for(String s : supplierNames ) {
			Supplier supplier;
			
			if(!suppliers.containsKey(s)) {
				supplier= new	Supplier(s);
			supplier.addProduct(productTypeName);
			
				suppliers.put(s, supplier);
			}
				
			else {
				supplier=suppliers.get(s);
				supplier.addProduct(productTypeName);								
			}
			supp.add(supplier);
				
		}
		products.put(productTypeName, supp);
		
	}
	
	public List<String> getProductTypes (String supplierName) {
		return suppliers.get(supplierName).getProducts();
	}
	
//R2	
	public void addGroup (String name, String productName, String... customerNames) 
			throws GroupHandlingException {
		
		if(!products.containsKey(productName) || groups.containsKey(name)) 
				throw new GroupHandlingException("product not existing or group already existing");
				
		List<String> customer= new ArrayList<String>();
		Collections.addAll(customer, customerNames);
		
		Group group = new Group(name, productName, customer);	
		groups.put(name, group);
		
	}
	
	public List<String> getGroups (String customerName) {
		return  groups.values().stream().filter(x-> x.getCustomers().contains(customerName))
        		.map(Group::getName).collect(Collectors.toList());
	}

//R3
	public void setSuppliers (String groupName, String... supplierNames)
			throws GroupHandlingException {
		
		if(!groups.containsKey(groupName)) throw new GroupHandlingException( "group not existing");
		Group g=groups.get(groupName);
		String product= g.getProduct();
		List<Supplier> supptoadd= new ArrayList<Supplier>();
		
		for(String s:supplierNames) {
			if(!suppliers.containsKey(s)) throw new GroupHandlingException("supplier not existing");
			Supplier supp= suppliers.get(s);
			if(!(products.get(product)).contains(supp)) 
				throw new GroupHandlingException("supplier not eligible for product");
						
			supptoadd.add(supp);
		}
		
		for(Supplier s: supptoadd)
			g.addSupplier(s);
				
	}
	
	public void addBid (String groupName, String supplierName, int price)
			throws GroupHandlingException {
		
		if(!groups.containsKey(groupName) || !suppliers.containsKey(supplierName)) 			
			throw new GroupHandlingException("non existing group ot supplier");
		Group g= groups.get(groupName);
		Supplier s= suppliers.get(supplierName);
		
		if(!g.getSuppliers().contains(s))				
				throw new GroupHandlingException("supplier not in group");
		
		Bid b= new Bid(g, s, price);
		bids.add(b);
		
	}
	
	public String getBids (String groupName) {
	
		
        return 	bids.stream().filter(x-> x.getGroup().getName().equals(groupName))
				.sorted(Comparator.comparing(Bid::getPrice).thenComparing(x->x.getSupplier().getName()))					
				.map(x-> {
					return x.getSupplier().getName()+ " : "+ x.getPrice();
				}).collect(Collectors.joining(",  "));
	}
	
	
	public void vote (String groupName, String customerName, String supplierName)
			throws GroupHandlingException {
		
		if(!groups.containsKey(groupName) || !suppliers.containsKey(supplierName)) 			
			throw new GroupHandlingException("non existing group ot supplier");
		Group g= groups.get(groupName);
		Supplier s= suppliers.get(supplierName);
		
		if(!g.getSuppliers().contains(s))				
				throw new GroupHandlingException("supplier not in group");
		
		if(!g.getCustomers().contains(customerName))
			throw new GroupHandlingException("Customer not in group");
		
		for(Bid b: bids) {
			if(b.getGroup().getName().equals(groupName) && b.getSupplier().getName().equals(supplierName))
				b.addVote();
		}
				
	}
	
	public String  getVotes (String groupName) {
	
		
        return 	bids.stream().filter(x->x.getGroup().getName().equals(groupName) && x.getnVotes()!=0)
				.sorted(Comparator.comparing(b->b.getSupplier().getName()))
				.map(b->{
					return b.getSupplier().getName()+" : "+b.getnVotes();
				}).collect(Collectors.joining(" , "));
	}
	
	public String getWinningBid (String groupName) {
		
		// **************GET THE MAXIMUM OF STH WITH A STREAM **********************
		
	 Bid b=bids.stream().filter( x->x.getGroup().getName().equals(groupName))
					.max(Comparator.comparing(Bid::getnVotes).thenComparing(Bid::getPrice, Collections.reverseOrder()))
					.orElse(null);
				
		if(b==null) return null;
		
        return b.getSupplier().getName()+" : "+ b.getnVotes();
	}
	
//R5
	public SortedMap<String, Integer> maxPricePerProductType() { //serve toMap

        return 	bids.stream().sorted(Comparator.comparing(Bid::getProduct))
        		.collect(Collectors.toMap(Bid::getProduct,(Bid::getPrice),
        				(p1, p2)-> { return p1>p2 ? p1:p2; }, TreeMap::new));
	}
	
	public SortedMap<Integer, List<String>> suppliersPerNumberOfBids() {
		
				
        return bids.stream().sorted(Comparator.comparing(Bid::getSupplierName).thenComparing(Bid::getnVotes))
				.filter(x->x.getnVotes()!=0)
				.collect(Collectors.groupingBy(Bid::getnVotes,
						() -> new TreeMap<Integer, List<String>>(Comparator.reverseOrder()),
						Collectors.mapping(Bid::getSupplierName, Collectors.toList()) ));
	}
	
	public SortedMap<String, Long> numberOfCustomersPerProductType() {
		
		return groups.values().stream().sorted(Comparator.comparing(Group::getProduct))
						.collect(Collectors.groupingBy(Group::getProduct, 
								TreeMap::new, Collectors.summingLong(Group::getNcustomers)));
		
        
	}
	
}
