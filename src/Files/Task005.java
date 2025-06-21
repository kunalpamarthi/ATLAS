// Task005: Read data from a file.

package Files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task005 {
    public static void main(String[] args) {
        FileReader fr;
        try {
            fr = new FileReader("src/Files/TextFile03.txt");
            int ch;
            while((ch = fr.read()) != -1){
                System.out.print((char)ch);
            }
            System.out.println("Reading complete");
            fr.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Sorry..!! File Not Found...!!!");
        }

        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
