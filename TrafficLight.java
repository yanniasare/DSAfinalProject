public class TrafficLight {
    private String color;
    private int greenDuration;
    private int yellowDuration;
    private int redDuration;
    private boolean colorSet;

    public TrafficLight(int greenDuration, int yellowDuration, int redDuration) {
        this.color = null; // Initial state is null until set
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        this.redDuration = redDuration;
        this.colorSet = false;
    }

    public void setColor(String color) {
        this.color = color;
        this.colorSet = true;
    }

    public String getColor() {
        return color;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public boolean isColorSet() {
        return colorSet;
    }

    public boolean isTimingSet() {
        return greenDuration > 0 && yellowDuration > 0 && redDuration > 0;
    }
}
