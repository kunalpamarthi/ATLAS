import java.util.Scanner;

public class ExploringOutputs {
    public static void main(String[] args) {
        System.out.println(8);
        System.out.println("8");
        System.out.println(9+8);
        System.out.println("8"+9);
        System.out.println("8" + "9");
        System.out.println("8+9");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        int name = scanner.nextInt();
        System.out.println(name);
    }
}
