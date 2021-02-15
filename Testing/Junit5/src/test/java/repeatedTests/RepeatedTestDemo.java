package repeatedTests;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestDemo {

    @RepeatedTest(5)
    public void simpleRepeatedTest(){
        assertTrue(0 < 5);
    }
}
