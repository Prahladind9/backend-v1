package assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AssertArrayEquals {

    @Test
    public void testAssertArrayEqualsForEqualArrays() {
        int[] expected = {1,2,3,4};
        int[] actual = {1,2,3,4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertArrayEqualsForNotEqualArrays() {
        int[] expected = {1,2,3,4};
        int[] actual = {1,2,3};
        assertArrayEquals(expected, actual, "Arrays are not equal.");
    }

    @Test
    public void testAssertArrayEqualsForEqualArraysWithDifferentOrder() {
        int[] expected = {1,2,4,3};
        int[] actual = {1,2,3,4};
        assertArrayEquals(expected, actual, () -> "Arrays order is different");
    }
}
