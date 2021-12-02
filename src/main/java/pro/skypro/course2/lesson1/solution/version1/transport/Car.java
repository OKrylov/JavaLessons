package pro.skypro.course2.lesson1.solution.version1.transport;

public class Car extends Vehicle {

    protected static final int DEFAULT_WHEELS_COUNT = 4;

    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    public Car(String modelName) {
        this(modelName, DEFAULT_WHEELS_COUNT);
    }

    public void checkEngine() {
        System.out.println("Проверяем двигатель");
    }

    @Override
    public void service() {
        super.service();
        checkEngine();
    }

}
