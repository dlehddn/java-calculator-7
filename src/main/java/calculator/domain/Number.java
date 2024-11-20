package calculator.domain;

import calculator.common.error.NumberErrorMessage;

import java.util.regex.Pattern;

import static calculator.common.error.NumberErrorMessage.*;

public class Number {
    private int number;

    public Number(String number) {
        NumberValidator.validate(number);
        this.number = Integer.valueOf(number);
    }

    public int getNumber() {
        return number;
    }

    static class NumberValidator {
        private static final String NUMBER_FORMAT = "^[0-9]*$";

        private static void validate(String input) {
            if (!Pattern.matches(NUMBER_FORMAT, input)) {
                throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
            }
        }
    }
}
