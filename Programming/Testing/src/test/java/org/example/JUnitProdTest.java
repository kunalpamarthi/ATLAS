package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitProdTest {
    @Test
    public void product(){
        int a=2, b=3, prod;
        prod = a*b;
        assertEquals(6, prod);
    }
}
