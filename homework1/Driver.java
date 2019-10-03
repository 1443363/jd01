package homework1;

import homework1.car.details.Engine;
import homework1.car.details.Wheels;

public class Driver implements IDriver {
    private int drivingExperience;
    private String driverLicense;
    private String key;

    public Driver(String driverLicense, int drivingExperience, String key) {
        this.driverLicense = driverLicense;
        this.drivingExperience = drivingExperience;
        this.key = key;
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    @Override
    public void openAndStart(Car car) {
        if (car.getLock().equals(this.key)) {
            System.out.println("Водитель открыл и завел машину.");
        } else {
            System.out.println("У водителя нет необходимого ключа. Дверь заблокирована.");
        }
    }

    @Override
    public void drive(Car car) {
        if (car.getDriverLicenseAcceptableCategory().equals(this.driverLicense)) {
            System.out.println("Водитель начал движение.");
        } else {
            System.out.println("У водителя нету необходимой квалификации для вождения данного автомобиля.");
            System.exit(0);
        }
    }

    @Override
    public void boarding(Car car) {
        System.out.println("Водитель принял " + car.getNumberOfSeats() + " попутчика.");
    }

    @Override
    public void gasUp(Car car) {
        System.out.println("Водитель заправил " + car.getEngine().getCapacity() + " литров " + car.getEngine().getFuelAcceptableQuality() +
                " бензина для " + car.getEngine().getName() + " мотора.");
        System.out.println("/*********************************************************************************************/");
    }

    @Override
    public void burnRubber(Car car) {
        System.out.println("Водитель начал ускоряться, сцепление с дорогой ему помогали держать его замечательные " + car.getWheels().getTyresType()
                + " марки " + car.getWheels().getName() + " и радиусом " + car.getWheels().getRadius() + " см.");
    }
}
