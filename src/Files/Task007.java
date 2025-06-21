// Task007: Merge two file into a new file.

package Files;

import java.io.*;

public class Task007 {
    public static void main(String[] args) {
        String file1 = "src/Files/TextFile03.txt";
        String file2 = "src/Files/TextFile02.txt";
        String outputFile = "src/Files/TextFile05.txt";

        try (FileOutputStream out = new FileOutputStream(outputFile);
             FileInputStream in1 = new FileInputStream(file1);
             FileInputStream in2 = new FileInputStream(file2)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in1.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            while ((bytesRead = in2.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Files merged successfully!");
        } catch(IOException e){
            System.out.println("Sorry..!! File Not Found...!!!");
        }
    }
}
