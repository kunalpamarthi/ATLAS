import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 65;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character to covert: ");
        String chr = scanner.next();
        x = chr.charAt(0);
        String bin = "";
        while (x>0){
            bin += String.valueOf((x%2));
            x /= 2;
        }
        System.out.println("Binary of "+chr+": "+ bin);
        scanner.close();
    }
}