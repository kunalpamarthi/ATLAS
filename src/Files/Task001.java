// Task001: File handling.

package Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task001 {
    public static void main(String[] args) {

        File f1=new File("src/Files/TextFile01.txt"); // to create new file
        FileOutputStream outfile = null;
        byte[] Text = {'I', ' ', 'L','O','V','E', ' ', 'I','N','D', 'I', 'A'};
        try {
            outfile = new FileOutputStream(f1);
            outfile.write(Text);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        System.out.println("Write Byte");
        System.out.println("Thank You...!!!");
    }
}
