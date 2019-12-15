import model.Instruction;

import java.util.List;

public class Day5Intcode2 {
    /**
     * Takes in the instructions and returns the final value at position 0
     *
     * @param instructions list of instructions and values to be evaluated
     * @return Intcode at position 0
     */
    public static Integer getIntcode(List<String> instructions, List<String> diagnosticCodes, List<String> input) {
        for (int i = 0; i < instructions.size(); ) {
            Instruction instruction = getInstruction(Integer.parseInt(instructions.get(i)));
            int step;

            if (instruction.getOpcode() == 99) {
                break;
            } else {
                step = executeInstruction(instructions, i, instruction, diagnosticCodes, input);
            }

            i += step;
        }

        return Integer.parseInt(instructions.get(0));
    }

    public static Integer executeInstruction(List<String> instructions, int pointer, Instruction instruction, List<String> diagnosticCodes, List<String> input) {
        int immediate1 = Integer.parseInt(instructions.get(pointer + 1));
        int parameter1 = instruction.getParameter1() == 0 ? immediate1 : pointer + 1;
        int parameter2 = 0;
        int parameter3 = 0;

        if (instruction.getOpcode() < 3) {
            int immediate2 = Integer.parseInt(instructions.get(pointer + 2));
            parameter2 = instruction.getParameter2() == 0 ? immediate2 : pointer + 2;
            int immediate3 = Integer.parseInt(instructions.get(pointer + 3));
            parameter3 = instruction.getParameter3() == 0 ? immediate3 : pointer + 3;
        }

        if (instruction.getOpcode() == 1) {
            int result = Integer.parseInt(instructions.get(parameter1)) + Integer.parseInt(instructions.get(parameter2));
            instructions.set(parameter3, String.valueOf(result));
            return 4;
        } else if (instruction.getOpcode() == 2) {
            int result = Integer.parseInt(instructions.get(parameter1)) * Integer.parseInt(instructions.get(parameter2));
            instructions.set(parameter3, String.valueOf(result));
            return 4;
        } else if (instruction.getOpcode() == 3) {
            instructions.set(parameter1, input.get(0));
            return 2;
        } else if (instruction.getOpcode() == 4) {
            diagnosticCodes.add(String.valueOf(Integer.parseInt(instructions.get(parameter1))));
            return 2;
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
