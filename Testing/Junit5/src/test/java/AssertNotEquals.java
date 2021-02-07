import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEquals {
    // ******** assertNotEquals Example - Start **********

    @Test
    void givenEmptyString_whenReverseIsCalled_thenEmptyStringIsReturned() {
        String actual = StringUtils.reverse((""));
        String expected = "1234";

        // assertNotEquals without message
        assertNotEquals(expected, actual);
    }

    @Test
    void givenNonNullString_whenReverseIsCalled_thenReversedStringIsReturned() {
        String actual = StringUtils.reverse(("ABCD"));
        String expected = "DCBA";

        String message = "assertNotEquals failed";
        // assertNotEquals with message
        assertNotEquals(expected, actual, message);
    }

    @Test
    void givenNonNullString_whenReverseIsCalled_thenReversedStringIsReturned2() {
        String actual = StringUtils.reverse(("1234"));
        String expected = "4321";

        Supplier<String> messageSupplier = () -> "assertNotEquals failed";
        // assertNotEquals with Java 8 Supplier<String>
        assertNotEquals(expected, actual, messageSupplier);
    }

    // ******** assertNotEquals Example - End **********
}
