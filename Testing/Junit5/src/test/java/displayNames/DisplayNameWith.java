package displayNames;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@DisplayName("Display name with spaces")
//@DisplayName("Display name with !@#$%^&*()_+~`╯°□°）╯ special character")
@DisplayName("Display name with 😀 emojis")
public class DisplayNameWith {

    @Test
    public void test() {
        System.out.println("test method got executed!!!");
    }
}
