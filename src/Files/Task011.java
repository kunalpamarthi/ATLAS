// Task011: Lambda reverse.

package Files;

@FunctionalInterface
interface RevInterface {
    String reverse(String n);
}

public class Task011 {
    public static void main(String[] args) {
        RevInterface ref = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
                result += str.charAt(i);
            return result;
        };

        System.out.println("Lambda reversed = " + ref.reverse("Lambda"));

    }
}
