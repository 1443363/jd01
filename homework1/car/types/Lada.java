package homework1.car.types;

import homework1.Car;

public class Lada extends Car {
    private int numberOfSeats;
    private String driverLicenseAcceptableCategory;
    private String lock;

    public Lada(int numberOfSeats, String driverLicenseAcceptableCategory,
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
}
