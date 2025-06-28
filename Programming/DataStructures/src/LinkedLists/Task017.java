// Task017: Create a Hash Map of capacity 10.

package LinkedLists;

import java.util.HashMap;

public class Task017 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(10);
        for (int i = 1; i <= 10; i++) {
            hashMap.put(i, String.valueOf(i+i*i));
        }
        System.out.println(hashMap);
    }
}
