public class Day4SecureContainer {
    /**
     * Grabs all valid passwords within the given range.
     *
     * @param lowEnd  low end of the range
     * @param highEnd high end of the range
     * @return the count of valid passwords
     */
    public static int getValidPasswords(int lowEnd, int highEnd) {
        int validPasswords = 0;

        for (int i = lowEnd; i <= highEnd; i++) {
            if (validatePassword(i)) {
                validPasswords++;
            }
        }

        return validPasswords;
    }

    /**
     * This method will validate a password based on the constraints provided by aoc.
     * It is a six-digit number. * assumed true because input will handle this
     * The value is within the range given in your puzzle input. * assumed true because input will handle this
     * Two adjacent digits are the same (like 22 in 122345).
     * Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
     *
     * @param password password to be validated
     * @return true if the password is valid, otherwise false
     */
    public static boolean validatePassword(int password) {
        if (password < 10) {
            return false;
        }

        Integer lastDigit = password % 10;
        password = password / 10;
        Integer secondToLastDigit = password % 10;
        password = password / 10;
        boolean hasSimilarAdjacentDigit = false;

        if (password == 0) {
            if (secondToLastDigit == lastDigit) {
                return true;
            } else {
                return false;
            }
        }

        while (password != 0) {
            if (secondToLastDigit > lastDigit) {
                return false;
            }

            if (secondToLastDigit == lastDigit) {
                hasSimilarAdjacentDigit = true;
            }

            lastDigit = secondToLastDigit;
            secondToLastDigit = password % 10;
            password = password / 10;
        }

        if (secondToLastDigit > lastDigit) {
            return false;
        }

        if (secondToLastDigit == lastDigit) {
            hasSimilarAdjacentDigit = true;
        }

        if (hasSimilarAdjacentDigit) {
            return true;
        }

        return false;
    }
}
