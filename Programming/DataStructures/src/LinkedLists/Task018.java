// Task018: copy data from one map to another map

package LinkedLists;

import java.util.HashMap;

public class Task018 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(10);
        for (int i = 1; i <= 10; i++) {
            hashMap.put(i, String.valueOf(i+i*i));
        }
        HashMap<Integer, String> hashMapClone = new HashMap<>(hashMap);
        System.out.println("Original: "+hashMap);
        System.out.println("Clone: "+hashMapClone);
    }
}
