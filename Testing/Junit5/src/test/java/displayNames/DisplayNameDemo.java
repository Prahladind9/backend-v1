package displayNames;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test class to demonstrate @Display name")
public class DisplayNameDemo {

    @Test
    public void testWithoutDisplayName() {
        System.out.println("test method got executed!!!");
    }

    @Test
    @DisplayName("Custom test name containing spaces")
    public void testWithDisplayNameContainingSpaces() {
        System.out.println("test method got executed!!!");
    }

    @Test
    @DisplayName("Custom test name containing special characters - !@#$%^&*()_+~`╯°□°）╯")
    public void testWithDisplayNameContainingSpecialCharacters() {
        System.out.println("test method got executed!!!");
    }

    @Test
    @DisplayName("Custom test name containing emojis - 😱")
    public void testWithDisplayNameContainingEmoji() {
        System.out.println("test method got executed!!!");
    }
}