package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {

    @Test
    void test_sum() {
        assertEquals(3, Sum.somme(1, 2));
        assertEquals(-1, Sum.somme(1, -2));
        assertEquals(-3, Sum.somme(-1, -2));
    }

}
