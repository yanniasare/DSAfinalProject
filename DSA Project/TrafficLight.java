public class TrafficLight {
    private String direction;
    private String color;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    // Constructor and other methods

    public TrafficLight (String direction, int redDuration, int yellowDuration, int greenDuration){
        this.direction = direction;
        this.color = "red"; // Default traffic light state
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
    }
    
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setColor(String color) {
        this.color = color;
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

    public void setDuration(String color, int duration) {
        switch (color.toLowerCase()) {
            case "red":
                this.redDuration = duration;
                break;
            case "yellow":
                this.yellowDuration = duration;
                break;
            case "green":
                this.greenDuration = duration;
                break;
        }
    }

    public void changeLight(String newColor) {
        setColor(newColor);
        System.out.println(direction + " traffic light color has changed to " + newColor);
    }
}
