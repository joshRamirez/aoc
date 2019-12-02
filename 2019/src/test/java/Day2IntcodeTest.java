import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day2IntcodeTest {

    @Test
    public void testGetIntcode1() {
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1");
        mockInstructions.add("0");
        mockInstructions.add("0");
        mockInstructions.add("0");
        mockInstructions.add("99");
        assertEquals(2, Day2Intcode.getIntcode(mockInstructions), 0);
    }

    @Test
    public void testGetIntcode2() {
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1");
        mockInstructions.add("9");
        mockInstructions.add("10");
        mockInstructions.add("3");
        mockInstructions.add("2");
        mockInstructions.add("3");
        mockInstructions.add("11");
        mockInstructions.add("0");
        mockInstructions.add("99");
        mockInstructions.add("30");
        mockInstructions.add("40");
        mockInstructions.add("50");
        assertEquals(3500, Day2Intcode.getIntcode(mockInstructions), 0);
    }

    @Test
    public void testGetIntcode3() {
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1");
        mockInstructions.add("1");
        mockInstructions.add("1");
        mockInstructions.add("4");
        mockInstructions.add("99");
        mockInstructions.add("5");
        mockInstructions.add("6");
        mockInstructions.add("0");
        mockInstructions.add("99");
        assertEquals(30, Day2Intcode.getIntcode(mockInstructions), 0);
    }

    @Test
    public void testPart1() {
        List<String> instructions = AocFileReader.readList("src/main/resources/Day2Data.txt");
        assertEquals(7210630, Day2Intcode.getIntcode(instructions), 0);
    }
}
