import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VehicleQueueManager {
    private Map<String, Queue<Vehicle>> vehicleQueues;

    // Constructor to initialize queues for each direction
    public VehicleQueueManager() {
        vehicleQueues = new HashMap<>();
        vehicleQueues.put("north", new LinkedList<>());
        vehicleQueues.put("south", new LinkedList<>());
        vehicleQueues.put("east", new LinkedList<>());
        vehicleQueues.put("west", new LinkedList<>());
    }

    // Method to add a vehicle to the queue of a specific direction
    public void addVehicle(String direction, Vehicle vehicle) {
        if (vehicleQueues.containsKey(direction.toLowerCase())) {
            vehicleQueues.get(direction.toLowerCase()).offer(vehicle);
            System.out.println(vehicle + " added to " + direction + " queue.");
        } else {
            System.out.println("Invalid direction: " + direction);
        }
    }

    // Method to remove a vehicle from the queue of a specific direction, prioritizing emergency vehicles
    public Vehicle removeVehicle(String direction) {
        direction = direction.toLowerCase();
        if (vehicleQueues.containsKey(direction) && !vehicleQueues.get(direction).isEmpty()) {
            Queue<Vehicle> queue = vehicleQueues.get(direction);

            // Prioritize emergency vehicles
            for (Vehicle vehicle : queue) {
                if (vehicle.isEmergency()) {
                    queue.remove(vehicle);
                    System.out.println(vehicle + " removed from " + direction + " queue (emergency).");
                    return vehicle;
                }
            }

            // Remove regular vehicle if no emergency vehicle is present
            Vehicle vehicle = queue.poll();
            System.out.println(vehicle + " removed from " + direction + " queue.");
            return vehicle;
        } else {
            System.out.println("No vehicles in " + direction + " queue or invalid direction.");
            return null;
        }
    }

    // Method to view the current queue of a specific direction
    public Queue<Vehicle> viewQueue(String direction) {
        direction = direction.toLowerCase();
        if (vehicleQueues.containsKey(direction)) {
            Queue<Vehicle> queue = vehicleQueues.get(direction);
            System.out.println(direction + " queue: " + queue);
            return queue;
        } else {
            System.out.println("Invalid direction: " + direction);
            return null;
        }
    }
}
