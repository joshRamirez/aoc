import model.Instruction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day5Intcode2Test {
    @Test
    public void testGetOpcode() {
        assertEquals(new Instruction(2, 4, 3, 4), Day5Intcode2.getInstruction(43402));
    }

    @Test
    public void testGetOpcodePartial() {
        assertEquals(new Instruction(2, 4, 0, 0), Day5Intcode2.getInstruction(402));
    }

    @Test
    public void testExecuteInstruction() {
        Instruction mockInstruction = new Instruction(2, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1002");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        List<String> expectedInstructions = new ArrayList();
        expectedInstructions.add("1002");
        expectedInstructions.add("4");
        expectedInstructions.add("3");
        expectedInstructions.add("4");
        expectedInstructions.add("99");

        // validate that the right amount of steps are returned
        assertEquals(new Integer(4), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
        // validate that the mockInstructions were properly mutated
        assertEquals(expectedInstructions, mockInstructions);
    }

    @Test
    public void testExecuteInstruction2StepInput() {
        Instruction mockInstruction = new Instruction(3, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1003");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        List<String> mockInput = new ArrayList<>();
        mockInput.add("1234");

        List<String> expectedInstructions = new ArrayList();
        expectedInstructions.add("1003");
        expectedInstructions.add("4");
        expectedInstructions.add("3");
        expectedInstructions.add("4");
        expectedInstructions.add("1234");

        // validate that the right amount of steps are returned
        assertEquals(new Integer(2), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), mockInput));
        // validate that the mockInstructions were properly mutated
        assertEquals(expectedInstructions, mockInstructions);
    }

    @Test
    public void testExecuteInstruction2StepOutput() {
        Instruction mockInstruction = new Instruction(4, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        List<String> mockDiagnostics = new ArrayList<>();
        mockInstructions.add("1004");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        List<String> expectedInstructions = new ArrayList();
        expectedInstructions.add("1004");
        expectedInstructions.add("4");
        expectedInstructions.add("3");
        expectedInstructions.add("4");
        expectedInstructions.add("33");

        List<String> expectedDiagnosticCodes = new ArrayList<>();
        expectedDiagnosticCodes.add("33");

        // validate right amount of steps are returned
        assertEquals(new Integer(2), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, mockDiagnostics, new ArrayList<>()));
        // validate mockInstructions were properly mutated
        assertEquals(expectedInstructions, mockInstructions);
        // validate diagnostic codes were properly added
        assertEquals(expectedDiagnosticCodes, mockDiagnostics);

        mockInstruction.setParameter1(1);
        mockInstructions.set(0, "1104");
        expectedDiagnosticCodes.set(0, "4");
        mockDiagnostics.remove(0);
        Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, mockDiagnostics, new ArrayList<>());

        // validate correct diagnostic mutation occurred
        assertEquals(expectedDiagnosticCodes, mockDiagnostics);
    }

    @Test
    public void testInstructionSet() {
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1002");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        List<String> expectedInstructions = new ArrayList();
        expectedInstructions.add("1002");
        expectedInstructions.add("4");
        expectedInstructions.add("3");
        expectedInstructions.add("4");
        expectedInstructions.add("99");
        Day5Intcode2.getIntcode(mockInstructions, new ArrayList<>(), new ArrayList<>());

        // validate mockInstructions were properly mutated after the program completed
        assertEquals(expectedInstructions, mockInstructions);
    }

    @Test
    public void testPart1() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day5Data.txt");
        List<String> diagnosticCodes = new ArrayList<>();
        List<String> inputs = new ArrayList<>();
        inputs.add("1");
        String expectedDiagnosticCode = "16574641";
        Day5Intcode2.getIntcode(instructions.get(0), diagnosticCodes, inputs);

        // this just checks that the answer is correct. In reality it should check that all the values except for the
        // last value are set to 0.
        assertEquals(expectedDiagnosticCode, diagnosticCodes.get(9));
    }
}
