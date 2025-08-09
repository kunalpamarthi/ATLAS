// Task003: Prototype.

package Day24.Prototype;

public class Theme {
    public static void main(String[] args) {
        Colors blackConcrete = new BlackConcrete("Black");
        Colors blackClone = blackConcrete.clones();
        blackClone.setName("Dark");
        System.out.println(blackConcrete.getName()+
                " is "+blackClone.getName()+" color.");
    }
}
