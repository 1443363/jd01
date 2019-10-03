package homework01;

public abstract class Wheels {
    private int radius;
    private boolean isSnowTyres;
    private boolean isSummerTyres;
    private boolean isAllSeasonTyres;
    private String name;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isSnowTyres() {
        return isSnowTyres;
    }

    public void setSnowTyres(boolean snowTyres) {
        isSnowTyres = snowTyres;
    }

    public boolean isSummerTyres() {
        return isSummerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {
        isSummerTyres = summerTyres;
    }

    public boolean isAllSeasonTyres() {
        return isAllSeasonTyres;
    }

    public void setAllSeasonTyres(boolean allSeasonTyres) {
        isAllSeasonTyres = allSeasonTyres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
