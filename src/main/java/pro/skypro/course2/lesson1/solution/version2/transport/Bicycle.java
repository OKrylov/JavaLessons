package pro.skypro.course2.lesson1.solution.version2.transport;

public class Bicycle extends Vehicle {

    public Bicycle(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void updateTyre() {
        System.out.println("Меняем велосипедную покрышку");
    }
}
