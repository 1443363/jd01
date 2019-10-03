package homework1.car.types;

import homework1.Car;
import homework1.car.details.Engine;
import homework1.car.details.Wheels;

public class Opel extends Car {
    private int numberOfSeats;
    private String driverLicenseAcceptableCategory;
    private String lock;
    private Wheels wheels;
    private Engine engine;

    public Opel(int numberOfSeats, String driverLicenseAcceptableCategory,
                   String lock) {
        this.numberOfSeats = numberOfSeats;
        this.driverLicenseAcceptableCategory = driverLicenseAcceptableCategory;
        this.lock = lock;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String getDriverLicenseAcceptableCategory() {
        return driverLicenseAcceptableCategory;
    }

    @Override
    public void setDriverLicenseAcceptableCategory(String driverLicenseAcceptableCategory) {
        this.driverLicenseAcceptableCategory = driverLicenseAcceptableCategory;
    }

    @Override
    public String getLock() {
        return lock;
    }

    @Override
    public void setLock(String lock) {
        this.lock = lock;
    }

    @Override
    public Wheels getWheels() {
        return wheels;
    }

    @Override
    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
