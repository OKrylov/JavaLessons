package pro.skypro.course2.lesson1.solution.version3;

import pro.skypro.course2.lesson1.solution.version3.service.ServiceStation;
import pro.skypro.course2.lesson1.solution.version3.transport.Car;
import pro.skypro.course2.lesson1.solution.version3.transport.Vehicle;
import pro.skypro.course2.lesson1.solution.version3.transport.Bicycle;
import pro.skypro.course2.lesson1.solution.version3.transport.Truck;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("car1");
        Car car2 = new Car("car2");

        Truck truck = new Truck("truck1", 6);
        Truck truck2 = new Truck("truck2", 8);

        Bicycle bicycle = new Bicycle("bicycle1", 3);
        Bicycle bicycle2 = new Bicycle("bicycle2", 2);

        Vehicle[] transports = new Vehicle[]{
                car,
                car2,
                truck,
                truck2,
                bicycle,
                bicycle2
        };

        ServiceStation station = new ServiceStation();

        for (Vehicle vehicle : transports) {
            station.check(vehicle);
        }
    }
}