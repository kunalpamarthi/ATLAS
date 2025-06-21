// Task006: Read one byte at a time from a file
// and copy it into another file immediately.

package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task006 {
    public static void main(String[] args) {
        String sourceFile = "src/Files/TextFile03.txt";
        String destinationFile = "src/Files/TextFile04.txt";

        try (FileInputStream in = new FileInputStream(sourceFile);
             FileOutputStream out = new FileOutputStream(destinationFile)) {

            int byteRead;
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
