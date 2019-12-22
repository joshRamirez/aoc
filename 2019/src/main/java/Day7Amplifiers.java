import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class Day7Amplifiers {
    public static Integer getMaxThrusterSignal(List<String> instructions, List<String> phases) {
        Integer maxThrusterSignal = null;
        List<List<String>> phasePermutations = new ArrayList<>();
        getPermutations(0, phases, phasePermutations);

        for (List<String> phase : phasePermutations) {
            Integer thrusterSignal = calculateThrusterSignal(instructions, phase);
            if (maxThrusterSignal != null) {
                maxThrusterSignal = Math.max(maxThrusterSignal, thrusterSignal);
            } else {
                maxThrusterSignal = thrusterSignal;
            }
        }

        return maxThrusterSignal;
    }

    public static void getPermutations(Integer start, List<String> phases, List<List<String>> phasePermutations) {
        if (start == phases.size() - 1) {
            List<String> permutation = new ArrayList();
            for (String phase : phases) {
                permutation.add(phase);
            }
            phasePermutations.add(permutation);
            return;
        }

        for (int i = start; i < phases.size(); ++i) {
            swap(phases, i, start);
            getPermutations(start + 1, phases, phasePermutations);
            swap(phases, i, start);
        }
    }

    public static Integer calculateThrusterSignal(List<String> instructions, List<String> phaseSettingSequence) {
        List<String> inputs;
        List<String> diagnosticCode;
        String output = "0";

        for (int i = 0; i < phaseSettingSequence.size(); i++) {
            inputs = new ArrayList<>();
            diagnosticCode = new ArrayList<>();
            inputs.add(phaseSettingSequence.get(i));
            inputs.add(output);
            Day5Intcode2.getIntcode(instructions, diagnosticCode, inputs);
            output = diagnosticCode.get(0);
        }

        return Integer.parseInt(output);
    }
}
