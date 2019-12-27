import model.Instruction;
import model.InstructionResult;
import model.Intcode;

import java.util.List;

public class Day5Intcode2 {
    /**
     * Takes in the instructions and returns the final value at position 0
     *
     * @param instructions list of instructions and values to be evaluated
     * @return Intcode at position 0
     */
    public static Intcode getIntcode(List<String> instructions, List<String> diagnosticCodes, List<String> input, Intcode intcode) {
        Integer start = intcode.getPosition() == null ? 0 : intcode.getPosition();
        for (int i = start; i < instructions.size(); ) {
            Instruction instruction = getInstruction(Integer.parseInt(instructions.get(i)));
            InstructionResult instructionResult;
            if (instruction.getOpcode() == 3 && input.size() == 0) {
                return new Intcode(null, i, false);
            }

            if (instruction.getOpcode() == 99) {
                break;
            } else {
                instructionResult = executeInstruction(instructions, i, instruction, diagnosticCodes, input);
            }

            if (instructionResult.isModified()) {
                i = instructionResult.getPointer();
            } else {
                i += instructionResult.getPointer();
            }
        }

        return new Intcode(Integer.parseInt(instructions.get(0)), 0, true);
    }

    // TODO(JOSH): make these methods utilities and have day 2 use them along with the new models

    /**
     * Executes an instruction while mutating instructions and diagnostic codes
     *
     * @param instructions    set of instructions
     * @param pointer         of current instruction
     * @param instruction     current instruction broken down into opcode and parameters
     * @param diagnosticCodes mutated list of diagnostic codes that result from opcode 4
     * @param input           inputs provided by unit ID
     * @return the amount of steps that the program should skip
     */
    public static InstructionResult executeInstruction(List<String> instructions, int pointer, Instruction instruction, List<String> diagnosticCodes, List<String> input) {
        int immediate1 = Integer.parseInt(instructions.get(pointer + 1));
        int parameter1 = instruction.getMode1() == 0 ? immediate1 : pointer + 1;
        int parameter2 = 0;
        int parameter3 = 0;

        if (instruction.getOpcode() < 3
                || (instruction.getOpcode() == 5 && Integer.parseInt(instructions.get(parameter1)) != 0)
                || (instruction.getOpcode() == 6 && Integer.parseInt(instructions.get(parameter1)) == 0)
                || instruction.getOpcode() > 6) {
            int immediate2 = Integer.parseInt(instructions.get(pointer + 2));
            parameter2 = instruction.getMode2() == 0 ? immediate2 : pointer + 2;
        }

        if (instruction.getOpcode() < 3 || instruction.getOpcode() > 6) {
            int immediate3 = Integer.parseInt(instructions.get(pointer + 3));
            parameter3 = instruction.getMode3() == 0 ? immediate3 : pointer + 3;
        }

        if (instruction.getOpcode() == 1) {
            int result = Integer.parseInt(instructions.get(parameter1)) + Integer.parseInt(instructions.get(parameter2));
            instructions.set(parameter3, String.valueOf(result));
            return new InstructionResult(false, 4);
        } else if (instruction.getOpcode() == 2) {
            int result = Integer.parseInt(instructions.get(parameter1)) * Integer.parseInt(instructions.get(parameter2));
            instructions.set(parameter3, String.valueOf(result));
            return new InstructionResult(false, 4);
        } else if (instruction.getOpcode() == 3) {
            instructions.set(parameter1, input.remove(0));
            return new InstructionResult(false, 2);
        } else if (instruction.getOpcode() == 4) {
            diagnosticCodes.add(String.valueOf(Integer.parseInt(instructions.get(parameter1))));
            return new InstructionResult(false, 2);
        } else if (instruction.getOpcode() == 5) {
            if (Integer.parseInt(instructions.get(parameter1)) != 0) {
                return new InstructionResult(true, Integer.parseInt(instructions.get(parameter2)));
            } else {
                return new InstructionResult(false, 3);
            }
        } else if (instruction.getOpcode() == 6) {
            if (Integer.parseInt(instructions.get(parameter1)) == 0) {
                return new InstructionResult(true, Integer.parseInt(instructions.get(parameter2)));
            } else {
                return new InstructionResult(false, 3);
            }
        } else if (instruction.getOpcode() == 7) {
            boolean result = Integer.parseInt(instructions.get(parameter1)) < Integer.parseInt(instructions.get(parameter2));
            if (result) {
                instructions.set(parameter3, "1");
            } else {
                instructions.set(parameter3, "0");
            }
            return new InstructionResult(false, 4);
        } else if (instruction.getOpcode() == 8) {
            boolean result = Integer.parseInt(instructions.get(parameter1)) == Integer.parseInt(instructions.get(parameter2));
            if (result) {
                instructions.set(parameter3, "1");
            } else {
                instructions.set(parameter3, "0");
            }
            return new InstructionResult(false, 4);
        }

        return null;
    }

    /**
     * Grabs opcode, parameter 1, parameter 2, and parameter 3 from an instruction. Instruction is of the format ABCDE
     * where DE are the opcode, C is parameter 1, B is parameter 2 and A is parameter 3
     *
     * @param instruction integer which contains above pieces
     * @return model.Instruction object which houses above pieces
     */
    public static Instruction getInstruction(int instruction) {
        int opcode = instruction % 100;
        instruction = instruction / 100;
        int parameter1 = instruction % 10;
        instruction = instruction / 10;
        int parameter2 = instruction % 10;
        instruction = instruction / 10;
        int parameter3 = instruction % 10;

        return new Instruction(opcode, parameter1, parameter2, parameter3);
    }
}
