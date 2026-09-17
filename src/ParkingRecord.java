
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingRecord {

    private final Vehicle vehicle;
    private final String slotNumber;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public ParkingRecord(Vehicle vehicle, String slotNumber) {
        this.vehicle = vehicle;
        this.slotNumber = slotNumber;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void completeParking() {
        exitTime = LocalDateTime.now();
    }

    public long getDurationMinutes() {
        LocalDateTime endTime
                = (exitTime == null) ? LocalDateTime.now() : exitTime;

        return Duration.between(entryTime, endTime).toMinutes();
    }

    public long getDurationHours() {
        return (long) Math.ceil(getDurationMinutes() / 60.0);
    }

    public double calculateFine() {

        long hours = getDurationHours();

        if (hours <= 8) {
            return 0;
        }

        return (hours - 8) * 50.0;
    }

    public boolean isOverstayed() {
        return getDurationHours() > 8;
    }

    public String getEntryTimeFormatted() {
        return entryTime.format(FORMATTER);
    }

    public String getExitTimeFormatted() {

        if (exitTime == null) {
            return "Still Parked";
        }

        return exitTime.format(FORMATTER);
    }

    @Override
    public String toString() {
        return vehicle.getVehicleNumber()
                + " | Slot: " + slotNumber
                + " | Entry: " + getEntryTimeFormatted()
                + " | Exit: " + getExitTimeFormatted();
    }
}
