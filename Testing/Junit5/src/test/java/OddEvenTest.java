import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OddEvenTest {

    @Test
    void givenEvenNumber_whenIsEvenIsCalled_thenTrueIsReturned(){
        OddEven oddEven = new OddEven();
        assertTrue(oddEven.isNumberEven(10));
    }

    @Test
    void givenOddNumber_whenIsEvenIsCalled_thenFalseIsReturned(){
        OddEven oddEven = new OddEven();
        assertFalse(oddEven.isNumberEven(3));
    }
}
