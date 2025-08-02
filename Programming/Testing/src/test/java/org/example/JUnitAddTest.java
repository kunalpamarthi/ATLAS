package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitAddTest {
    @Test
    public void add(){
        int a =2, b=3, sum;
        sum = a+b;
        assertEquals(5, sum);
    }
}
