package homework01;

public abstract class Car{
    private int numberOfSeats;
    private String driverLicenseAcceptableCategory;
    public String lock;

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
