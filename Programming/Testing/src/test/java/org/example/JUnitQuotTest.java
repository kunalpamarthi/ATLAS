package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitQuotTest {
    @Test
    public void quot(){
        int a =2, b=3, quot;
        quot = b/a;
        assertEquals(1, quot);
    }
}
