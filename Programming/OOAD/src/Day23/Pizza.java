package Day23;

public interface Pizza {
    void preparations();
    void baking();
    void cutting();
    void boxing();
}

class PepperoniPizza implements Pizza{
    @Override
    public void baking() {
        System.out.println("Baking the pizza...");
    }

    @Override
    public void boxing() {
        System.out.println("Boxed the pizza... done and dusted.");
    }

    @Override
    public void cutting() {
        System.out.println("Cutting the pizza...");
    }

    @Override
    public void preparations() {
        System.out.println("Preparing for pizza...");
    }
}
