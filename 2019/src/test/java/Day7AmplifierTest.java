import org.junit.Test;
import util.AocFileReader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day7AmplifierTest {
    @Test
    public void testThrusterSignal43210() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("4");
        phases.add("3");
        phases.add("2");
        phases.add("1");
        phases.add("0");
        assertEquals(new Integer(43210), Day7Amplifiers.calculateThrusterSignal(instructions, phases));
    }

    @Test
    public void testMaxThrusterSignal43210() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7DataSample1.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("0");
        phases.add("1");
        phases.add("2");
        phases.add("3");
        phases.add("4");
        assertEquals(new Integer(43210), Day7Amplifiers.getMaxThrusterSignal(instructions, phases));
    }

    @Test
    public void testMaxThrusterSignalPart1() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("0");
        phases.add("1");
        phases.add("2");
        phases.add("3");
        phases.add("4");
        assertEquals(new Integer(914828), Day7Amplifiers.getMaxThrusterSignal(instructions, phases));
    }

    @Test
    public void testThrusterSignal98765() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("9");
        phases.add("8");
        phases.add("7");
        phases.add("6");
        phases.add("5");
        assertEquals(new Integer(139629729), Day7Amplifiers.calculateThrusterSignal(instructions, phases));
    }

    @Test
    public void testThrusterSignal97856() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample3.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7DataSample3.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7DataSample3.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7DataSample3.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7DataSample3.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("9");
        phases.add("7");
        phases.add("8");
        phases.add("5");
        phases.add("6");
        assertEquals(new Integer(18216), Day7Amplifiers.calculateThrusterSignal(instructions, phases));
    }

    @Test
    public void testMaxThrusterSignal98765() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7DataSample2.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("5");
        phases.add("6");
        phases.add("7");
        phases.add("8");
        phases.add("9");
        assertEquals(new Integer(139629729), Day7Amplifiers.getMaxThrusterSignal(instructions, phases));
    }

    @Test
    public void testMaxThrusterSignalPart2() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions1 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions2 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions3 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        List<List<String>> instructions4 = AocFileReader.readList("src/main/resources/Day7Data.txt");
        instructions.add(instructions1.get(0));
        instructions.add(instructions2.get(0));
        instructions.add(instructions3.get(0));
        instructions.add(instructions4.get(0));
        List<String> phases = new ArrayList<>();
        phases.add("5");
        phases.add("6");
        phases.add("7");
        phases.add("8");
        phases.add("9");
        assertEquals(new Integer(17956613), Day7Amplifiers.getMaxThrusterSignal(instructions, phases));
    }
}
