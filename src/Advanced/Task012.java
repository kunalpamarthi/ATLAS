// Task012: Double colon

package Advanced;

import java.util.stream.Stream;

public class Task012 {
    public static void main(String[] args) {
        Stream <String> stream = Stream.of("shiro",
                "is", "very", "good", "boy.");
        stream.forEach(System.out::println);
    }
}
