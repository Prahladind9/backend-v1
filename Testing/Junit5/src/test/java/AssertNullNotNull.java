import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertNullNotNull {

    @Test
    void givenNullString_whenReverseIsCalled_thenNullIsReturned() {
        String actual = StringUtils.reverse((null));
        assertNull(actual);
    }

    @Test
    void givenEmptyString_whenReverseIsCalled_thenEmptyStringIsReturned() {
        String actual = StringUtils.reverse((""));
        assertNotNull(actual);
    }

    @Test
    void givenNonNullString_whenReverseIsCalled_thenReversedStringIsReturned() {
        String actual = StringUtils.reverse(("ABCD"));
        assertNotNull(actual);
    }

}