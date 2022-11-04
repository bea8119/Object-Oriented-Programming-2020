package warehouse;

public class Order {
	
	private String code;
	private boolean delivered;
	private Product product;
	private Supplier supplier;
	private int quantity;
	
	

	

	public Order(String code,int quantity, Product product, Supplier supplier) {
		
		this.code = code;
		this.product = product;
		this.supplier = supplier;
		this.quantity=quantity;
		this.delivered=false;
	}

	public String getCode(){
		
		return code;
	}
		public int getQuantity(){
				
				return quantity;
			}
	
	public boolean delivered(){
		// TODO: Completare!
		return delivered;
	}

	public void setDelivered() throws MultipleDelivery {
		
		this.delivered= true;
	}
	
	public String toString(){
		return "Order "+this.code+" for "+this.getQuantity()
		+ " of "+ product.getCode()+ " : "+product.getDescription()
		+" from "+supplier.getNome();
	
	}

	public Product getProduct() {
		return product;
	}

	public Supplier getSupplier() {
		return supplier;
	}
	
	
	
}
