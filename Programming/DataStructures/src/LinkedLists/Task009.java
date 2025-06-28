// Task009: Display list with for and foreach loops

package LinkedLists;

public class Task009 {
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"->");
        }
        System.out.println("Null");
        System.out.print("List: ");
        for(String s: list){
            System.out.print(s+"->");
        }
        System.out.println("Null");
    }
}
