import java.util.Queue;

public class IntersectionManager {
    private VehicleQueueManager vehicleQueueManager;
    private TrafficLightManager trafficLightManager;
    private static final String[] DIRECTIONS = {"north", "south", "east", "west"};
    private boolean simulationRunning;
    private String currentGreenDirection;
    private long lastUpdateTime;
    private int currentLightDuration;
    private double speedMultiplier = 1.0;

    public IntersectionManager() {
        vehicleQueueManager = new VehicleQueueManager();
        trafficLightManager = new TrafficLightManager();
        currentGreenDirection = "north"; // Initial green direction
        simulationRunning = false;
        lastUpdateTime = System.currentTimeMillis();
        currentLightDuration = trafficLightManager.getGreenDuration();
    }

    public VehicleQueueManager getVehicleQueueManager() {
        return vehicleQueueManager;
    }

    public TrafficLightManager getTrafficLightManager() {
        return trafficLightManager;
    }

    public void setSimulationSpeed(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public void startSimulation(int numIterations) {
        simulationRunning = true;
        System.out.println("Simulation started.");
        int iteration = 0;

        while (simulationRunning && iteration < numIterations) {
            updateTraffic();
            checkEmergencyVehicles();
            iteration++;

            // Adding a delay to simulate real-time passage
            try {
                Thread.sleep((long) (1000 / speedMultiplier)); // Adjust sleep duration based on speed
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted.");
                Thread.currentThread().interrupt();
            }
        }

        stopSimulation();
    }

    public void stopSimulation() {
        simulationRunning = false;
        System.out.println("Simulation stopped.");
    }

    private void updateTraffic() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastUpdateTime) / 1000 >= currentLightDuration / speedMultiplier) {
            lastUpdateTime = currentTime;

            if (trafficLightManager.getColor(currentGreenDirection).equals("green")) {
                // Change to yellow if the light is currently green
                trafficLightManager.setLight(currentGreenDirection, "yellow");
                currentLightDuration = trafficLightManager.getYellowDuration();
            } else if (trafficLightManager.getColor(currentGreenDirection).equals("yellow")) {
                // Change to red if the light is currently yellow
                trafficLightManager.setLight(currentGreenDirection, "red");
                currentLightDuration = trafficLightManager.getRedDuration();

                // Remove vehicle from current green direction
                Vehicle removedVehicle = vehicleQueueManager.removeVehicle(currentGreenDirection);
                if (removedVehicle != null) {
                    System.out.println(removedVehicle + " passed through " + currentGreenDirection);
                }

                // Determine the next green direction, prioritizing emergency vehicles
                boolean emergencyFound = false;
                for (String direction : DIRECTIONS) {
                    Queue<Vehicle> queue = vehicleQueueManager.viewQueue(direction);
                    if (queue != null && !queue.isEmpty() && queue.peek().isEmergency()) {
                        currentGreenDirection = direction;
                        emergencyFound = true;
                        break;
                    }
                }

                // If no emergency vehicle found, switch to the next direction in the order
                if (!emergencyFound) {
                    int currentIndex = (java.util.Arrays.asList(DIRECTIONS).indexOf(currentGreenDirection) + 1) % DIRECTIONS.length;
                    currentGreenDirection = DIRECTIONS[currentIndex];
                }

                // Set the new green light
                trafficLightManager.setLight(currentGreenDirection, "green");
                currentLightDuration = trafficLightManager.getGreenDuration();
                System.out.println("Green light now for " + currentGreenDirection);
            }
        }
    }

    private void checkEmergencyVehicles() {
        for (String direction : DIRECTIONS) {
            Queue<Vehicle> queue = vehicleQueueManager.viewQueue(direction);
            if (queue != null) {
                for (Vehicle vehicle : queue) {
                    if (vehicle.isEmergency()) {
                        System.out.println("Emergency vehicle in " + direction);
                        return; // Exit after finding an emergency vehicle
                    }
                }
            }
        }
    }
}
