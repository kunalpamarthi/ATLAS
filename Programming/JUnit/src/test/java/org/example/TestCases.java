// Task003: Test cases for launcher.

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCases {

    @Test
    void firstTest() {
        assertTrue(true);
    }

    @Test
    void secondTest() {
        assertTrue(true, "This test should pass.");
    }

    @Test
    void thirdTest(){
        fail("false");
    }
}