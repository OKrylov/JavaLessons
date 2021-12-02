package pro.skypro.course2.lesson1.solution.version3.transport;

import pro.skypro.course2.lesson1.solution.version3.service.ServiceWheels;

public class Bicycle extends Vehicle implements ServiceWheels {

    public Bicycle(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void updateTyres() {
        for (int i = 0; i < getWheelsCount(); i++) {
            System.out.println("Меняем велосипедную покрышку");
        }
    }

    @Override
    public void service() {
        super.service();
        updateTyres();
    }
}
