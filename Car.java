
public class Car {
	private String carName;
	private int carId;
	private boolean status;
	private double serviceFee;
	public Car() {
		carName="x";
		carId=-1;
		status=false;
		serviceFee=0;
	}
	public Car(String name, int id, boolean s, double sF) {
		this.carName=name;
		this.carId=id;
		this.status=s;
		this.serviceFee=sF;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public void printme() {
		System.out.println("Car name: "+ carName + ", Id: "+carId+", status: "+status+", service Fee: "+serviceFee);
	}
	
	
}
