//Task033

class MartCustomer{
    int cost = 40;
    String items = "Tomatoes";
}

class Billing extends MartCustomer{
    void billing(){
        super.items= "potatoes";
        super.cost= 30;
    }
}

public class Task033 {
    public static void main(String[] args) {
        Billing billing = new Billing();
        System.out.println(billing.items+": "+billing.cost);
        billing.billing();
        System.out.println(billing.items+": "+billing.cost);
    }
}
