package Day23;

public interface PizzaFactory {
    Pizza createPizza();
}

class PepperoniPizzaFactory implements PizzaFactory{
    @Override
    public Pizza createPizza() {
        Pizza pizza = new PepperoniPizza();
        pizza.preparations();
        pizza.baking();
        pizza.cutting();
        pizza.boxing();
        return pizza;
    }
}
