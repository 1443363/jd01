package homework1;

import homework1.car.details.Engine;
import homework1.car.details.Wheels;
import homework1.car.types.Ferrari;

public class Main {
    public static void main(String[] args) {
        Ferrari ferrari = new Ferrari(2, "Категория B", "Electronic");
        Driver schumacher = new Driver("Категория B", 20, "Electronic");
        Engine ferrariEngine = new Engine("V6 Turbo", 15, "АИ-98");
        Wheels ferrariWheels = new Wheels(40, "355 F1 GTS");
        ferrariWheels.selectTyresType(1);
        ferrari.setWheels(ferrariWheels);
        ferrari.setEngine(ferrariEngine);

        schumacher.openAndStart(ferrari);
        schumacher.drive(ferrari);
        schumacher.burnRubber(ferrari);
        schumacher.boarding(ferrari);
        schumacher.gasUp(ferrari);
    }
}
