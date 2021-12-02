package pro.skypro.course2.lesson1.solution.version2;

import pro.skypro.course2.lesson1.solution.version2.service.ServiceStation;
import pro.skypro.course2.lesson1.solution.version2.transport.Bicycle;
import pro.skypro.course2.lesson1.solution.version2.transport.Car;
import pro.skypro.course2.lesson1.solution.version2.transport.Truck;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("car1");
        Car car2 = new Car("car2");

        Truck truck = new Truck("truck1", 6);
        Truck truck2 = new Truck("truck2", 8);

        Bicycle bicycle = new Bicycle("bicycle1", 3);
        Bicycle bicycle2 = new Bicycle("bicycle2", 2);

        ServiceStation station = new ServiceStation();

        station.check(car);
        station.check(car2);
        station.check(truck);
        station.check(truck2);
        station.check(bicycle);
        station.check(bicycle2);


//        Vehicle[] transports = new Vehicle[] {car, car2, truck, truck2, bicycle, bicycle2};
//        for (Vehicle vehicle : transports) {
//            station.check(vehicle);
//        }
    }
}