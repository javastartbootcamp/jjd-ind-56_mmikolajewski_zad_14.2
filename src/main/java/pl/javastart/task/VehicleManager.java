package pl.javastart.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehicleManager {
    private static final int DISCARD_VEHICLE = 0;
    private static final int REPLACE_VEHICLE = 1;
    private static final int EXIT = 0;
    private static final int ADD_VEHICLE = 1;
    private static final int INSPECT_VEHICLE = 2;

    private static final String FILE_NAME = "vehicles.csv";

    private Queue<Vehicle> vehicles = FileOperations.readFile(FILE_NAME);
    private Scanner scanner = new Scanner(System.in);

    void mainLoop() {
        int option;
        do {
            printOption();
            option = readOption();
            evaluateOption(option);
        } while (option != EXIT);
    }

    private int readOption() {
        System.out.println("Wybierz opcję:");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void printOption() {
        System.out.println("Dostępne opcje:");
        System.out.println(" > Koniec programu:" + EXIT);
        System.out.println(" > Dodaj nowy pojazd:" + ADD_VEHICLE);
        System.out.println(" > Dokonaj przeglądu pojazdu z kolejki:" + INSPECT_VEHICLE);
    }

    private void evaluateOption(int option) {
        if (option == ADD_VEHICLE) {
            addNextVehicle();
        } else if (option == INSPECT_VEHICLE) {
            printAndRemoveVehicle();
        } else if (option == EXIT) {
            saveDataToFile();
        } else {
            System.out.println("Nieznana opcja");
        }
    }

    private void saveDataToFile() {
        FileOperations.writeToFile(FILE_NAME, vehicles);
        System.out.println("Dane zapisano to bazy");
    }

    private void printAndRemoveVehicle() {
        Vehicle vehicle = vehicles.poll();
        if (vehicle == null) {
            System.out.println("Lista jest pusta");
        } else {
            System.out.println("Pojazd poddany przeglądowi");
            System.out.println(vehicle);
        }
    }

    private void addNextVehicle() {
        Vehicle vehicle = createNewVehicle();
        if (vehicles.contains(vehicle)) {
            askAndReplaceVehicle(vehicle);
        } else {
            addVehicle(vehicle);
        }

    }

    private Vehicle createNewVehicle() {
        System.out.println("Podaj typ pojazdu ( motocykl, samochód, samochód ciężarowy)");
        String type = readString();
        System.out.println("Podaj markę pojazdu");
        String brand = readString();
        System.out.println("Podaj model pojazdu");
        String model = readString();
        System.out.println("Podaj rok produkcji");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj przebieg");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj numer VIN");
        String vin = scanner.nextLine();
        return new Vehicle(type, brand, model, year, mileage, vin);
    }

    private String readString() {
        String option = "";
        try {
            option = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Podałeś niepoprawny format");
            scanner.nextLine();
        }
        return option;

    }

    private void askAndReplaceVehicle(Vehicle vehicle) {
        System.out.println("Pojazd znajduje się w kolejce do przeglądu, wybierz co chcesz zrobić");
        System.out.println(" > Zignoruj element - " + DISCARD_VEHICLE);
        System.out.println(" > Nadpisz element - " + REPLACE_VEHICLE);
        int option = readOption();
        if (option == REPLACE_VEHICLE) {
            vehicles.remove(vehicle);
            vehicles.add(vehicle);
        } else {
            System.out.println("W bazie pozostawiono poprzedni element");
        }
    }

    private void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Dodano pojazd do kolejki");
    }
}
