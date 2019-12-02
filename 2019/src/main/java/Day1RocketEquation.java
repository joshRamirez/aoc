import java.util.List;

public class Day1RocketEquation {
    /**
     * Part 1 function, which gathers the initial fuel required based on the masses provided.
     *
     * @param masses all the masses to be used for the calculation of required fuel
     * @return weight in fuel required
     */
    public static Integer getRequiredInitialFuel(List<String> masses) {
        Integer sum = 0;
        for (String mass : masses) {
            Integer massAsInt = Integer.parseInt(mass);
            sum += getFuel(massAsInt);
        }

        return sum;
    }

    // TODO(JOSH): the above and below functions may be able to be made into a single function? The only difference is
    //  the function call.

    /**
     * Part 2 function, which now needs to include the fuel weight recursively until each module requires 0 new fuel
     *
     * @param masses all the masses to be used for the calculation of required fuel
     * @return weight in fuel required
     */
    public static Integer getRequiredTotalFuel(List<String> masses) {
        Integer sum = 0;
        for (String mass : masses) {
            Integer massAsInt = Integer.parseInt(mass);
            sum += getRequiredExtraFuel(massAsInt, 0);
        }

        return sum;
    }

    /**
     * Recursively gets the fuel required for a module until the fuel for the fuel is less than or equal to 0. Based on
     * the following constraint:
     * 'So, for each module mass, calculate its fuel and add it to the total. Then, treat the fuel amount you just
     * calculated as the input mass and repeat the process, continuing until a fuel requirement is zero or negative.'
     *
     * @param newMass mass being passed in to evaluate the fuel needed
     * @param fuel    accumulated fuel
     * @return the total fuel weight requirement for the module
     */
    public static Integer getRequiredExtraFuel(Integer newMass, Integer fuel) {
        Integer mass = getFuel(newMass);
        if (mass <= 0) {
            return fuel;
        }

        fuel += mass;
        return getRequiredExtraFuel(mass, fuel);
    }

    /**
     * Gets the fuel required for the mass passed in based on the following constraint:
     * 'Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module,
     * take its mass, divide by three, round down, and subtract 2.'
     *
     * @param mass mass of the module which will be used to get the weight
     * @return the fuel weight required for the given mass
     */
    private static Integer getFuel(Integer mass) {
        Integer divideMassBy3 = mass / 3;

        return divideMassBy3 - 2;
    }
}
