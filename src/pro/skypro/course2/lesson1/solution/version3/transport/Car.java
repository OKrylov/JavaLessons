package pro.skypro.course2.lesson1.solution.version3.transport;

import pro.skypro.course2.lesson1.solution.version3.service.ServiceEngine;
import pro.skypro.course2.lesson1.solution.version3.service.ServiceWheels;

public class Car extends Vehicle implements ServiceWheels, ServiceEngine {

    protected static final int WHEELS_COUNT = 4;

    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    public Car(String modelName) {
        this(modelName, WHEELS_COUNT);
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

    @Override
    public void service() {
        super.service();
        updateTyres();
        checkEngine();
    }

}
