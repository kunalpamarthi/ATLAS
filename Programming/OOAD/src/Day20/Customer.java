// Task001: Without SRP

package Day20;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {
    String name;
    String customerId;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public String getCustomerID() {
        return customerId;
    }
    public void saveData() {
        try(FileWriter fw = new FileWriter(customerId+".txt")){
            fw.write("The customer name is "+ name + ".\n");
            fw.write("The customer id is "+ customerId + ".\n");
            System.out.println("The data is saved in the file with your customer id.");
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Prasunamba" , "C001");
        customer.saveData();
        System.out.println("File created for the customer: "+customer.getCustomerID() +" "+customer.getName());
    }

}
