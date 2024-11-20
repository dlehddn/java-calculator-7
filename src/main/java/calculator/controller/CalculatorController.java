package calculator.controller;

import calculator.domain.Numbers;
import calculator.model.Calculator;
import calculator.model.NumberExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberExtractor numberExtractor;
    private final Calculator calculator;

    public CalculatorController(InputView inputView,
                                OutputView outputView,
                                NumberExtractor numberExtractor,
                                Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberExtractor = numberExtractor;
        this.calculator = calculator;
    }

    public void run() {
        String input = inputView.read();
        Numbers numbers = numberExtractor.execute(input);
        outputView.printResult(calculator.execute(numbers));
    }
}
