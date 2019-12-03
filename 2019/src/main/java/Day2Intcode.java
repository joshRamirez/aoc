import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2Intcode {

    /**
     * Takes in the instructions and returns the final value at position 0
     *
     * @param instructions list of instructions and values to be evaluated
     * @return Intcode at position 0
     */
    public static Integer getIntcode(List<String> instructions) {
        for (int i = 0; i < instructions.size(); i += 4) {
            if (calculateInstruction(instructions, i) == true) {
                continue;
            }
        }

        return Integer.parseInt(instructions.get(0));
    }

    /**
     * Finds verb/noun that when placed in the instruction set yields 19690720 as the result of the program
     *
     * @param instructions list of instructions and values to be evaluated
     * @return the result of 100 * noun + verb for the result that yielded 19690720
     */
    public static Integer getIntcodeFor19690720(List<String> instructions) {
        List<String> original = new ArrayList();
        instructions.stream().forEach(it -> original.add(it));

        for (int i = 0; i < instructions.size(); i++) {
            for (int j = i; j < instructions.size(); j++) {
                instructions.set(1, String.valueOf(i));
                instructions.set(2, String.valueOf(j));

                for (int k = 0; k < instructions.size(); k += 4) {
                    calculateInstruction(instructions, k);
                }

                if (Integer.parseInt(instructions.get(0)) == 19690720) {
                    return 100 * Integer.parseInt(instructions.get(1)) + Integer.parseInt(instructions.get(2));
                } else {
                    Collections.copy(instructions, original);
                }
            }
        }

        return Integer.parseInt(instructions.get(0));
    }

    /**
     * Applies the designated instruction and returns whether or not the program should terminate
     *
     * @param instructions        list of data/instructions to be used for calculation
     * @param instructionPosition position of the current instruction to be executed
     * @return true if the program should halt either by instruction of 99 or an unknown op code, otherwise false
     */
    private static boolean calculateInstruction(List<String> instructions, int instructionPosition) {
        int instruction = Integer.parseInt(instructions.get(instructionPosition));

        if (instruction == 99) {
            return true;
        } else if (instruction == 1) {
            int position1 = Integer.parseInt(instructions.get(instructionPosition + 1));
            int addend1 = Integer.parseInt(instructions.get(position1));
            int position2 = Integer.parseInt(instructions.get(instructionPosition + 2));
            int addend2 = Integer.parseInt(instructions.get(position2));
            int sum = addend1 + addend2;
            int position3 = Integer.parseInt(instructions.get(instructionPosition + 3));
            if (position3 > instructions.size()) {
                return true;
            }
            instructions.set(position3, String.valueOf(sum));
            return false;
        } else if (instruction == 2) {
            int position1 = Integer.parseInt(instructions.get(instructionPosition + 1));
            int x = Integer.parseInt(instructions.get(position1));
            int position2 = Integer.parseInt(instructions.get(instructionPosition + 2));
            int y = Integer.parseInt(instructions.get(position2));
            int mult = x * y;
            int position3 = Integer.parseInt(instructions.get(instructionPosition + 3));
            if (position3 > instructions.size()) {
                return true;
            }
            instructions.set(position3, String.valueOf(mult));
            return false;
        }

        return true;
    }
}
