// Task019: Create a  hash map using a load factor

package LinkedLists;

import java.util.HashMap;

public class Task019 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(10, 0.75f);
        for (int i = 1; i <= 10; i++) {
            hashMap.put(i, String.valueOf(i+i*i));
        }
        System.out.println(hashMap);
    }
}
