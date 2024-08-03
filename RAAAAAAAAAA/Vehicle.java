public class Vehicle {
    private String vehicleType;
    private boolean isEmergency;

    // Constructor to initialize the vehicle
    public Vehicle(String vehicleType, boolean isEmergency) {
        setVehicleType(vehicleType);
        this.isEmergency = isEmergency;
    }

    // Getter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }

    // Setter for vehicle type with validation
    public void setVehicleType(String vehicleType) {
        if (isValidVehicleType(vehicleType)) {
            this.vehicleType = vehicleType;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
        }
    }

    // Getter for emergency status
    public boolean isEmergency() {
        return isEmergency;
    }

    // Check if the vehicle type is valid
    private boolean isValidVehicleType(String vehicleType) {
        return vehicleType.equalsIgnoreCase("car") ||
               vehicleType.equalsIgnoreCase("truck") ||
               vehicleType.equalsIgnoreCase("bus");
    }

    @Override
    public String toString() {
        return (isEmergency ? "Emergency " : "") + vehicleType;
    }
}
