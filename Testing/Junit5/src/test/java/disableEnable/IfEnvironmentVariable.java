package disableEnable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IfEnvironmentVariable {
    @Test
    void testOnAllEnvironmentVariables() {
        assertTrue(3 > 0);
    }

    @DisabledIfEnvironmentVariable(named="USER", matches="rao")
    @Test
    void testDisabledIfUserMatchesRao() {
        assertFalse(0 > 4);
    }

    @DisabledIfEnvironmentVariable(named="HOME", matches="/dummies/home")
    @Test
    void testDisabledIfHomeMatchesDummyDirectory() {
        assertFalse(10 > 40);
    }

    @EnabledIfEnvironmentVariable(named="USER", matches="rao")
    @Test
    void testEnabledIfUserMatchesRao() {
        assertFalse(0 > 4);
    }

    @EnabledIfEnvironmentVariable(named="HOME", matches="/dummies/home")
    @Test
    void testEnabledIfHomeMatchesDummyDirectory() {
        assertFalse(10 > 40);
    }
}
