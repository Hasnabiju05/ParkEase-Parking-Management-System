
import java.util.HashMap;
import java.util.Map;

public class EntryExitService {

    private final SlotManager slotManager;

    private final Map<String, ParkingRecord> activeParkings;

    public EntryExitService(SlotManager slotManager) {
        this.slotManager = slotManager;
        this.activeParkings = new HashMap<>();
    }

    public boolean vehicleEntry(Vehicle vehicle) {

        String number = vehicle.getVehicleNumber();

        if (activeParkings.containsKey(number)) {
            System.out.println(
                    "Vehicle is already inside the parking area."
            );
            return false;
        }

        ParkingSlot availableSlot
                = slotManager.findAvailableSlot(vehicle.getVehicleType());

        if (availableSlot == null) {

            System.out.println(
                    "No parking slot is currently available."
            );

            return false;
        }

        slotManager.occupySlot(
                availableSlot,
                vehicle.getVehicleNumber()
        );

        ParkingRecord record
                = new ParkingRecord(
                        vehicle,
                        availableSlot.getSlotNumber()
                );

        activeParkings.put(number, record);

        System.out.println("\nVehicle entry successful.");
        System.out.println(
                "Assigned Slot: "
                + availableSlot.getSlotNumber()
        );
        System.out.println(
                "Entry Time: "
                + record.getEntryTimeFormatted()
        );

        return true;
    }

    public ParkingRecord vehicleExit(String vehicleNumber) {

        vehicleNumber = vehicleNumber.toUpperCase();

        ParkingRecord record
                = activeParkings.get(vehicleNumber);

        if (record == null) {

            System.out.println(
                    "No active parking found for this vehicle."
            );

            return null;
        }

        record.completeParking();

        slotManager.releaseSlot(
                record.getSlotNumber()
        );

        activeParkings.remove(vehicleNumber);

        System.out.println("\n========== EXIT DETAILS ==========");
        System.out.println(
                "Vehicle: "
                + vehicleNumber
        );
        System.out.println(
                "Slot: "
                + record.getSlotNumber()
        );
        System.out.println(
                "Entry: "
                + record.getEntryTimeFormatted()
        );
        System.out.println(
                "Exit: "
                + record.getExitTimeFormatted()
        );
        System.out.println(
                "Duration: "
                + record.getDurationHours()
                + " hour(s)"
        );
        System.out.println(
                "Fine: Rs. "
                + record.calculateFine()
        );
        System.out.println("=================================");

        return record;
    }

    public void showActiveVehicles() {

        System.out.println(
                "\n========== ACTIVE PARKINGS =========="
        );

        if (activeParkings.isEmpty()) {

            System.out.println(
                    "No vehicles are currently parked."
            );

        } else {

            for (ParkingRecord record
                    : activeParkings.values()) {

                System.out.println(record);
            }
        }

        System.out.println(
                "====================================="
        );
    }

    public Map<String, ParkingRecord> getActiveParkings() {
        return activeParkings;
    }
}
