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
     * Grabs all valid passwords within the given range for part 2.
     *
     * @param lowEnd  low end of the range
     * @param highEnd high end of the range
     * @return the count of valid passwords
     */
    public static int getValidPasswordsPart2(int lowEnd, int highEnd) {
        int validPasswords = 0;

        for (int i = lowEnd; i <= highEnd; i++) {
            if (validatePasswordPart2(i)) {
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

    /**
     * This method will validate a password based on the constraints provided by aoc part 2. Here there needs to be at
     * least one pair of adjacent similar digits.
     *
     * @param password password to be validated
     * @return true if the password is valid, otherwise false
     */
    public static boolean validatePasswordPart2(int password) {
        Integer beforeLastDigit = null;
        Integer lastDigit = password % 10;
        password = password / 10;
        Integer secondToLastDigit = password % 10;
        password = password / 10;
        Integer thirdToLastDigit = password % 10;
        password = password / 10;
        boolean hasSimilarAdjacentDigit = false;

        while (password != 0) {
            if (secondToLastDigit > lastDigit || thirdToLastDigit > secondToLastDigit) {
                return false;
            }

            if ((secondToLastDigit == lastDigit && secondToLastDigit != thirdToLastDigit)) {
                if (beforeLastDigit == null) {
                    hasSimilarAdjacentDigit = true;
                } else if (beforeLastDigit != lastDigit) {
                    hasSimilarAdjacentDigit = true;
                }
            }

            beforeLastDigit = lastDigit;
            lastDigit = secondToLastDigit;
            secondToLastDigit = thirdToLastDigit;
            thirdToLastDigit = password % 10;
            password = password / 10;
        }

        if (secondToLastDigit > lastDigit || thirdToLastDigit > secondToLastDigit) {
            return false;
        }

        if ((lastDigit != beforeLastDigit && secondToLastDigit == lastDigit && secondToLastDigit != thirdToLastDigit)
                || (secondToLastDigit != lastDigit && secondToLastDigit == thirdToLastDigit)) {
            hasSimilarAdjacentDigit = true;
        }

        if (hasSimilarAdjacentDigit) {
            return true;
        }

        return false;
    }
}
