package calculator.model;

import calculator.domain.Delimiter;
import calculator.domain.Delimiters;
import calculator.domain.Number;
import calculator.domain.Numbers;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static calculator.common.error.DelimiterErrorMessage.*;

public class NumberExtractor {
    public Numbers execute(String input) {
        Delimiters delimiters = new Delimiters();
        input = cutCustomExpression(delimiters, input);
        return extractNumbers(delimiters, input);
    }

    private String cutCustomExpression(Delimiters delimiters, String input) {
        if (input.startsWith("//")) {
            int endStrIdx = input.indexOf("\\n");
            throwExceptionWhenNoSuchEndStr(endStrIdx);
            delimiters.add(new Delimiter(input.charAt(2)));
            return input.substring(5);
        }
        return input;
    }

    private void throwExceptionWhenNoSuchEndStr(int endStrIdx) {
        if (endStrIdx == -1) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private Numbers extractNumbers(Delimiters delimiters, String input) {
        String rex = makeOrRex(delimiters);
        return new Numbers(
                Arrays.stream(input.split(rex))
                .map(s -> new Number(s))
                .collect(Collectors.toList())
        );
    }

    private String makeOrRex(Delimiters delimiters) {
        StringBuilder sb = new StringBuilder();
        for (Delimiter delimiter : delimiters.getDelimiters()) {
            sb.append(Pattern.quote(String.valueOf(delimiter.getDelimiter())))
                    .append("|");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
