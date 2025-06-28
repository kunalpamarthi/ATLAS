// Task010: display the elements of the linked list without loops

package LinkedLists;

class ToStrList<T> extends CustomLinkedList<T>{
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        GNode<T> current = head;
        while (current != null){
            stringBuilder.append(current.data);
            stringBuilder.append(" -> ");
            current = current.next;
        }
        stringBuilder.append("Null");
        return stringBuilder.toString();
    }
}

public class Task010 {
    public static void main(String[] args) {
        ToStrList<String> list = new ToStrList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println("List: "+list);
    }
}
