package disableEnable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisabledMethodTest {

    @Test
    void testOnDevelopmentEnvironment(){
        System.setProperty("ENV", "DEV");
        assertTrue("DEV".equals(System.getProperty("ENV")));
    }

    @Disabled("Skip in upper environments")
    @Test
    void testOnProductionEnvironment(){
        System.setProperty("ENV", "PROD");
        assertTrue("PROD".equals(System.getProperty("ENV")));
    }
}
