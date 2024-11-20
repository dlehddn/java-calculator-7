package calculator.model;

import calculator.domain.Number;
import calculator.domain.Numbers;

public class Calculator {
    private int result;

    public Calculator() {
        this.result = 0;
    }

    public int execute(Numbers numbers) {
        for (Number number : numbers.getNumbers()) {
            result += number.getNumber();
        }
        return result;
    }
}
