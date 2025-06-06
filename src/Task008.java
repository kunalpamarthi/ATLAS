/*Task008
Write a program to create a class named Customer
Call the customer class in Task008 class using an object.
*/

class Customer{
    void accept(){
        System.out.println("accept() method is called.");
    }
    void display(){
        System.out.println("display() method is called.");
    }
}

public class Task008 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.accept();
        customer.display();
    }
}
