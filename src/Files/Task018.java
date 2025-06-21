// Task018: Wap to run a loop / iterate()  and limit it to 20 values (1 to 2)
//While displaying use for each to limit till 10 numbers.

package Files;

import java.util.stream.Stream;

public class Task018 {
    public static void main(String[] args) {
        Stream<Integer> num =
                Stream.iterate(1, n -> n + 1).limit(20);

        num.limit(10).forEach(System.out::println);
    }
}