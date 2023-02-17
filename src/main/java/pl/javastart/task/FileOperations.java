package pl.javastart.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileOperations {

    static void writeToFile(String fileName, Queue<Vehicle> list)  {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
            for (Vehicle vehicle : list) {
                writer.write(vehicle.toFile());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("błąd zapisu pliku");
        }
    }

    static LinkedList<Vehicle> readFile(String fileName) {
        LinkedList<Vehicle> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(fileName);
        try {
            scanner = new Scanner(fileName);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                Vehicle vehicle = new Vehicle(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5]);
                linkedList.add(vehicle);
            }
        } finally {
            scanner.close();
        }
        return linkedList;
    }
}
