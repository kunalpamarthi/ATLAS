package Day21.Product;

public interface Product {
    void seeReviews();
    void getProduct();
}

class Cloth implements Product{
    @Override
    public void getProduct() {
        System.out.print("👕\t");
    }

    @Override
    public void seeReviews() {
        System.out.println("3.5/5 (1k)");
    }
}

class Book implements Product{
    @Override
    public void getProduct() {
        System.out.print("📔\t");
    }

    @Override
    public void seeReviews() {
        System.out.println("4.2/5 (597)");
    }
}
