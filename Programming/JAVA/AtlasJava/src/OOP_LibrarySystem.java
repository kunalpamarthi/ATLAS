class Book{
    String name;
    int year;
    String author;
    boolean avail = true;

    Book(String title, int year, String author){
        this.name = title;
        this.year = year;
        this.author = author;
    }

    void display(){
        System.out.println(name + "\n" +year+ "\n"+ author);
        System.out.println(avail ? "Available." : "Not Available.");
    }

    void borrowBook(){
        if (avail){
            avail = false;
            System.out.println("\nborrowed");
        }else {
            System.out.println("Requested book is currently unavailable!!");
        }
    }
    void returnBook(){
        if (!avail){
            avail = true;
            System.out.println("\nreturned");
        }else {
            System.out.println("Cant return existing book.");
        }
    }
}

public class OOP_LibrarySystem {
    public static void main(String[] args) {
        Book firstBook = new Book("ABC", 1243, "xyz");
        firstBook.display();
        firstBook.returnBook();
        firstBook.borrowBook();
        firstBook.display();
        firstBook.returnBook();
        firstBook.display();
    }
}
