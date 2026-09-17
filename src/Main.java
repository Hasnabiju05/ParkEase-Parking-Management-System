
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Create Scanner for keyboard input
    private static final Scanner scanner = new Scanner(System.in);

    // Store all registered vehicles
    private static List<Vehicle> vehicles = new ArrayList<>();

    // Parking system objects
    private static final SlotManager slotManager
            = new SlotManager();

    private static final EntryExitService parkingService
            = new EntryExitService(slotManager);

    private static final AlertService alertService
            = new AlertService(parkingService);

    public static void main(String[] args) {

        try {

            // Load previously saved vehicles
            vehicles = FileHandler.loadVehicles();

            System.out.println(
                    "========================================"
            );
            System.out.println(
                    "       PARKEASE PARKING SYSTEM"
            );
            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "Registered vehicles loaded: "
                    + vehicles.size()
            );

            boolean running = true;

            while (running) {

                displayMenu();

                int choice = readInteger(
                        "Enter your choice: "
                );

                switch (choice) {

                    case 1 ->
                        registerVehicle();
                    case 2 ->
                        vehicleEntry();
                    case 3 ->
                        vehicleExit();
                    case 4 ->
                        slotManager.displaySlots();
                    case 5 ->
                        parkingService.showActiveVehicles();
                    case 6 ->
                        alertService.checkOverstayedVehicles();
                    case 7 ->
                        showVehicleLog();
                    case 8 -> {
                        FileHandler.saveVehicles(vehicles);
                        running = false;

                        System.out.println(
                                "Thank you for using ParkEase!"
                        );
                    }
                    default ->
                        System.out.println(
                                "Invalid choice. Please select 1-8."
                        );
                }
            }

        } catch (Exception e) {
            System.out.println(
                    "An error occurred: " + e.getMessage()
            );
        }
    }

    private static void displayMenu() {

        System.out.println(
                "\n========== MAIN MENU =========="
        );

        System.out.println(
                "1. Register Vehicle"
        );

        System.out.println(
                "2. Vehicle Entry"
        );

        System.out.println(
                "3. Vehicle Exit"
        );

        System.out.println(
                "4. View All Parking Slots"
        );

        System.out.println(
                "5. View Active Parkings"
        );

        System.out.println(
                "6. Check Overstayed Vehicles"
        );

        System.out.println(
                "7. View Registered Vehicles"
        );

        System.out.println(
                "8. Save and Exit"
        );

        System.out.println(
                "==============================="
        );
    }

    private static void registerVehicle() {

        System.out.println(
                "\n========== REGISTER VEHICLE =========="
        );

        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();

        if (owner.trim().isEmpty()) {

            System.out.println(
                    "Owner name cannot be empty."
            );

            return;
        }

        System.out.print(
                "Enter vehicle number: "
        );

        String number = scanner.nextLine()
                .trim()
                .toUpperCase();

        if (number.isEmpty()) {

            System.out.println(
                    "Vehicle number cannot be empty."
            );

            return;
        }

        // Check whether vehicle already exists
        if (findVehicle(number) != null) {

            System.out.println(
                    "This vehicle is already registered."
            );

            return;
        }

        System.out.println(
                "Select vehicle type:"
        );

        System.out.println(
                "1. Two-Wheeler"
        );

        System.out.println(
                "2. Four-Wheeler"
        );

        int typeChoice
                = readInteger("Enter type: ");

        String type;

        switch (typeChoice) {
            case 1 ->
                type = "2";
            case 2 ->
                type = "4";
            default -> {
                System.out.println(
                        "Invalid vehicle type."
                );
                return;
            }
        }

        Vehicle vehicle = new Vehicle(
                owner,
                number,
                type
        );

        vehicles.add(vehicle);

        System.out.println(
                "\nVehicle registered successfully!"
        );

        System.out.println(vehicle);
    }

    private static void vehicleEntry() {

        System.out.println(
                "\n========== VEHICLE ENTRY =========="
        );

        System.out.print(
                "Enter vehicle number: "
        );

        String number = scanner.nextLine()
                .trim()
                .toUpperCase();

        Vehicle vehicle = findVehicle(number);

        if (vehicle == null) {

            System.out.println(
                    "Vehicle is not registered."
            );

            return;
        }

        parkingService.vehicleEntry(vehicle);
    }

    private static void vehicleExit() {

        System.out.println(
                "\n========== VEHICLE EXIT =========="
        );

        System.out.print(
                "Enter vehicle number: "
        );

        String number = scanner.nextLine()
                .trim()
                .toUpperCase();

        parkingService.vehicleExit(number);
    }

    private static void showVehicleLog() {

        System.out.println(
                "\n========== REGISTERED VEHICLES =========="
        );

        if (vehicles.isEmpty()) {

            System.out.println(
                    "No vehicles registered."
            );

            return;
        }

        for (Vehicle vehicle : vehicles) {

            System.out.println(vehicle);
        }

        System.out.println(
                "=========================================="
        );
    }

    private static Vehicle findVehicle(
            String vehicleNumber) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleNumber()
                    .equalsIgnoreCase(vehicleNumber)) {

                return vehicle;
            }
        }

        return null;
    }

    private static int readInteger(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value = Integer.parseInt(
                        scanner.nextLine()
                );

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}
