package disableEnable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IfSystemPropertyTest {

    @Test
    void testOnAllSystemProperties(){
        System.getenv().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        assertTrue(3 > 0);
    }

    @DisabledIfSystemProperty(named = "user.name", matches ="rao")
    @Test
    void testDisabledIfUserNameMatchesRao(){
        assertTrue(0 > 4);
    }

    @DisabledIfSystemProperty(named = "os.name", matches = "Windows")
    @Test
    void testDisabledIfOperatingSystemMatchesWindows(){
        assertFalse(10 > 40);
    }

    @EnabledIfSystemProperty(named = "user.name", matches="rao")
    @Test
    void testEnabledIfUserNameMatchesRao(){
        assertFalse(0 > 4);
    }

    @EnabledIfSystemProperty(named = "os.name", matches = "Mac")
    @Test
    void testEnabledIfOperatingSystemMatchesMac(){
        assertFalse(10 > 40);
    }
}
