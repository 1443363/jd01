package homework1;

public abstract class Car{
    private int numberOfSeats;
    private String driverLicenseAcceptableCategory;
    private String lock;

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
}
