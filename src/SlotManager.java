
import java.util.ArrayList;
import java.util.List;

public class SlotManager {

    private final List<ParkingSlot> slots;

    public SlotManager() {

        slots = new ArrayList<>();

        // Two-wheeler slots
        for (int i = 1; i <= 20; i++) {
            slots.add(
                    new ParkingSlot(
                            String.format("T%03d", i),
                            "TWO-WHEELER"
                    )
            );
        }

        // Four-wheeler slots
        for (int i = 1; i <= 10; i++) {
            slots.add(
                    new ParkingSlot(
                            String.format("F%03d", i),
                            "FOUR-WHEELER"
                    )
            );
        }
    }

    public ParkingSlot findAvailableSlot(String vehicleType) {

        String requiredType;

        if (vehicleType.equalsIgnoreCase("2")) {
            requiredType = "TWO-WHEELER";
        } else {
            requiredType = "FOUR-WHEELER";
        }

        for (ParkingSlot slot : slots) {

            if (!slot.isOccupied()
                    && slot.getSlotType().equals(requiredType)) {

                return slot;
            }
        }

        return null;
    }

    public void occupySlot(ParkingSlot slot, String vehicleNumber) {

        if (slot != null) {
            slot.occupy(vehicleNumber);
        }
    }

    public void releaseSlot(String slotNumber) {

        for (ParkingSlot slot : slots) {

            if (slot.getSlotNumber().equalsIgnoreCase(slotNumber)) {
                slot.release();
                return;
            }
        }
    }

    public void displaySlots() {

        System.out.println("\n========== PARKING SLOTS ==========");

        for (ParkingSlot slot : slots) {
            System.out.println(slot);
        }

        System.out.println("===================================");
    }

    public int getAvailableCount(String type) {

        int count = 0;

        for (ParkingSlot slot : slots) {

            if (!slot.isOccupied()
                    && slot.getSlotType().equalsIgnoreCase(type)) {

                count++;
            }
        }

        return count;
    }
}
