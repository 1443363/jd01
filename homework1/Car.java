package homework1;

import homework1.car.details.Engine;
import homework1.car.details.Wheels;

public abstract class Car{
    private int numberOfSeats;
    private String driverLicenseAcceptableCategory;
    private String lock;
    private Wheels wheels;
    private Engine engine;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDriverLicenseAcceptableCategory() {
        return driverLicenseAcceptableCategory;
    }

    public void setDriverLicenseAcceptableCategory(String driverLicenseAcceptableCategory) {
        this.driverLicenseAcceptableCategory = driverLicenseAcceptableCategory;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
