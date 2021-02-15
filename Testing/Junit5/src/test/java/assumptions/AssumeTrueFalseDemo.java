package assumptions;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

public class AssumeTrueFalseDemo {

    @Test
    void testOnDevelopmentEnvironment() {
        System.setProperty("ENV", "DEV");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
        //remainder of test will proceed
    }

    @Test
    void testOnProductionEnvironment() {
        System.setProperty("ENV", "PROD");
        assumeTrue("DEV".equals(System.getProperty("ENV")), "Assumption failed");
        // remainder of test will be aborted
    }

    /**
     * Assume False Testing
     */
    @Test
    void testOnDevelopmentEnvironmentAF() {
        System.setProperty("ENV", "DEV");
        assumeFalse("DEV".equals(System.getProperty("ENV")), "Assumption failed");
        //remainder of test will be aborted
    }

    /**
     * Assume False Testing
     */
    @Test
    void testOnProductionEnvironmentAF() {
        System.setProperty("ENV", "PROD");
        assumeFalse("DEV".equals(System.getProperty("ENV")));
        // remainder of test will proceed
    }
}