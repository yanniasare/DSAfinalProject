import java.util.LinkedList;
import java.util.Queue;

public class VehicleQueue {
    private Queue<Vehicle> queue;
    private String direction;

    public VehicleQueue(String direction) {
        this.queue = new LinkedList<>();
        this.direction = direction;
    }

    public void addVehicle(Vehicle vehicle) {
        queue.add(vehicle);
        System.out.println(vehicle.getType() + " added to " + direction + " queue.");
    }

    public Vehicle removeVehicle() {
        return queue.poll(); // Removes and returns the front vehicle
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void viewQueue() {
        System.out.println("Queue for " + direction + ":");
        for (Vehicle vehicle : queue) {
            System.out.println(vehicle.getType());
        }
    }
}
