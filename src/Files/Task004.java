// Task004: Create a file and writes character into that file.

package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Task004 {
    public static void main(String[] args) {
        File f1=new File("src/Files/TextFile03.txt");
        FileWriter fw;
        try {
            fw=new FileWriter(f1);
            fw.write("ahmedabad \n");
            fw.write("baroda \n");
            fw.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Sorry..!! File Not Found...!!!");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("write operation done!!");
    }
}
