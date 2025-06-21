// Task008: Renaming the files.

package Files;

import java.io.File;
import java.util.Scanner;

public class Task008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file1 = scanner.next();
        System.out.print("Enter new name: ");
        String file2 = scanner.next();

        File f1 = new File("src/Files"+file1);
        File f2 = new File("src/Files"+file2);

        boolean result = f1.renameTo(f2);

        if(result)
            System.out.println(">\nRenamed the file " +
                    file1+" To "+file2+" Successfully.");
        else
            System.out.println(">\nProcess of renaming the file "
                    +file1+" is unsuccessful.");
    }
}
