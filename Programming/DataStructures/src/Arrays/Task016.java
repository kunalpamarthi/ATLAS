// Task016: Try to add 1 null value in the key and run the hash map code.
// Also add one more null value to the key and see the result.
// Make a Hashmap synchronized.

package Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task016 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, "Lok");
        hashMap.put(102, "Jan");
        hashMap.put(103, "People");
        System.out.println(hashMap);
        Map<Integer, String> syncMap = Collections.synchronizedMap(hashMap);
        syncMap.put(null, "Human");
        System.out.println(syncMap);
    }
}
