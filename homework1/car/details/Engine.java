package homework1.car.details;

public class Engine{
    private int capacity;
    private String fuelAcceptableQuality;
    private String name;

    public Engine(String name, int capacity, String fuelAcceptableQuality) {
        this.name = name;
        this.capacity = capacity;
        this.fuelAcceptableQuality = fuelAcceptableQuality;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuelAcceptableQuality() {
        return fuelAcceptableQuality;
    }

    public void setFuelAcceptableQuality(String fuelAcceptableQuality) {
        this.fuelAcceptableQuality = fuelAcceptableQuality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
