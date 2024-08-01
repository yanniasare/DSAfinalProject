import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class VehicleQueueManagement {
    private Queue<String> northQueue = new LinkedList<>();
    private Queue<String> southQueue = new LinkedList<>();
    private Queue<String> eastQueue = new LinkedList<>();
    private Queue<String> westQueue = new LinkedList<>();

    public void addVehicle(String direction, String vehicleType) {
        switch (direction.toLowerCase()) {
            case "north":
                northQueue.add(vehicleType);
                break;
            case "south":
                southQueue.add(vehicleType);
                break;
            case "east":
                eastQueue.add(vehicleType);
                break;
            case "west":
                westQueue.add(vehicleType);
                break;
            default:
                System.out.println("Invalid direction!");
                break;
        }
        System.out.println(vehicleType + " added to " + direction + " queue.");
    }

    public void removeVehicle(String direction) {
        String vehicleType = null;
        switch (direction.toLowerCase()) {
            case "north":
                vehicleType = northQueue.poll();
                break;
            case "south":
                vehicleType = southQueue.poll();
                break;
            case "east":
                vehicleType = eastQueue.poll();
                break;
            case "west":
                vehicleType = westQueue.poll();
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }
        if (vehicleType != null) {
            System.out.println(vehicleType + " removed from " + direction + " queue.");
        } else {
            System.out.println("No vehicles in " + direction + " queue.");
        }
    }

    public static void main(String[] args) {
        VehicleQueueManagement vqm = new VehicleQueueManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: (1) Add vehicle (2) Remove vehicle (3) Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter direction (north, south, east, west):");
                    String direction = scanner.nextLine();
                    System.out.println("Enter vehicle type:");
                    String vehicleType = scanner.nextLine();
                    vqm.addVehicle(direction, vehicleType);
                    break;
                case 2:
                    System.out.println("Enter direction (north, south, east, west):");
                    direction = scanner.nextLine();
                    vqm.removeVehicle(direction);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose 1, 2, or 3.");
                    break;
            }
        }
    }
}