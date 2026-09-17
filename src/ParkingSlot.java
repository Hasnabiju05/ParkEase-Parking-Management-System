
public class ParkingSlot {

    private final String slotNumber;
    private final String slotType;
    private boolean occupied;
    private String vehicleNumber;

    public ParkingSlot(String slotNumber, String slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.occupied = false;
        this.vehicleNumber = "";
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void occupy(String vehicleNumber) {
        this.occupied = true;
        this.vehicleNumber = vehicleNumber;
    }

    public void release() {
        this.occupied = false;
        this.vehicleNumber = "";
    }

    @Override
    public String toString() {
        if (occupied) {
            return slotNumber + " | " + slotType
                    + " | OCCUPIED | " + vehicleNumber;
        }

        return slotNumber + " | " + slotType + " | FREE";
    }
}
