package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import static calculator.common.error.InputErrorMessage.*;

public class InputView {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String read() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        InputValidator.validate(input);
        return input;
    }

    static class InputValidator {
        public static void validate(String input) {
            if (input.isBlank()) {
                throw new IllegalArgumentException(IS_BLANK.getMessage());
            }
        }
    }
}
