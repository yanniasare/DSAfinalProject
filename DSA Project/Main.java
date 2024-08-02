import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntersectionManager intersectionManager = new IntersectionManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        double speedMultiplier = 1.0;

        // Display welcome message
        System.out.println("Welcome to the Traffic Simulation System");
        System.out.println("Enter a command:");

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Enter direction (north, south, east, west):");
                    String direction = scanner.next();
                    System.out.println("Enter color (green, yellow, red):");
                    String color = scanner.next();
                    intersectionManager.trafficLightManager.setLight(direction, color);
                    break;

                case 2:
                    System.out.println("Enter color (green, yellow, red):");
                    String lightColor = scanner.next();
                    System.out.println("Enter duration in seconds:");
                    int duration = scanner.nextInt();
                    intersectionManager.trafficLightManager.setDuration(lightColor, duration);
                    break;

                case 3:
                    System.out.println("Enter direction (north, south, east, west):");
                    String vehicleDirection = scanner.next();
                    System.out.println("Enter vehicle type (car, truck, bus):");
                    String vehicleType = scanner.next();
                    System.out.println("Is it an emergency vehicle? (yes/no):");
                    String isEmergency = scanner.next();
                    boolean emergency = isEmergency.equalsIgnoreCase("yes");
                    intersectionManager.vehicleQueueManager.addVehicle(vehicleDirection, new Vehicle(vehicleType, emergency));
                    break;

                case 4:
                    System.out.println("Enter direction (north, south, east, west):");
                    String removeDirection = scanner.next();
                    intersectionManager.vehicleQueueManager.removeVehicle(removeDirection);
                    break;

                case 5:
                    System.out.println("Enter the number of iterations for the simulation:");
                    int numIterations = scanner.nextInt();
                    intersectionManager.startSimulation(numIterations);
                    break;

                case 6:
                    intersectionManager.stopSimulation();
                    break;

                case 7:
                    System.out.println("Enter simulation speed multiplier (e.g., 1.0 for real-time, 2.0 for double speed):");
                    speedMultiplier = scanner.nextDouble();
                    intersectionManager.setSimulationSpeed(speedMultiplier);
                    break;

                case 8:
                    System.out.println("Enter direction (north, south, east, west):");
                    String viewDirection = scanner.next();
                    intersectionManager.vehicleQueueManager.viewQueue(viewDirection);
                    break;

                case 9:
                    exit = true;
                    break;

                default:
                    System.out.println("Unknown choice. Please select a valid option.");
                    break;
            }

            // Prompt user to enter another command after completing an action
            if (!exit) {
                System.out.println("\nEnter a command:");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nTraffic Simulation Menu:");
        System.out.println("1. Set Traffic Light Color");
        System.out.println("2. Set Light Timing Duration");
        System.out.println("3. Add Vehicle to Queue");
        System.out.println("4. Remove Vehicle from Queue");
        System.out.println("5. Start Simulation");
        System.out.println("6. Stop Simulation");
        System.out.println("7. Set Simulation Speed");
        System.out.println("8. View Vehicle Queue");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return choice;
    }
}
