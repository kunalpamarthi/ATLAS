// Task019: Create an array List skip 15 numbers
// and print the output using foreach loop.

package Files;

import java.util.stream.Stream;

public class Task019 {
    public static void main(String[] args) {
        Stream<Integer> num = Stream
                .iterate(1, n -> n+1)
                .limit(20);

        Stream<Integer> skipNum = num.skip(15);

        skipNum.forEach(System.out::println);

    }
}
