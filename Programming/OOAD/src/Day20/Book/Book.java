// Task003: The below is violating SRP, complete it and
// also implement the SRP principle and rewrite the code.

package Day20.Book;

public class Book {
    public static void main(String[] args) {
        BookDetails bookDetails = new BookDetails("shiro", "Kunal", 200);
        BookFormater bookFormater = new BookFormater();
        PriceCalc calc = new PriceCalc();
        System.out.println("Selling price of "+bookFormater.formatTitle(bookDetails.getTitle())+
                " written by "+bookDetails.getAuthor()+
                " is: "+calc.discountedPrice(bookDetails.getPrice(), 0.25));
    }
}
