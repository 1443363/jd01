package homework1;

import homework1.car.details.Engine;
import homework1.car.details.Wheels;

public interface IDriver {
    void openAndStart(Car car);
    void drive(Car car);
    void burnRubber(Car car);
    void boarding(Car car);
    void gasUp(Car car);
}
