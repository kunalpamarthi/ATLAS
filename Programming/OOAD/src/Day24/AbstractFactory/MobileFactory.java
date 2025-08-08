// Task001: Abstract Factory design pattern

package Day24.AbstractFactory;

public class MobileFactory {
    private final Brand brand;

    public MobileFactory(Brand brand){
        this.brand = brand;
    }

    public Mobile createMobile(String modelName){
        return brand.createModel(modelName);
    }

    public static void main(String[] args) {
        Brand apple = new Apple();
        MobileFactory appleFactory = new MobileFactory(apple);
        Mobile iPhone16 = appleFactory.createMobile("iPhone16");
        iPhone16.text();
    }
}
