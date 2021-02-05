import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    // ******** assertNull Example - Start **********
    @Test
    void givenNullString_whenReverseIsCalled_thenNullIsReturned(){
        String actual = StringUtils.reverse(null);

        //assertNull without message
        assertNull(actual);
    }

    @Test
    void givenEmptyString_whenReversedIsCalled_thenEmptyStringIsReturned(){
        String actual = StringUtils.reverse("");
        String message = "Actual String should be null !!!";

        //assertNull with message
        assertNull(actual, message);
    }

    @Test
    void givenNonNullString_whenReverseIsCalled_thenReversedStringIsReturned(){
        String actual = StringUtils.reverse("ABCD");
        Supplier<String> messageSupplier = () -> "Actual String should be null !!!";

        //assertNull with Java 8 MessageSupplier
        assertNull(actual, messageSupplier);
    }
    // ******** assertNull Example - End **********

}
