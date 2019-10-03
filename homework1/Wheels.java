package homework1;

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
        if(snowTyres = true) {
            this.isSummerTyres = false;
            this.isAllSeasonTyres = false;
        }
        isSnowTyres = snowTyres;
    }

    public boolean isSummerTyres() {
        return isSummerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {
        if(summerTyres = true) {
            this.isSnowTyres = false;
            this.isAllSeasonTyres = false;
        }
        isSummerTyres = summerTyres;
    }

    public boolean isAllSeasonTyres() {
        return isAllSeasonTyres;
    }

    public void setAllSeasonTyres(boolean allSeasonTyres) {
        if(allSeasonTyres = true) {
            this.isSnowTyres = false;
            this.isSummerTyres = false;
        }
        isAllSeasonTyres = allSeasonTyres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
