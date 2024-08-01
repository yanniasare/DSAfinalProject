public class TrafficLight {

    private String direction;
    private String color;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

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

    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setDuration (redDuration) {
        this.redDuration = redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration (yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration (greenDuration) {
        this.greenDuration = greenDuration;
    }

    public void changeLight(String newColor) {
        setColor(newColor);
        System.out.println(direction + " traffic light color has changed to " + newColor)
    }

}