public class TrafficLight {
    private String direction;
    private String color;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    // Constructor
    public TrafficLight(String direction, int redDuration, int yellowDuration, int greenDuration) {
        this.direction = direction;
        this.color = "red"; // Default traffic light state
        setRedDuration(redDuration);
        setYellowDuration(yellowDuration);
        setGreenDuration(greenDuration);
    }
    
    // Getters
    public String getDirection() {
        return direction;
    }

    public String getColor() {
        return color;
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

    // Setters
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setColor(String color) {
        if (isValidColor(color)) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Invalid color: " + color);
        }
    }

    public void setRedDuration(int redDuration) {
        if (redDuration > 0) {
            this.redDuration = redDuration;
        } else {
            throw new IllegalArgumentException("Duration must be positive.");
        }
    }

    public void setYellowDuration(int yellowDuration) {
        if (yellowDuration > 0) {
            this.yellowDuration = yellowDuration;
        } else {
            throw new IllegalArgumentException("Duration must be positive.");
        }
    }

    public void setGreenDuration(int greenDuration) {
        if (greenDuration > 0) {
            this.greenDuration = greenDuration;
        } else {
            throw new IllegalArgumentException("Duration must be positive.");
        }
    }

    public void setDuration(String color, int duration) {
        if (duration > 0) {
            switch (color.toLowerCase()) {
                case "red":
                    setRedDuration(duration);
                    break;
                case "yellow":
                    setYellowDuration(duration);
                    break;
                case "green":
                    setGreenDuration(duration);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid color: " + color);
            }
        } else {
            throw new IllegalArgumentException("Duration must be positive.");
        }
    }

    public void changeLight(String newColor) {
        setColor(newColor);
        System.out.println(direction + " traffic light color has changed to " + newColor);
    }

    // Check if the color is valid
    private boolean isValidColor(String color) {
        return color.equalsIgnoreCase("red") || 
               color.equalsIgnoreCase("yellow") || 
               color.equalsIgnoreCase("green");
    }

    // Cycle to the next light color based on the current color
    public void cycleLight() {
        switch (color.toLowerCase()) {
            case "red":
                changeLight("green");
                break;
            case "green":
                changeLight("yellow");
                break;
            case "yellow":
                changeLight("red");
                break;
            default:
                throw new IllegalStateException("Invalid traffic light state: " + color);
        }
    }
}
