package homework05;

public enum Country implements ICountryInformation {
    BELARUS(280_000, 9_500_000),
    FRANCE(500_000, 15_000_000),
    USA(5_000, 50_000_000),
    RUSSIA(6_000, 70_000_000),
    UKRAINE(500_000, 13_000_000),
    ITALY(400_000, 10_000_000),
    SPAIN(350_000,7_000_000),
    NORWEY(400_000,17_000_000),
    ARMENIA(400_000, 5_000_000),
    GEORGIA(350_000, 8_000_000);

    private int area;
    private int population;



    Country(int area, int population) {
        this.area = area;
        this.population = population;
    }

    @Override
    public int getCountryArea() {
        return area;
    }

    @Override
    public int getCountryPopulation() {
        return population;
    }
}
