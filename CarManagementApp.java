import java.util.Scanner;
public class CarManagementApp{
	public static void main(String[] args) {
        Car[] myInventory = new Car[10];
        Scanner input = new Scanner(System.in);
        int count = 0;

        do {
            int c = menu(input);

            if (c == 1) { 
                if (count < myInventory.length) {
                    myInventory[count] = addCar(input);
                    count++;
                } else {
                    System.out.println("Inventory is full.");
                }
                continue;
            }

            if (c == 2) { 
                System.out.println("Enter the car ID:");
                int carEditID = input.nextInt();

                for (int i = 0; i < myInventory.length; i++) {
                    if (myInventory[i] != null && myInventory[i].getCarId() == carEditID) {
                        editCar(i, myInventory, input);
                        break;
                    }
                }
            }

            if (c == 3) {
            	System.out.println("Enter car ID: ");
            	int carEditID=input.nextInt();
            	for (int i=0; i<myInventory.length; i++) {
            		if (myInventory[i] != null && myInventory[i].getCarId()==carEditID) {
                		setToFixed(i, myInventory, input);
                		break;
                	}
            	}
            	
            }
            
            if (c==4) {
            	for (int i=0; i<myInventory.length; i++) {
            		if (myInventory[i]!=null) {
            			printme(myInventory[i]);
            		}
            		else {
            			break;
            		}
            	}
            
            }
            
            if (c==5) {
            	System.out.println("Enter car ID: ");
            	int carEditID=input.nextInt();
            	for (int i=0; i<myInventory.length; i++) {
            		if (myInventory[i] != null && myInventory[i].getCarId()==carEditID) {
            			myInventory=deleteCar(i, myInventory, input);
            			break;
            		}
            	}
            }
            if (c==6) {
            	System.out.println("Enter a price: ");
            	double minPrice =input.nextDouble();
            	Car[] pricesearch=searchPrice(minPrice, myInventory, input);
            	for (int i=0; i<pricesearch.length; i++){
            		if (pricesearch.length==0) {
            			System.out.println("No such car exists");
            		}
            		else {
            			System.out.println("Cars with service fees greater than or equal to $" + minPrice + ":");
            			printme(pricesearch[i]);
            	}
            	
            }
            }
            if (c==7) {
            	System.out.println("Enter car ID: ");
            	int carEditID=input.nextInt();
            	for (int i=0; i<myInventory.length; i++) {
            		if (myInventory[i] != null && myInventory[i].getCarId()==carEditID) {
                		setToNotFixed(i, myInventory, input);
                		break;
                	}
            	}
            }
            if (c==8) {
            	System.out.println("Expected profit from fixing all cars is: "+totalProfit(myInventory, input));
            }
            
            if(c==9) {
            	System.out.println("Exiting");
            	break;
            }

        } while (true);
        
    }

    public static int menu(Scanner input) {
        System.out.println("1. Add, 2. Edit, 3. Set a car status to 'fixed', 4. Print all cars in inventory, 5. Delete a Car by ID, 6.Display all cars with service costs exeeding a specified price, 7. Set a specific car to 'unfixed', 8. Display expected profit from fixing all cars, 9. Exit");
        System.out.print("Choose an option: ");
        return input.nextInt();
    }

    public static Car addCar(Scanner input) {
    	
        System.out.print("Enter car name: ");
        input.nextLine(); 
        String newName = input.nextLine();
        System.out.print("Enter car ID: ");
        int newID = input.nextInt();
        System.out.print("Enter car repair status (true if fixed, false if not fixed): ");
        boolean newCarStatus = input.nextBoolean();
        System.out.print("Enter service fee: ");
        double newServiceFees = input.nextDouble();
        return new Car(newName, newID, newCarStatus, newServiceFees);
    }

    public static void editCar(int editingIndex, Car[] myInventory, Scanner input) {
        System.out.println("What would you like to edit? 1. Car Name 2. Car ID 3. Repair Status 4. Service Fee");
        int action = input.nextInt();
        input.nextLine(); 

        if (action == 1) {
            System.out.print("Enter a new car name: ");
            String newName = input.nextLine();
            myInventory[editingIndex].setCarName(newName);
        } else if (action == 2) {
            System.out.print("Enter new ID: ");
            int newID = input.nextInt();
            myInventory[editingIndex].setCarId(newID);
        } else if (action == 3) {
            System.out.print("Enter repair status (true if fixed, false if not fixed): ");
            boolean newStatus = input.nextBoolean();
            myInventory[editingIndex].setStatus(newStatus);
        } else if (action == 4) {
            System.out.print("Enter service fee: ");
            double newFee = input.nextDouble();
            myInventory[editingIndex].setServiceFee(newFee);
        }
    }
    public static void setToFixed(int editingIndex, Car[]myInventory, Scanner input) {
    	myInventory[editingIndex].setStatus(true);
    }
    
    public static void printme(Car j) {
    	String carName=j.getCarName();
    	String status="";
    	int carId=j.getCarId();
    	if (j.isStatus()) {
    			status="Fixed";	
    		}
    		else {
    			status="Not Fixed";
    		}
    		
    	
    	double serviceFee=j.getServiceFee();
    			
		System.out.println("Car name: "+ carName + ", Id: "+carId+", status: "+status+", service Fee: "+serviceFee);
	}
    public static Car[] deleteCar(int editingIndex, Car[] carList, Scanner input) {
    	carList[editingIndex].setCarName("x");
    	carList[editingIndex].setCarId(-1);
    	carList[editingIndex].setStatus(false);
    	carList[editingIndex].setServiceFee(0);
    	Car[]myInventory=new Car[10];
    	for (int i=0; i<carList.length-1; i++) {
    		if (i<editingIndex) {
    			myInventory[i]=carList[i];
    		}
    		else {
    			myInventory[i]=carList[i+1];
    		}
    		
    	}
    	return myInventory;
    }
    public static Car[] searchPrice(double price, Car[] carList, Scanner input) {
    	Car[] priceList = new Car[carList.length];
        int count = 0; 
        for (int i = 0; i < carList.length; i++) {
            Car car = carList[i]; 
            if (car != null && car.getServiceFee() >= price) {
                priceList[count] = car; 
                count++;
            }
        
        }
        Car[] result = new Car[count];
        for (int i = 0; i < count; i++) {
            result[i] = priceList[i];
        }

        return result;
    }

    
	public static void setToNotFixed(int editingIndex, Car[]myInventory, Scanner input) {
		myInventory[editingIndex].setStatus(false);
	}
    public static double totalProfit(Car[]carList, Scanner input) {
    	double profit=0;
    	for (int i=0; i<carList.length; i++) {
    		if (carList[i]!=null) {
    			profit+=carList[i].getServiceFee();
    		}
    	}
    	
    	return profit;
    }
}



