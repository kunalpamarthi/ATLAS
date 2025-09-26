// Task004: Assumptions.

/*assumeTrue() - used to skip the test when a specified condition is not true
                 for assumeTrue or not false for assumeFalse.
assumingThat() - to execute a block of code based on a Boolean Assumptions,
                 If the Assumptions is false the block is skipped.*/

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class TestAssumptions {
    @Test
    void Testcase1() {
        boolean condition = "true".equalsIgnoreCase(System.getProperty("true"));
        int result = testcase2();
        Assertions.assertEquals(20, result, "value need to be 10");
        Assumptions.assumeTrue(condition, "as the condition is not met skip test case");
    }

    private int testcase2() {
        return 10;
    }

}
