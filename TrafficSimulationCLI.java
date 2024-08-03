import java.util.Scanner;

public class TrafficSimulationCLI {
    private TrafficSimulation simulation;

    public TrafficSimulationCLI() {
        this.simulation = new TrafficSimulation();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. set_light");
            System.out.println("2. set_light_timing");
            System.out.println("3. add_vehicle");
            System.out.println("4. remove_vehicle");
            System.out.println("5. start_simulation");
            System.out.println("6. stop_simulation");
            System.out.println("7. set_simulation_speed");
            System.out.println("8. view_queue");
            System.out.println("9. exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter direction (north, south, east, west): ");
                    String direction = scanner.nextLine();
                    System.out.print("Enter light color (green, yellow, red): ");
                    String color = scanner.nextLine();
                    simulation.getIntersection().setLight(direction, color);
                    break;
                case 2:
                    // Implement set_light_timing logic
                    break;
                case 3:
                    System.out.print("Enter direction (north, south, east, west): ");
                    direction = scanner.nextLine();
                    System.out.print("Enter vehicle type (car, truck, bus): ");
                    String type = scanner.nextLine();
                    simulation.getIntersection().addVehicle(direction, new Vehicle(type));
                    break;
                case 4:
                    System.out.print("Enter direction (north, south, east, west): ");
                    direction = scanner.nextLine();
                    simulation.getIntersection().removeVehicle(direction);
                    break;
                case 5:
                    simulation.start();
                    break;
                case 6:
                    simulation.stop();
                    break;
                case 7:
                    System.out.print("Enter simulation speed (1 for real-time, higher for faster): ");
                    int speed = scanner.nextInt();
                    simulation.setSpeed(speed);
                    break;
                case 8:
                    System.out.print("Enter direction (north, south, east, west): ");
                    direction = scanner.nextLine();
                    simulation.getIntersection().viewQueue(direction);
                    break;
                case 9:
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TrafficSimulationCLI cli = new TrafficSimulationCLI();
        cli.start();
    }
}
