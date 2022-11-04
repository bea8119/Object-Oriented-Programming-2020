package groups;

import java.util.ArrayList;
import java.util.List;

public class Group {
	
	private String name;
	private String product;
	private List<String> customers= new ArrayList<String>();
	private List<Supplier> suppliers= new ArrayList<Supplier>();
	
	public Group(String name, String product, List<String> customers) {		
		this.name = name;
		this.product = product;
		this.customers = customers;
	}

	public String getName() {
		return name;
	}

	public String getProduct() {
		return product;
	}

	public List<String> getCustomers() {
		return customers;
	}
	
	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void addSupplier(Supplier supplier) {
		
		this.suppliers.add(supplier);
	}
	
	public int getNcustomers() {
		return customers.size();
	}

}
