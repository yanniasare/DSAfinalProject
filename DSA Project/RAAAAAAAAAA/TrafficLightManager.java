import java.util.HashMap;
import java.util.Map;

public class TrafficLightManager {
    private Map<String, TrafficLight> trafficLights;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    public TrafficLightManager() {
        redDuration = 30;  // Default red light duration in seconds
        yellowDuration = 5;  // Default yellow light duration in seconds
        greenDuration = 30;  // Default green light duration in seconds

        trafficLights = new HashMap<>();
        trafficLights.put("north", new TrafficLight("north", redDuration, yellowDuration, greenDuration));
        trafficLights.put("south", new TrafficLight("south", redDuration, yellowDuration, greenDuration));
        trafficLights.put("east", new TrafficLight("east", redDuration, yellowDuration, greenDuration));
        trafficLights.put("west", new TrafficLight("west", redDuration, yellowDuration, greenDuration));
    }

    public void setLight(String direction, String color) {
        direction = direction.toLowerCase();
        if (trafficLights.containsKey(direction) && isValidColor(color)) {
            TrafficLight light = trafficLights.get(direction);
            light.setColor(color);
            System.out.println("Set " + direction + " light to " + color);
        } else {
            System.out.println("Invalid direction or color: " + direction + ", " + color);
        }
    }

    public String getColor(String direction) {
        direction = direction.toLowerCase();
        if (trafficLights.containsKey(direction)) {
            return trafficLights.get(direction).getColor();
        }
        System.out.println("Invalid direction: " + direction);
        return null;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setDuration(String color, int duration) {
        if (duration <= 0) {
            System.out.println("Duration must be positive.");
            return;
        }

        if (isValidColor(color)) {
            switch (color.toLowerCase()) {
                case "red":
                    redDuration = duration;
                    break;
                case "yellow":
                    yellowDuration = duration;
                    break;
                case "green":
                    greenDuration = duration;
                    break;
            }

            for (TrafficLight light : trafficLights.values()) {
                light.setDuration(color, duration);
            }
            System.out.println("Set all lights " + color + " duration to " + duration + " seconds");
        } else {
            System.out.println("Invalid color: " + color);
        }
    }

    private boolean isValidColor(String color) {
        return color.equalsIgnoreCase("red") ||
               color.equalsIgnoreCase("yellow") ||
               color.equalsIgnoreCase("green");
    }

    
}
