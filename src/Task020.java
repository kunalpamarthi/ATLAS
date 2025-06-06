//Task020: Create an array of your name

public class Task020 {
    public static void main(String[] args) {
        char[] name = {'k', 'u', 'n', 'a', 'l'};
        System.out.println(name);
        int nameLength = name.length;
        System.out.println("There are "+nameLength+" letters in my name.");
        for(int i = 0; i < nameLength; i++) {
            System.out.print(name[i]+ " ");
        }
    }
}
