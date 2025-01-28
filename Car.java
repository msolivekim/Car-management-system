public class Car {
	private String name;
	private String make;
	private double price;
	
	public Car() {
		this.name="";
		this.make="";
		this.price=-1;
	}
	
	public Car(String name, String make, double price) {
		this.name=name;
		this.make=make;
		this.price=price;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

