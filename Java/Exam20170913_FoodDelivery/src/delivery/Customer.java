package delivery;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private String mail;
	
	public Customer(int id, String name, String address, String phone, String mail) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}

	@Override
	public String toString() {
		return  name + ", " + address + ", " + phone + ", " + mail;
	}
	
	
	

}
