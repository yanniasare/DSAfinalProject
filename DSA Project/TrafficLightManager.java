public class TrafficLightManager {
    private Map <String, TrafficLight> trafficLights;

    public TrafficLightManager() {
        trafficLights = new HashMap<>();

        trafficLights.put("north", new TrafficLights("north", 30, 5, 30));
        trafficLights.put("south", new TrafficLights("south", 30, 5, 30));
        trafficLights.put("east", new TrafficLights("east", 30, 5, 30));
        trafficLights.put("west", new TrafficLights("west", 30, 5, 30));
    }

    public void setLight (String direction, String color) {
        if(trafficLights.containsKey(direction)){
            trafficLights.get(direction).changeLight(color);
        }
        else{
            System.out.println("Invalid direction: " + direction);
        }
    }

    public void setLightTiming (String color, int duration) {
        for (TrafficLight light : trafficLights.values()) {
            switch (color) {
                case "red":
                    light.setGreenDuration(duration);
                    break;
                case "yellow":
                    light.setGreenDuration(duration);
                    break;
                case "green":
                    light.setGreenDuration(duration);
                    break;
                default:
                    System.out.println("Invalid color: " + color);    
            } 
        }
    }

    public void printTrafficLights() {
        for (TrafficLight light : trafficLights.values()){
            System.out.println(light.getDirection() + "light is " + light,getColor());
        }
    }


}