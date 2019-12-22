import org.junit.Test;
import util.AocFileReader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day7AmplifierTest {
    @Test
    public void testThrusterSignal43210() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<String> phases = new ArrayList<>();
        phases.add("4");
        phases.add("3");
        phases.add("2");
        phases.add("1");
        phases.add("0");
        assertEquals(new Integer(43210), Day7Amplifiers.calculateThrusterSignal(instructions.get(0), phases));
    }

    @Test
    public void testMaxThrusterSignal43210() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<String> phases = new ArrayList<>();
        phases.add("0");
        phases.add("1");
        phases.add("2");
        phases.add("3");
        phases.add("4");
        assertEquals(new Integer(43210), Day7Amplifiers.getMaxThrusterSignal(instructions.get(0), phases));
    }

    @Test
    public void testMaxThrusterSignalPart1() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<String> phases = new ArrayList<>();
        phases.add("0");
        phases.add("1");
        phases.add("2");
        phases.add("3");
        phases.add("4");
        assertEquals(new Integer(914828), Day7Amplifiers.getMaxThrusterSignal(instructions.get(0), phases));
    }
}
