package pl.javastart.task;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        VehicleManager vehicleManager = new VehicleManager();
        try {
            vehicleManager.mainLoop();
        } catch (InputMismatchException e) {
            System.out.println("podałeś nieprawidłwoy format");
        }

    }
}
