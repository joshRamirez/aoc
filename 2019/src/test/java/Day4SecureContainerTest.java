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

    @Test
    public void testValidatePassword223045() {
        assertEquals(false, Day4SecureContainer.validatePassword(223045));
    }

    @Test
    public void testValidatePassword400001() {
        assertEquals(false, Day4SecureContainer.validatePassword(400001));
    }

    @Test
    public void testGetValidPasswords111111to111115() {
        assertEquals(5, Day4SecureContainer.getValidPasswords(111111, 111115));
    }

    @Test
    public void testGetValidPasswords372304to847060() {
        assertEquals(475, Day4SecureContainer.getValidPasswords(372304, 847060));
    }
}
