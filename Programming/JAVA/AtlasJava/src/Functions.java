import java.util.Scanner;

public class Functions {

    public static void sum(double num1, double num2){
        System.out.println(num1+num2);
    }

    static boolean isPrime(int num){
        for(int i=2; i<num/2; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    static boolean isEven(int num){
        return (num%2 == 0);
    }

    public static void main(String[] args) {
        sum(1,2);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        boolean prime = isPrime(num);
        if (prime) System.out.println("Prime");
        else System.out.println("Not Prime");

        boolean even = isEven(num);
        System.out.println(even ? "Even" : "Odd");
    }

}
