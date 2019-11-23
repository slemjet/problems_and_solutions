package pl.slemjet.kata.operations.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleAdditionMathTest {

    private static BasicMath tested;

    @BeforeAll
    static void setUp() {
        tested = new SimpleAdditionMath();
    }

    @Test
    void negatePositive() {
        assertEquals(-10, tested.negate(10));
    }

    @Test
    void negateMaxPositive() {
        assertEquals(Integer.MIN_VALUE + 1, tested.negate(Integer.MAX_VALUE));
    }

    @Test
    void negateNegative() {
        assertEquals(10, tested.negate(-10));
    }

    @Test
    void negateMinNegative() {
        assertEquals(Integer.MAX_VALUE, tested.negate(Integer.MIN_VALUE + 1));
    }

    @Test
    void negateZero() {
        assertEquals(0, tested.negate(0));
    }

    @Test
    void subtractPositive() {
        assertEquals(5, tested.subtract(10, 5));
        assertEquals(-5, tested.subtract(5, 10));
    }

    @Test
    void subtractNegative() {
        assertEquals(-5, tested.subtract(-10, -5));
        assertEquals(5, tested.subtract(-5, -10));
    }

    @Test
    void subtractSeros() {
        assertEquals(-10, tested.subtract(-10, 0));
        assertEquals(10, tested.subtract(10, 0));
        assertEquals(10, tested.subtract(0, -10));
        assertEquals(-10, tested.subtract(0, 10));
        assertEquals(0, tested.subtract(0, 0));
    }

    @Test
    void absPositive() {
        assertEquals(10, tested.abs(10));
    }

    @Test
    void absNegative() {
        assertEquals(5, tested.abs(-5));
    }

    @Test
    void absZero() {
        assertEquals(0, tested.abs(0));
    }

    @Test
    void multiplyPositive() {
        assertEquals(100, tested.multiply(10, 10));
    }

    @Test
    void multiplyNegative() {
        assertEquals(-100, tested.multiply(-10, 10));
        assertEquals(-100, tested.multiply(10, -10));
    }

    @Test
    void multiplyZero() {
        assertEquals(0, tested.multiply(0, 10));
        assertEquals(0, tested.multiply(10, 0));
    }

    @Test
    void dividePositive() {
        assertEquals(10, tested.divide(100, 10));
        assertEquals(33, tested.divide(100, 3));
    }

    @Test
    void divideNegative() {
        assertEquals(-10, tested.divide(-100, 10));
        assertEquals(-33, tested.divide(100, -3));
    }

    @Test
    void divideZero() {
        assertEquals(0, tested.divide(0, 10));
        assertThrows(IllegalArgumentException.class, () -> assertEquals(0, tested.divide(100, 0)));
    }
}