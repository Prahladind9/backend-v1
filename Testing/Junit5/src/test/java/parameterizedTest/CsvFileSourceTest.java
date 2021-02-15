package parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvFileSourceTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/capitals.csv", numLinesToSkip = 1)
    void testWithCsvFilesSource(String country, String capital){
        assertNotNull(country);
        assertNotNull(capital);
    }
}
