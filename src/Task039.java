//Abstraction: Rewrite the above code to give the output without errors.

abstract class NewEmployee {
    private final String name;
    private String address;
    private final int number;

    public NewEmployee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void computePay() {
        System.out.println("Inside Employee computePay");
    }

    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class conEmployee extends NewEmployee{

    public conEmployee(String name, String address, int number) {
        super(name, address, number);
    }
}

public class Task039 {
    public static void main(String[] args) {
        String newEmpName = "shiro";
        int mobileNum = 91234567;
        String address = "Hyd, TG";
        conEmployee employee = new conEmployee(newEmpName, address, mobileNum);
        System.out.println(employee.getName()+"\t"+employee.getAddress()+"\n\t"+
                employee.getNumber());
        employee.computePay();
        employee.mailCheck();
        System.out.println("-".repeat(50));
        employee.setAddress("Bengaluru, KA");
        System.out.println(employee.getName()+"\t"+employee.getAddress()+"\n\t"+
                employee.getNumber());
    }
}
