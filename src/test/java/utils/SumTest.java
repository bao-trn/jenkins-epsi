package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {

    @Test
    void test_somme() {
        assertEquals(3, Sum.somme(1, 2));
        assertEquals(-1, Sum.somme(1, -2));
        assertEquals(-3, Sum.somme(-1, -2));
    }

    @Test
    void test_somme_1() {
        assertEquals(3, Sum.somme_1(1, 2));
        assertEquals(-1, Sum.somme_1(1, -2));
        assertEquals(-3, Sum.somme_1(-1, -2));
    }

    @Test
    void test_somme_2() {
        assertEquals(3, Sum.somme_2(1, 2));
        assertEquals(-1, Sum.somme_2(1, -2));
        assertEquals(-3, Sum.somme_2(-1, -2));
    }

    @Test
    void test_somme_3() {
        assertEquals(3, Sum.somme_3(1, 2));
        assertEquals(-10, Sum.somme_3(1, -2));
        assertEquals(-3, Sum.somme_3(-1, -2));
    }

    @Test
    void test_somme_4() {
        assertEquals(3, Sum.somme_4(1, 2));
        assertEquals(-10, Sum.somme_4(1, -2));
        assertEquals(-3, Sum.somme_4(-1, -2));
    }

}
