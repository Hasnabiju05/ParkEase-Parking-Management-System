
import java.util.Map;

public class AlertService {

    private final EntryExitService entryExitService;

    public AlertService(EntryExitService entryExitService) {
        this.entryExitService = entryExitService;
    }

    public void checkOverstayedVehicles() {

        Map<String, ParkingRecord> active
                = entryExitService.getActiveParkings();

        System.out.println(
                "\n========== OVERSTAY CHECK =========="
        );

        boolean found = false;

        for (ParkingRecord record : active.values()) {

            if (record.isOverstayed()) {

                found = true;

                System.out.println(
                        "Vehicle: "
                        + record.getVehicle()
                                .getVehicleNumber()
                );

                System.out.println(
                        "Slot: "
                        + record.getSlotNumber()
                );

                System.out.println(
                        "Duration: "
                        + record.getDurationHours()
                        + " hour(s)"
                );

                System.out.println(
                        "Current Fine: Rs. "
                        + record.calculateFine()
                );

                System.out.println("-----------------------------------");
            }
        }

        if (!found) {
            System.out.println(
                    "No vehicles have exceeded 8 hours."
            );
        }

        System.out.println(
                "==================================="
        );
    }
}
