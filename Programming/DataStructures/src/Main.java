//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        int x = 65;
        String bin = "";
        while (x>0){
            bin += String.valueOf((x%2));
            x /= 2;
        }
        System.out.println("Binary of 65: "+ bin);
    }
}