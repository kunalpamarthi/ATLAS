// Task003: File handling user input

package Files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task003 {
    public static void main(String[] args) {
        FileOutputStream outfile;
        //String s=args[0]; // to input string from command line
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the file data: ");
        String s=sc.nextLine();
        byte[] b1 = s.getBytes();
        try{
            //noinspection resource
            outfile = new FileOutputStream("src/Files/TextFile02.txt");
            outfile.write(b1);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        System.out.println("Write Byte");
        System.out.println("Thank You...!!!");
    }
}
