public class TrafficSimulation {
    private Intersection intersection;
    private boolean running;
    private int speed; // 1 for real-time, higher numbers for faster simulation

    public TrafficSimulation() {
        this.intersection = new Intersection();
        this.running = false;
        this.speed = 1;
    }

    public void start() {
        if (!canStart()) {
            return; // Do not start the simulation if validation fails
        }

        running = true;
        new Thread(this::runSimulation).start(); // Run simulation in a new thread
    }

    public void stop() {
        running = false;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void runSimulation() {
        while (running) {
            try {
                // Example cycle: green for north/south, then east/west
                // Adjust these durations as needed
                simulateTrafficLightCycle("north", "south", 30);
                simulateTrafficLightCycle("east", "west", 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void simulateTrafficLightCycle(String dir1, String dir2, int duration) throws InterruptedException {
        // Set lights to green for dir1 and dir2, red for others
        intersection.setLight(dir1, "green");
        intersection.setLight(dir2, "green");

        // Set lights to red for other directions
        if (!dir1.equals("north") && !dir2.equals("north")) intersection.setLight("north", "red");
        if (!dir1.equals("south") && !dir2.equals("south")) intersection.setLight("south", "red");
        if (!dir1.equals("east") && !dir2.equals("east")) intersection.setLight("east", "red");
        if (!dir1.equals("west") && !dir2.equals("west")) intersection.setLight("west", "red");

        // Simulate vehicle movement and wait for the duration
        moveVehiclesThroughIntersection(dir1, dir2);
        Thread.sleep(duration * 1000 / speed); // Sleep adjusted by simulation speed

        // Set yellow lights before turning red
        intersection.setLight(dir1, "yellow");
        intersection.setLight(dir2, "yellow");
        Thread.sleep(5 * 1000 / speed); // 5 seconds for yellow light

        // Finally, set lights to red
        intersection.setLight(dir1, "red");
        intersection.setLight(dir2, "red");
    }

    private void moveVehiclesThroughIntersection(String dir1, String dir2) {
        // Example logic: Remove vehicles from the queues for the green directions
        intersection.removeVehicle(dir1);
        intersection.removeVehicle(dir2);
    }

    private boolean canStart() {
        if (!intersection.areLightsSet()) {
            System.out.println("Error: Not all traffic lights have been set.");
            return false;
        }

        if (!intersection.areTimingsSet()) {
            System.out.println("Error: Light timings are not set.");
            return false;
        }

        if (!intersection.areVehiclesPresent()) {
            System.out.println("Error: No vehicles are present in the queues.");
            return false;
        }

        return true;
    }

    public Intersection getIntersection() {
        return intersection;
    }
}
