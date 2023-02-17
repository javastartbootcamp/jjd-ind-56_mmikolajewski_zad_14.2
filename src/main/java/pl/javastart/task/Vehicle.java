package pl.javastart.task;

import java.util.Objects;

public class Vehicle {
    private String type;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String vin;

    public Vehicle(String type, String brand, String model, int year, int mileage, String vin) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && mileage == vehicle.mileage && Objects.equals(type, vehicle.type) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, brand, model, year, mileage, vin);
    }

    @Override
    public String toString() {
        return type + " " + brand + " " + model + ", rok produkcji " + year +
                ", stan licznika " + mileage + ", numer VIN " + vin;
    }

    public String toFile() {
        return type + ";" + brand + ";" + model + ";" + year + ";" + mileage + ";" + vin;
    }
}
