package homework1.car.details;

public class Wheels {
    private int radius;
    private String tyresType;
    private String name;

    public Wheels(int radius, String name) {
        this.radius = radius;
        this.tyresType = tyresType;
        this.name = name;
    }
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void selectTyresType(int tyrestype) {
        switch (tyrestype) {
            case 1:
                tyresType = "зимние шины";
                break;
            case 2:
                tyresType = "летние шины";
                break;
            case 3:
                tyresType = "всесезонные шины";
                break;
            default:
                tyresType = "*БЫЛО ВВЕДЕНО НЕКОРРЕКТНОЕ ЗНАЧЕНИЕ ДЛЯ ШИН*";
                break;
        }
    }

    public String getTyresType() {
        return tyresType;
    }
}
