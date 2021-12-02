package pro.skypro.course2.lesson1.solution.version3.transport;

import pro.skypro.course2.lesson1.solution.version3.service.ServiceEngine;
import pro.skypro.course2.lesson1.solution.version3.service.ServiceTrailer;
import pro.skypro.course2.lesson1.solution.version3.service.ServiceWheels;

public class Truck extends Vehicle implements ServiceWheels, ServiceEngine, ServiceTrailer {

    public Truck(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void updateTyres() {
        for (int i = 0; i < getWheelsCount(); i++) {
            System.out.println("Меняем покрышку");
        }
    }

    public void checkEngine() {
        System.out.println("Проверяем двигатель");
    }

    public void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }

    @Override
    public void service() {
        super.service();
        updateTyres();
        checkEngine();
        checkTrailer();
    }
}