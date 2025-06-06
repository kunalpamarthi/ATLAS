//Task019: WAP to display the content of the above enum from the class
// Task016_1 in this program. (main  needs to be added)

public class Task019 {
    public static void main(String[] args) {
        Element H = Element.valueOfAtomicNumber(1);
        Element He = Element.valueOfLabel("Helium");
        System.out.println(H.atomicNumber);
        System.out.println(He.label);
        Element element = Element.valueOfAtomicWeight(20.180f);
        System.out.println(element.label);
    }
}
