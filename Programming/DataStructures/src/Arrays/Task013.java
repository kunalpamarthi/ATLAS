// Task013: Understand the below Hash map code and
// try to print values using get method of Hash map.

package Arrays;

import java.util.HashMap;

public class Task013 {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(103, "Meera");
        hm.put(101, "Anita");
        hm.put(102, "Kavita");

        for (int i = 101; i <= (100+hm.size()); i++) {
            System.out.println(i +"\t"+ hm.get(i));
        }
    }
}
