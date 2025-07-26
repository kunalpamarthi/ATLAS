// Task001: SRP Implementation

package Day20.Customers;

public class SRPImplementation {
    public static void main(String[] args) {
        Customers customers = new Customers("shiro", "43");
        ManageFiles manageFiles = new ManageFiles();
        manageFiles.saveData(customers);
    }
}
