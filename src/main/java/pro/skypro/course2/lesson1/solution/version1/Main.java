package pro.skypro.course2.lesson1.solution.version1;

import pro.skypro.course2.lesson1.solution.version1.transport.Bicycle;
import pro.skypro.course2.lesson1.solution.version1.transport.Car;
import pro.skypro.course2.lesson1.solution.version1.service.ServiceStation;
import pro.skypro.course2.lesson1.solution.version1.transport.Truck;
import pro.skypro.course2.lesson1.solution.version1.transport.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle[] transports = new Vehicle[] {
                new Car("car1"),
                new Car("car2"),
                new Truck("truck1", 6),
                new Truck("truck2", 8),
                new Bicycle("bicycle1", 3),
                new Bicycle("bicycle2", 2),
        };

        ServiceStation station = new ServiceStation();

        for (Vehicle vehicle : transports) {
            station.check(vehicle);
        }

    }
}