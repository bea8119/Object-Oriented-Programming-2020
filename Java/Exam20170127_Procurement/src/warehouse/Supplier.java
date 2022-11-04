package warehouse;

import java.util.LinkedList;
import java.util.List;

public class Supplier {
	
	private String code;
	private String name;
	private List<Product> products= new LinkedList<Product>();
	
	

	public Supplier(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCodice(){
		
		return code;
	}

	public String getNome(){
		
		return name;
	}
	
	public void newSupply(Product product){
		products.add(product);
		
	}
	
	public List<Product> supplies(){
		
		return products;
	}
}
