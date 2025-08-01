// Dependency Inversion Principle

package Day21.Product;

public class Mart {
    public static void main(String[] args) {
        Product shirt  = new Cloth();
        Product book = new Book();
        shirt.getProduct();
        shirt.seeReviews();
        book.getProduct();
        book.seeReviews();
    }
}
