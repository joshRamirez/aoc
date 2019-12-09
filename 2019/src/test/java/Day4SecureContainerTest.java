import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day4SecureContainerTest {
    @Test
    public void testValidatePassword111123() {
        assertEquals(true, Day4SecureContainer.validatePassword(111123));
    }

    @Test
    public void testValidatePassword4588999() {
        assertEquals(true, Day4SecureContainer.validatePassword(458899));
    }

    @Test
    public void testValidatePassword66() {
        assertEquals(true, Day4SecureContainer.validatePassword(66));
    }

    @Test
    public void testValidatePassword135679() {
        assertEquals(false, Day4SecureContainer.validatePassword(135679));
    }

    @Test
    public void testValidatePassword1298() {
        assertEquals(false, Day4SecureContainer.validatePassword(123498));
    }

    @Test
    public void testValidatePassword97() {
        assertEquals(false, Day4SecureContainer.validatePassword(97));
    }
}
