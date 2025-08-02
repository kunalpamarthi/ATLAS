package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitDiffTest {
    @Test
    public void diff(){
        int a=2, b=3, doff;
        doff = b-a;
        assertEquals(1, doff);
    }
}
