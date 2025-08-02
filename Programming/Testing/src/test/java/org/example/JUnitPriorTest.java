// Task001: Tags annotation.

package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitPriorTest {
    @Test
    @Tag("firstPriority")
    void product(){

    }

    @Test
    @Tag("firstPriority")
    void quot(){
        int a =2, b=3, quot;
        quot = b/a;
        assertEquals(1, quot);
    }

    @Test
    @Tag("fastTag")
    void diff(){
        int a=2, b=3, doff;
        doff = b-a;
        assertEquals(1, doff);
    }

    @Test
    @Tag("slowTag")
    void add(){
        int a =2, b=3, sum;
        sum = a+b;
        assertEquals(5, sum);
    }

}
