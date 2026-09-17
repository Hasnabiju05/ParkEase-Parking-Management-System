
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_PATH
            = "../data/vehicles.txt";

    public static void saveVehicles(
            List<Vehicle> vehicles) {

        try {

            File file = new File(FILE_PATH);

            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (BufferedWriter writer
                    = new BufferedWriter(
                            new FileWriter(file)
                    )) {

                for (Vehicle vehicle : vehicles) {

                    writer.write(
                            vehicle.toFileString()
                    );

                    writer.newLine();
                }
            }

            System.out.println(
                    "Vehicle data saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Unable to save vehicle data."
            );
        }
    }

    public static List<Vehicle> loadVehicles() {

        List<Vehicle> vehicles
                = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return vehicles;
        }

        try (BufferedReader reader
                = new BufferedReader(
                        new FileReader(file)
                )) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts
                        = line.split("\\|");

                if (parts.length == 3) {

                    Vehicle vehicle
                            = new Vehicle(
                                    parts[0],
                                    parts[1],
                                    parts[2]
                            );

                    vehicles.add(vehicle);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Unable to load saved vehicle data."
            );
        }

        return vehicles;
    }
}
