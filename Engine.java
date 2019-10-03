package homework01;

public abstract class Engine {
    private int capacity;
    private String fuelAcceptableQuality;
    private String name;

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
