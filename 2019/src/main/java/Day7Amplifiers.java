import model.Intcode;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class Day7Amplifiers {
    public static Integer getMaxThrusterSignal(List<List<String>> instructions, List<String> phases) {
        Integer maxThrusterSignal = null;
        List<List<String>> phasePermutations = new ArrayList<>();
        getPermutations(0, phases, phasePermutations);

        for (List<String> phase : phasePermutations) {
            List<List<String>> instructionsCopy = new ArrayList<>();
            for (int i = 0; i < instructions.size(); i++) {
                instructionsCopy.add(new ArrayList<>(instructions.get(i).size()));
                int finalI = i;
                instructions.get(i).stream().forEach(it -> instructionsCopy.get(finalI).add(it));
            }
            Integer thrusterSignal = calculateThrusterSignal(instructionsCopy, phase);
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

    public static Integer calculateThrusterSignal(List<List<String>> instructions, List<String> phaseSettingSequence) {
        List<String> inputs;
        List<String> diagnosticCode = new ArrayList<>();
        Integer startSize = phaseSettingSequence.size();
        diagnosticCode.add("0");
        List<Intcode> intcodes = new ArrayList<>();
        for (String ignored : phaseSettingSequence) {
            intcodes.add(new Intcode());
        }

        do {
            for (int i = 0; i < startSize; i++) {
                inputs = new ArrayList<>();
                if (phaseSettingSequence.size() != 0) {
                    inputs.add(phaseSettingSequence.remove(0));
                }
                while (diagnosticCode.size() != 0) {
                    inputs.add(diagnosticCode.remove(0));
                }
                intcodes.set(i, Day5Intcode2.getIntcode(instructions.get(i), diagnosticCode, inputs, intcodes.get(i)));
            }
        } while (intcodes.stream().anyMatch(it -> !it.isTerminated()));

        return Integer.parseInt(diagnosticCode.get(0));
    }
}
