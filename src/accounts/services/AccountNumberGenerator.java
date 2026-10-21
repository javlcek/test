package accounts.services;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class AccountNumberGenerator {

    private static final int[] WEIGHTS = {6, 3, 7, 9, 10, 5, 8, 4, 2, 1};

    private static final int ACCOUNT_NUMBER_LENGTH = 10;

    private final String bankCode;

    private final Set<String> issuedNumbers = new HashSet<>();

    public AccountNumberGenerator(String bankCode) {
        this.bankCode = bankCode;
    }

    public String generate() {
        String number;

        do {
            number = generateBaseNumber();
        } while (!issuedNumbers.add(number));

        return number + "/" + bankCode;
    }

    private String generateBaseNumber() {
        var random = ThreadLocalRandom.current();

        while (true) {
            var digits = new int[ACCOUNT_NUMBER_LENGTH];
            var sum = 0;

            for (var i = 0; i < ACCOUNT_NUMBER_LENGTH - 1; i++) {
                digits[i] = (i == 0) ? 1 + random.nextInt(9) : random.nextInt(10);
                sum += digits[i] * WEIGHTS[i];
            }

            var checkDigit = (11 - sum % 11) % 11;
            if (checkDigit == 10) {
                continue;
            }
            digits[ACCOUNT_NUMBER_LENGTH - 1] = checkDigit;

            var builder = new StringBuilder(ACCOUNT_NUMBER_LENGTH);
            for (var digit : digits) {
                builder.append(digit);
            }

            return builder.toString();
        }
    }

    public static boolean isValid(String number) {
        if (!number.matches("\\d{2,10}")) {
            return false;
        }

        var padded = "0".repeat(ACCOUNT_NUMBER_LENGTH - number.length()) + number;
        var sum = 0;

        for (var i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            sum += (padded.charAt(i) - '0') * WEIGHTS[i];
        }

        return sum % 11 == 0;
    }
}
