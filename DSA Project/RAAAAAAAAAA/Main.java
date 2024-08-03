import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntersectionManager intersectionManager = new IntersectionManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        double speedMultiplier = 1.0;

        // Display welcome message
        System.out.println("Welcome to the Traffic Simulation System");

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    setTrafficLightColor(scanner, intersectionManager);
                    break;

                case 2:
                    setLightTimingDuration(scanner, intersectionManager);
                    break;

                case 3:
                    addVehicleToQueue(scanner, intersectionManager);
                    break;

                case 4:
                    removeVehicleFromQueue(scanner, intersectionManager);
                    break;

                case 5:
                    startSimulation(scanner, intersectionManager);
                    break;

                case 6:
                    intersectionManager.stopSimulation();
                    break;

                case 7:
                    setSimulationSpeed(scanner, intersectionManager);
                    break;

                case 8:
                    viewVehicleQueue(scanner, intersectionManager);
                    break;

                case 9:
                    exit = true;
                    System.out.println("Exiting the Traffic Simulation System. Goodbye!");
                    break;

                default:
                    System.out.println("Unknown choice. Please select a valid option.");
                    break;
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

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void setTrafficLightColor(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter direction (north, south, east, west):");
        String direction = scanner.next();
        System.out.println("Enter color (green, yellow, red):");
        String color = scanner.next();
        intersectionManager.getTrafficLightManager().setLight(direction, color);
    }

    private static void setLightTimingDuration(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter color (green, yellow, red):");
        String lightColor = scanner.next();
        System.out.println("Enter duration in seconds:");
        int duration = getIntInput(scanner);
        intersectionManager.getTrafficLightManager().setDuration(lightColor, duration);
    }

    private static void addVehicleToQueue(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter direction (north, south, east, west):");
        String vehicleDirection = scanner.next();
        System.out.println("Enter vehicle type (car, truck, bus):");
        String vehicleType = scanner.next();
        System.out.println("Is it an emergency vehicle? (yes/no):");
        String isEmergency = scanner.next();
        boolean emergency = isEmergency.equalsIgnoreCase("yes");
        intersectionManager.getVehicleQueueManager().addVehicle(vehicleDirection, new Vehicle(vehicleType, emergency));
    }

    private static void removeVehicleFromQueue(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter direction (north, south, east, west):");
        String removeDirection = scanner.next();
        intersectionManager.getVehicleQueueManager().removeVehicle(removeDirection);
    }

    private static void startSimulation(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter the number of iterations for the simulation:");
        int numIterations = getIntInput(scanner);
        intersectionManager.startSimulation(numIterations);
    }

    private static void setSimulationSpeed(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter simulation speed multiplier (e.g., 1.0 for real-time, 2.0 for double speed):");
        double speedMultiplier = getDoubleInput(scanner);
        intersectionManager.setSimulationSpeed(speedMultiplier);
    }

    private static void viewVehicleQueue(Scanner scanner, IntersectionManager intersectionManager) {
        System.out.println("Enter direction (north, south, east, west):");
        String viewDirection = scanner.next();
        intersectionManager.getVehicleQueueManager().viewQueue(viewDirection);
    }
}
