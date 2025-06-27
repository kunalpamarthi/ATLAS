// Task012: Understand the below Hash table code and
// try to print values using get method of Hash table

package Arrays;

import java.util.Hashtable;
import java.util.Map;

public class Task012 {
    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("Anitha", 101);
        ht.put("Kavita", 102);
        ht.put("Meera", 103);
        System.out.println(ht);
        for (Map.Entry<String, Integer> e : ht.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }
}
