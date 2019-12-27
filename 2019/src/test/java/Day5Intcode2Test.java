import model.Instruction;
import model.InstructionResult;
import model.Intcode;
import org.junit.Test;
import util.AocFileReader;

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
        assertEquals(new InstructionResult(false, 4), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
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
        assertEquals(new InstructionResult(false, 2), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), mockInput));
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
        assertEquals(new InstructionResult(false, 2), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, mockDiagnostics, new ArrayList<>()));
        // validate mockInstructions were properly mutated
        assertEquals(expectedInstructions, mockInstructions);
        // validate diagnostic codes were properly added
        assertEquals(expectedDiagnosticCodes, mockDiagnostics);

        mockInstruction.setMode1(1);
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
        Day5Intcode2.getIntcode(mockInstructions, new ArrayList<>(), new ArrayList<>(), new Intcode());

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
        Day5Intcode2.getIntcode(instructions.get(0), diagnosticCodes, inputs, new Intcode());

        // this just checks that the answer is correct. In reality it should check that all the values except for the
        // last value are set to 0.
        assertEquals(expectedDiagnosticCode, diagnosticCodes.get(9));
    }

    @Test
    public void testExecuteInstructionOpcode5True() {
        Instruction mockInstruction = new Instruction(5, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1005");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        // validate that the right amount of steps are returned
        assertEquals(new InstructionResult(true, 3), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void testExecuteInstructionOpcode5False() {
        Instruction mockInstruction = new Instruction(5, 1, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1105");
        mockInstructions.add("0");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        // validate that the right amount of steps are returned
        assertEquals(new InstructionResult(false, 3), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void testExecuteInstructionOpcode6False() {
        Instruction mockInstruction = new Instruction(6, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1006");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        // validate that the right amount of steps are returned
        assertEquals(new InstructionResult(false, 3), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void testExecuteInstructionOpcode6True() {
        Instruction mockInstruction = new Instruction(6, 1, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1106");
        mockInstructions.add("0");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        // validate that the right amount of steps are returned
        assertEquals(new InstructionResult(true, 3), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void testExecuteInstructionOpcode7() {
        Instruction mockInstruction = new Instruction(7, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1007");
        mockInstructions.add("4");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        List<String> expectedInstructions = new ArrayList();
        expectedInstructions.add("1007");
        expectedInstructions.add("4");
        expectedInstructions.add("3");
        expectedInstructions.add("4");
        expectedInstructions.add("0");

        // validate that the right amount of steps are returned
        assertEquals(new InstructionResult(false, 4), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
        // validate instructions are mutated correctly
        assertEquals(expectedInstructions, mockInstructions);
    }

    @Test
    public void testExecuteInstructionOpcode8() {
        Instruction mockInstruction = new Instruction(8, 0, 1, 0);
        List<String> mockInstructions = new ArrayList();
        mockInstructions.add("1008");
        mockInstructions.add("2");
        mockInstructions.add("3");
        mockInstructions.add("4");
        mockInstructions.add("33");

        List<String> expectedInstructions = new ArrayList();
        expectedInstructions.add("1008");
        expectedInstructions.add("2");
        expectedInstructions.add("3");
        expectedInstructions.add("4");
        expectedInstructions.add("1");

        // validate that the right amount of steps are returned
        assertEquals(new InstructionResult(false, 4), Day5Intcode2.executeInstruction(mockInstructions, 0, mockInstruction, new ArrayList<>(), new ArrayList<>()));
        // validate instructions are mutated correctly
        assertEquals(expectedInstructions, mockInstructions);
    }

    @Test
    public void testPart2SampleInput1() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day5DataSample.txt");
        List<String> diagnosticCodes = new ArrayList<>();
        List<String> inputs = new ArrayList<>();
        inputs.add("1");
        String expectedDiagnosticCode = "999";
        Day5Intcode2.getIntcode(instructions.get(0), diagnosticCodes, inputs, new Intcode());

        // this just checks that the answer is correct. In reality it should check that all the values except for the
        // last value are set to 0.
        assertEquals(expectedDiagnosticCode, diagnosticCodes.get(0));
    }

    @Test
    public void testPart2SampleInput8() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day5DataSample.txt");
        List<String> diagnosticCodes = new ArrayList<>();
        List<String> inputs = new ArrayList<>();
        inputs.add("8");
        String expectedDiagnosticCode = "1000";
        Day5Intcode2.getIntcode(instructions.get(0), diagnosticCodes, inputs, new Intcode());

        // this just checks that the answer is correct. In reality it should check that all the values except for the
        // last value are set to 0.
        assertEquals(expectedDiagnosticCode, diagnosticCodes.get(0));
    }

    @Test
    public void testPart2SampleInput10() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day5DataSample.txt");
        List<String> diagnosticCodes = new ArrayList<>();
        List<String> inputs = new ArrayList<>();
        inputs.add("10");
        String expectedDiagnosticCode = "1001";
        Day5Intcode2.getIntcode(instructions.get(0), diagnosticCodes, inputs, new Intcode());

        // this just checks that the answer is correct. In reality it should check that all the values except for the
        // last value are set to 0.
        assertEquals(expectedDiagnosticCode, diagnosticCodes.get(0));
    }

    @Test
    public void testPart2() {
        List<List<String>> instructions = AocFileReader.readList("src/main/resources/Day5Data.txt");
        List<String> diagnosticCodes = new ArrayList<>();
        List<String> inputs = new ArrayList<>();
        inputs.add("5");
        String expectedDiagnosticCode = "15163975";
        Day5Intcode2.getIntcode(instructions.get(0), diagnosticCodes, inputs, new Intcode());

        // this just checks that the answer is correct. In reality it should check that all the values except for the
        // last value are set to 0.
        assertEquals(expectedDiagnosticCode, diagnosticCodes.get(0));
    }
}
