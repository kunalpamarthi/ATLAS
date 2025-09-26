// Task005: Parameterized tests.

package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParameterized {
    @ParameterizedTest
    @ValueSource(ints = {100, 25, 30, 70, 40})
    void testSquare(int value) {
        int result = square(value);
        assertEquals(value * value, result, " if wrong");
    }

    private int square(int number) {
        return number * number;
    }

}
