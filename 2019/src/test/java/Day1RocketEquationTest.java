import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day1RocketEquationTest {

    @Test
    public void test12() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("12");
        assertEquals(2, Day1RocketEquation.getRequiredInitialFuel(mockFileResults), 0);
    }

    @Test
    public void test14() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("14");
        assertEquals(2, Day1RocketEquation.getRequiredInitialFuel(mockFileResults), 0);
    }

    @Test
    public void test1969() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("1969");
        assertEquals(654, Day1RocketEquation.getRequiredInitialFuel(mockFileResults), 0);
    }

    @Test
    public void test100756() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("100756");
        assertEquals(33583, Day1RocketEquation.getRequiredInitialFuel(mockFileResults), 0);
    }

    @Test
    public void testList() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("12");
        mockFileResults.add("14");
        mockFileResults.add("1969");
        mockFileResults.add("100756");
        assertEquals((2 + 2 + 654 + 33583), Day1RocketEquation.getRequiredInitialFuel(mockFileResults), 0);
    }

    @Test
    public void testPart1() {
        List<String> fileResults = AocFileReader.readFile("src/main/resources/Day1Data.txt");
        assertEquals(3303995, Day1RocketEquation.getRequiredInitialFuel(fileResults), 0);
    }

    @Test
    public void test14part2() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("14");
        assertEquals(2, Day1RocketEquation.getRequiredTotalFuel(mockFileResults), 0);
    }

    @Test
    public void test1969part2() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("1969");
        assertEquals(966, Day1RocketEquation.getRequiredTotalFuel(mockFileResults), 0);
    }

    @Test
    public void test100756part2() {
        List<String> mockFileResults = new ArrayList();
        mockFileResults.add("100756");
        assertEquals(50346, Day1RocketEquation.getRequiredTotalFuel(mockFileResults), 0);
    }

    //4955948 too high
    @Test
    public void testPart2() {
        List<String> fileResults = AocFileReader.readFile("src/main/resources/Day1Data.txt");
        assertEquals(4953118, Day1RocketEquation.getRequiredTotalFuel(fileResults), 0);
    }
}