package Day20.Customers;

import java.io.FileWriter;
import java.io.IOException;

public class ManageFiles {

    public void saveData(Customers customers) {
        String name = customers.getName();
        String cId = customers.getCustomerID();
        try(FileWriter fw = new FileWriter(cId+".txt")){
            fw.write("the customer name is "+ name + ".\n");
            fw.write("the customer id is "+ cId + ".\n");
            System.out.println("The data is saved in the file with your customer id.");
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
