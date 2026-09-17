
public class Vehicle {

    private final String ownerName;
    private final String vehicleNumber;
    private final String vehicleType;

    public Vehicle(String ownerName, String vehicleNumber, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleNumber = vehicleNumber.toUpperCase();
        this.vehicleType = vehicleType.toUpperCase();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String toFileString() {
        return ownerName + "|" + vehicleNumber + "|" + vehicleType;
    }

    @Override
    public String toString() {
        return "Owner: " + ownerName
                + " | Vehicle No: " + vehicleNumber
                + " | Type: " + vehicleType;
    }
}
