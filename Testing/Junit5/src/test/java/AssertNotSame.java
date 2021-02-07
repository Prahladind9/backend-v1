import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

public class AssertNotSame {
    @Test
    public void testAssertNotSameWithDifferentObject() {
        String actual = "hello";
        String expected = "hell";
        assertNotSame(expected, actual);
    }

    @Test
    public void testAssertNotSameWithSameObject() {
        String actual = "hello";
        String expected = "hello";
        assertNotSame(expected, actual);
    }

    @Test
    public void testAssertNotSameWithSameObjectAndMessage() {
        String actual = "hello";
        String expected = "hello";
        assertNotSame(expected, actual, "The actual value is same as expected value");
    }

    @Test
    public void testAssertNotSameWithSameObjectAndMessageSupplier() {
        String actual = "hello";
        String expected = "hello";
        assertNotSame(expected, actual, () -> "The actual value is same as expected value");
    }
}
