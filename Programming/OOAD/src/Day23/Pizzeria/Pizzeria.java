// Task002: Factory model design pattern.

package Day23.Pizzeria;

public class Pizzeria {
    public static void main(String[] args) {
        PizzaFactory factory = new PepperoniPizzaFactory();
        Pizza pizza = factory.createPizza();
        if(pizza != null){
            System.out.println("Enjoy your pizza.!!");
        }
    }
}
