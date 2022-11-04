package delivery;

public class Menu {
	private String description;
	private double price;
	private String category;
	private int time;
	
	public Menu(String description, double price, String category, int time) {
		
		this.description = description;
		this.price = price;
		this.category = category;
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public int getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "[ "+ category +" ] "+ description +" : "+String.format("%.2f", price);
	}
	
	public boolean match(String search) {
		
		return description.toLowerCase().contains(search.toLowerCase());
	}

}
