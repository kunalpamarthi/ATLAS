package Day20.Customers;

public class Customers {
    public String name;
    public String customerId;

    public Customers(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public String getCustomerID() {
        return customerId;
    }
}
