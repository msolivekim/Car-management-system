import java.util.ArrayList;
import java.util.Scanner;

public class CarInventory {
    private ArrayList<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    public void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car name: ");
        String name = scanner.nextLine();
        System.out.print("Enter car make: ");
        String make = scanner.nextLine();
        System.out.print("Enter car price: ");
        double price = scanner.nextInt();
        cars.add(new Car(name, make, price));
        System.out.println("Car added successfully.");
        scanner.close();
    }

    public void deleteCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car name to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getName().equals(name)) {
                cars.remove(i);
                System.out.println("Car deleted successfully.");
                scanner.close();
                return;
            }
        }
        System.out.println("Car not found.");
        scanner.close();
    }

    public void printAllCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void editCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car name to edit: ");
        String name = scanner.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getName().equals(name)) {
                System.out.print("Enter new name: ");
                car.setName(scanner.nextLine());
                System.out.print("Enter new make: ");
                car.setMake(scanner.nextLine());
                System.out.print("Enter new price: ");
                car.setPrice(scanner.nextDouble()); 
                System.out.println("Car edited successfully.");
                scanner.close();
                return;
                
            }
            
        }
        System.out.println("Car not found.");
        scanner.close();
    }
    public static void main(String[] args) {
        CarInventory inventory = new CarInventory();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Car");
            System.out.println("2. Delete Car");
            System.out.println("3. Print All Cars");
            System.out.println("4. Edit Car");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    inventory.addCar();
                    break;
                case 2:
                    inventory.deleteCar();
                    break;
                case 3:
                    inventory.printAllCars();
                    break;
                case 4:
                    inventory.editCar();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        input.close();
    }
    
}