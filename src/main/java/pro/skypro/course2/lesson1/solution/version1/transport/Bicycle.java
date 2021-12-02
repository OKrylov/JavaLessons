package pro.skypro.course2.lesson1.solution.version1.transport;

public class Bicycle extends Vehicle {

    private String radio;

    public Bicycle(String modelName, int wheelsCount) {
        this(modelName, wheelsCount, null);
    }

    public Bicycle(String modelName, int wheelsCount, String radio) {
        super(modelName, wheelsCount);
        this.radio = radio;
    }

    @Override
    public void updateTyre() {
        System.out.println("Меняем велосипедную покрышку");
    }
}
