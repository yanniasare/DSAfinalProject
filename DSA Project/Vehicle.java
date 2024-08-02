public class Vehicle {
    private String vehicleType;
    private boolean isEmergency;

    // Constructor to initialize the vehicle
    public Vehicle(String vehicleType, boolean isEmergency) {
        this.vehicleType = vehicleType;
        this.isEmergency = isEmergency;
    }

    // Getter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }

    // Getter for emergency status
    public boolean isEmergency() {
        return isEmergency;
    }

    @Override
    public String toString() {
        return (isEmergency ? "Emergency " : "") + vehicleType;
    }
}
