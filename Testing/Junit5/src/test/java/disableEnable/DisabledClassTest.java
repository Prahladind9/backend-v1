package disableEnable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class DisabledClassTest {
    @Test
    void testMethod1(){
        assertTrue(4 > 0);
    }

    @Test
    void testMethod2(){
        assertFalse(4 < 0);
    }
}
