package homework1;

public abstract class Driver implements IDriver {
    private int drivingExperience;
    private String driverLicense;
    private boolean isRequiredKey;



    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        if (driverLicense != null) {
            this.driverLicense = driverLicense;
        } else {
            this.driverLicense = null;
        }
    }

    public boolean getRequiredKey() {
        return isRequiredKey;
    }

    public void setRequiredKey(Car car, String key) {
        if (car.getLock().equals(key)) {
            this.isRequiredKey = true;
        } else {
            this.isRequiredKey = false;
        }
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }
}
